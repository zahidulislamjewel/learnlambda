package lesson3;

import java.util.*;
import java.util.function.*;

public class PersonTraditionalExample {

    enum Gender {
        MALE, FEMALE, OTHER
    }

    record Person(String firstName, String lastName, String email, int age, Gender gender) {}

    public static void main(String[] args) {

        List<Person> persons = Arrays.asList(
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

    // 2. Print all persons using anonymous class
    static void printAllPersons(List<Person> persons) {
        System.out.println("All persons:");
        for (Person p : persons) {
            System.out.println(p);
        }
        System.out.println("\n---");
    }

    // 3. Print emails
    static void printEmails(List<Person> persons) {
        System.out.println("Emails of all persons:");
        for (Person p : persons) {
            System.out.println(p.email());
        }
        System.out.println("\n---");
    }

    // 4. Filter persons older than 30 using traditional loop
    static void printPersonsOlderThan30(List<Person> persons) {
        System.out.println("Persons older than 30:");
        for (Person p : persons) {
            if (p.age() > 30) {
                System.out.println(p);
            }
        }
        System.out.println("\n---");
    }

    // 5. Filter female persons using traditional loop
    static void printFemalePersons(List<Person> persons) {
        System.out.println("Female persons:");
        for (Person p : persons) {
            if (p.gender() == Gender.FEMALE) {
                System.out.println(p);
            }
        }
        System.out.println("\n---");
    }

    // 6. Print full names using traditional loop
    static void printFullNames(List<Person> persons) {
        System.out.println("Full names of all persons:");
        for (Person p : persons) {
            String fullName = p.firstName() + " " + p.lastName();
            System.out.println(fullName);
        }
        System.out.println("\n---");
    }

    // 7. Print name and age using traditional loop
    static void printNameAndAge(List<Person> persons) {
        System.out.println("Name and Age:");
        for (Person p : persons) {
            String fullName = p.firstName() + " " + p.lastName();
            int age = p.age();
            System.out.println(fullName + " -> " + age);
        }
        System.out.println("\n---");
    }
}
