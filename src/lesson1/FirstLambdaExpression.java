package lesson1;

public class FirstLambdaExpression {
    public static void main(String[] args) {

//        {Interface} lambdaGreeter = public void greet() {
//            System.out.println("Hello World!");
//        }

//        Greeter greeter = () -> System.out.println("Hello, world!");
//        greeter.greet();

//        Processor processor = () -> System.out.println("Hello, world!");
//        processor.process();
    }
}

@FunctionalInterface
interface Greeter {
    void greet();
}

@FunctionalInterface
interface Processor {
    void process();
}

