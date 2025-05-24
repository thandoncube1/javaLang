package Characters;

import java.util.*;

public class StreamsList {
    public static void main(String[] args) {
        List<String> names = List.of("Dory", "Gill", "Bruce", "Nemo", "Darla", "Marlin", "Jacques");

        List<String> inUpperCase = new ArrayList<>();

        names.parallelStream()
            .map(String::toUpperCase)
            .forEach(name -> inUpperCase.add(name));

        System.out.println(names.size());
        System.out.println(inUpperCase.size());
    }
}

// A pure function is idempotent, it returns the same resut for the 
// same input, no matter how many times you call it.


// It has no side effects

// Mutation is good on in private, A pure function does not depend on anything outside
// that may possibly change.
