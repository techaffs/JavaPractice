package programming;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class PlayingWithOptionalClass { //for NullreferencePointers
        public static void main(String[] args) {
                List<String> fruits = List.of("apple","banana","mango","grapes","orange","peach");
//              List<String> fruits = Arrays.asList("apple", "banana", "mango", "grapes", "orange", "peach");

                Optional<String> banana = Optional.of("banana");
                Optional<String> empty = Optional.empty();

                Predicate<? super String> predicate = fruit -> fruit.startsWith("c");
                Optional<String> optional = fruits.stream().filter(predicate).findFirst();
                System.out.println(optional);
                System.out.println(optional.isEmpty());
                System.out.println(optional.isPresent());
                if(!optional.isPresent())
                        System.out.println(optional.get());
                else
                        System.out.println("not found!");


        }
}

