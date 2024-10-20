package calculator.model;

public class Calculator {
    private static final Calculator instance = new Calculator();
    private Calculator() {}
    public static Calculator getInstance() {
        return instance;
    }

    public int sum(String string){
        int result = 0;
        String[] nums = string.split(" ");
        for(String num : nums){
            result+= Integer.parseInt(num);
        }
        return result;
    }
}
