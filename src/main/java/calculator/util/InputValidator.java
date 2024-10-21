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

        for(int i = 0; i < target.getValue().length(); i++) {

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
        return true;
    }

}
