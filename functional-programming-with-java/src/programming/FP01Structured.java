package programming;

import java.util.List;

public class FP01Structured {
    public static void main(String[] args) {
//        printAllNumbersInListStructured(List.of(12,10,5,7,3,27,15,49));
        printEvenNumbersInListStructured(List.of(12,10,5,7,3,27,15,49));
    }

    private static void printAllNumbersInListStructured(List<Integer> numbers) {
        for(int number:numbers){
            System.out.println(number);
        }

    }

    private static void printEvenNumbersInListStructured(List<Integer> numbers) {
        for(int number:numbers){
            if(number % 2 == 0)
                System.out.println(number);
        }

    }
}
