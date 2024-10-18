package calculator.view;

import javax.security.auth.callback.CallbackHandler;
import java.util.List;

public class InputValidator {

    // 기존 구분자 & 커스텀 구분자 외의 구분자가 입력될 경우
    // separation에 추가
    public void validatingSeparator(List<String> separated, List<String> separators) {
        for (int i = 0; i < separated.size(); i++) {
            if (i % 2 == 1) { // 구분자
                if (!separators.contains(separated.get(i))) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    // 마지막 요소가 숫자가 아니라 구분자일 경우
    // separation에 추가
    public void lastElement(List<String> separated) {
        // 마지막 요소의 첫글자가 숫자가 아닐경우 exception
        // 첫글자가 숫자면 나머지 글자도 숫자임
        if (!Character.isDigit(separated.getLast().charAt(0))) {
            throw new IllegalArgumentException();
        }
    }

    // 첫글자가 `/` 혹은 숫자가 아닐 경우
    // firstLetter에 추가
    public void validatingFirstLetter(char firstLetter) {
        if (firstLetter != '/' && !Character.isDigit(firstLetter)) { // 조건식 맞는지 확인해볼 것
            throw new IllegalArgumentException();
        }
    }

    // findCustomSeparator에 추가
    public String customValidator(String given) {
        checkForm(given);

        String customSepartor = given.substring(2, given.indexOf("\\n"));
        checkContent(customSepartor);

        notNumAfterCustom(given);

        return customSepartor;
    }

    // (첫글자가 `/`일 경우) 그 뒤에 `//xx\n`형식이 온전히 이어지지 않을 경우
    // findCustomSeparator에 추가(customValidator)
    private void checkForm(String given) {
        if (!given.contains("//") || ! given.contains("\\n")) { // 조건식 맞는지 확인
            throw new IllegalArgumentException();
        }
    }

    // 커스텀 구분자 지정문자 사이에 아무것도 없을 경우
    // 커스텀 구분자 지정문자 안에 숫자가 있을 경우
    // findCustomSeparator에 추가(customValidator)
    private void checkContent(String customSeparator) {
        if (customSeparator.isEmpty() || customSeparator.isBlank()) { // 정확한 하나만 사용하게 고치기
            throw new IllegalArgumentException();
        }
        for (int i = 0;i < customSeparator.length();i++) {
            if (Character.isDigit(customSeparator.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
    }

    // 커스텀 구분자 지정문자 뒤에 숫자가 오지 않을 경우
    // findCustomSeparator에 추가(customValidator)
    private void notNumAfterCustom(String given) {
        if (!Character.isDigit(given.charAt(given.indexOf("\\n") + 2))) {
            throw new IllegalArgumentException();
        }
    }
}
