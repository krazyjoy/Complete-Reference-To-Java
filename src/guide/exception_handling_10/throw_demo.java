package guide.exception_handling_10;

public class throw_demo {
    
    static void demoproc(){
        try{
            throw new NullPointerException("demo");
        }
        catch(NullPointerException e){
            System.out.println("Caught inside demoproc");
            throw e;
        }
    }
    static void throwOne(){
        System.out.println("Inside throwOne.");
        // throw new IllegalAccessException("demo");

    }

    public static void main(String[] args) {
        try{
            demoproc();
        }
        catch(NullPointerException e){
            System.out.println("Recaught: "+ e);
        }
    }
}
