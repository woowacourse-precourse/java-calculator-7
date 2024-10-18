package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private final SeparatorProcessor separatorProcessor;
    private final Pattern customSeparatorCmdPattern;
    private final int customSeparatorIdx;
    private final String minusDigitRegex = "-[0-9]*";
    private final String positiveDigitRegex = "\\d*";

    public Calculator() {
        this.separatorProcessor = new SeparatorProcessor(',', ':');
        this.customSeparatorCmdPattern = Pattern.compile("^(\\/\\/.\\\\n)");
        this.customSeparatorIdx = 2;
    }

    /**
     * 문자열에서 구분자를 기준으로 숫자를 추출하여 합 계산
     *
     * @return 구분자로 분리된 숫자의 합
     */
    public int sum(String cmd) {
        if (cmd.isEmpty()) {
            return 0;
        }

        // 커스텀 구분자 등록
        Matcher matcher = customSeparatorCmdPattern.matcher(cmd);
        boolean containsCustomSeparatorCmd = matcher.find();
        if (containsCustomSeparatorCmd) {
            registerCustomSeparator(matcher);

            // 구분자 등록에 사용됐던 명령어 제거
            cmd = cmd.replace(matcher.group(), "");
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
    private void registerCustomSeparator(Matcher matcher) {
        char customSeparator = matcher.group().charAt(customSeparatorIdx);

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
        if (str.matches(minusDigitRegex)) {
            throw new IllegalArgumentException("음수 계산 불가");
        }
        if (!str.matches(positiveDigitRegex)) {
            throw new IllegalArgumentException("숫자 이외의 값은 계산 불가");
        }

        return true;
    }
}
