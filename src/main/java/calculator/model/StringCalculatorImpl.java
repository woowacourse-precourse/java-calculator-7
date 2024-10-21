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
        String delimiter = ":|,";
        String numbers = input;

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");

            if(delimiterIndex == -1){
                throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다");
            }

            delimiter = input.substring(2, delimiterIndex);
            numbers = input.substring(delimiterIndex + 2);
        }

        return numbers.split(delimiter);
    }



    @Override
    public int sum(String[] numbers) {
        int total = 0;

        for(String number : numbers){
            total += validate(number);
        }

        return total;
    }

    public int validate(String number){
        try{
            int num = Integer.parseInt(number);
            if(num < 0){
                throw new IllegalArgumentException("음수는 입력할 수 없습니다 : " + number);
            }
            return num;
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("유효하지 않은 숫자입니다 : " + number);
        }
    }
}
