package parser;

public class Parser {

    public String parseStringToCalculate(String string) {
        if (string.substring(0, 4).equals("//\\n")) {
            return string.substring(4);
        }

        return string.substring(5);
    }

}
