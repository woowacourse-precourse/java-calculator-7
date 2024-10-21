package calculator.parser;

import java.util.regex.Pattern;

public class InputParser {

    private static final String DEFAULT_SEPARATOR = ", | :";

    public String[] parse(String input) throws IllegalArgumentException {
        String separator = DEFAULT_SEPARATOR;
        String numbers = input;

        if (input.startsWith("//")) {       //커스텀 구분자 사용 시
            int newlineIndex = input.indexOf("\n");     //\n의 인덱스를 찾음
            if (newlineIndex == -1) {                   //\n이 존재하지 않을 시 오류 발생
                throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
            }

            String customSeparator = input.substring(2, newlineIndex);  //커스텀 구분자 추출
            if (customSeparator.length() != 1) {    //커스텀 구분자가 한 글자 이상일 경우 오류 발생
                throw new IllegalArgumentException("커스텀 구분자는 한 글자여야 합니다.");
            }

            if (Character.isDigit(customSeparator.charAt(0))) { //커스텀 구분자가 숫자일 경우 오류 발생
                throw new IllegalArgumentException("구분자는 숫자가 될 수 없습니다.");
            }

            separator = Pattern.quote(customSeparator);     //구분자를 quote 처리
            numbers = input.substring(newlineIndex + 1);    //\n 이후부터 numbers로 사용
        } else {
            if (!Character.isDigit(input.charAt(0))) {  //첫 글자가 숫자가 아니라면 오류발생
                throw new IllegalArgumentException("입력 형식이 올바르지 않습니다.");
            }
        }

        String[] tokens = numbers.split(separator);     //구분자를 사용하여 숫자 추출하여 자장

        if (tokens.length == 0) {   //구분된 숫자가 없을 시 오류발생
            throw new IllegalArgumentException("숫자가 입력되지 않았습니다.");
        }

        return tokens;
    }
}