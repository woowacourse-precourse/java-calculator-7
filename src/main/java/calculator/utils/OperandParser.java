package calculator.utils;

import java.util.ArrayList;
import java.util.List;

public class OperandParser {
    private int isSeparator(String tmpString, List<String> separator) {
        for (int i = 0; i < separator.size(); i++) {
            if (tmpString.length() < separator.get(i).length()) {
                continue;
            }
            if (separator.get(i).equals(tmpString.substring(0, separator.get(i).length()))) {
                return separator.get(i).length();
            }
        }
        return -1;
    }

    public List<Integer> parse(String removedString, List<String> separator) {
        List<Integer> operand = new ArrayList<>();
        String tmpOperand = "";

        for (int i = 0; i < removedString.length(); i++) {
            int separatorLength = isSeparator(removedString.substring(i), separator);

            if (separatorLength != -1) {
                if (!tmpOperand.equals("")) {
                    operand.add(Integer.parseInt(tmpOperand));
                    tmpOperand = "";
                }
                i += separatorLength - 1;
            } else if (Character.isDigit(removedString.charAt(i))) {
                tmpOperand += removedString.charAt(i);
            } else {
                throw new IllegalArgumentException("등록되지 않은 구분자가 포함되어 있습니다.");
            }
        }
        if (!tmpOperand.equals("")) {
            operand.add(Integer.parseInt(tmpOperand));
        }
        return operand;
    }
}
