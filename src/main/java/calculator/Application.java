package calculator;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    private static final String REGEX_A = "[0-9,:]*$";
    private static final String REGEX_B = "^//(.)\\\\n([0-9,:]|\\1)*$";

    private static final Map<Pattern, InputType> PATTERN_MAP = Map.of(
            Pattern.compile(REGEX_A), InputType.typeA,
            Pattern.compile(REGEX_B), InputType.typeB
    );

    public static void main(String[] args) {
        for (String input : args) {
            System.out.println("결과 : " + sum(input));
        }
    }

    /**
     * @description : input 값과 구분자를 받아 합산 처리
     */
    public static int sum(String input) {
        InputType type = validateInputPattern(input);
        String customSeparator = type.isTypeB() ? String.valueOf(input.charAt(2)) : "";
        String separatorsForSplit = makeSeparators(",", ":", type.isTypeB() ? customSeparator : "");
        String[] numbers = type.isTypeA() ? input.split(separatorsForSplit) : input.substring(5).split(separatorsForSplit);

        int sum = 0;
        for (String n : numbers) {
            sum += Integer.parseInt(n);
        }
        return sum;
    }

    /**
     * @description : 문자열이 패턴에 유효한지 검사하여 알맞은 타입 반환
     */
    private static InputType validateInputPattern(String input) {
        for (Map.Entry<Pattern, InputType> entry : PATTERN_MAP.entrySet()) {
            if (entry.getKey().matcher(input).matches()) {
                return entry.getValue();
            }
        }
        throw new IllegalArgumentException(input);
    }

    /**
     * @description : custom separator를 문자열에서 정규식을 사용하여 반환
     */
    @Deprecated
    private static String getCustomSeparator(String input) {
        Pattern pattern = Pattern.compile(REGEX_B);
        Matcher matcher = pattern.matcher(input);
        return matcher.hasMatch() ? matcher.group(1) : null;
    }


    /**
     * @return : "[,:]" or "[,:(custom separator)]"
     * @description : input을 커스텀 구분자를 포함하여 split() 하기 위해 가변인수로 받아 처리
     */
    private static String makeSeparators(String... separators) {
        StringBuilder combineStr = new StringBuilder();
        combineStr.append("[");
        for (String s : separators) {
            combineStr.append(s);
        }
        combineStr.append("]");
        return combineStr.toString();
    }


    private enum InputType {
        typeA, typeB;

        public boolean isTypeA() {
            return this.equals(typeA);
        }

        public boolean isTypeB() {
            return this.equals(typeB);
        }
    }

}
