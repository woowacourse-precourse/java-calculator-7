package calculator.splitter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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
            if (!number.isEmpty()) {
                try{
                    numbers.add(Integer.parseInt(number));
                } catch (IllegalArgumentException e){

                }
            }
        }
        return numbers;
    }
}
