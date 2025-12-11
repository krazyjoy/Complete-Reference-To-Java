package guide.multithreading_11;

class deadlockA{
    synchronized void foo(deadlockB b){
        String name = Thread.currentThread().getName();
        System.out.println(name + " entered deadlockA.foo");
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            System.out.println("DeadlockA interrupted.");
        }
        System.out.println(name + "trying to call deadlockB.last()");
        b.last();
    }
    synchronized void last(){
        System.out.println("Inside deadlockA.last");
    }
}

class deadlockB{
    synchronized void bar(deadlockA a){
        String name = Thread.currentThread().getName();
        System.out.println(name + " entered deadlockB.foo");
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            System.out.println("DeadlockB interrupted.");
        }
        System.out.println(name + "trying to call deadlockA.last()");
        a.last();
    }
    synchronized void last(){
        System.out.println("Inside deadlockB.last");
    }
}
public class deadlock implements Runnable{
    deadlockA a = new deadlockA();
    deadlockB b = new deadlockB();
    deadlock(){
        Thread.currentThread().setName("MainThread");
        Thread t = new Thread(this, "RacingThread");
        t.start();

        a.foo(b); // get lock on a in this thread
        System.out.println("Back in main thread.");
    }
    public void run(){
        b.bar(a); // get lock on b in other thread (because the run() runs on the newly created thread)
        System.out.println("Back in other thread");
    }

    public static void main(String args[]){
        // RacingThread owns the monitor on b, while it is waiting for the monitor on a
        // At the same time, MainThread owns a and is waiting to get b.
        new deadlock();
    }
}
