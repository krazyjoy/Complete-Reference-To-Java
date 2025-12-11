package guide.packages_and_interfaces_09.examples.p2;
import guide.packages_and_interfaces_09.examples.p1.Protection;

/*
Protection2 is a subclass of p1.Protection
- this grants access to all p1.Protection variables except for n_pri (private) and n (default protection)

*/

class Protection2 extends Protection{
    Protection2(){
        System.out.println("derived other package constructor");
        
        // class or package only 
        // System.out.println("n = " + n);
        // System.out.println("n_pro = " + n_pro);
        System.out.println("n_pub = "+ n_pub);
    }

}

