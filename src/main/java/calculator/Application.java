package calculator;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    private static final String REGEX_A = "[0-9,:]*$";
    private static final String REGEX_B = ""; // todo 정규식 만들기

    private enum InputType {
        typeA, typeB
    }

    private static final Map<Pattern, InputType> PATTERN_MAP = Map.of(
            Pattern.compile(REGEX_A), InputType.typeA,
            Pattern.compile(REGEX_B), InputType.typeB
    );

    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException();
        }
        String input = args[0];
        InputType type = classifyStringPattern(input);

        int result = -1;
        if (type.equals(InputType.typeA)) {
            result = sum(input, ",", ":");
        } else if (type.equals(InputType.typeB)) {
//            String customSeparator = getCustomSeparator(input);
            result = sum(input.substring(5), ",", ":", String.valueOf(input.charAt(2)));
        }

        System.out.println("결과 : " + result);
    }

    /**
     * @param input
     * @return
     * @description : 정규식을 통해 문자열이 패턴에 부합한지 판별 후 type return
     */
    private static InputType classifyStringPattern(String input) {
        for (Map.Entry<Pattern, InputType> entry : PATTERN_MAP.entrySet()) {
            if (entry.getKey().matcher(input).matches()) {
                return entry.getValue();
            }
        }
        throw new IllegalArgumentException();
    }

    /**
     * @param input
     * @return
     * @description : custom separator를 문자열에서 정규식을 사용하여 반환
     */
    private static String getCustomSeparator(String input) {
        Pattern pattern = Pattern.compile(REGEX_B);
        Matcher matcher = pattern.matcher(input);
        return matcher.hasMatch() ? matcher.group(1) : null;
    }

    /**
     * @param input
     * @param separators
     * @return
     * @description : input 값과 구분자를 받아 합산 처리
     */
    public static int sum(String input, String... separators) {
        String separatorsForSplit = makeSeparators(separators);
        String[] numbers = input.split(separatorsForSplit);

        int sum = 0;
        for (String n : numbers) {
            sum += Integer.parseInt(n);
        }
        return sum;
    }

    /**
     * @param separators : 구분자
     * @return : "[,:]" or "[,:(custom)]"
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

}
