I would like to depict what I got from this project in question-answer way,
## What can you  know from this  project?
####   Understanding OOP principles
1.1)What is the benefit of encapsulation?

In OOP paradigm there are objects.Their inner states are hidden from programmer.
In oop paradigm,we just send message to objects ,by invoking method and objects react somehow.
The plus is we may not know how object works,we just need interface to use functionality.
 

1.2)What advantages of using Polymorphism

In places where we need super class we are able to substitute subclass

1.3)How we can extend our code with the help of Inheritance without violating SOLID

If we need new features,we just inherit from necessary class and add functionality  

#### SOLID principles

2.1)S-single responsibility,why it is important

The idea is class has only one reason to change.
If we write everything in one class,it would be difficult to test it,also 
it is hard for other programmers to get the idea of code.

2.2)O-open for modification close for extension.

The idea is writing code ones and doesn't change it,only extend.
When we write code then we test it,and we are sure it works smoothly,but suppose 
we add new feature in old tested code,we must test it again,as logic was changed.Moreover,
other classes who depend on changed class also must be tested.

2.3)L-liskov principle 

The idea is overriding method in subclass must work smoothly.If instead of super class we substitute subclass program can't just break.  

2.4)Interface segregation principle -

we shouldn't make clients (classes) using abstractions implement methods that they don't need.
Just make from one big interface  different precise small interfaces.

2.5)Dependency inversion

When one class need another as dependency,we shouldn't add concrete class,because if logic of program will be changed,we may use another class,so  we have to override code,violating O principle
The better way use abstraction and with the help of dependency inversion add necessary classes. 

#### Default methods(equals,hashcode) realizations in Object

3.1)why it is important to override hashcode.

When we use hash map,for instance,it uses hash code to find basket,also it uses equals when elements in one basket have one hashcode,so it is important to override equals as well.

3.2)why we need to override equals. default equals works as ==

if we want to add logic of comparison.

3.3)requirements to equals,hashcode

It is reflexive: for any non-null reference value x, x.equals(x) should return true.
It is symmetric: for any non-null reference values x and y, x.equals(y) should return true if and only if y.equals(x) returns true.
It is transitive: for any non-null reference values x, y, and z, if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) should return true.
It is consistent: for any non-null reference values x and y, multiple invocations of x.equals(y) consistently return true or consistently return false, provided no information used in equals comparisons on the objects is modified.

The general contract of hashCode is:
Whenever it is invoked on the same object more than once during an execution of a Java application, the hashCode method must consistently return the same integer, provided no information used in equals comparisons on the object is modified. This integer need not remain consistent from one execution of an application to another execution of the same application. If two objects are equal according to the equals(Object) method, then calling the hashCode method on each of the two objects must produce the same integer result.
It is not required that if two objects are unequal according to the equals(java.lang.Object) method, then calling the hashCode method on each of the two objects must produce distinct integer results. However, the programmer should be aware that producing distinct integer results for unequal objects may improve the performance of hash tables. 



#### Overloading and overwritten methods.
4.1)Can be static method overwritten or overloaded
static methods can be only overwritten

4.2)Can be entity method overloaded or overwritten
entity method can be only overloaded


#### Docker

I had to create container which run my application.It helped me to understand differences between containers,images 

#### Maven

import dependencies from official repository and from system.

build jar with maven

Other themes 

Elements of functional programming in Java syntax. Functional interfaces, lambda expressions. Links to methods.

Exceptions

inner classes 

reflection

