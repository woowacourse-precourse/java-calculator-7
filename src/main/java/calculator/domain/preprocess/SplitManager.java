package calculator.domain.preprocess;

import java.util.List;

public class SplitManager {

    public List<String> discardBlankSpace(List<String> input){
        input.removeIf(String::isBlank);
        return input;
    }


}
