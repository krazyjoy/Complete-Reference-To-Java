
## inheritance basics
To inherit a class, you incorporate the definition of one class into another using `extends`. By using inheritance, you can create a general class that defines traits common to set of related items.

In `boxWeight_demo.java`, BoxWeight class inherits width, height, depth from Box class.

### Using super
*super* prefix deduplicate code found in its superclass, also implying a subclass is granted access to these members.

```java
class BoxWeight extends Box{
    double weight;

    BoxWeight(double w, double h, double d, double m){
        super(w, h, d);
        weight = m;
    }
}
```

*super* can refer to the member of a superclass 

```java
class A{
    int i;
}

class B extends A{
    int i;
    B(int a, int b){
        super.i = a; // refer to i in A
        i = b; 
    }
    void show(){
        System.out.println("i in superclass: " + super.i);
        System.out.println("i in subclass: " + i);
    }
}
```

A superclass variable can reference a subclass object.

- `weightBox` is a reference to BoxWeight objects
- `plainBox` is a reference to Box objects

```java
public static void main(String[] args) {
    BoxWeight weightBox = new BoxWeight(3, 5, 7, 8.37);
    Box plainBox = new Box();
    plainBox = weightBox;
    System.out.println("Volume of plainBox is " + plainBox.volume()); // plainBox will receive the volume from weightBox
}
```

- you can also pass an object to constructor
```java
class BoxWeight extends Box{
    double weight;
    BoxWeight(BoxWeight ob){
        super(ob);
        weight = ob.weight;
    }
}
```
## When Constructors Are Executed
Constructors complete their execution in order of derivation, from superclass to subclass.
The order of execution will be `A->B->C`

```java
class A{
    A(){

    }
    class B extends A{
        B(){

        }
    }

    class C extends B{
        C(){

        }
    }
}

class CallingConstructors{
    public static void main(String[] args) {
        C c = new C();
    }
}
```

## Method Override
Overridden methods allow Java to support runtime poylmorphism.

Polymorphism allows a general class to specify methods that will be common to all of its derivatives.

- example: `method_overriding.java`


## Abstract Classes
*Abstract class* - determines the nature of the methods that the subclasses must implement

```java
abstract type name(parameter-list);
```
The subclass that inherits the abstract class must implement the abstract method.

```java
abstract class A{
    abstract void callme();
    void callmetoo(){
        System.out.println("This is a concrete method.");
    }
}

class B extends A{
    void callme(){
        System.out.println("B's implementation of callme.");
    }
}

class AbstractDemo{
    public static void main(String[] args) {
        B b = new B();
        b.callme(); // "B's implementation of callme."
        b.callmetoo(); // "This is a concrete method."
    }
}
```

## final with inheritance
To disallow a method from being overridden, specify *final* as a modifier at the start of its declaration.

- *late-binding*: Java resolves calls to methods dynamically.
- *early-binding*: a call resolve at compile time.
```java
class A{
    final void meth(){
        System.out.println("This is a final method.");
    }
}
class B extends A{
    // ERROR! Can't Override
    void meth(){
        System.out.println("Illegal");
    }
}
```
