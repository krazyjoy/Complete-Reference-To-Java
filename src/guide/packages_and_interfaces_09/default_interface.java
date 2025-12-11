package guide.packages_and_interfaces_09;

interface MyIF{
    // standard interface declaration
    int getNumber();

    // default interface method
    default String getString(){
        return "Default String";
    }
}


class MyIfImp implements MyIF{
    public int getNumber(){
        return 100;
    }
}

class MyIfImp2 implements MyIF{
    public int getNumber(){
        return 100;
    }
    public String getString(){
        return "This is a different string.";
    }
}
public class default_interface {
    public static void main(String[] args) {
        MyIfImp obj = new MyIfImp();
        System.out.println(obj.getNumber());
        System.out.println(obj.getString());

        MyIfImp2 obj2 = new MyIfImp2();
        System.out.println(obj2.getString());
    }
}
