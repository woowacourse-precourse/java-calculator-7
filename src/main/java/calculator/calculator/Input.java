package calculator.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {
    private String inputString;
    private List<String> delimiters;

    public Input(String inputString) {
        this.inputString = inputString;
        this.delimiters = new ArrayList<>(Arrays.asList(",", ":")); // 수정 가능한 리스트로 초기화
    }

    public String getInputString() {
        return inputString;
    }

    public List<String> getDelimiters() {
        return delimiters;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public void setDelimiters(List<String> delimiters) {
        this.delimiters = delimiters;
    }
}
