package guide.packages_and_interfaces_09;

interface Callback{
    void callback(int param);
}


/*
    class Incomplete does not implement callback()
    thus must declare "abstract"
    -> any class inherits Incomplete must implement `callback()` or declare `abstract` itself

*/



abstract class Incomplete implements Callback{
    int a, b;
    void show(){
        System.out.println(a + " " + b);
    }
}
public class partial_implementation {
    
}
