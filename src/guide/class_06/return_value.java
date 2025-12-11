package guide.class_06;

class Box3{
    double width;
    double height;
    double depth;

    double volume(){
        return width * height * depth;
    }
}
public class return_value {
    public static void main(String args[]){
        Box3 mybox1 = new Box3();
        Box3 mybox2 = new Box3();
        double vol;

        mybox1.width = 10;
        mybox1.height = 20;
        mybox1.depth = 15;

        mybox2.width = 3;
        mybox2.height = 6;
        mybox2.depth = 9;

        vol = mybox1.volume();
        System.out.println("Volume is " + vol);
        vol = mybox2.volume();
        System.out.println("Volume is " + vol);
       
    }
}
