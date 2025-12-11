# interface
- abstract a class interface from its application = specify what a class must do but not how it does it
- variables inside of an interface must be *final* or *static*
# implementation
- lack instance variables
- lack method body

*access* interface *name*{ <br>
    *return-type* method *name*(*para-list*); <br>
    type final-varname1 = value; <br>

}

# syntax
```
class className implements interface, interface2, ... {
    // class body
}
```

## Nested Inferface
a nested interface is an interface declared inside another class or interface


```java
class Outer {
    interface InnerInterface {
        void show();
    }
}
```
you can think of it as "an interface that belongs to an outer type"


## Variables in Interfaces
interfaces allow shared constants to be implemented differently
- example: `interface_variables.java`

## Interfaces can be extended
one interface can inherit another by the use of keyword `extends`
- it must provde implementations for all methods required by the intergace inheritance chain
- example: `interface_extension.java`

## Default Interface Method
1. supply an implementation that will be used if no other implementation is explicitly provided
2. when a desired method is dependent on how the interface is used

example: `default_interface.java`

## Static Methods in an Interface
a static method defined by an interface can be called independently of any object
```
InterfaceName.staticMethodName
``` 
