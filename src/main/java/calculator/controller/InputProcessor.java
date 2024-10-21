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
}
