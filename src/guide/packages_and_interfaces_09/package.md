# Package

- package is a type of access control that avoids collision of naming same classes or methods
- define classes inside a package prevents it being accessed by code outside of package
- define class members in a package makes it exposed to other members in the same package
- package is mirrored by directories


## classes vs packages

|         | encapsulation & container                       |
|---------|-------------------------------------------------|
| package | containers for classes and subordinate packages |
| class   | containers for data and code                    |


## private, public, protected
- 4 types of visibility for class members:
    - subclasses in the same package
    - non-subclasses in the same package
    - subclasses in different packages
    - classes that are neither in the same package or subclasses

1. public
    - anything declared `public` can be accessed anywhere
2. private
    - anything declared `private` cannot be seen outside of its class
    - (no explicit access specification: visible to subclasses and other classes in the same package)
3. protected
    - anything declared `protected` can be seen outside of current package but only to the subclasses

|                                | private | non modifier | protected | public |
|--------------------------------|---------|--------------|-----------|--------|
| same class                     | yes     | yes          | yes       | yes    |
| same package subclass          | no      | yes          | yes       | yes    |
| same package non-subclass      | no      | yes          | yes       | yes    |
| different package subclass     | no      | no           | yes       | yes    |
| different package non-subclass | no      | no           | no        | yes    |
