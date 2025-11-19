# **Method Reference**

A **method reference** is a shorthand syntax used to refer to an existing method instead of writing a lambda expression that simply calls that method.

It does not create a new method. It only *references* an already-existing one.

Method reference is possible only when the referenced method’s signature **matches the functional interface’s single abstract method**.

---

# **Why use Method References?**

* To reduce verbosity
* To increase readability
* To avoid writing redundant lambda expressions
* To reuse existing methods cleanly

When a lambda only calls an existing method, a method reference is simpler and cleaner.

Example:

```java
Consumer<String> consumer = s -> System.out.println(s);
```

can be rewritten as:

```java
Consumer<String> consumer = System.out::println;
```

---

# **Types of Method References**

Java supports **four types**.

---

## **1. Reference to a Static Method**

Syntax:

```
ClassName::staticMethod
```

### Lambda version:

```java
Function<String, Integer> f = s -> Integer.parseInt(s);
```

### Method reference:

```java
Function<String, Integer> f = Integer::parseInt;
```

---

## **2. Reference to an Instance Method of a Particular Object**

Syntax:

```
instance::method
```

### Lambda:

```java
Runnable r = () -> printer.printMessage();
```

### Method reference:

```java
Runnable r = printer::printMessage;
```

---

## **3. Reference to an Instance Method of an Arbitrary Object of a Given Type**

Used when the object is provided as a parameter.

Syntax:

```
ClassName::instanceMethod
```

### Lambda:

```java
Function<String, String> f = s -> s.toLowerCase();
```

### Method reference:

```java
Function<String, String> f = String::toLowerCase;
```

Another common example:

```java
Comparator<String> c = (a, b) -> a.compareTo(b);
Comparator<String> c2 = String::compareTo;
```

---

## **4. Reference to a Constructor**

Syntax:

```
ClassName::new
```

### Lambda:

```java
Supplier<List<String>> listMaker = () -> new ArrayList<>();
```

### Method reference:

```java
Supplier<List<String>> listMaker = ArrayList::new;
```

---

# **When can a Method Reference be used instead of a Lambda?**

We can use a method reference **only when the lambda body does nothing except call another method**.

### Condition:

**Lambda:**

```java
(params) -> existingMethod(params)
```

can be replaced with

**Method reference:**

```java
ClassName::existingMethod
```

**if and only if**:

* Method signatures are compatible
* No additional logic exists inside the lambda
* Parameters are passed unchanged

---

# **Quick Examples of Converts**

### Example 1: Consumer

```java
Consumer<String> c = s -> System.out.println(s);
Consumer<String> c2 = System.out::println;
```

### Example 2: Predicate

If `isPrime(int)` is defined:

```java
Predicate<Integer> p = i -> isPrime(i);
Predicate<Integer> p2 = ClassName::isPrime;
```

### Example 3: Runnable

```java
Runnable r = () -> doSomething();
Runnable r2 = ClassName::doSomething;
```

### Example 4: BiFunction

```java
BiFunction<Integer, Integer, Integer> add = (a, b) -> Integer.sum(a, b);
BiFunction<Integer, Integer, Integer> add2 = Integer::sum;
```

---

# **Summary**

**Method reference is a shorthand for a lambda expression that calls an existing method, used when the lambda contains no extra logic and matches the functional interface signature.**
