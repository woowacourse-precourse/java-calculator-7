package calculator.DTO;

import java.util.List;

public class StringCalculatorDTO {
    String input;
    List<String> detachedInput;
    int sum = 0;

    public StringCalculatorDTO(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public List<String> getDetachedInput() {
        return detachedInput;
    }

    public void setDetachedInput(List<String> detachedInput) {
        this.detachedInput = detachedInput;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
