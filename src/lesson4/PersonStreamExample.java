package lesson4;

import java.util.*;
import java.util.stream.Collectors;

public class PersonStreamExample {

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

        filterOlderThan30(persons);
        femaleFullNames(persons);
        countMalesAbove25(persons);
        collectAllEmails(persons);
        findOldestPerson(persons);
        incrementAge(persons);
    }

    // 1. Filter persons older than 30
    static void filterOlderThan30(List<Person> persons) {
        System.out.println("Persons older than 30:");
        List<Person> olderThan30 = persons.stream()
                .filter(p -> p.age() > 30)
                .toList();
        olderThan30.forEach(System.out::println);
        System.out.println("\n---");
    }

    // 2. Get full names of female persons
    static void femaleFullNames(List<Person> persons) {
        System.out.println("Full names of female persons:");
        List<String> femaleNames = persons.stream()
                .filter(p -> p.gender() == Gender.FEMALE)
                .map(p -> p.firstName() + " " + p.lastName())
                .toList();
        femaleNames.forEach(System.out::println);
        System.out.println("\n---");
    }

    // 3. Count males older than 25
    static void countMalesAbove25(List<Person> persons) {
        long count = persons.stream()
                .filter(p -> p.gender() == Gender.MALE)
                .filter(p -> p.age() > 25)
                .count();
        System.out.println("Number of males older than 25: " + count);
        System.out.println("\n---");
    }

    // 4. Collect all emails as comma-separated string
    static void collectAllEmails(List<Person> persons) {
        String emails = persons.stream()
                .map(Person::email)
                .collect(Collectors.joining(", "));
        System.out.println("All emails: " + emails);
        System.out.println("\n---");
    }

    // 5. Find the oldest person
    static void findOldestPerson(List<Person> persons) {
        persons.stream()
                .max(Comparator.comparingInt(Person::age))
                .ifPresent(p -> System.out.println("Oldest person: " + p));
        System.out.println("\n---");
    }

    // 6. Increment age by 1 and collect new list
    static void incrementAge(List<Person> persons) {
        System.out.println("Persons with incremented age:");
        List<Person> incremented = persons.stream()
                .map(p -> new Person(
                        p.firstName(),
                        p.lastName(),
                        p.email(),
                        p.age() + 1,
                        p.gender()))
                .toList();
        incremented.forEach(System.out::println);
        System.out.println("\n---");
    }
}
