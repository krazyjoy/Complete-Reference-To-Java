package guide.multithreading_11;

public class main_thread {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("Current thread: " + t);

        // change the name of the thread
        t.setName("My thread");
        System.out.println("After name changed: " + t);

        try{
            for(int n=5; n>0; n--){
                System.out.println(n);
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e){
            System.out.println("Main thread interrupted.");
        }
    }
}
