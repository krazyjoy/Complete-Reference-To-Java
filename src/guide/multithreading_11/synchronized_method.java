package guide.multithreading_11;


// creates an object that contains input string
// normal output: [msg]
class Callme{
    synchronized void call(String msg){
        System.out.println("[" + msg);
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }
}

// thread class
class Caller implements Runnable{
    String msg;
    Callme target;
    Thread t;
    Caller(Callme targ, String s){
        target = targ;
        msg = s;
        t = new Thread(this);
        t.start();
    }
    public void run(){
        target.call(msg);
    }
}   
public class synchronized_method {
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
