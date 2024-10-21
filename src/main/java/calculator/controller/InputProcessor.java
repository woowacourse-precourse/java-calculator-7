package calculator.controller;

import java.util.ArrayList;
import java.util.List;

public class InputProcessor {
    private static final String DEFAULT_SEPARATORS = ",;";
    private String input;
    private String separatorPart = "";
    private String numberPart = "";
    private String separators = DEFAULT_SEPARATORS;
    private List<Integer> numbers = new ArrayList<>();
    
    public InputProcessor(String input) {   
        this.input = input;
    }
    
    public void processInput() {
        if (input.startsWith("//")) {
            int separatorEndIdx = input.indexOf("\\n");
            
            if (separatorEndIdx == -1) {
                throw new IllegalArgumentException("커스텀 구분자는 //와 \\n 사이에 존재해야 합니다.");
            } else {
                separators = "";
            }
            
            separatorPart = input.substring(2, separatorEndIdx);
            numberPart = input.substring(separatorEndIdx + 2);
        } else {
            numberPart = input;
        }
        
        try {
            setSeparator();
            setNumbers();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 정수입니다.");
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    
    private void setSeparator() {
        if (separatorPart.isEmpty()) {
            return;
        }

        char ch = separatorPart.charAt(0);

        if (separatorPart.length() != 1 || Character.isDigit(ch) || ch == '+') {
            throw new IllegalArgumentException("유효하지 않은 구분자입니다.");
        }
        separators = String.valueOf(ch);
    }

    private void setNumbers() throws NumberFormatException {
        if (numberPart.isEmpty()) {
            numbers.add(0);
            return;
        }

        String[] tokens = numberPart.split(separators);

        for (String token : tokens) {
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
            }
            numbers.add(number);
        }
    }

}
