package guide.packages_and_interfaces_09.examples.p1;
/*
SamePackage is not a subclass of Protection, but is in the same package
-> Granted to all access but n_pri
*/
public class SamePackage {
    SamePackage(){
        Protection p = new Protection();
        System.out.println("same package constructor");
        
        // System.out.println("n_pri = " +p.n_pri);
        System.out.println("n_pro = " + p.n_pro);
        System.out.println("n_pub = " + p.n_pub);
    }


}
