import java.util.ArrayList;

public class StringCalculator {
    public int add(String numbers) {
        ArrayList<Integer> nums = validNumbers(numbers);
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        // if (numbers.isBlank()) {
        //     return 0;
        // }

        return sum;

    }

    private ArrayList<Integer> validNumbers(String numbers) {
        ArrayList<Integer> valids = new ArrayList<Integer>();
        String invalids = "";
        String[] nums = numbers.split("//*|,|\n| |;");
        for (String n : nums) {
            System.out.println(n);
            if (n.isBlank()) {
                continue;
            }


            try {
                int x = Integer.parseInt(n);
            } catch (NumberFormatException e) {
                continue;
            }
            if (n.contains("-")) {
                invalids += n + " ";

            } else {
                int r = Integer.parseInt(n);
                if (r < 1000) {
                    valids.add(Integer.parseInt(n));
                }
            }
        }
        if (invalids.length() != 0) {
            throw new IllegalArgumentException("Negatives not allowed " + invalids);
        }


        return valids;

    }
}