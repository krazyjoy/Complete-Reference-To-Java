package guide.multithreading_11;

class Callme{
    // no synchronized method defined
    void call(String msg){
        System.out.println("[" + msg);
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            System.out.println("interrupted.");
        }
        System.out.println("]");
    }
}

class Caller implements Runnable{
    Callme target;
    String msg;
    Thread t;

    public Caller(Callme targ, String s){
        target = targ;
        msg = s;
        t = new Thread(this);
        t.start();
    }
    public void run(){
        // add synchronized statement to the object
        synchronized(target){
            target.call(msg);
        }
        
    }
}

public class synchronized_statement {
    public static void main(String[] args) {
        Callme target = new Callme();
        Caller obj1 = new Caller(target, "Hello");
        Caller obj2 = new Caller(target, "Synchronized");
        Caller obj3 = new Caller(target, "World");
        try{
            obj1.t.join();
            obj2.t.join();
            obj3.t.join();
        }
        catch(InterruptedException e){
            System.out.println("Interrupted.");
        }
    }
}
