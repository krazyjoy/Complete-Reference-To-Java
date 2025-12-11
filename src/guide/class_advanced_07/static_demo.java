package guide.class_advanced_07;

public class static_demo {
    public static void main(String[] args) {
        // call a static method
        staticByName.callme();
        System.out.println("b = " + staticByName.b);
    }
}
class staticByName{
    static int a = 42;
    static int b = 99;
    static void callme(){
        System.out.println("a = " + a);
    }
}
