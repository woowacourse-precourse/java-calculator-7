package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String getUserInput() {
        String input = Console.readLine();
        validateUserInput(input);
        return input;
    }

    public static void validateUserInput(String input) {
        if (input.isEmpty() || validateGeneralUserInput(input) || validateCustomUserInput(input)) {
            return;
        }
        throw new IllegalArgumentException("연속된 구분자, 공백, 커스텀 구분자 등 잘못된 입력 입니다.");
    }

    //사용자가 기본 구분자를 사용하였을 경우
    public static boolean validateGeneralUserInput(String input) {
        return validateSeparator(input)
                && validateGeneralSequenceSeparator(input)
                && validateLastSeparator(input);
    }

    //사용자가 커스텀 구분자를 사용하였을 경우
    public static boolean validateCustomUserInput(String input) {
        return validateCustomFrontAndCharacter(input)
                && validateSeparator(input, input.charAt(2))
                && validateCustomSequenceSeparator(input)
                && validateLastSeparator(input);
    }

    //사용자가 커스텀 구분자를 사용하였을 경우, 앞 열 위치인지, 구분자가 문자인지 검증
    public static boolean validateCustomFrontAndCharacter(String input) {
        if (input.length() > 1) {
            char inputChar = input.charAt(2);
            return input.indexOf("//") == 0
                    && !Character.isDigit(inputChar)
                    && input.indexOf("\\n") == 3;
        }
        return false;
    }

    //사용자가 입력한 기본 구분자 검증
    public static boolean validateSeparator(String input) {
        for (char inputChar : input.toCharArray()) {
            if(!validateIncludeSeparator(inputChar)) {
                return false;
            }
        }
        return true;
    }

    //사용자가 입력한 커스텀 구분자 검증
    public static boolean validateSeparator(String input, char customSeparator) {
        for (int i = 5; i < input.length(); i++) {
            char inputChar = input.charAt(i);
            if (!validateIncludeSeparator(inputChar, customSeparator)) {
                return false;
            }
        }
        return true;
    }

    //사용자가 입력한 기본 구분자만 들어갔는지 검증
    public static boolean validateIncludeSeparator(char inputChar) {
        if (!Character.isDigit(inputChar)) {
            return inputChar == ',' || inputChar == ':';
        }
        return true;
    }

    //사용자가 입력한 커스텀 구분자와 기본 구분자만 들어갔는지 검증
    public static boolean validateIncludeSeparator(char inputChar, char customSeparator) {
        if (!Character.isDigit(inputChar)) {
            return inputChar == ',' || inputChar == ':' || inputChar == customSeparator;
        }
        return true;
    }

    //사용자가 기본 구분자를 연달아 쓰지 않았는지 검증
    public static boolean validateGeneralSequenceSeparator(String input) {
        for (char inputChar : input.toCharArray()) {
            if (!Character.isDigit(inputChar) && input.indexOf(inputChar) != (input.length() - 1)) {
                int idx = input.indexOf(inputChar) + 1;
                char inputCharNext = input.charAt(idx);
                if (!Character.isDigit(inputCharNext)) {
                    return false;
                }
            }
        }
        return true;
    }

    //사용자가 커스텀 구분자를 연달아 쓰지 않았는지 검증
    public static boolean validateCustomSequenceSeparator(String input) {
        for (int i = 5; i < input.length(); i++) {
            char inputChar = input.charAt(i);
            if (!Character.isDigit(inputChar) && i != (input.length() - 1)) {
                int idx = i + 1;
                char inputCharNext = input.charAt(idx);
                if (!Character.isDigit(inputCharNext)) {
                    return false;
                }
            }
        }
        return true;
    }

    //사용자가 문자열 마지막에 구분자를 사용했는지 검증
    public static boolean validateLastSeparator(String input) {
        char inputChar = input.charAt(input.length() - 1);
        return Character.isDigit(inputChar);
    }

}
