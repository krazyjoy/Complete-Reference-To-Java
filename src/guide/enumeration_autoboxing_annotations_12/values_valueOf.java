package guide.enumeration_autoboxing_annotations_12;

enum Apple{
    Jonathan, GoldenDel, RedDel, Winesap, Cortland;
}
public class values_valueOf {
    public static void main(String[] args) {
        Apple ap;
        Apple allApples[] = Apple.values();
        for(Apple a: allApples)
            System.out.println(a);
        ap = Apple.valueOf("Winesap");
        System.out.println("ap contains " + ap);
    }

}

