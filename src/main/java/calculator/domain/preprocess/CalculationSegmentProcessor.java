package calculator.domain.preprocess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static calculator.utils.Util.isInteger;

public class CalculationSegmentProcessor {


    public void findNoneDelimeterString(List<String>delimterList, String input){

        String extractedCharacter ;

        for(int i=0; i<input.length(); i++) {
            extractedCharacter = input.substring(i, i + 1);
            if (!isInteger(extractedCharacter) && !delimterList.contains(extractedCharacter))
                //음수가 들어오는 예외를 따로 작업하지 않은 이유는 여기서 "-" 또한 걸러지기 떄문.
                throw new IllegalArgumentException("구분자 이외의 문자가 있습니다.");
        }
    }

    private List<String> discardBlankSpace(List<String> input) {
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
