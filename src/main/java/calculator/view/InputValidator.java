package calculator.view;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    private void throwIllegalArgument(String message) {
        throw new IllegalArgumentException(message);
    }

    // 기존 구분자 & 커스텀 구분자 외의 구분자가 입력될 경우
    // separation에 추가
    public void validatingSeparator(List<String> separated, List<String> separators) {
        for (int i = 0; i < separated.size(); i++) {
            if (i % 2 == 1) { // 구분자
                if (!separators.contains(separated.get(i))) {
                    throwIllegalArgument("[ERROR]유효하지 않은 구분자가 사용되었습니다.");
                }
            }
        }
    }

    // 마지막 요소가 숫자가 아니라 구분자일 경우
    // separation에 추가
    public void lastElement(List<String> separated) {
        // 마지막 요소의 첫글자가 숫자가 아닐경우 exception
        // 첫글자가 숫자면 나머지 글자도 숫자임
        if (!Character.isDigit(separated.get(separated.size() - 1).charAt(0))) {
            throwIllegalArgument("[ERROR]수식이 숫자로 끝나지 않습니다.");
        }
    }

    // 첫글자가 `/` 혹은 숫자가 아닐 경우
    // firstLetter에 추가
    public void validatingFirstLetter(char firstLetter) {
        if (firstLetter != '/' && !Character.isDigit(firstLetter)) { // 조건식 맞는지 확인해볼 것
            throwIllegalArgument("[ERROR]수식이 커스텀 구분자 선언자 혹은 숫자로 시작되지 않습니다.");
        }
    }

    // findCustomSeparator에 추가
    public List<String> customValidator(String given) {
        List<String> customSeparatorAndExpression = checkForm(given);

        checkContent(customSeparatorAndExpression.get(0));

        notNumAfterCustom(customSeparatorAndExpression.get(1));

        return customSeparatorAndExpression;
    }

    // (첫글자가 `/`일 경우) 그 뒤에 `//xx\n`형식이 온전히 이어지지 않을 경우
    // findCustomSeparator에 추가(customValidator)
    private List<String> checkForm(String given) {
        String regex = "//(.*)\\n(.*)"; // 정규 표현식
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(given);

        if (matcher.find()) {
            String customSeparator = matcher.group(1); // 커스텀 구분자
            String expression = matcher.group(2); // 수식 부분
            return Arrays.asList(customSeparator, expression);
        } else {
            throwIllegalArgument("[ERROR]커스텀 구분자 선언자가 올바르게 사용되지 않았습니다.");
            return null; //TODO: 불필요한 코드
        }
    }

    // 커스텀 구분자 지정문자 사이에 아무것도 없거나 공백문자를 포함할 경우
    // 커스텀 구분자 지정문자 안에 숫자가 있을 경우
    // findCustomSeparator에 추가(customValidator)
    private void checkContent(String customSeparator) {
        if (customSeparator.isEmpty() || customSeparator.isBlank()) {
            throwIllegalArgument("[ERROR]커스텀 구분자 선언자 안에는 한 글자 이상 선언해야 합니다.");
        }
        for (int i = 0;i < customSeparator.length();i++) {
            if (Character.isDigit(customSeparator.charAt(i))) {
                throwIllegalArgument("[ERROR]커스텀 구분자 선언자 안에는 숫자가 들어갈 수 없습니다.");
            }
        }
    }

    // 커스텀 구분자 지정문자 뒤에 숫자가 오지 않을 경우
    // findCustomSeparator에 추가(customValidator)
    private void notNumAfterCustom(String expression) {
        if (!Character.isDigit(expression.charAt(0))) {
            throwIllegalArgument("[ERROR]커스텀 구분자 선언자 뒤에 수식이 숫자로 시작하지 않습니다.");
        }
    }
}
