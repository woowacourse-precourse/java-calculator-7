package calculator.DTO;

import java.util.List;

public class StringCalculatorDTO {
    final String input;
    List<String> detachedInput;

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
}
