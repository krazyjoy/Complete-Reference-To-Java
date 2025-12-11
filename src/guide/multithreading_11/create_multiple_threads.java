package guide.multithreading_11;
class NewThread2 implements Runnable{
    Thread t;
    String name;

    NewThread2(String threadName){
        name = threadName;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
        t.start();
    }
    public void run(){
        try{
            for(int i=5; i>0; i--){
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e){
            System.out.println(name + " interrupted.");
        }
        System.out.println(name + " exiting.");
    }
}
public class create_multiple_threads {
    public static void main(String[] args) {
        new NewThread2("One");
        new NewThread2("Two");
        new NewThread2("Three");

        try{
            Thread.sleep(10000);
        }
        catch(InterruptedException e){
            System.out.println("main thread interrupted.");
        }
        System.out.println(" main thread exiting.");
    }
}
