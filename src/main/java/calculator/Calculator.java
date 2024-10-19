package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private final SeparatorProcessor separatorProcessor;
    private final Pattern customSeparatorCmdPattern;
    private final int CUSTOM_SEPARATOR_IDX = 2;
    private final String CUSTOM_SEPARATOR_CMD_REGEX = "^(\\/\\/.\\\\n)";
    private final String MINUS_DIGIT_REGEX = "-[0-9]*";
    private final String DIGIT_REGEX = "-?\\d*";
    private final ICalculatorDisplay calculatorDisplay;

    public Calculator(ICalculatorDisplay calculatorDisplay) {
        this.separatorProcessor = new SeparatorProcessor(',', ':');
        this.customSeparatorCmdPattern = Pattern.compile(CUSTOM_SEPARATOR_CMD_REGEX);
        this.calculatorDisplay = calculatorDisplay;
    }

    public void run() {
        String cmd = calculatorDisplay.getPromptInput();

        // 커스텀 구분자 설정
        Matcher matcher = customSeparatorCmdPattern.matcher(cmd);
        if (matcher.find()) { // 사용자가 커스텀 구분자 설정 명령을 입력했을 시
            registerCustomSeparator(matcher.group().charAt(CUSTOM_SEPARATOR_IDX));

            // 구분자 등록에 사용됐던 명령어 제거
            cmd = cmd.replace(matcher.group(), "");
        }

        // 계산
        int result = sum(cmd);

        calculatorDisplay.printResult(result);
    }

    /**
     * 문자열에서 구분자를 기준으로 숫자를 추출하여 합 계산
     *
     * @return 구분자로 분리된 숫자의 합
     */
    private int sum(String cmd) {
        if (cmd.isEmpty()) {
            return 0;
        }

        // 합 계산
        int result = 0;
        String[] rawNumbers = separatorProcessor.split(cmd);
        for (String rawNum : rawNumbers) {
            validateNumber(rawNum);

            result += Integer.parseInt(rawNum);
        }

        return result;
    }

    /**
     * 커스텀 구분자 등록
     *
     * @throws IllegalArgumentException 숫자를 커스텀 구분자로 등록하려는 경우
     */
    private void registerCustomSeparator(char customSeparator) {
        if (Character.isDigit(customSeparator)) {
            throw new IllegalArgumentException("숫자는 커스텀 구분자로 등록 불가");
        }

        separatorProcessor.addSeparator(customSeparator);
    }

    /**
     * 올바른 숫자인지 검사
     *
     * @throws IllegalArgumentException 음수이거나, 숫자 이외의 값일 경우
     */
    private boolean validateNumber(String str) {
        if (str.matches(MINUS_DIGIT_REGEX)) {
            throw new IllegalArgumentException("음수 계산 불가");
        }
        if (!str.matches(DIGIT_REGEX)) {
            throw new IllegalArgumentException("숫자 이외의 값은 계산 불가");
        }

        return true;
    }
}
