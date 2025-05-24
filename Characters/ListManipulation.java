package Characters;

import java.util.*;

public class ListManipulation {
    public static void main(String[] args) {
        // List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3));
        // Collection<Integer> numbers = new ArrayList<>(List.of(1, 2, 3));
        var numbers = new ArrayList<>(List.of(1, 2, 3));

        // Type inference is based on the context because the context at this point is
        // we are currently using an ArrayList instead of Collection
        // or List interfaace and this makes it worse because we lose some really goo methods.

        System.out.println(numbers); // [1, 2, 3]
        
        numbers.remove(1);

        System.out.println(numbers);

        // Working with sets and how we work with Arrays.asList.
        List<Integer> numberList = Arrays.asList(1, 2, 3); // Unexpandable list not mutable
        // It is way better to use List.of
        try {
            numberList.add(4);
        } catch(Exception ex) {
            System.out.println("add unsupported");
        }

        try {
            numberList.set(3, 4);
        } catch(Exception ex) {
            System.out.println("set unsupported");
        }

        System.out.println(numberList);
    }
}
