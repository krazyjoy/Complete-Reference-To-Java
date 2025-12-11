package guide.class_06;

class Box4{
    double width;
    double height;
    double depth;

    double volume(){
        return width * height * depth;
    }

    void setDim(double w, double h, double d){
        width = w;
        height = h;
        depth = d;
    }
}
public class parameterized {
    public static void main(String[] args) {
        Box4 mybox1 = new Box4();
        Box4 mybox2 = new Box4();
        double vol;

        mybox1.setDim(10, 20, 15);
        mybox2.setDim(3, 6, 9);

        vol = mybox1.volume();
        System.out.println("Volume is "+vol);
        vol = mybox2.volume();
        System.out.println("Volume is "+vol);
    }
}
