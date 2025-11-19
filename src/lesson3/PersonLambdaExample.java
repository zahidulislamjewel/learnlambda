package lesson3;

import java.util.*;
import java.util.function.*;

public class PersonLambdaExample {

    enum Gender {
        MALE, FEMALE, OTHER
    }

    record Person(String firstName, String lastName, String email, int age, Gender gender) {}

    public static void main(String[] args) {

        List<Person> persons = List.of(
                new Person("John", "Doe", "john.doe@example.com", 25, Gender.MALE),
                new Person("Alice", "Smith", "alice.smith@example.com", 30, Gender.FEMALE),
                new Person("Bob", "Johnson", "bob.johnson@example.com", 22, Gender.MALE),
                new Person("Clara", "Brown", "clara.brown@example.com", 28, Gender.FEMALE),
                new Person("David", "Wilson", "david.wilson@example.com", 35, Gender.MALE),
                new Person("Eva", "Taylor", "eva.taylor@example.com", 20, Gender.FEMALE),
                new Person("Frank", "Anderson", "frank.anderson@example.com", 40, Gender.MALE),
                new Person("Grace", "Thomas", "grace.thomas@example.com", 27, Gender.FEMALE),
                new Person("Henry", "Moore", "henry.moore@example.com", 32, Gender.MALE),
                new Person("Ivy", "Martin", "ivy.martin@example.com", 24, Gender.FEMALE),
                new Person("Jack", "Lee", "jack.lee@example.com", 29, Gender.MALE),
                new Person("Lily", "Walker", "lily.walker@example.com", 26, Gender.FEMALE)
        );

        printAllPersons(persons);
        printEmails(persons);
        printPersonsOlderThan30(persons);
        printFemalePersons(persons);
        printFullNames(persons);
        printNameAndAge(persons);
    }

    // 2. Print all persons
    static void printAllPersons(List<Person> persons) {
        System.out.println("All persons:");
        Consumer<Person> printPerson = p -> System.out.println(p);
        persons.forEach(printPerson);
        System.out.println("\n---");
    }

    // 3. Print emails of all persons
    static void printEmails(List<Person> persons) {
        System.out.println("Emails of all persons:");
        Consumer<Person> printEmail = p -> System.out.println(p.email());
        persons.forEach(printEmail);
        System.out.println("\n---");
    }

    // 4. Filter persons older than 30
    static void printPersonsOlderThan30(List<Person> persons) {
        System.out.println("Persons older than 30:");
        Predicate<Person> olderThan30 = p -> p.age() > 30;
        for (Person p : persons) {
            if (olderThan30.test(p)) {
                System.out.println(p);
            }
        }
        System.out.println("\n---");
    }

    // 5. Filter female persons
    static void printFemalePersons(List<Person> persons) {
        System.out.println("Female persons:");
        Predicate<Person> isFemale = p -> p.gender() == Gender.FEMALE;
        for (Person p : persons) {
            if (isFemale.test(p)) {
                System.out.println(p);
            }
        }
        System.out.println("\n---");
    }

    // 6. Apply a Function to get full names
    static void printFullNames(List<Person> persons) {
        System.out.println("Full names of all persons:");
        Function<Person, String> fullName = p -> p.firstName() + " " + p.lastName();
        for (Person p : persons) {
            System.out.println(fullName.apply(p));
        }
        System.out.println("\n---");
    }

    // 7. Apply BiConsumer to print name and age
    static void printNameAndAge(List<Person> persons) {
        System.out.println("Name and Age:");
        Function<Person, String> fullName = p -> p.firstName() + " " + p.lastName();
        BiConsumer<String, Integer> nameAgePrinter = (name, age) -> System.out.println(name + " -> " + age);
        for (Person p : persons) {
            nameAgePrinter.accept(fullName.apply(p), p.age());
        }
        System.out.println("\n---");
    }
}