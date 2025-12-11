package guide.exception_handling_10;
import java.util.Random;

public class try_catch {
    public static void main(String args[]){
        int d, a;
        try{
            d = 0;
            a = 42 / d;
            System.out.println("This will not be printed");
        }
        catch(ArithmeticException e){
            System.out.println("Division by zero.");
        }

        int b=0, c=0;
        Random r = new Random();
        for(int i=0; i<32000; i++){
            try{
                b = r.nextInt();
                c = r.nextInt();
                a = 12345 / (b/c);
            }
            catch(ArithmeticException e){
                System.out.println("Division by zero.");
                a=0;
            }
        }
    }
}
