package calculator.model;
import java.util.regex.Pattern;


public class Splitter {
    private String numbers;

    public Splitter(){
        this.numbers = numbers;
    }

    public String[] splitNumbers(){
        String customDelimiter = "";
        if(checkCustomDelimiter()){
            customDelimiter = getCustomDelimiter();
            this.numbers = SplitDelimiter(numbers);
            return numbers.split("[,;]|" + Pattern.quote(customDelimiter));
        }
            return numbers.split("[,;]");
    }
}
