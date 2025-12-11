## Overloading Methods
A method is overloaded - when two or more methods within the same class that share the same name, as long as their parameter declarations are different.
- example: `overload_method.java`

## Overloading Constructors
- example: `overload_constructor.java`


## Using Object as Parameters
Using object as parameters create a clone of the object.

```java
class Box{
    double width;
    double height;
    double depth;


    Box(Box ob){
        width = ob.width;
        height = ob.height;
        depth = ob.depth;
    }
}
```
`equalTo()` method compares two objects for equality and returns the result.

## Argument Passing
Two ways that a computer language can pass an argument to a subroutine
1. call-by-value: copies the *value* of an argument into the formal parameter of the subroutine
    - `call_by_value.java`
2. call-by-reference: a reference to an argument is passed to the parameter for accessing the actual argument specified
    - `pass_by_ref.java`

## Returning Objects
A method can return the class type you created.

```java
class Test{
    int a;
    Test(int i){
        a = i;
    }
    Test incrByTen(){
        Test temp = new Test(a+10);
        return temp;
    }
}

class RetOb{
    public static void main(String[] args) {
        Test ob1 = new Test(2);
        Test ob2;

        ob2 = ob1.incrByTen();
        System.out.println("ob1.a: " + ob1.a);
        System.out.println("ob2.a: " + ob2.a);
    }
}
```


## Recursion
Recursion is the process of defining something in terms of itself. It is the attribute that allows a method to call itself.


## Static
static - defines a class member that will be used independentlu of any object of that class

methods declared as `static` have several restrictions:
- they can only directly call other `static` method
- they can only directly access `static` data
- they cannot refer to `this` or `super` in any way

if you wish to call a static method from outside its class
```java
classname.method();
```

## nested classes
Nested Class - a class define within another class

Nested classes are particularly helpful when handling events.

- example: `inner_class_demo.java`

## String Class
Every string you create is actually an object type **String**
- **String** are immutable
- `+` operator concatenate two strings
- `equals()` test the equality for two strings
- `length()` obtains the length of a string
- `charAt()` obtains the character at a specified index within a string

## Varargs; Variable-Length Arguments
A method can take a variable number of arguments

old approach is to put arguments into an array

```java
class PassArray{
    static void vaTest(int v[]){
        System.out.println("Number of args: " + v.length + " Contents: ");
        for(int x: v){
            System.out.print(x+" ");
        }
        System.out.println();
    }

    public static void main(String args[]){
        int n1[] = {10};
        int n2[] = {1,2,3};
        int n3[] = {};

        vaTest(n1);
        vaTest(n2);
        vaTest(n3);
    }
}
```
- syntax:
    ```
    static void vaTest(int ... v){
    }
    ```
- example: `varArgs.java`
