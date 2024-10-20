package calculator;

public class Calculator {
    public int returnSum(String[] numbers){
        int sum = 0;
        for (String num: numbers){
            int n = Integer.parseInt(num);
            sum += n;
        }
        return sum;
    }

    public int addNumber(String input){
        String regEx = "[,:]";
        String [] numbers = input.split(regEx);
        return returnSum(numbers);
    }
}
