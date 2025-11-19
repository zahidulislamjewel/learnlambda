

# **Object-Oriented Programming (OOP) vs Functional Programming (FP)**

Java has always been OOP-centric. But with Java 8, **functional programming concepts** (like lambdas, streams) were introduced.


# **1. Difference between OOP and FP**

### **OOP (Object-Oriented Programming)**

* Everything revolves around **objects** and **classes**.
* We model real-world things as objects.
* Behavior is implemented using **methods inside classes**.
* Code is often **state-driven**: objects have mutable internal states.

**Example (OOP style):**

```java
class Printer {
    void print(String s) {
        System.out.println(s);
    }
}

Printer printer = new Printer();
printer.print("Hello");
```

---

### **FP (Functional Programming)**

* Focuses on **functions** instead of objects.
* Functions are treated as **first-class citizens**.
* Avoids **mutable state**.
* Encourages **declarative** programming (what to do, not how).

Before Java 8, Java couldn’t directly pass a function.
After Java 8, lambdas allow us to **pass behavior** just like data.

**Functional style:**

```java
Consumer<String> printer = s -> System.out.println(s);
printer.accept("Hello");
```

Here `s -> System.out.println(s)` is a **lambda expression**, representing a function.

---

# **2. Why do we need Functional Programming in Java?**

Because it solves some real problems that OOP alone couldn’t solve well:

### **a) To enable concise code**

Functional style removes boilerplate.

### **b) To improve readability**

Streams + lambdas make business logic clearer.

### **c) For parallel processing**

FP is naturally suitable for parallelism because it avoids mutable state.

Example:

```java
list.parallelStream()
    .map(x -> x * 2)
    .forEach(System.out::println);
```

### **d) To treat behavior as data**

You can pass logic into methods.



---

# **Summary**

**OOP = objects + state.**

**FP = pure functions + immutability.**

**Lambdas bring functional programming into Java, enabling cleaner, concise, expressive, and parallelizable code.**
