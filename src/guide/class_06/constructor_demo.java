package guide.class_06;



class Box5{
    double width;
    double height;
    double depth;

    Box5(){
        width = 10;
        height = 10;
        depth = 10;
    }
    double volume(){
        return width * height * depth;
    }

    void setDim(double w, double h, double d){
        width = w;
        height = h;
        depth = d;
    }
}


public class constructor_demo {
    public static void main(String[] args) {
        Box5 mybox1 = new Box5();
        Box5 mybox2 = new Box5();
        double vol;

        // mybox1.setDim(10, 20, 15);
        // mybox2.setDim(3, 6, 9);

        vol = mybox1.volume();
        System.out.println("Volume is "+vol);
        vol = mybox2.volume();
        System.out.println("Volume is "+vol);
    }
}
