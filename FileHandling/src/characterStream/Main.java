package characterStream;

import java.io.*;

/**
 * ======================================================
 * JAVA CHARACTER STREAMS – COMPLETE DEMO (SINGLE FILE)
 * ======================================================
 *
 * Character Streams are designed for TEXT DATA.
 * They work with 16-bit Unicode characters and
 * handle encoding/decoding automatically.
 *
 * Character streams in Java are designed for Unicode text processing using Reader and Writer hierarchies,
 * making them ideal for text files, logs, and configuration data, while byte streams are preferred for binary data.
 *
 * ------------------------------------------------------
 * CLASS HIERARCHY (Simplified)
 * ------------------------------------------------------
 *
 *                Object
 *                  |
 *               Reader (abstract)
 *                  |
 *      ------------------------------------
 *      |              |                   |
 * BufferedReader  InputStreamReader    StringReader
 *                       |
 *                   FileReader
 *
 * java.lang.Object
 *  └── java.io.Reader        (abstract)
 *       ├── java.io.BufferedReader
 *       │    └── java.io.LineNumberReader
 *       ├── java.io.CharArrayReader
 *       ├── java.io.FilterReader
 *       │    └── java.io.PushbackReader
 *       ├── java.io.InputStreamReader
 *       │    └── java.io.FileReader
 *       ├── java.io.PipedReader
 *       └── java.io.StringReader
 *
 *
 *                Object
 *                  |
 *               Writer (abstract)
 *                  |
 *      ------------------------------------
 *      |              |                   |
 * BufferedWriter  OutputStreamWriter   StringWriter
 *                       |
 *                   FileWriter
 *
 * java.lang.Object
 *  └── java.io.Writer        (abstract)
 *       ├── java.io.BufferedWriter
 *       ├── java.io.CharArrayWriter
 *       ├── java.io.FilterWriter
 *       ├── java.io.OutputStreamWriter
 *       │    └── java.io.FileWriter
 *       ├── java.io.PipedWriter
 *       ├── java.io.PrintWriter
 *       └── java.io.StringWriter
 *
 * ------------------------------------------------------
 * USE CHARACTER STREAMS FOR:
 * ------------------------------------------------------
 * Text files (.txt, .csv, .json, .xml)
 * Logs
 * Configuration files
 * Unicode / multi-language text
 *
 * NOT suitable for images, PDFs, videos
 */

public class Main {
///    Write the base root dir here where the file is located or where you want to create.
    static String rootDir = "";
    public static void main(String[] args) {

        writeTextUsingFileWriter();
        readTextUsingBufferedReader();

        writeFormattedTextUsingPrintWriter();

        unicodeTextDemo();
        byteToCharBridgeDemo();
    }

    /* =====================================================
     * BASIC TEXT WRITING (FileWriter)
     * ===================================================== */
    private static void writeTextUsingFileWriter() {
        File file = new File(rootDir+"char_text.txt");

        System.out.println("Writing text using file Writer");
        try (FileWriter fw = new FileWriter(file)) {

            fw.write("This is written using FileWriter\n");
            fw.write("FileWriter writes characters, not bytes\n");

            System.out.println("Text written using FileWriter.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* =====================================================
     * READING TEXT LINE BY LINE (BufferedReader)
     * ===================================================== */
    private static void readTextUsingBufferedReader() {
        File file = new File(rootDir+"char_text.txt");

        System.out.println("\nReading text using Buffered Reader.");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* =====================================================
     * FORMATTED TEXT OUTPUT (PrintWriter)
     * ===================================================== */
    private static void writeFormattedTextUsingPrintWriter() {
        File logFile = new File(rootDir+"char_log.txt");

        try (PrintWriter pw = new PrintWriter(new FileWriter(logFile))) {

            pw.println("Application Started");
            pw.printf("User ID: %d%n", 101);
            pw.printf("CPU Usage: %.2f%%%n", 72.356);
            pw.println("Application Finished");

            System.out.println("Formatted text written using PrintWriter.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* =====================================================
     * UNICODE SUPPORT DEMO (Why Char Streams Matter)
     * ===================================================== */
    private static void unicodeTextDemo() {
        File unicodeFile = new File(rootDir+"char_unicode.txt");

        try (Writer writer = new BufferedWriter(new FileWriter(unicodeFile))) {

            writer.write("English: Hello\n");
            writer.write("Hindi: नमस्ते\n");
            writer.write("Chinese: 你好\n");
            writer.write("Rune: ᛞ\n");

            System.out.println("Unicode text written successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* =====================================================
     * BYTE → CHARACTER BRIDGE (IMPORTANT)
     * =====================================================
     *
     * InputStreamReader converts BYTE STREAM → CHAR STREAM
     * Useful when reading text from:
     * - Network streams
     * - Binary sources
     * - Files with specific encoding
     */
    private static void byteToCharBridgeDemo() {
        File file = new File(rootDir+"char_text.txt");

        try (
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader br = new BufferedReader(isr)
        ) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("[BRIDGE] " + line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
