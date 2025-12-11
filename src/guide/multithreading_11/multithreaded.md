## multithreaded programming
a multithreaded program contains two or more parts that can run concurrently <br>
each part of such a program is called a *thread*, and each *thread* separate path of execution

## multitasking
- process-based
    - a process, is a program that is executing
    - a process-based multitasking is a feature that allows your computer to run two or more programs concurrently
    - e.g. you can run a java compiler while visiting a website

- thread-based
    - a thread is the smallest unit of dispatchable code
    - a single program can perform tow or more tasks simultaneously
    - e.g. a text editor can format text at the same time that it is printing



## benefit of multithreading
1. enables to make maximum use of the processing power available in the system
    (keep idle time to minimum)

## JAVA Thread Model
- Java's multithreading features works in both single-core and multi-core system
- in a single-core system
    - each thread receiving a slice of CPU time
- in a multi-core system
    - two or more threads can execute simultaneously

## thread priorities
Java assigns to each thread a priority that determines how that thread should be treated with respect to the others <br>
A thread priority determines when to switch from one running thread to the next, so called - *context switching*

- a thread can voluntarily relinquish control: <br>
    this is done by explicitly yielding, sleeping or blocking on pending i/o.
    In this scenario, all other threads are examined, and the highest-priority thread that is ready to run is given the CPU
- a thread can be preempted by a higher-priority thread: <br>
    In this case, a lower-priority thread that does not yield the processor is simply preempted.


## synchronization
multithreading introduces asynchronous behaviors to your program
$\rightarrow$ we need to enforce synchronicity when needed <br>
e.g. prevent one thread from writing data while another thread is in the middle of reading it
**How??**
Java implements an elegant twist on an age-old model pf interprocess synchronization: the *monitor* <br>
The monitor is a control mechanism that it can hold one thread at a time. When a thread enters a monitor, all other threads must wait until that thread exits the monitor.

## thread class & runnable interface

| Method      | Meaning                                  |
|-------------|------------------------------------------|
| getName     | obtain a thread's name                   |
| getPriority | obtain a thread's priority               |
| isAlive     | determine if a thread is still running   |
| join        | wait for a thread to terminate           |
| run         | entry point for the thread               |
| sleep       | suspend a thread for a period of time    |
| start       | start a thread by calling its run method |

## main thread
main thread is created and begins running when a java program starts up <br>
- main thread will spawn other *child* threads
- main thread must be the **last** thread to finish execution because it performs various shutdown actions

main thread can be controlled by `Thread` object:
1. obtain the reference of main thread: call the method `currentThread()` <br>
    ```java
    static Thread currentThread()
    ```

2. once you have the reference of main thread, you can perform actions like using the methods above
    ```java
    t.setName("My thread");
    ```
    see `main_thread.java` for example

3. the printed information of thread shows 3 compartments
    ```java
    Thread t = Thread.currentThread();
    System.out.println("Current thread: " + t);

    // Thread[#1,main,5,main]
    ```
    <br>
    [priority, the name of thread, the name of its group]

## creating a thread
Two ways to create a thread
1. implement the **Runnable** interface
2. extend the **Thread** class

### Implement a Runnable
**Runnable** abstracts a unit of executable code. <br>
To implement a **Runnable**, a class need only implement a simple method called **run()**
The **start()** method calls the function implemented in **run()**
```java
class newThread implements Runnable{
    Thread t;
    newThread(){
        // create a new second thread
        t = new Thread(this, "demo thread"); // Thread(Runnable threadOb, String threadName);
        t.start();
    }
    public void run(){

    }

}
```
### Extending a thread
1. create a new class that extends **Thread**, then create an instance of that class <br>
2. the extending class must override the **run()** method, which is the entry point for the new thread
```java
class NewThread extends Thread{
    NewThread(){
        super("Demo thread");
        start();
    }
    public void run(){
        try{

        }
        catch(){

        }
    }
}

class ExtendThread{
    public static void main(String args[]){
        new NewThread();
        ...
    }
}
```

## isAlive and join
We want the main thread to finish last. In the preceding examles, this is accomplished by calling **sleep()** within **main()**,
with a long enough delay to ensure that all child threads terminate prior to the main thread.
### How do we know if a thread has ended?
- `isAlive()` - returns `true` if the thread upon which it is called is still running
- `join()` - waits for a thread to finish until the specified thread `joins` it
- e.g. `join_demo`



## synchronized method
the keyword `synchronized` preceding method name will serialize access to the specified method
    ```java
    synchronized void call(String msg){

    }
    ```

Within the program of `synchronized_method.java`,
the **Callme** class creates an object that carries input string. The **Caller** class creates thread that takes **Callme** objects. The program `join()` three threads with string `[Hello], [Synchronized], [World]`.



- an example of not using `synchronized` keyword:
    ```
    [Hello
    [Synchronized
    [World
    ]
    ]
    ]
    ```
- an example of using `synchronized` keyword:
    ```
    [Hello
    ]
    [World
    ]
    [Synchronized
    ]
    ```

## synchronized statement
It is possible that a third party source code does not use synchronize methods in their classes. Thus, you can't add `synchronized` to the appropriate method within the class. <br>

**How to access to an object of this class be synchronized**
```
synchronized(objref){
    // statements
}
```
e.g.
```java
class Callme{
    // no synchronized method defined
    void call(){

    }
}

class Caller implements Runnable{
    Callme target;
    String msg;

    public Caller(Callme targ, String s){

    }
    public void run(){
        // add synchronized statement to the object
        synchronized(target){
            target.call(msg)
        }
    }
}
```

## interthread communication
- multithreading replaces loop programming by dividing tasks into discrete, logical units.
- to avoid polling, java includes an elegant interprocess communication mechanism via the **wait()**, **notify()**, **notifyAll()** methods.
- all three methods are implmeneted as final methods, thus can be called only from within **synchronized** context

    - `wait()` - tells the calling thread to give up the monitor(=processing), and go to sleep until some other thread enters and calls `notify()` or `notifyAll()`
    - `notify()` - wakes a thread that called `wait()` on the same object
    - `notifyAll()` - wakes up all the threads that called `wait()` on the same object. One of the threads will be granted access.

- example of producer and consumer program (`producer_consumer.java`) that does not use `wait()` and `notify()`
    ```
    Put: 1
    Got: 1
    Got: 1
    Got: 1
    Got: 1
    Got: 1
    Put: 2
    Put: 3
    Put: 4
    Got: 4
    ```
    nothing prevents producer from overrunning the consumer, nor will anything stop consumer from consuming the same queue value twice.

- example of producer and consumer program (`wait_n_notify.java`) that uses `wait()` and `notify()`
    ```
    Got: 505018
    Put: 505019
    Got: 505019
    Put: 505020
    Got: 505020
    Put: 505021
    ```

## ERROR in Multitasking - Deadlock
occurs when two threads have a circular dependency on a pair of synchronized objects
e.g one thread enters the monitor on onject X, and another thread enters the monitor on object Y.
If the thread in X tries to call any synchronized method on Y, it will block as expected.
However, if the thread in Y, in turn, tries to call any synchronized method on X, the thread waits forever,
because to access X, it would have to release its own lock on Y, so that the first thread could complete.

- example: `deadlock.java`
