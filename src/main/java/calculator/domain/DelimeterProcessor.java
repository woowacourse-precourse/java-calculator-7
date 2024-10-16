package calculator.domain;

public class DelimeterProcessor {

    public boolean checkCustomDelimeterRequest(String input) {
        if (input.startsWith("//") && input.contains("\n"))
            return true;
        else
            return false;
    }
}
