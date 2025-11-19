package lesson1;

import java.util.function.*;

public class WritingMoreLambda {

    public static void main(String[] args) {

        // using Consumer (takes input, returns nothing)
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("Hello from Consumer");

        // using Supplier (takes nothing, returns something)
        Supplier<String> supplier = () -> "Hello from Supplier";
        System.out.println(supplier.get());

        // using Function (T -> R)
        Function<String, Integer> function = s -> s.length();
        System.out.println(function.apply("Hello"));

        // using BiFunction (T,U -> R)
        BiFunction<Integer, Integer, Integer> biFunction = (a, b) -> a + b;
        System.out.println(biFunction.apply(10, 20));

        // using Predicate (T -> boolean)
        Predicate<Integer> predicate = num -> isPrime(num);
        System.out.println(predicate.test(97));

        // using Runnable (no input, no return)
        Runnable runnable = () -> System.out.println("Running in a thread...");
        new Thread(runnable).start();

        // using BiConsumer (takes two inputs, returns nothing)
        BiConsumer<String, Integer> biConsumer = (name, age) ->
                System.out.println(name + " is " + age + " years old.");
        biConsumer.accept("Alice", 25);

        // using UnaryOperator (T -> T)
        UnaryOperator<Integer> unaryOp = x -> x * x;
        System.out.println(unaryOp.apply(6));  // 36

        // using BinaryOperator (T,T -> T)
        BinaryOperator<Integer> binaryOp = (x, y) -> x * y;
        System.out.println(binaryOp.apply(5, 4));  // 20

        // using BiPredicate (T, U -> boolean)
        BiPredicate<String, String> biPredicate = (a, b) -> a.equalsIgnoreCase(b);
        System.out.println(biPredicate.test("Hello", "HELLO"));
    }

    // Prime checker for the example
    static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }
}
