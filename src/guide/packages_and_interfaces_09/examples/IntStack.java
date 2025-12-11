package guide.packages_and_interfaces_09.examples;

interface intStack {
    void push(int item);
    int pop();
}

class FixedStack implements intStack{
    private int stck[];
    private int tos;

    FixedStack(int size){
        stck = new int[size];
        tos = -1;
    }

    public void push(int item){
        if(tos==stck.length-1)
            System.out.println("Stack is full");
        else
            stck[++tos] = item;
    }

    public int pop(){
        if(tos < 0){
            System.out.println("Stack underflow.");
            return 0;
        }
        else
            return stck[tos--];
    }
}

class DynStack implements intStack{
    private int stck[];
    private int tos;

    DynStack(int size){
        stck = new int[size];
        tos = -1;
    }
    public void push(int item){
        // stack is full, allocate double the size of current stack
        if(tos==stck.length-1){
            int temp[] = new int[stck.length*2];
            for(int i=0; i<stck.length; i++){
                temp[i] = stck[i];
            }
            stck = temp;
            stck[++tos] = item;
        }
        else{
            stck[++tos] = item;
        }
    }
    public int pop(){
        if(tos < 0){
            System.out.println("Stack underflow");
            return 0;
        }
        else{
            return stck[tos--];
        }
    }

}


public class IntStack{

    public static void main(String[] args) {
        FixedStack mystack1 = new FixedStack(5);
        FixedStack mystack2 = new FixedStack(8);

        for(int i=0; i<5; i++)
            mystack1.push(i);
        for(int i=0; i<8; i++)
            mystack2.push(i);

        System.out.println("Stack in mystack1: ");
        for(int i=0; i<5; i++)
            System.out.println(mystack1.pop());
        System.out.println("Stack in mystack2: ");
        for(int i=0; i<8; i++)
            System.out.println(mystack2.pop());


        DynStack mystack3 = new DynStack(5);
        DynStack mystack4 = new DynStack(8);
        for(int i=0; i<12; i++)
            mystack3.push(i);
        for(int i=0; i<20; i++)
            mystack4.push(i);

        System.out.println("Stack in mystack3: ");
        for(int i=0; i<12; i++)
            System.out.println(mystack3.pop());
        System.out.println("Stack in mystack4: ");
        for(int i=0; i<20; i++)
            System.out.println(mystack4.pop());

    }
}

