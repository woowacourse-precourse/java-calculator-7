package calculator;

public class Calculator {
    public int sum(String str) {

        if(str == null || str.isEmpty()) {
            return 0;
        }

        String[] nums = str.split(",|:");
        int sum = 0;

        for(String s : nums) {
            try {
                int number = Integer.parseInt(s);
                sum += number;
            } catch (Exception e) {
                throw new IllegalArgumentException();
            }
        }

        return sum;
    }
}
