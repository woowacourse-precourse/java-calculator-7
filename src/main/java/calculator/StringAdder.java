package calculator;

import calculator.constant.Message;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringAdder {
    LinkedList<Object> expression;
    ArrayList<Character> separators;

    StringAdder() {
        separators = new ArrayList<>(List.of(',', ';'));
    }

    void setInputValue() {
        try {
            String inputValue = Console.readLine();
            inputValue = inputValue.replace(" ", "").replace("\n", "");
            inputValue = getSeparator(inputValue);
            expression = new LinkedList<>();
            formulate(inputValue);
        } catch (Exception exception) {
            throw new IllegalArgumentException(Message.EXCEPTION_MESSAGE + exception);
        }
    }

    int calculate() {
        int sum = 0;
        boolean addFlag = true;
        try {
            for (Object token : expression) {
                if (token instanceof Integer && addFlag) {
                    addFlag = false;
                    sum = Math.addExact(sum, (int) token);
                } else if (token instanceof Character && !addFlag && separators.contains((char) token)) {
                    addFlag = true;
                } else {
                    throw new Exception();
                }
            }
            if (addFlag) {
                throw new Exception();
            }
        } catch (Exception exception) {
            throw new IllegalArgumentException(Message.EXCEPTION_MESSAGE + "잘못된 수식");
        }

        return sum;
    }

    private String getSeparator(String sentence) {
        Matcher matcher = Pattern.compile("^//(.)\\\\n(.*)").matcher(sentence); // "//(separator)\n"...
        if (matcher.find()) {
            char separator = matcher.group(1).charAt(0);
            if (Character.isDigit(separator)) {
                throw new IllegalArgumentException(Message.EXCEPTION_MESSAGE + "숫자 형태의 구분자");
            }
            separators.add(separator);
            return matcher.group(2);
        }
        return sentence;
    }

    private void formulate(String sentence) {
        StringBuilder operand = new StringBuilder();

        for (char ch : sentence.toCharArray()) {
            if (Character.isDigit(ch)/* || ch == '-'*/) { // 일단 음수는 불가능
                operand.append(ch);
            } else {
                if (!operand.isEmpty()) {
                    expression.add(Integer.parseInt(operand.toString()));
                }
                operand.delete(0, operand.length());
                expression.add(ch);
            }
        }
        if (!operand.isEmpty()) {
            expression.add(Integer.parseInt(operand.toString()));
        }
    }
}
