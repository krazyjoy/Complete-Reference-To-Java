## exception 
- exception is an object that describes an exceptional condition 
that had occurred in a piece of code
- when an exception condition arises, an object representing that exception is created and thrown in the method that caused the error

## exception-handling block
```java
try{

}
catch(ExceptionType1 exOb){

}
catch(ExceptionType2 exOb){

}
finally{

}
```

## Top-level Exception Hierarchy
Throwable <br>
&emsp; $\rightarrow$ Error <br>
&emsp; $\rightarrow$ Exception $\rightarrow$ Runtime Exception

## Using Try and Catch
to guard against and handle a run-time error, simply enclose the code you want to monitor inside a try block


## Multiple Catch Clauses
handle the situation of more than one exception raised by a single piece of code


## Nested Try Statements
- a try statement can be inside the block of another try
- each time a try statement is entered, the context of that exception is pushed on the stack

## throw
the flow of execution stops immediately after the throw statement
```
throw ThrowableInstance;
```
## finally
`finally` handles the situation when you want a block of code to still execute after a `try/catch` block has completed and before the codde following the try/catch block

example: `finally_demo.java`
1. `procA()` prematurely breaks out of the try by throwing an exception
2. `procB()`'s try statement is exited via a return statement
3. `procC()`'s try executes normally; however, finally block is still executed

