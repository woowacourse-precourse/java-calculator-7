package calculator.model;

public class StringCalculatorImpl implements StringCalculator{
    @Override
    public int add(String input) {
        if(input == null || input.isEmpty()){
            return 0;
        }

        String[] numbers = parse(input);

        return sum(numbers);
    }

    @Override
    public String[] parse(String input) {
        String delimiter = ",|:";
        String numbers = input;

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");
            delimiter = input.substring(2, delimiterIndex);
            numbers = input.substring(delimiterIndex + 2);
        }

        return numbers.split(delimiter);
    }

    @Override
    public int sum(String[] numbers) {
        int total = 0;

        for(String number : numbers){
            total += Integer.parseInt(number);
        }

        return total;
    }
}
