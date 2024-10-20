package calculator.function;

import java.util.List;

public class Checker {
    private List<String> inputStrings;
    private String separator;

    public Checker(List<String> inputStrings, String separator) {
        this.inputStrings = inputStrings;
        this.separator = separator;
    }

    public void execute(){
        for (String inputString : inputStrings) {
            for (int i = 0; i < separator.length(); i++) {
                char target = separator.charAt(i);
                if(inputString.indexOf(target) != -1) throw new IllegalArgumentException();
            }
            if(inputString.length() > 1 && inputString.charAt(0) == '0') throw new IllegalArgumentException();
            if(!inputString.matches("\\d*")) throw new IllegalArgumentException();
        }
    }
}
