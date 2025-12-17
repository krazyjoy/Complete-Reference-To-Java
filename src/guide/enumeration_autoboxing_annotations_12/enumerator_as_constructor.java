package guide.enumeration_autoboxing_annotations_12;

// use an enum constructor, instance variable, and method
enum Apple2{
    Jonathan(10), GoldenDel(9), RedDel, Winesap(15), Cortland(8);

    private int price;

    Apple2(){
        price = -1;
    }
    Apple2(int p){
        price = p;
    }
    int getPrice(){
        return price;
    }
}

public class enumerator_as_constructor {
    public static void main(String args[]){
        Apple2 ap;

        // display price of specific apple
        System.out.println("Winesap costs "+ Apple2.Winesap.getPrice() + " cents.\n");

        System.out.println("All apple prices: ");
        for(Apple2 a: Apple2.values()){
            System.out.println(a + " costs " + a.getPrice() + " cents.");
        }
    }
}


