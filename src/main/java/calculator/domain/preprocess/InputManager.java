package calculator.domain.preprocess;

import java.util.List;

public class InputManager {

    public boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void findNoneDelimeterString(List<String>delimterList, String input){

        String extractedCharacter ;

        for(int i=0; i<input.length(); i++) {
            extractedCharacter = input.substring(i, i + 1);
            if (!isInteger(extractedCharacter) && !delimterList.contains(extractedCharacter))
                throw new IllegalArgumentException("구분자 이외의 문자가 있습니다.");
        }
    }

}
