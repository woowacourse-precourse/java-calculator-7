package calculator;

import calculator.dto.InputDTO;
import calculator.dto.Numbers;
import java.util.regex.Pattern;

public class Calculator {

    public static int add(InputDTO inputDTO) {
        String userInput = inputDTO.getUserInput().trim();
        String defaultSeparator = ",|:";  // 기본 구분자
        String customSeparator = defaultSeparator;  // 기본 구분자로 초기화

        // \n 문자를 줄바꿈 문자로 변환
        userInput = userInput.replace("\\n", "\n");

        // 사용자 입력에서 커스텀 구분자 추출
        if (userInput.startsWith("//")) {
            int separatorEndIndex = userInput.indexOf('\n');
            if (separatorEndIndex == -1) {
                throw new IllegalArgumentException("Invalid input format.");
            }
            // 커스텀 구분자를 포함한 정규식 생성
            String newSeparator = Pattern.quote(userInput.substring(2, separatorEndIndex));
            customSeparator = defaultSeparator + "|" + newSeparator;  // 기존 구분자와 결합
            userInput = userInput.substring(separatorEndIndex + 1);  // 나머지 문자열 추출
        }

        // 문자열을 모든 구분자로 분리
        String[] inputs = userInput.split(customSeparator);
        Numbers numbers = new Numbers(inputs);

        return numbers.sum();  // 합계 반환
    }

}