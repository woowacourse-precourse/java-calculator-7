package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class ValueExtractor{
    public static String[] getDelimitedValue(String input, ArrayList<String> delimiter){
        String regex = String.join("|", delimiter);
        return input.split(regex);
    }
}
