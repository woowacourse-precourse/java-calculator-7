package calculator.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputConsoleHandler {

    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("(/{2})([^0-9 ]{1,})(\\\\n)");
    private static final Pattern OPERAND_PATTERN = Pattern.compile("-?\\d+([^0-9 ]{1,}-?\\d+)*");

    public void showInputGuideMessage() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public String[] getUserInput() {
        StringJoiner separatorJoiner = new StringJoiner("|", "[", "]");

        separatorJoiner.add(",");
        separatorJoiner.add(":");

        String userInput = Console.readLine();

        if (userInput.isBlank()) {
            String[] blankArray = {};

            return blankArray;
        }

        if (isNotCustomSeparatorLine(userInput) && isNotOperandLine(userInput)) {
            throw new IllegalArgumentException("허용되지 않은 입력입니다. 애플리케이션을 종료합니다.");
        }

        if (isNotOperandLine(userInput)) {
            throw new IllegalArgumentException("지원되지 않는 계산 형식입니다. 애플리케이션을 종료합니다");
        }

        if (isCustomSeparatorLine(userInput)) {
            String customSeparator = findCustomSeparator(userInput);

            if ("\\Q.\\E".equals(customSeparator)) {
                throw new IllegalArgumentException("구분자로 소숫점 (.) 을 사용할 수 없습니다. 애플리케이션을 종료합니다");
            }

            separatorJoiner.add(customSeparator);
        }

        if (isNotCustomSeparatorLine(userInput) && doesExistsCustomSeparator(userInput)) {
            throw new IllegalArgumentException("커스텀 구분자의 지정 방법이 잘못되었습니다. 애플리케이션을 종료합니다.");
        }

        String operands = findOperands(userInput);
        String joinerString = separatorJoiner.toString();

        return operands.split(joinerString);
    }


    private boolean isNotOperandLine(String input) {
        return !isOperandLine(input);
    }

    private boolean isNotCustomSeparatorLine(String input) {
        return !isCustomSeparatorLine(input);
    }

    private boolean isOperandLine(String input) {
        Matcher matcher = OPERAND_PATTERN.matcher(input);

        return matcher.find();
    }

    private String findCustomSeparator(String input) {
        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(input);
        matcher.find();

        return Pattern.quote(matcher.group(2));
    }

    private boolean isCustomSeparatorLine(String input) {
        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(input);

        return matcher.find();
    }

    private String findOperands(String input) {
        Matcher matcher = OPERAND_PATTERN.matcher(input);
        matcher.find();

        return matcher.group();
    }

    private boolean doesExistsCustomSeparator(String userInput) {
        return !userInput.matches("-?\\d+([,|:]-?\\d+)*");
    }

    public boolean askIfAppEnd() {
        String userAction = Console.readLine();

        if ("1".equals(userAction)) {
            return false;
        }

        if ("2".equals(userAction)) {
            return true;
        }

        throw new IllegalArgumentException("허용되지 않은 동작입니다. 애플리케이션을 종료합니다.");
    }

}
