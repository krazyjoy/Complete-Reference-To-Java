## enumerations
*enumeration* is a list of named constants.
In java, an enumeration defines a class type, it can have constructors, methods, and instance variables.

An enumeration is created using **enum** keyword.

```java
enum Apple{
    Jonathan, GoldenDel, RedDel, Winesap, Cortland; // enumeration constants
}
```
Once you have defined an enumeration, you can create a variable of that type.

You also did not need to instantiate an **enum** using **new**.
```java
Apple ap;
ap = Apple.RedDel;
```

Comparing two enumeration constants using `==` relational operator.
```java
if(ap== Apple.GoldenDel) // ...
```

An enumeration value can be used to control a **switch** statement.
```java
switch(ap){
    case Jonathan:
        // ...
    case Winesap:
        // ...
}
```

## values() and valueOf() methods
All enumeration contain two predefined methods:
- `values()` - returns an array contains a list of the enumeration list
- `valueOf()` - returns the enumeration constant whose value corresponds to the string passed in *str*

- example: `values_valueOf.java`, `enumerator_as_constructor.java`

## enumerations inherit Enum
All enumerations inherit the class: **java.lang.Enum**

- **ordinal()** - returns the index of enumeration object in the enumeration list, starting from index 0
- **compareTo()** - compares the index between enumeration constants
    - `<0`: e1 has an ordinal value less than e2
    - `=0`: e1 has an ordinal value equal to e2
    - `>0`: e1 has an ordinal value greater than e2

- **equals()** - compare an enumeration constant to any other object
- examples: `enum_method.java`, `enum_method2.java`
