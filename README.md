# Concurrent Audits

This repository contains Java code that demonstrates concurrent auditing operations. 

The `App` class serves as the entry point for the application. It demonstrates concurrent auditing 
operations `add` `remove` and `inStock` by utilizing a fixed thread pool of three threads.

In the synchronized `add` and `remove` methods should display their "START" messages in order and complete 
their operations before displaying their corresponding "END" messages. Also notice that whichever synchronized 
method add od remove wins the race and locks the Audit object it will be able to finish running before the 
other synchronized method is allowed to start

The thread IDs for the "START" and "END" messages of add and remove should match, indicating that the same 
thread is performing the entire operation.

Since `inStock` is not synchronized, it's "START" and "END" messages may appear interleaved with the "START" 
and "END" messages of add and remove, and their thread IDs may differ.

# Run 


```
gradle run
```


# Example output
```
gradle run 

> Task :app:run
executorService submit add at: 20:59:44.000
executorService submit remove at: 20:59:44.000
executorService submit inStock at: 20:59:44.000

Thread 12 add(int amount) START at: 20:59:44.040
Thread 13 inStock() START at: 20:59:44.040
Thread 13 inStock() END at: 20:59:44.164
...
Thread 13 inStock() START at: 20:59:44.898
Thread 13 inStock() END at: 20:59:45.001
Thread 13 inStock() START at: 20:59:45.002
Thread 12 add(int amount) END at: 20:59:45.060
Thread 14 remove(int amount) START at: 20:59:45.062
Thread 13 inStock() END at: 20:59:45.107
Thread 13 inStock() START at: 20:59:45.107
Thread 13 inStock() END at: 20:59:45.210
...
Thread 13 inStock() START at: 20:59:45.939
Thread 13 inStock() END at: 20:59:46.040
Thread 13 inStock() START at: 20:59:46.046
Thread 14 remove(int amount) END at: 20:59:46.067
Thread 13 inStock() END at: 20:59:46.154
```