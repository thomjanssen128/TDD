package nl.thom.tdd;

import java.util.ArrayList;

public class StringCalculator {
    public int add(String numbers) {
        return validNumbers(numbers).stream().mapToInt(a->a).sum();
    }

    private ArrayList<Integer> validNumbers(String numbers) {
        ArrayList<Integer> valids = new ArrayList<>();
        String[] nums = splitter(numbers);
        ArrayList<String> filtered = filterNegativeNumbers(nums);

        for (String n : filtered) {
            // System.out.println(n);
            try {
                int x = Integer.parseInt(n);
            } catch (NumberFormatException e) {
                continue;
            }
            if (n.isBlank()) {
                continue;


            } else {
                int r = Integer.parseInt(n);
                if (r < 1000) {
                    valids.add(Integer.parseInt(n));
                }
            }
        }

        return valids;

    }

    private String[] splitter(String input) {
        return input.split("/|\\*|,|n| |;|%|\n");
    }

    private ArrayList<String> filterNegativeNumbers(String[] input) {
        String invalids = "";
        ArrayList<String> filtered = new ArrayList<>();

        for (String n : input) {
            // System.out.println(n);
            if (n.contains("-")) {
                invalids += n + " ";
            } else {
                filtered.add(n);
            }
        }
        if (invalids.length() != 0) {
            throw new IllegalArgumentException("Negatives not allowed " + invalids);
        }
        return filtered;


    }
}