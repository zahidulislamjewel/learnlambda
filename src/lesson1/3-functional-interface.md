Here is the completed document with the names of all important built-in functional interfaces added.

---

# **What is a Functional Interface (SAM)?**

A **functional interface** is an interface with **exactly one abstract method**.
Because it has one method, it represents **one unit of behavior**.

Common built-in functional interfaces include:

### Core functional interfaces

* `Runnable`
* `Callable<V>`
* `Supplier<T>`
* `Consumer<T>`
* `BiConsumer<T, U>`
* `Function<T, R>`
* `BiFunction<T, U, R>`
* `UnaryOperator<T>`
* `BinaryOperator<T>`
* `Predicate<T>`
* `BiPredicate<T, U>`


These interfaces all contain **one abstract method**, making them valid targets for lambda expressions.

They are also known as **SAM interfaces** (Single Abstract Method).

Java marks these with `@FunctionalInterface` (optional but recommended).

Example:

```java
@FunctionalInterface
interface MyFunction {
    int apply(int x);
}
```

---

# **Why did Java use Functional Interfaces as the type of Lambda Expressions?**

Because Java is a **strongly typed, object-oriented language**, not a pure functional language.
Every lambda needs a **fixed type** at compile time.
Instead of introducing a new “function type” in the language, Java reused something it already had: **interfaces**.

### Java chose functional interfaces for 3 main reasons:

### **1. Backward compatibility**

Lambdas had to work with old Java code.
Functional interfaces already existed (`Runnable`, `Comparator`, etc.), so lambdas could drop in without breaking old code.

### **2. Clean, simple type system**

No need to introduce a new "function type".
Java simply treats a lambda as an implementation of the one abstract method.

Example:

```java
Predicate<Integer> p = i -> i > 10;
```

Here, Java knows the lambda matches `Predicate`’s single method:
`boolean test(T t)`.

### **3. Interoperability with existing APIs**

Existing libraries (Collections, Streams, Threads, Executors, NIO) immediately benefited from lambdas without requiring redesign.

---

# **Summary**

**A functional interface is an interface with one abstract method (SAM), and Java uses it as the type of lambda expressions because it maintains strong typing, preserves backward compatibility, and allows lambdas to integrate seamlessly with all existing Java APIs.**
