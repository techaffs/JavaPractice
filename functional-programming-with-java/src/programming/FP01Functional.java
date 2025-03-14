package programming;

import java.util.List;

public class FP01Functional {
    public static void main(String[] args) {
//        printAllNumbersInListFunctional(List.of(12,10,5,7,3,27,15,49));
//        printEvenNumbersInListFunctional(List.of(12,10,5,7,3,27,15,49));
//        printSquaresOfEvenNumbersInListFunctional(List.of(12,10,5,7,3,27,15,49));
        printCubeOfOddNumbersInListFunctional(List.of(12,10,5,7,3,27,15,49));
    }

    private static void print(int number){
        System.out.println(number);
    }

//    private static boolean isEven(int number){
//        return number % 2 == 0;
//    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
//        for(int number:numbers){
//            System.out.println(number);
//        }
//        numbers.stream().forEach(FP01Functional::print);
        numbers.stream().forEach(System.out::println);
    }

    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
//        for(int number:numbers){
//            if(number % 2 == 0)
//                System.out.println(number);
//        }
//        numbers.stream()
//                .filter(FP01Functional::isEven)
//                .forEach(System.out::println);

        numbers.stream()
                .filter(number -> number%2 == 0) //Lambda Expression
                .forEach(System.out::println); //Method Reference
    }

    private static void printSquaresOfEvenNumbersInListFunctional(List<Integer> numbers) {

        numbers.stream()
                .filter(number -> number%2 == 0) //Lambda Expression
                .map(number -> number * number)
                .forEach(System.out::println);
    }

    private static void printCubeOfOddNumbersInListFunctional(List<Integer> numbers) {

        numbers.stream()
                .filter(number -> number%2 != 0) //Lambda Expression
                .map(number -> number * number * number)
                .forEach(System.out::println);

        // Different example
        int a = 5;
        Square s = (int x) -> 10 * 10;
        int ans = s.calculate(a);
        System.out.println(ans);
    }
}
        interface Square {
            int calculate(int x);
        }
