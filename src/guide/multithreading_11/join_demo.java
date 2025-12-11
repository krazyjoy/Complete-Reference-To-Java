package guide.multithreading_11;

import guide.multithreading_11.create_multiple_threads;

public class join_demo {
    

    public static void main(String[] args) {
        NewThread2 ob1 = new NewThread2("One");
        NewThread2 ob2 = new NewThread2("Two");
        NewThread2 ob3 = new NewThread2("Three");

        System.out.println("Thread One is alive: " + ob1.t.isAlive()); // true
        System.out.println("Thread Two is alive: " + ob2.t.isAlive()); // true
        System.out.println("Thread Three is alive: " + ob3.t.isAlive()); // true


        try{
            System.out.println("Waiting for threads to finish.");
            ob1.t.join(); 
            ob2.t.join();
            ob3.t.join();

            /*
                One: 5
                Two: 5
                Three: 5
                One: 4
                Three: 4
                Two: 4
                One: 3
                Two: 3
                Three: 3
                Two: 2
                One: 2
                Three: 2
                Two: 1
                Three: 1
                One: 1
            */
        }
        catch(InterruptedException e){
            System.out.println("main thread interrupted.");
        }
        System.out.println("Thread One is alive: " + ob1.t.isAlive()); // false
        System.out.println("Thread Two is alive: " + ob2.t.isAlive()); // false
        System.out.println("Thread Three is alive: " + ob3.t.isAlive()); // false
        System.out.println("main thread exiting.");
    }
    
}
