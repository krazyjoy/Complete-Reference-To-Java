package guide.multithreading_11;

class NewThread extends Thread{
    NewThread(){
        super("extended thread");
        System.out.println("Child thread: " + this);
        start();
    }

    public void run(){
        try{
            for(int i=5; i>0; i--){
                System.out.println("Child Thread: " + i);
                Thread.sleep(500);
            }
        }
        catch(InterruptedException e){
            System.out.println("Child thread interrupted.");
        }
        System.out.println("Exiting child thread.");
    }
}

public class extend_thread{
    public static void main(String[] args) {
        new NewThread();
        try{
            for(int i=5; i>0; i--){
                System.out.println("Main Thread: " + i);
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e){
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Exiting main thread.");
    }
}