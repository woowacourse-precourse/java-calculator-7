package calculator.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputStringSeparator {
    private String inputString;
    private String finalSeparator;
    private String customSeparator = "";
    private String[] inputNumberString;
    private ArrayList<Integer> inputNUmberInt = new ArrayList<>();
    private int startIndex;
    private int lastIndex;
    private boolean isCustomSeparatorContained = false;

    public InputStringSeparator(String inputString) {
        validateInputString(inputString);
        setInputString(inputString);
        setCustomSeparator();
        setFinalSeparator();
        setInputNumber();
    }

    private void validateInputString(String inputString) {
        boolean isFirstCustomSeparator = inputString.contains("//");
        boolean isLastCustomSeparator = inputString.contains("\\n");
        if (isFirstCustomSeparator != isLastCustomSeparator) {
            throw new IllegalArgumentException("형식을 지켜 커스텀 구분자를 지정해야 합니다.");
        }
        if (isFirstCustomSeparator) {
            if (inputString.indexOf("//") != 0) {
                throw new IllegalArgumentException("커스텀 구분자를 먼저 지정한 후 숫자를 입력하세요.");
            }
        }
        if (isFirstCustomSeparator && isLastCustomSeparator) {
            this.isCustomSeparatorContained = true;
        }
    }

    private void setInputString(String inputString) {
        this.inputString = inputString.replaceAll("\n", "\\n");
    }

    private void setCustomSeparator() {
        if (isCustomSeparatorContained) {
            startIndex = inputString.indexOf("//") + 2;
            lastIndex = inputString.indexOf("\\n");
            this.customSeparator = inputString.substring(startIndex, lastIndex);
        }
    }

    private void setFinalSeparator() {
        if (this.customSeparator.isEmpty()) {
            this.finalSeparator = ",|:";
            return;
        }
        this.finalSeparator = ",|:|" + this.customSeparator;
    }

    private void setInputNumber() {
        extractInputNumber();
        separateInputNumber();
        changeToInt();
    }

    private void extractInputNumber() {
        if (isCustomSeparatorContained) {
            this.inputString = inputString.substring(lastIndex + 2);
        }
    }

    private void separateInputNumber() {
        if (inputString.length() > 0) {
            this.inputNumberString = inputString.split(finalSeparator);
        }
    }

    private void changeToInt() {
        for (String num : inputNumberString) {
            int parseInt = Integer.parseInt(num);
            if (parseInt < 0) {
                throw new IllegalArgumentException("숫자는 양수를 입력해야 합니다.");
            }
            this.inputNUmberInt.add(parseInt);
        }
    }

    public List<Integer> getInputNumber() {
        return Collections.unmodifiableList(inputNUmberInt);
    }

}
