# Concurrent Audits

This repository contains Java code that demonstrates concurrent auditing operations. 

The `App` class serves as the entry point for the application. It demonstrates concurrent auditing operations `add` `remove` and `inStock` by utilizing a fixed thread pool of three threads.

In the synchronized `add` and `remove` methods should display their "START" messages in order and complete their operations before displaying their corresponding "END" messages. The thread IDs for the "START" and "END" messages of add and remove should match, indicating that the same thread is performing the entire operation.

Since `inStock` is not synchronized, its "START" and "END" messages may appear interleaved with the "START" and "END" messages of add and remove, and their thread IDs may differ.

# Run 


```
gradle run
```


# Example output
```
gradle run 

> Task :app:run
executorService submitted add
executorService submitted inStock
executorService submitted remove
13:27:24.976 - Thread 13 Checking START stock.
13:27:24.976 - Thread 12 Adding START 1 item.
13:27:25.100 - Thread 13 Checking END stock.
0
13:27:25.101 - Thread 13 Checking START stock.
13:27:25.100 - Thread 12 Adding END 1 item.1
13:27:25.112 - Thread 12 Adding START 1 item.
13:27:25.205 - Thread 13 Checking END stock.
1
13:27:25.205 - Thread 13 Checking START stock.
13:27:25.218 - Thread 12 Adding END 1 item.2
13:27:25.218 - Thread 12 Adding START 1 item.
13:27:25.311 - Thread 13 Checking END stock.

...

13:27:35.431 - Thread 12 Adding START 1 item.
13:27:35.535 - Thread 12 Adding END 1 item.-71
13:27:35.535 - Thread 12 Adding START 1 item.
13:27:35.638 - Thread 12 Adding END 1 item.-70

...

13:27:45.714 - Thread 12 Adding START 1 item.
13:27:45.816 - Thread 12 Adding END 1 item.0
```