# Java File Handling (Byte Streams vs Character Streams)

This project demonstrates Java I/O fundamentals using both **Byte Streams** and **Character Streams**, focusing on correctness, performance, and real-world usage.

---

## How to Run This Project (Inputs/Outputs)

Both demos use:

- `static String rootDir = "";`

If `rootDir` is empty, files are created/read relative to the **current working directory** of your run configuration.

### Required input files (must exist)

- `demo.pdf` (used by `byteStream.Main.copyPdfFile()`)

> Note: `byteStream.Main.copyImageFile()` currently copies `output.txt` → `output2.txt`.  
> Ensure `output.txt` exists, or rename the method / filenames if you intend a real image copy.

### Files generated/overwritten by the demos

**Byte stream demo writes:**
- `note.txt`
- `output2.txt` (copy target)
- `demo_copy.pdf` (copy target)
- `app.log`

**Character stream demo writes:**
- `char_text.txt`
- `char_log.txt`
- `char_unicode.txt`

---

## IOException (Context)

An `IOException` represents a failure during an input/output operation, such as:

- File not found
- Permission denied
- Corrupted or unreadable data
- Disk or network I/O failure

Any code that performs I/O must either handle it using `try/catch` or declare it using `throws`.

All examples in this project use **try-with-resources**, which guarantees that streams are closed properly even if an exception occurs.

---

## Streams in Java (Conceptual Model)

A **stream** is a one-way flow of data between a program and a source or destination such as a file, console, memory, or network.

Java provides two main stream families:

- **Byte Streams** (`InputStream` / `OutputStream`)
  - Work with raw 8-bit bytes
  - Used for binary data

- **Character Streams** (`Reader` / `Writer`)
  - Work with 16-bit Unicode characters
  - Handle encoding and decoding automatically
  - Used for text data

### Bridge Streams

- `InputStreamReader` converts byte streams to character streams
- `OutputStreamWriter` converts character streams to byte streams

These are essential when the source is binary but the content is text.

---

## Design Note: Decorator Pattern

Java I/O streams follow the **Decorator Pattern**.

Examples:
- `BufferedInputStream` decorates `InputStream`
- `BufferedReader` decorates `Reader`
- `PrintStream` decorates `OutputStream`

This allows functionality such as buffering and formatting to be added dynamically.

---

# 1) Byte Streams (`package: byteStream`)

This section corresponds to `src/byteStream/Main.java`.

## When to Use Byte Streams

Use byte streams when exact byte preservation is required:

- Images
- PDFs
- Audio and video files
- Encrypted or compressed data
- Any binary file format

Byte streams are not suitable for Unicode text unless encoding is handled explicitly.

---

## Core Classes Used

- `FileInputStream`, `FileOutputStream`
- `BufferedInputStream`, `BufferedOutputStream`
- `PrintStream`

---

## Class Hierarchy (Simplified)

```

InputStream
├── FileInputStream
├── BufferedInputStream
├── DataInputStream
└── ObjectInputStream

OutputStream
├── FileOutputStream
├── BufferedOutputStream
└── PrintStream

```

---

## Demos Implemented

### A) Writing Text Using Byte Streams (`writeTextUsingByteStream`)

**Creates/overwrites**
- `note.txt`

**How it works**
- `String` → bytes via `content.getBytes()`
- written with `FileOutputStream`

**Important Notes**
- `String.getBytes()` uses the platform default charset.
- For predictable results, prefer:

```java
// ...existing code...
content.getBytes(java.nio.charset.StandardCharsets.UTF_8)
```

---

### B) Reading Text Using Byte Streams

**Reads**
- `note.txt`

**How it works**
- reads one byte at a time and prints `(char) data`

**Technical detail (correct)**
- `InputStream.read()` returns:
  - `0..255` for a byte value
  - `-1` for end of stream

**Limitation**
- This “byte→char cast” is not a safe Unicode decoding strategy (works reliably only for basic ASCII). For real text, use `Reader` or `InputStreamReader` with a charset.

---

### C) Buffered Copy Demo (`copyImageFile`)

**Copies (as coded)**
- `output.txt` → `output2.txt`

**Classes**
- `BufferedInputStream` / `BufferedOutputStream` over file streams

**Why buffering matters**

* Without buffering, each byte causes a system call.
* With buffering, data is transferred in blocks, improving performance significantly.

---

### D) PDF or Binary File Copy

**What it does**
***Copies***
- `demo.pdf` → `demo_copy.pdf`

* Copies a PDF or any binary file using buffered byte streams.

**Key Point**

* The same logic applies to all binary formats.
* No decoding or interpretation occurs.

---

### E) File Logging Using `PrintStream` (`consoleAndFileLogging`)

**Creates/overwrites**
- `app.log`

**What it demonstrates**
- `println` + `printf` formatting over an `OutputStream`.

**Note**
- `PrintStream` does not throw `IOException` to callers; check `ps.checkError()` if you care about silent failures.

---

## Flush vs Close

* `flush()` forces buffered data to be written immediately.
* `close()` automatically calls `flush()` before releasing resources.

Failure to flush or close streams is a common reason data does not appear in files.

---

# 2) Character Streams (`package: characterStream`)

This section corresponds to `src/characterStream/Main.java`.

## When to Use Character Streams

Use character streams for Unicode text:

* Text files (`.txt`)
* CSV, JSON, XML
* Logs and configuration files
* Multilingual content

Character streams must not be used for binary data.

---

## Core Classes Used

* `FileReader`, `FileWriter`
* `BufferedReader`, `BufferedWriter`
* `PrintWriter`
* `InputStreamReader` for byte-to-character conversion with explicit encoding

---

## Class Hierarchy (Simplified)

### Readers

```
Reader
 ├── InputStreamReader
 │    └── FileReader
 ├── BufferedReader
 ├── StringReader
 └── CharArrayReader
```

### Writers

```
Writer
 ├── OutputStreamWriter
 │    └── FileWriter
 ├── BufferedWriter
 ├── PrintWriter
 └── StringWriter
```

---

## Demos Implemented

### A) Writing Text Using `FileWriter` (`writeTextUsingFileWriter`)

**Creates/overwrites**
- `char_text.txt`

**What it demonstrates**
- writing characters (text) via the `Writer` hierarchy.

**Charset note**
- `FileWriter` uses the platform default charset. If you need an explicit charset (recommended), use:
- `OutputStreamWriter` + `FileOutputStream` (or NIO `Files.newBufferedWriter`).

---

### B) Reading Text Line-by-Line (`readTextUsingBufferedReader`)

**Reads**
- `char_text.txt`

**What it demonstrates**
- `BufferedReader.readLine()` for efficient line processing.

---

### C) Formatted Output (`writeFormattedTextUsingPrintWriter`)

**Creates/overwrites**
- `char_log.txt`

**What it demonstrates**
- `PrintWriter.println/printf` style formatted text output.

---

### D) Unicode Support Demo (`unicodeTextDemo`)

**Creates/overwrites**
- `char_unicode.txt`

**What it demonstrates**
- correct handling of multilingual Unicode text (including `ᛞ`) when using character streams.

---

### E) Byte → Character Bridge (`byteToCharBridgeDemo`)

**Reads**
- `char_text.txt`

**What it demonstrates**
- `InputStreamReader(new FileInputStream(file), "UTF-8")` to decode bytes into characters **with an explicit charset**, then `BufferedReader` to read lines.

---

## try-with-resources Usage

All examples use:

```java
try (/* one or more streams */) {
    // use the stream
} catch (IOException e) {
    e.printStackTrace();
}
```

This ensures that `close()` is always called and resources are released correctly.

---

## Predefined Streams

* `System.in`  : Standard input (keyboard by default), type `InputStream`
* `System.out` : Standard output (console by default), type `PrintStream`
* `System.err` : Standard error stream (console by default), type `PrintStream`

`System.err` is typically used for error logging and can be redirected independently from standard output.

---

## File Class and Portability

Hardcoding file paths (for example, using `\` on Windows) can break portability.

The `File` class provides constructors and utilities to build platform-independent paths:

* `File(String parent, String child)`
* `File(File parent, String child)`
* `File(URI uri)`

---

## Quick Decision Guide

* Need exact byte-level accuracy (images, PDFs, binaries)
  Use **Byte Streams**

* Need correct Unicode text handling
  Use **Character Streams**

* Source is bytes but content is text with known encoding
  Use **InputStreamReader** or **OutputStreamWriter**

---

## References

* [Java I/O Tutorial (Oracle)](https://docs.oracle.com/javase/tutorial/essential/io/)
* [`InputStream` API Documentation](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/InputStream.html)
* [`OutputStream` API Documentation](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/OutputStream.html)
* [`Reader` API Documentation](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/Reader.html)
* [`Writer` API Documentation](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/Writer.html)
