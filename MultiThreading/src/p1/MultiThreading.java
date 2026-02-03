package p1;

/**
 * ============================================ MULTITHREADING IN JAVA ============================================
 * <p>
 * Multithreading: Multithreading is a feature of Java that allows a program to execute multiple threads concurrently.
 * A thread is a lightweight sub-process, the smallest unit of execution within a process.
 * <p>
 * In simple words:
 * -> A process can have multiple threads
 * -> Threads run in parallel (or appear to, via CPU time slicing)
 * -> This improves performance, responsiveness, and resource utilization
 * <p>
 * Example:
 * Browser Tabs, Video Streaming, Games, Server Application.
 * <p>
 * -------------------------------------------- THREAD vs PROCESS -------------------------------------------------
 * <p>
 * Process:
 * -> Heavyweight
 * -> Has its own memory space
 * -> Communication is expensive
 * <p>
 * Thread:
 * -> Lightweight
 * -> Shares memory with other threads of the same process
 * -> Faster communication
 * <p>
 * <p>
 * -------------------------------------------- CREATING THREADS --------------------------------------------------
 * <p>
 * There are mainly 2 ways to create threads in Java:
 * <p>
 * 1. By extending Thread class
 * 2. By implementing Runnable interface (Recommended)
 * <p>
 * <p>
 * 1. Extending Thread class:
 * -> Create a class that extends Thread
 * -> Override run() method
 * -> Call start() method to begin execution
 * <p>
 * Example:
 * class MyThread extends Thread {
 * public void run() {
 * System.out.println("Thread running");
 * }
 * }
 * <p>
 * <p>
 * 2. Implementing Runnable interface:
 * -> Implement Runnable
 * -> Override run()
 * -> Pass Runnable object to Thread constructor
 * <p>
 * Example:
 * class MyTask implements Runnable {
 * public void run() {
 * System.out.println("Task running");
 * }
 * }
 * <p>
 * Thread t = new Thread(new MyTask());
 * t.start();
 * <p>
 * NOTE:
 * -> Runnable is preferred because Java supports single inheritance
 * -> Enables better separation of task and thread
 * <p>
 * <p>
 * -------------------------------------------- THREAD LIFE CYCLE --------------------------------------------------
 * <p>
 * 1. New       -> Thread created but not started
 * 2. Runnable -> start() called, thread ready to run
 * 3. Running  -> CPU executing the thread
 * 4. Waiting / Blocked -> Waiting for resources / sleep / join
 * 5. Terminated -> Execution completed
 * <p>
 * <p>
 * -------------------------------------------- IMPORTANT THREAD METHODS -----------------------------------------
 * <p>
 * start()     -> Starts thread, internally calls run()
 * run()       -> Contains thread logic
 * sleep(ms)   -> Pauses execution for given time
 * join()      -> Waits for another thread to finish
 * yield()     -> Gives chance to other threads
 * getName()   -> Returns thread name
 * getPriority()-> Returns priority
 * <p>
 * <p>
 * -------------------------------------------- THREAD PRIORITY ---------------------------------------------------
 * <p>
 * Priority Range: 1 (MIN_PRIORITY) to 10 (MAX_PRIORITY)
 * Default Priority: 5
 * <p>
 * NOTE:
 * -> Priority is a hint to JVM, not a guarantee
 * <p>
 * <p>
 * -------------------------------------------- SYNCHRONIZATION ---------------------------------------------------
 * <p>
 * Synchronization is used to prevent multiple threads from accessing
 * shared resources simultaneously, avoiding data inconsistency.
 * <p>
 * Types:
 * 1. Synchronized method
 * 2. Synchronized block
 * <p>
 * Example:
 * synchronized void increment() {
 * count++;
 * }
 * <p>
 * Problem without synchronization:
 * -> Race Condition
 * -> Inconsistent data
 * <p>
 * <p>
 * -------------------------------------------- INTER-THREAD COMMUNICATION ----------------------------------------
 * <p>
 * Methods:
 * -> wait()
 * -> notify()
 * -> notifyAll()
 * <p>
 * These methods are used to coordinate execution between threads.
 * <p>
 * NOTE:
 * -> Must be called inside synchronized block
 * -> Defined in Object class
 * <p>
 * <p>
 * -------------------------------------------- DAEMON THREAD -----------------------------------------------------
 * <p>
 * Daemon Thread:
 * -> Runs in background
 * -> JVM terminates daemon threads automatically when all user threads finish
 * <p>
 * Example:
 * Garbage Collector
 * <p>
 * setDaemon(true);
 * <p>
 * <p>
 * -------------------------------------------- DEADLOCK ----------------------------------------------------------
 * <p>
 * Deadlock:
 * A situation where two or more threads are waiting for each other
 * indefinitely to release resources.
 * <p>
 * Causes:
 * -> Circular dependency
 * -> Improper synchronization
 * <p>
 * <p>
 * -------------------------------------------- VOLATILE KEYWORD --------------------------------------------------
 * <p>
 * volatile keyword ensures visibility of changes to variables across threads.
 * It prevents thread caching of variables.
 * <p>
 * NOTE:
 * -> Does NOT provide atomicity
 * <p>
 * <p>
 * -------------------------------------------- MULTITHREADING vs CONCURRENCY -------------------------------------
 * <p>
 * Multithreading:
 * -> Multiple threads within a single process
 * <p>
 * Concurrency:
 * -> Structure of program that deals with multiple tasks at once
 * <p>
 * <p>
 * -------------------------------------------- BEST PRACTICES ----------------------------------------------------
 * <p>
 * -> Prefer Runnable over Thread
 * -> Avoid unnecessary synchronization
 * -> Minimize shared mutable data
 * -> Handle InterruptedException properly
 * -> Avoid deadlocks
 * <p>
 * <p>
 * -------------------------------------------- ONE-LINE INTERVIEW SUMMARY ----------------------------------------
 * <p>
 * Multithreading allows concurrent execution of multiple threads within a process
 * to improve performance and responsiveness while sharing common resources.
 *
 */

class MyThread extends Thread {
    StringBuffer stringBuffer;
    StringBuilder stringBuilder;

    MyThread(StringBuffer stringBuffer, StringBuilder stringBuilder) {
        this.stringBuffer = stringBuffer;
        this.stringBuilder = stringBuilder;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +" : Priority :"+Thread.currentThread().getPriority());
        for (int i = 0; i < 100; i++) {
            System.out.println("MyThread is running");

            stringBuffer.append('*');
            stringBuilder.append('*');

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // restore interrupt status
                return; // exit cleanly
            }
        }
    }
}

class MyThread2 implements Runnable {
    StringBuffer stringBuffer;
    StringBuilder stringBuilder;

    MyThread2(StringBuffer stringBuffer, StringBuilder stringBuilder) {
        this.stringBuffer = stringBuffer;
        this.stringBuilder = stringBuilder;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +" : Priority :"+Thread.currentThread().getPriority());
        for (int i = 0; i < 100; i++) {
            System.out.println("MyThread2 is running");

            stringBuffer.append('#');
            stringBuilder.append('#');

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // restore interrupt status
                return; // exit cleanly
            }
        }
    }
}

public class MultiThreading {
    public static void main(String[] args) throws InterruptedException {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();


        MyThread t1 = new MyThread(stringBuffer,stringBuilder);

        t1.setPriority(Thread.MAX_PRIORITY);/// We can set the priority for a thread, Which is just a hint to the JVM.

        MyThread2 mt2 = new MyThread2(stringBuffer,stringBuilder);
        Thread t2 = new Thread(mt2);

        t1.start();
//        Thread.sleep(1);/// Will Make the current thread to sleep for 1 millisecond
        t2.start();

        t1.join();
        t2.join();

        System.out.println("=======================================================================");
        System.out.println("String Builder Size : "+stringBuilder.length());
        System.out.println("String Buffer Size : "+stringBuffer.length());
//        System.out.println(stringBuilder);
//        System.out.println(stringBuffer);

        String str1 = stringBuilder.toString();
        String str2 = stringBuffer.toString();

        System.out.println(str1.equals(str2));
        System.out.println(firstMismatchIndex(str1, str2)); // compare builder vs buffer (was buffer vs buffer)

    }

    public static int firstMismatchIndex(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length());

        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return i;
            }
        }

        return s1.length() == s2.length() ? -1 : len;
    }

}
