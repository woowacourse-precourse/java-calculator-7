package calculator.cal.numberadder.string;

import java.util.ArrayList;
import java.util.List;

public class StringParser {

    public List<Integer> parseBySeparator(String inputString, String separator) {
        List<Integer> numbers = new ArrayList<>();

        //구분자로 숫자 추출
        if (inputString == null || inputString.isBlank()) {
            throw new IllegalArgumentException("문자열을 입력하지 않았습니다.");
        }
        String noSpaceString = inputString.replace(" ", "");
        String[] numberStrings = noSpaceString.split(separator);

        //형변환
        for (String numberString : numberStrings) {
            Integer number = 0;

            //공백일 경우 0
            if (!(numberString.length() <= 0) && numberString.matches("\\d+")) {
                number = Integer.parseInt(numberString);
            } else if (!numberString.isEmpty()) {
                //숫자가 아닌 다른것이 들어온 경우 예외
                throw new IllegalArgumentException(numberString + "은(는) 숫자가 아닙니다.");
            }

            numbers.add(number);
        }

        return numbers;
    }

}