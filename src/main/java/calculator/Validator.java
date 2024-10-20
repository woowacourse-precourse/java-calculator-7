package calculator;

public class Validator {

    public void validateDefaultInput(String input) {
        for (char c : input.toCharArray()) {
            if (isInvalidCharacter(c)) {
                throw new IllegalArgumentException("잘못된 문자 포함됨");
            }
        }
    }

    private boolean isInvalidCharacter(char c) {
        return !Character.isDigit(c) && c != ':' && c != ','; // TODO
    }

    public void validateCustomInput(String input, String customDelimiter) {
        String regex = "^([0-9:,]+|(" + customDelimiter + "))*$";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException("잘못된 문자 포함됨");
        }
    }

    public static boolean isEmptyString(String input) {
        return input.isEmpty();
    }

//    public void validateInput(String input) {
////        if (isEmptyString(input)) {
////            return;
////        }
//        if (isNegativeNumber(input)) {
//            throw new IllegalArgumentException("음수는 입력할 수 없음");
//        }
//        if (isInvalidCharacter(input)) {
//            throw new IllegalArgumentException("잘못된 문자 포함됨");
//        }
//    }

//    private boolean isNegativeNumber(String input) {
//        return !InputParser.isDelimiter("-") && input.contains("-");
//    }

//    private boolean isInvalidCharacter(String input) {
//        for (char c : input.toCharArray()) {
//            if (!Character.isDigit(c) && !isDelimiter(c)) {
//                return true;
//            }
//        }
//        // TODO 정규표현식으로 바꾸기
////        String pattern = "^[0-9]+([:,][0-9]+)*$";
//        String pattern = "^(\\\\d+([,:" + InputParser.getCustomDelimiter() + "]\\\\d+)*)?$";
//        return !input.matches(pattern);
//
////        return false;
//    }

//    private boolean isDelimiter(char c) {
//        return InputParser.isDelimiter(String.valueOf(c));
//    }
}

