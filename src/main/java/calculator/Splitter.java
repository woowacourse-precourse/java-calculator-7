package calculator;

import java.util.Arrays;
import java.util.List;

public class Splitter {

    public List<String> splitByBasicSeparator(String value) {
        return Arrays.stream(value.split("[,:]")).toList();

    }
    
}
