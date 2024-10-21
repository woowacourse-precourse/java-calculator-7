package calculator;

import static calculator.CustomCheck.isCustom;

public class Validation {

    public static void execution(String str) {
        if (isCustom(str)) {
            checkCustomVal(str);
        } else {
            checkNormalVal(str);
        }
    }

    private static void checkNormalVal(String str) {

        String[] numbers = Delimiter.doNormalDelimiter(str);

        if (!(checkInteger(numbers[0]))) {
            throw new IllegalArgumentException("첫번째 수는 숫자로 입력해주세요.");
        }

        for (String number : numbers) {
            try {
                int num = Integer.parseInt(number);
                if (num < 0) {
                    throw new IllegalArgumentException("입력값은 양수로 입력해주세요.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("유효하지 않은 숫자의 형식입니다.");
            }
        }
    }

    // 커스텀 문자로 숫자가 들어온 경우
    private static void checkCustomVal(String str) {
        String[] numbers = Delimiter.doCustomDelimiter(str);

        if ((checkInteger(CustomCheck.getCustom(str)))) {
            throw new IllegalArgumentException("커스텀 값엔 숫자를 입력할 수 없습니다.");
        }

        for (String number : numbers) {

            if (Integer.parseInt(number) < 0) {
                throw new IllegalArgumentException("커스텀 입력 값은 양수로 입력해주세요.");

            }
        }
    }

    private static boolean checkInteger(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}