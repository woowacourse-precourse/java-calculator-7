package calculator;

import java.util.List;

public class StringAdd {

    private final DelimiterParser delimiterParser;
    private final NumberParser numberParser;

    public StringAdd(){
        this.delimiterParser = new DelimiterParser();
        this.numberParser = new NumberParser();
    }

    public int add(String input){
        if(input.isEmpty()){
            return 0;
        }

        String delimiters = delimiterParser.parseDelimiter(input);
        String numbers = delimiterParser.extractNumbers(input);
        List<Integer> numberList = numberParser.parseNumbers(numbers, delimiters);
        System.out.println(delimiters);
        System.out.println(numbers);
        System.out.println(numberList);

        return 0;
    }
}
