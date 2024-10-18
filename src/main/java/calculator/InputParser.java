package calculator;

import javax.swing.text.html.parser.Parser;
import java.util.ArrayList;
import  java.util.List;


public class InputParser {
    public  parsedInput parse(String input){
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
}
