package calculator;

import java.util.*;
import java.util.regex.Pattern;

public class Application {
    private static final String REGEX_A = "[0-9,:]*$";
    private static final String REGEX_B = "^//(.)\\\\n([0-9,:]|\\1)*$";

    private static final Map<Pattern, InputType> PATTERN_MAP = Map.of(
            Pattern.compile(REGEX_A), InputType.typeA,
            Pattern.compile(REGEX_B), InputType.typeB
    );

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println("결과 : " + sum(input));
    }

    /**
     * @description : input 값과 구분자를 받아 합산 처리
     */
    public static int sum(String input) {
        InputType type = validateInputPattern(input);
        String customSeparator = type.isTypeB() ? String.valueOf(input.charAt(2)) : "";
        String separatorsForSplit = makeSeparators(",", ":", type.isTypeB() ? customSeparator : "");
        String[] numbers = type.isTypeA() ? input.split(separatorsForSplit) : input.substring(5).split(separatorsForSplit);

        List<String> numberList = new ArrayList<>(Arrays.asList(numbers));
        numberList.removeIf(String::isBlank);

        int sum = 0;
        for (String n : numberList) {
            sum += Integer.parseInt(n);
        }
        return sum;
    }

    /**
     * @description: 문자열이 패턴에 유효한지 검사하여 알맞은 타입 반환
     */
    private static InputType validateInputPattern(String input) {
        for (Map.Entry<Pattern, InputType> entry : PATTERN_MAP.entrySet()) {
            if (entry.getKey().matcher(input).matches()) {
                return entry.getValue();
            }
        }
        throw new IllegalArgumentException("Invalid input: " + input);
    }

    /**
     * @return: "[,:]" or "[,:(custom separator)]"
     * @description: input을 커스텀 구분자를 포함하여 split() 하기 위해 가변인수로 받아 처리
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
