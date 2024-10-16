package calculator.domain.preprocess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitManager {

    public List<String> discardBlankSpace(List<String> input) {
        input.removeIf(String::isBlank);
        return input;
    }

    public List<String> extractNumbers(List<String> delimeterList, String input){

        String regularExpression = "["+String.join("",delimeterList)+"]";
        String[] extractedNumbers = input.split(regularExpression);
        List<String> extractedNumbersList = new ArrayList<>(Arrays.asList(extractedNumbers));
        return  discardBlankSpace(extractedNumbersList);
    }

}
