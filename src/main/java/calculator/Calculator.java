package calculator;

import global.ErrorCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    private static final Printer printer = new Printer();
    static String input = "";
    static List<String> separators = new ArrayList<>(Arrays.asList(",", ":"));

    Calculator() {
        input = printer.write();
    }


    public void calculate() {
        if (input.isEmpty()) {
            printer.read(0);
            return;
        }
        findCustomSeparator();
        printer.read(sum());
    }

    /**
     * findCustomSeparator(): 커스텀 구분자를 찾아 seperators 리스트에 추가한다.
     */
    private void findCustomSeparator() {
        if (input.startsWith("//")) {
            if (!input.contains("\\n")) {
                throw new IllegalArgumentException(ErrorCode.INVALID_CUSTOM_REQUEST.message);
            }
            int separatorEndIndex = input.indexOf("\\n");
            String customSeparator = input.substring(2, separatorEndIndex);

            separators.addAll(Arrays.asList(customSeparator.split("")));
            input = input.substring(separatorEndIndex + 2);
        }
    }

    /**
     * sum(): 구분자를 이용해 문자열 분리 후 숫자들 합계 리턴
     *
     * @return : 합계
     */
    private Integer sum() {
        String[] numbers = input.split(separators.toString());
        return Arrays.stream(numbers)
                .mapToInt(number -> {
                    int integer;
                    if (number.isEmpty()) {
                        throw new IllegalArgumentException(ErrorCode.TO0_MUCH_SEPARATORS.message);
                    }
                    try {
                        integer = Integer.parseInt(number);
                    } catch (Exception e) {
                        throw new IllegalArgumentException(ErrorCode.WRONG_INPUT.message);
                    }
                    if (integer < 0) {
                        throw new IllegalArgumentException(ErrorCode.NOT_ALLOWED_NEGATIVE.message);
                    }
                    return integer;
                }).sum();
    }

}
