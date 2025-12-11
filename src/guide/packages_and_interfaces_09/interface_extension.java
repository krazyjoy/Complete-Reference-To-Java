package guide.packages_and_interfaces_09;


interface IFA{
    void meth1();
    void meth2();
}

interface IFB extends IFA{
    void meth3();
}

class MyClass implements IFB{
    public void meth1(){
        System.out.println("Implement meth1().");
    }
    public void meth2(){
        System.out.println("Implement meth2().");
    }
    public void meth3(){
        System.out.println("Implement meth3().");
    }
}

public class interface_extension {
    public static void main(String args[]){
        MyClass ob = new MyClass();
        ob.meth1();
        ob.meth2();
        ob.meth3();
    }
}
