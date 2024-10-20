package calculator.model;

public class Equation {
    public Integer[] nums;

    public Equation(String expression) {
        parse(expression);
    }

    public void parse(String expression) {
        Separator separator = new Separator();
        var raw = separator.consumeCustomSeparator(expression);
        if(!isValid(raw, separator)) {
            throw new IllegalArgumentException();
        }
        String[] strNums = raw.split("[" + separator.raw +"]");

        nums = new Integer[strNums.length];
        for(int i = 0; i < strNums.length; i++) {
            nums[i] = Integer.parseInt(strNums[i]);
        }
    }

    public boolean isValid(String expression, Separator separator) {
        var a = expression.replaceAll("[\\d" + separator.raw + "]", "");
        return a.isEmpty();
    }

    public Integer sum() {
        Integer sum = 0;

        for(Integer num : nums) {
            sum += num;
        }
        return sum;
    }
}
