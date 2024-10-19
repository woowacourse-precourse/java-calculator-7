package calculator.model;

//실제 계산 로직 처리
public class Calculator {

    //문자열에서 숫자를 추출하여 더하는 기능
    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] numbers = splitInput(input);
        return sum(numbers);
    }

    //기본 구분자(쉼표, 콜론) 및 커스텀 구분자 처리
    private String[] splitInput(String input) {
        String delimiter = ",|:"; //기본 구분자
        if (input.startsWith("//")) {
            //커스텀 구분자 처리
            int delimiterIndex = input.indexOf("\\n");
            delimiter = input.substring(2, delimiterIndex);
            input = input.substring(delimiterIndex + 2);
        }
        return input.split(delimiter);
    }

    //입력된 문자열을 분석하여 합산
    private int sum(String[] numbers){
        int total = 0;
        for(String number : numbers){
            if (!number.isEmpty()) { // 빈 문자열을 무시
                total += Integer.parseInt(number);
            }
        }
        return total;
    }
}

