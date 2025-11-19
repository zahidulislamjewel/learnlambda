```java
// Assiging Function to a Variable
String name = "Jhon Doe";
double pi = 4.14159;

// Step-1: Assiging to a variable
greetlambdaFunction = public void greet() {
    System.out.println("Hello World");
}

// Step-2: Removing access modifier
greetlambdaFunction = void greet() {
    System.out.println("Hello World");
}

// Step-3: Removing return type
greetlambdaFunction = greet() {
    System.out.println("Hello World");
}

// Step-3: Removing function name
greetlambdaFunction = () {
    System.out.println("Hello World");
}

// Step-4: Adding arrow (->) syntax
greetlambdaFunction = () -> {
        System.out.println("Hello World");
}

// Step-5: Removing curly braces (if single statement)
greetlambdaFunction = () -> System.out.println("Hello World");

// Step-6: Assiging interface variable type
{Interface} greetlambdaFunction = () -> System.out.println("Hello World");
```