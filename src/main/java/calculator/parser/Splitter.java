package calculator.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class Splitter implements SplitterInterface {
    private Seperator seperator;

    public void setSeperator(Seperator seperator) {
        this.seperator = seperator;
    }

    @Override
    public List<Integer> split(String text){
        String pattern = String.join("|", seperator.getSeperators()
                .stream()
                .map(Pattern::quote)
                .toArray(String[]::new));

        String[] numberString = text.split(pattern);
        List<Integer> numbers = new ArrayList<>();

        for (String number : numberString) {
            number = number.trim();
            if (parseInt(number) < 0){
                throw new NumberFormatException();
            }
            if (!number.isEmpty()) {
                try{
                    numbers.add(parseInt(number));
                } catch (NumberFormatException e){
                    throw new IllegalArgumentException();
                }
            }
        }
        return numbers;
    }

}
