package calculator.domain;

public class DelimeterProcessor {

    public boolean checkCustomDelimeterRequest(String input) {
        if (input.startsWith("//") && input.indexOf("\n") == 3)
            return true;
        else
            return false;
    }
}
