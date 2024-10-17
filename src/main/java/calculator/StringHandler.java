package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringHandler {
    public String extractSeparator(String input) {
        int start = input.indexOf("//") + 2;
        int end = input.indexOf("\n");
        return input.substring(start, end);
    }
}
