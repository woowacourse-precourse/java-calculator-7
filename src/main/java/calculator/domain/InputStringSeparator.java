package calculator.domain;

public class InputStringSeparator {
    private String inputString;
    private String finalSeparator;
    private String customSeparator = "";
    private String[] inputNumber; // int vs integear ??
    private int startIndex;
    private int lastIndex;

    public InputStringSeparator(String inputString) {
        setInputString(inputString);
        setCustomSeparator();
        setFinalSeparator();
        setInputNumber();
    }

    private void validateInputString(String inputString) {

    }

    private void setInputString(String inputString) {
        this.inputString = inputString.replaceAll("\n", "\\n");
    }

    private void setCustomSeparator() {
        if (isCustomSeparatorContained()) {
            startIndex = inputString.indexOf("//") + 2;
            lastIndex = inputString.indexOf("\\n");
            this.customSeparator = inputString.substring(startIndex, lastIndex); //커스텀 구분자는 그럼 한 개만인가?
        }
    }

    private boolean isCustomSeparatorContained() {
        return inputString.contains("//") && inputString.contains("\\n");
    }

    private void setFinalSeparator() {
        if (this.customSeparator.isEmpty()) {
            this.finalSeparator = ",|:";
            return;
        }
        this.finalSeparator = ",|:|" + this.customSeparator;
    }

    private void setInputNumber() {
        if (isCustomSeparatorContained()) {
            this.inputString = inputString.substring(lastIndex + 2);
        }
        if (inputString.length() > 0) {
            this.inputNumber = inputString.split(finalSeparator);
        }
    }

    public String[] getInputNumber() {
        return this.inputNumber;
    }
}
