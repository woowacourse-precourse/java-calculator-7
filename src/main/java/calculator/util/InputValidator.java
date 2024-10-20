package calculator.util;

import calculator.domain.CalcTarget;

public class InputValidator {

    private static String separator = ",:";

    public static void validate(CalcTarget target) {
        if(target.getCustomSeparator() != null) {
            separator += target.getCustomSeparator();
        }

        if(!isValidateInput(target)) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
    }

    private static boolean isValidateInput(CalcTarget target) {
        StringBuilder prefix = new StringBuilder();
        boolean isHaveSeparator = false;
        if (!Character.isDigit(target.getValue().charAt(0))){
            return false;
        }
        prefix.append(target.getValue().charAt(0));
        for(int i = 1; i < target.getValue().length(); i++) {
            if (!prefix.isEmpty()) {
                if (isContainSeparator(target.getValue(), i)) {
                    isHaveSeparator = true;
                }
            }

            if(!prefix.isEmpty() && separator.contains(prefix.toString())) {
                if(!Character.isDigit(target.getValue().charAt(i))){
                    return false;
                }
            }

            if(!separator.contains(target.getValue().charAt(i) + "")) {
                if (!Character.isDigit(target.getValue().charAt(i))) {
                    return false;
                }
            }

            prefix.setLength(0);
            prefix.append(target.getValue().charAt(i));
        }
        if(prefix.length() == 1 && separator.contains(prefix.toString())) {
            return false;
        }
        if(!isHaveSeparator && target.getValue().length()!=1) {
            return false;
        }
        return true;
    }

    private static boolean isContainSeparator(String input, int index) {
        return separator.indexOf(input.charAt(index)) != -1;
    }
}
