package calculator;

import java.util.List;

public class StringAdd {

    private final DelimiterParser delimiterParser;

    public StringAdd(){
        this.delimiterParser = new DelimiterParser();
    }

    public int add(String input){
        if(input.isEmpty()){
            return 0;
        }

        String delimiters = delimiterParser.parseDelimiter(input);
        String numbers = delimiterParser.extractNumbers(input);
        System.out.println(delimiters);
        System.out.println(numbers);

        return 0;
    }
}
