# **Stream API**

**Definition:** A **Stream** is a sequence of elements supporting **functional-style operations** (like map, filter, reduce) to process data **declaratively**.

**Key Characteristics:**

1. **No storage:** Stream does not store elements, it just processes them.
2. **Functional:** Supports **lambda expressions** for operations.
3. **Lazy evaluation:** Intermediate operations are evaluated only when a terminal operation is invoked.
4. **Pipelining:** Can chain multiple operations in a single pipeline.
5. **Parallel processing:** Can easily switch to parallel streams for multi-core execution.

---

## **Core Components**

* **Source:** Collection, array, generator, I/O channel, etc.
* **Intermediate operations:** `filter`, `map`, `distinct`, `sorted`, `limit`
* **Terminal operations:** `forEach`, `collect`, `reduce`, `count`, `anyMatch`

---

## **Example**

```java

List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

// Filter even numbers, double them, and print
numbers.stream()
       .filter(n -> n % 2 == 0)   // intermediate
       .map(n -> n * 2)           // intermediate
       .forEach(System.out::println); // terminal

```

---

### **Summary**

* Stream API provides **clean, functional, and declarative** ways to process collections.
* Reduces boilerplate code (loops, conditionals).
* Supports **parallelism** with minimal code changes (`parallelStream()`).