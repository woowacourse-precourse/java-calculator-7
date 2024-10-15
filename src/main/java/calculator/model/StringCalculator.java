package calculator.model;

public class StringCalculator {

    // TODO 여러개 표현식 구분 구현
    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String delimiter = ",|:";

        if (input.startsWith("//")) {
            String[] parts = input.split("\n", 2);
            delimiter = extractDelimiters(parts[0]);
            input = parts[1];
        }

        String[] numbers = input.split(delimiter);
        return sum(numbers);
    }

    private String extractDelimiters(String delimitersPart){
        if (delimitersPart.startsWith("//[")){
            String delimiters = delimitersPart.substring(3, delimitersPart.length() -1);
            delimiters = delimiters.replace("][", "|");
            return delimiters;
        }else {
            return delimitersPart.substring(2);
        }
    }



    private int sum(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            try {
                int num = Integer.parseInt(number);
                 if (num < 0){
                     throw new IllegalArgumentException("음수는 허용되지 않습니다 : " + num);
                 }else {
                     total += num;
                 }

            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("유효하지 않은 숫자입니다 : " + number);
            }

        }
        return total;
    }
}
