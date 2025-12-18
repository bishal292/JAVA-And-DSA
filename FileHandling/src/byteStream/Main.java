package byteStream;

import java.io.*;

/**
 * ======================================================
 * JAVA BYTE STREAMS – COMPLETE DEMO (SINGLE FILE)
 * ======================================================
 *
 * Byte Streams deal with RAW BINARY DATA (8-bit).
 * They are used when data must be transferred EXACTLY
 * as it exists, without encoding/decoding.
 *
 * ------------------------------------------------------
 * CLASS HIERARCHY (Simplified)
 * ------------------------------------------------------
 * Object
 *  │
 *  InputStream
 *  ├── ByteArrayInputStream
 *  ├── FileInputStream
 *  ├── FilterInputStream
 *  │    ├── BufferedInputStream
 *  │    ├── DataInputStream
 *  │    └── PushbackInputStream
 *  ├── ObjectInputStream
 *  ├── PipedInputStream
 *  └── SequenceInputStream
 *
 *
 *              Object
 *                |
 *          InputStream (abstract)
 *                |
 *      --------------------------------
 *      |              |               |
 * FileInputStream BufferedInputStream DataInputStream
 *
 *
 *              Object
 *                |
 *         OutputStream (abstract)
 *                |
 *      --------------------------------
 *      |              |               |
 * FileOutputStream BufferedOutputStream FilterOutputStream
 *                                           |
 *                                      PrintStream
 * Object
 *  │
 *  OutputStream
 *  ├── ByteArrayOutputStream
 *  ├── FileOutputStream
 *  ├── FilterOutputStream
 *  │    ├── BufferedOutputStream
 *  │    ├── DataOutputStream
 *  │    └── PrintStream
 *  ├── ObjectOutputStream
 *  └── PipedOutputStream
 *
 * ------------------------------------------------------
 * USE BYTE STREAMS FOR:
 * ------------------------------------------------------
 * Images
 * PDFs
 * Videos / Audio
 * Encrypted data
 * Any binary file
 *
 *
 * NOT recommended for Unicode text processing
 */

public class Main {
    ///    Write the base root dir here where the file is located or where you want to create.
    static String rootDir = "";
    public static void main(String[] args) {
        writeTextUsingByteStream();
//        readTextUsingByteStream();

        copyImageFile();
        copyPdfFile();

        consoleAndFileLogging();
    }

    /* =====================================================
     * WORKING WITH TEXT FILE USING BYTE STREAM
     * ===================================================== */
    private static void writeTextUsingByteStream() {
        File file = new File(rootDir+"note.txt");

        try (FileOutputStream fos = new FileOutputStream(file)) {

            String content = "Writing TEXT using ByteStream\n"
                    + "Internally this is binary data\n";

            fos.write(content.getBytes()); // converts text to bytes
            System.out.println("Text written using FileOutputStream");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readTextUsingByteStream() {
        File file = new File(rootDir+"note.txt");

        try (FileInputStream fis = new FileInputStream(file)) {

            int data;
            while ((data = fis.read()) != -1) {
                System.out.print((char) data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* =====================================================
     * IMAGE FILE COPY (MOST COMMON BYTE STREAM USE)
     * ===================================================== */
    private static void copyImageFile() {
        File source = new File(rootDir+"output.txt");
        File destination = new File(rootDir+"output2.txt");

        try (
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))
        ) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            System.out.println("Image copied successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* =====================================================
     * PDF / ANY BINARY FILE COPY
     * ===================================================== */
    private static void copyPdfFile() {
        File source = new File(rootDir+"demo.pdf");
        File destination = new File(rootDir+"demo_copy.pdf");

        try (
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))
        ) {

            byte[] buffer = new byte[8192]; // larger buffer for big files
            int count;

            while ((count = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, count);
            }

            System.out.println("PDF copied successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* =====================================================
     * PRINTSTREAM (TEXT FORMATTING OVER BYTE STREAM)
     * ===================================================== */
    private static void consoleAndFileLogging() {
        File logFile = new File(rootDir+"app.log");

        try (PrintStream ps = new PrintStream(new FileOutputStream(logFile))) {

            ps.println("Application Started");
            ps.println("User ID: 101");
            ps.printf("CPU Load: %.2f%%%n", 73.456);
            ps.println("Application Finished");

            System.out.println("Logs written using PrintStream.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
