package guide.packages_and_interfaces_09.examples.p1;

/*
Derived is a subclass of Protection
-> Derived is granted access to every variable in Protection except for n_pri

*/
public class Derived extends Protection{
    Derived(){
        System.out.println("derived constructor");
        System.out.println("n = " + n);

        // System.out.println("n_pri = "+ n_pri);

        System.out.println("n_pro" + n_pro);
        System.out.println("n_pub = "+ n_pub);
    }

}
