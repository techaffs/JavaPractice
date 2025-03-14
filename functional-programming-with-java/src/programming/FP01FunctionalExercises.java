package programming;

import java.util.List;

public class FP01FunctionalExercises {
    public static void main(String[] args) {
//        printOddNumbersInListFunctional(List.of(12,10,5,7,3,27,15,49));

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices",
                "AWS", "Azure", "Docker", "K8", "PCF");

//        printAllCoursesInListFunctional(courses);
//        printContainsCoursesInListFunctional(courses);
//        printLengthWiseCoursesInListFunctional(courses);
        printLengthOfEachCourseInListFunctional(courses);
    }

    private static void printOddNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number%2 != 0) //Lambda Expression
                .forEach(System.out::println); //Method Reference
    }

    private static void printAllCoursesInListFunctional(List<String> courses) {
        courses.stream()
                .forEach(System.out::println);
    }

    private static void printContainsCoursesInListFunctional(List<String> courses) {
        courses.stream()
                .filter(course -> course.contains("Spring"))
                .forEach(System.out::println); //Method Reference
    }

    private static void printLengthWiseCoursesInListFunctional(List<String> courses) {
        courses.stream()
                .filter(course -> course.length() <= 3)
                .forEach(System.out::println); //Method Reference
    }

    private static void printLengthOfEachCourseInListFunctional(List<String> courses) {
        courses.stream()
                .map(course -> course + ": len(" + course.length()+")")
                .forEach(System.out::println);
    }
}
