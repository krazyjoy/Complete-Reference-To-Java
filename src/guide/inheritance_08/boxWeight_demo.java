package guide.inheritance_08;
class Box{
    double width;
    double height;
    double depth;
    
    Box(){
        width = -1;
        height = -1;
        depth = -1;
    }
    Box(double w, double h, double d){
        width = w;
        height = h;
        depth = d;
    }
    double volume(){
        return width*height*depth;
    }
}
class BoxWeight extends Box{
    double weight;

    BoxWeight(double w, double h, double d, double m){
        super(w, h, d);
        weight = m;
    }
}
public class boxWeight_demo {
    public static void main(String args[]){

    }
}




