package calculator.service;

import calculator.domain.UserInput;
import java.util.List;
import java.util.regex.Pattern;

public class ParserService {

    public Integer checkUserInputEmpty(UserInput userInput) {
        if (userInput.getText().isEmpty()) {
            return 0;
        } else {
            return null;
        }
    }

    public List<String> checkCustomSeparator(UserInput userInput) {
        String userInputText = userInput.getText();
        // 기본 구분자 선언
        String separator = ",|:";

        // 입력값이 //로 시작하고, 전체 문장에 "\n"을 포함하면 커스텀구분자 수색
        if (userInputText.startsWith("//") && userInputText.contains("\n")) {
            // 커스텀 구분자가 끝나는 위치 파악
            int enterIndex = userInputText.indexOf("\n");
            // "//"와 "\n" 사이에서 커스텀 구분자 추출
            String customSeparator = userInputText.substring(2, enterIndex);
            // 구분자 목록에 커스텀 구분자 추가
            separator = separator + "|" + Pattern.quote(customSeparator);
            // userInputText에서 커스텀 구분자를 제외한 부분만 계산 대상으로 함
            userInputText = userInputText.substring(enterIndex + 1);
        }

        // 구분자로 문자열 분리
        List<String> numberList = List.of(userInputText.split(separator));
        return numberList;
    }

}