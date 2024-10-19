package calculator;

import java.util.ArrayList;
import  java.util.List;


public class InputParser {
    public ParsedInput parse(String input){
        String delimiter = "[,:]";

        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf('\n');
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            delimiter = Delimiter.escape(input.substring(2, delimiterEndIndex).trim());
            input = input.substring(delimiterEndIndex + 1);
        }

        String[] tokens = input.split(delimiter);
        List<Integer> numbers = new ArrayList<>();

        return new ParsedInput(numbers);
    }

    private int parseNumber(String number){
        if(number.isEmpty()){
            return 0;
        }
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("잘못된 숫자 형식입니다: " + number);
        }
    }
}
