package guide.class_advanced_07;

class Outer{
    int outer_x = 100;
    class Inner{
        int y = 10;
        void display(){
            System.out.println("display: outer_x = "+ outer_x);
        }
    }
    void test(){
        Inner inner = new Inner();
        inner.display();
    }
    // y is local to Inner class
    // void show_y(){
    //     System.out.println("show_y: y = "+y);
    // }

}
public class inner_class_demo {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.test();
    }
}
