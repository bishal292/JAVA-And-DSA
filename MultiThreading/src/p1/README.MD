# Multithreading in Java

Multithreading allows a single Java program (a **process**) to run multiple **threads** concurrently. Threads share the same heap memory, so they can communicate efficiently—but that also introduces race conditions if shared data is mutated without coordination.

This module demonstrates:
- Creating threads via `extends Thread` and `implements Runnable`
- `start()`, `sleep()`, `join()`, thread priority
- Thread-safety difference: `StringBuffer` (synchronized) vs `StringBuilder` (not synchronized)

## Process vs Thread
- **Process**: heavyweight, separate memory space, IPC is expensive
- **Thread**: lightweight, shares process memory, faster coordination but needs synchronization

## Why multithreading is used
- Better **responsiveness** (UI/main thread not blocked by background work)
- Better **throughput** (handle multiple tasks/requests concurrently)
- Overlap CPU work with **I/O waiting**

## Creating threads
### 1) Extending `Thread`
- Override `run()`
- Call `start()` (do not call `run()` directly)

### 2) Implementing `Runnable` (recommended)
- Implement `run()`
- `new Thread(runnable).start()`

Why `Runnable` is preferred:
- avoids inheritance limitation
- separates “task” from “thread”

## Thread lifecycle (high-level)
`NEW → RUNNABLE → (RUNNING) → WAITING/BLOCKED/TIMED_WAITING → TERMINATED`

## Common APIs used in the demo
- `start()` : starts a new thread (invokes `run()` on that new thread)
- `sleep(ms)` : pauses current thread (`TIMED_WAITING`)
- `join()` : wait until another thread finishes
- `setPriority(...)` : scheduling hint (not guaranteed)

## Thread safety: `StringBuffer` vs `StringBuilder`
- `StringBuilder` is **not thread-safe**: concurrent appends can interleave and corrupt internal state/length.
- `StringBuffer` is **synchronized**: safer for concurrent mutation of the same instance.

In `MultiThreading.java`, two threads append different characters to both objects; after both complete:
- `StringBuffer` should be consistent
- `StringBuilder` may show mismatch or unexpected length/content

## Run
See: [MultiThreading.java](./MultiThreading.java)

What to observe:
- Output order is non-deterministic (thread scheduling)
- After `join()`, final lengths and first mismatch index indicate thread-safety behavior
