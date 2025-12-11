# Importing Packages
The classes within packages must be **fully qualified** with their package name or names, it could become tedious to type in the long dot-separated package path name for every class you want to use.

`import` statement brings certain classes or entire package into visibility

syntax:
```java
import pkg1[.pkg2].(classname|*);
```

examples of syntax
```java
import java.util.Date;
import java.io.*;
```
an example with import statement
```java
import java.util.*;
class MyDate extends Date{

}
```

an example without import statement
```java
class MyDate extends java.util.Date{

}
```

when a package is imported, only those items within the package declared as public will be available to non-subclasses in the importing code
