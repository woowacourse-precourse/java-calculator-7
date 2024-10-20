package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import static calculator.domain.ValueExtractor.getDelimitedValue;

public class NumberExtractor{
    public static int[] getIntegerArray(String input, ArrayList<String> delimiter){
        String[] delimitedValue = getDelimitedValue(input, delimiter);

        return Arrays.stream(delimitedValue).mapToInt(Integer::parseInt).toArray();
    }
}
