package calculator;

public class InputParser {

    public String getCustomParser(String input) {
        String separator = null;
        if(input.startsWith("//")){
            int indexOfNewline = input.indexOf("\n");
            separator = input.substring(2, indexOfNewline);
        }
        return separator;
    }

}
