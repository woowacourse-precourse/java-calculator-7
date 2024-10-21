package calculator.entity;

public class CalcEntity {
    public int addNum(String[] nums) {
        int sum = 0;

        for (String num: nums)
            sum += Integer.parseInt(num.trim());

        return sum;
    }
}