package calculator;

public class DefaultCal {

    private String sep = ",|:";

    public int cal(String input) {
        String[] nums = input.split(sep);
        for (String num : nums) {
            System.out.println(num);
        }
        int total = 0;
        for (String num : nums) {
            total += Integer.parseInt(num);
        }
        return total;
    }

}
