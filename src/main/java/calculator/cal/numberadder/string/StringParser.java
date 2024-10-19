package calculator.cal.numberadder.string;

import java.util.ArrayList;
import java.util.List;

public class StringParser {

    public List<Integer> parseBySeparator(String inputString, String separator) {
        List<Integer> numbers = new ArrayList<>();

        //구분자로 숫자 추출
        String noSpaceString = inputString.replace(" ", "");
        String[] numberStrings = noSpaceString.split(separator);

        //형변환
        for (String numberString : numberStrings) {
            Integer number = 0;

            //공백일 경우 0
            if (!(numberString.length() <= 0)) {
                number = Integer.parseInt(numberString);
            }
            numbers.add(number);
        }

        return numbers;
    }

}
