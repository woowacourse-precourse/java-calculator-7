package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidatorImpl implements StringValidator {

    // 입력값의 유효성을 검사하고, 구분자를 반환하는 메서드
    @Override
    public String isValid(String input) {
        // 1. 입력이 null이거나 빈 문자열인지 검사 -> 수정해야함
        if (input == null || input.isEmpty()) {
            //throw new IllegalArgumentException("입력 값이 비어있거나 null입니다.");
            System.out.println("0");
        }

        // 2. 정규 표현식을 사용하여 "//"와 "\n" 사이의 커스텀 구분자를 추출
        Pattern pattern = Pattern.compile("//(.*?)\\n");  // "//"와 "\n" 사이의 구분자를 찾는 정규 표현식
        Matcher matcher = pattern.matcher(input);

        String delimiter;
        String numbers;

        if (matcher.find()) {
            // 커스텀 구분자 추출
            delimiter = matcher.group(1);  // 첫 번째 그룹에서 구분자를 추출
            numbers = input.substring(matcher.end());  // "\n" 이후의 숫자 부분 추출
            System.out.println("1: " + numbers + delimiter);
        } else {
            // 기본 구분자 처리 (쉼표와 콜론 사용)
            delimiter = "[,:]";
            numbers = input;// 전체 입력을 숫자 부분으로 간주
            System.out.println("2: " + numbers + delimiter);
        }


        // 3. 숫자 형식 검사 (숫자 이외의 값이 있는지 확인)
        String[] tokens = numbers.split(Pattern.quote(delimiter));  // 구분자로 숫자 분리
        for (String token : tokens) {
            if (!token.matches("\\d+")) {  // 숫자가 아닌 경우 예외 처리
                throw new IllegalArgumentException("숫자 형식이 올바르지 않음 " + token);
            }
        }

        // 4. 유효한 경우 구분자 반환
        return delimiter;
    }
}
