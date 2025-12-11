package guide.packages_and_interfaces_09;

interface MyIF{
    int getNumber();
    default String getString(){
        return "Default String";
    }
    static int getDefaultNumber(){
        return 0;
    }
}
class MyIFImp implements MyIF{
    public String getString(){
        return "A different String";
    }
    public int getNumber(){
        return 200;
    }
}
public class static_in_interface {
    public static void main(String[] args) {
        int defNum = MyIF.getDefaultNumber();
        System.out.println("default number: " + defNum);
    }
}
