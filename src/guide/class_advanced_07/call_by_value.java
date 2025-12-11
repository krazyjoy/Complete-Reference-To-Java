package guide.class_advanced_07;

class Test{
    void meth(int i, int j){
        i *= 2;
        j /= 2;
    }
}
public class call_by_value {
    public static void main(String[] args) {
        Test ob = new Test();
        int a = 15, b = 20;
        System.out.println("a & b before call: " + a + " " + b);
        ob.meth(a, b);
        System.out.println("a & b after call: " + a + " " + b);
    }
}

