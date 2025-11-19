package lesson2;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceExample {

    public static void main(String[] args) {

//         1. Static method reference
         Function<String, Integer> parse = s -> Integer.parseInt(s);
//        Function<String, Integer> parse = Integer::parseInt;
        System.out.println(parse.apply("123"));

//         2. Instance method of a particular object
        MethodReferenceExample example = new MethodReferenceExample();
         Runnable r1 = () -> example.printMessage();
//        Runnable r1 = example::printMessage;
        r1.run();

//         3. Instance method of an arbitrary object of a type
         Function<String, String> lower = s -> s.toLowerCase();
//        Function<String, String> lower = String::toLowerCase;
        System.out.println(lower.apply("HELLO"));


//         4. Constructor reference
         Supplier<StringBuilder> builder = () -> new StringBuilder();
//        Supplier<StringBuilder> builder = StringBuilder::new;
        System.out.println(builder.get().append("Created via constructor reference"));

//         Comparator using method reference
        Comparator<String> comparator = (s1, s2) -> s1.compareToIgnoreCase(s2);
//        Comparator<String> comparator = String::compareToIgnoreCase;
        System.out.println(comparator.compare("abc", "AbC") == 0);

        // BiFunction using method reference
        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
//        BiFunction<Integer, Integer, Integer> sum = Integer::sum;
        System.out.println(sum.apply(10, 20));
    }

    void printMessage() {
        System.out.println("Instance method invoked using method reference");
    }
}
