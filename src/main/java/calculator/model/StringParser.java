package calculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {
    public List<Integer> extractNumbers(String str){
        List<Integer> numbers;
        String delimeter = findDelimeter(str);

        numbers = Arrays.stream(str.split(delimeter))
                .map(s -> s.isEmpty() ? "0" : s)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return numbers;
    }

    public String findDelimeter(String str){
        if (str.startsWith("//")&&str.contains("\n")){
            return str.substring(2, str.indexOf("\n"));
        }
        return ",|:";
    }


}
