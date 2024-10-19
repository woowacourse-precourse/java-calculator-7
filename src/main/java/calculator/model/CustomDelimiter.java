package calculator.model;

import static calculator.util.Constants.*;
import static calculator.util.Validations.*;

public class CustomDelimiter {
    private String value;
    private int valueEndIdx;

    public CustomDelimiter() {
        this.value = "";
        this.valueEndIdx = DEFAULT_CUSTOM_DELI_END_IDX;
    }

    public void findCustomDelimiter(String inputValue) {
        if (includesCustomDelimiter(inputValue)) {
            setValueAndValueEndIdx(inputValue);
        }
    }

    private boolean includesCustomDelimiter(String inputValue) {
        boolean includes = true;
        if (inputValue.length() < CUSTOM_DELI_START_SIGNAL.length()) {
            return false;
        }
        for (int i=0; i<CUSTOM_DELI_START_SIGNAL.length(); i++) {
            if (inputValue.charAt(i) != CUSTOM_DELI_START_SIGNAL.charAt(i)) {
                includes = false;
                break;
            }
        }
        return includes;
    }

    private void setValueAndValueEndIdx(String inputValue) {
        int valueLength = inputValue.length();
        String customDeli = "";
        int customDeliEndIdx = DEFAULT_CUSTOM_DELI_END_IDX;

        for (int i=2; i<valueLength; i++) {
            if (checkCustomDelimiterEnd(i, inputValue, valueLength)) {
                customDeliEndIdx = i + 1;
                break;
            }
            customDeli += inputValue.substring(i, i+1);
        }
        validateIfCustomDeliEnds(customDeliEndIdx);
        validateCustomDelimiter(customDeli);

        this.value = customDeli;
        this.valueEndIdx = customDeliEndIdx;
    }

    private boolean checkCustomDelimiterEnd(int idx, String inputValue, int valueLength) {
        boolean ends = true;
        if (idx <= 2 || idx >= valueLength - 1) {
            return false;
        }
        for (int d=0; d<CUSTOM_DELI_END_SIGNAL.length(); d++) {
            if (inputValue.charAt(idx+d) != CUSTOM_DELI_END_SIGNAL.charAt(d)) {
                ends = false;
                break;
            }
        }
        return ends;
    }

    public boolean exists() { return value != ""; }

    public String getValue() { return value; }

    public int getValueEndIdx() { return valueEndIdx; }
}
