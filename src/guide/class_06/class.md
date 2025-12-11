## class
a class is a *template* for an object, and an object is an *instance* of a class
- instance variables: data or variables within a class
- method: contains code within a class
- use `.` to access instance variables
- example: `box_demo.java`, when you compile this program, you will find two `.class` files have been created, one for **Box** and one for **box_demo**
```java
class classname{
    type instance-variable1;

    type methodname(parameter-list){
        // body of method
    }
}
```

## Declaring Objects
**How to obtaining objects of class?**
1. declare a variable of the class type 
2. acquire the actual copy of the object and assign to that variable

```java
Box mybox; // declare reference to object
mybox = new Box(); // allocate a Box object
```

Statement
`Box mybox;` 

Effect 
```
 ----------
|         |
-----------
    mybox
```
Statement 
`mybox = new Box()`

Effect <br>
```
-----------      -----------         
|         |----> |  width  |
-----------      -----------
    mybox        |  height |
                 -----------
                 |  depth  |
                 -----------
                  box object
```
## Assigning Object Reference Variables
**When you assign one object refernce variable to another object reference variable, you are not creating a copy of the object, you are making a copy of reference.**

The assignment of `b1` to `b2` does not allocate any memory or copy any part of the original object.
It makes `b2` refer to the same object as does `b1`.
```java
Box b1 = new Box();
Box b2 = b1;
```
Although `b1` and `b2` both refer to the same object, they are not linked in any other way. For example, a subsequent assignment to `b1` will simply *unhook* `b1` from the original object without affecting the object or affecting `b2`.
```java
Box b1 = new Box();
Box b2 = b1;
// ...
b1 = null;
```

## Introducing Method
A method is a way Java implement subroutines - 
When the Java run-time system transfers control to the code define inside a method. After the statements inside method have executed, control is returned to the calling routine, and execution resumes with the lines of code following the call.

```java
type name(parameter-list){
    //body of method
}
```

- example: `method_demo.java`

## Returning Value
- example: `return_value.java`

## Adding a Method that takes Parameters
- *parameter* - a variable defined by a method that receives a value when the method is called
- *argument* - is a value that is passed a method when it is invoked

The reason of introducing a parameterized method is because parameters allow a method to be **generalized**

- example: `parameterized.java`

## Constructors
*constructor* - intializes an object immediately upon creation

It would be simpler and more concise to have all the setup done at the time the object is first created.

- example: `constructor_demo.java`

## Parameterized Constructors
Parameterized constructors initialize an object with specified arguments

```java
class Box{
    double width;
    double height;
    double depth;

    Box(double w, double h, double d){
        width = w;
        height = h;
        depth = d;
    }
}
```

## this keyword
*this* - a reference to an object on which the method was invoked
```java
Box(double w, double h, double d){
    this.width = w;
    this.height = h;
    this.depth = d;
}
```
*this* lets you refer directly to the object, and resolves any *namespace collision* that might occur between instance variables and local variables.

```java
Box(double width, double height, double depth){
    this.width = width;
    this.height = height;
    this.depth = depth;
}
```

## Garbage Collection
Objects are dynamically allocated using **new** operator, how such objects are destroyed and their memory released for later reallocation.

In C++, dynamically allocated objects must be manually released by the use of **delete** operator.

In Java, deallocation is handled automatically.
When no references to an object exist, that object is assumed to be no longer needed, and the meory occupied by that object can be reclaimed.

## finalize() method
Sometimes an object will need to perform some action when it is destroyed.

e.g. if an object is holding some non-Java resource such as a file handler or character font, then you might want to make sure these resources are freed before an object is destroyed.

Inside the `finalize()`
method, you will specify those actions that must be performed before an object is destroyed.
The garbage collector runs periodically, checking for objects that are no longer referenced
by any running state or indirectly through other referenced objects. Right before an asset is
freed, the Java run time calls the `finalize()` method on the object

```java
protected void finalize(){
    // finalization code
}
```
