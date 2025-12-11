package guide.packages_and_interfaces_09;

interface Callback{
    void callback(int param);
}

/*
    The version of method (`callback`) is determined by the type of object
    that object refers to at run time
*/

class Client implements Callback{
    public void callback(int p){
        System.out.println("callback called with "+ p);
    }

    void nonIfaceMeth(){
        System.out.println("Classes that implement interfaces " +
            "may also define other members, too."
        );
    }
}

class AnotherClient implements Callback{
    public void callback(int p){
        System.out.println("Another version of callback");
        System.out.println("p squared is "+ (p*p));
    }
}

public class interface_ {
    public static void main(String[] args) {
        Callback c = new Client();
        c.callback(42);

        AnotherClient ac = new AnotherClient();
        c = ac; // Callback object now refers to the callback defined in AnotherClient
        c.callback(42);
        
    }
}
