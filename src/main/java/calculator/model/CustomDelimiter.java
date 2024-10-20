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

    public void register(String inputValue) {
        if (startsWithSignal(inputValue)) {
            registerValueAndValueEndIdx(inputValue);
        }
    }

    private boolean startsWithSignal(String inputValue) {
        return inputValue.startsWith(CUSTOM_DELI_START_SIGNAL);
    }

    private void registerValueAndValueEndIdx(String inputValue) {
        int valueLength = inputValue.length();
        String customDeli = "";
        int customDeliEndIdx = DEFAULT_CUSTOM_DELI_END_IDX;

        for (int i=CUSTOM_DELI_START_SIGNAL.length(); i<valueLength; i++) {
            if (endsWithSignal(i, inputValue, valueLength)) {
                customDeliEndIdx = i + 1;
                break;
            }
            customDeli += inputValue.substring(i, i+1);
        }
        validateCustomDeliEnds(customDeliEndIdx);
        validateCorrectCustomDelimiter(customDeli);

        this.value = customDeli;
        this.valueEndIdx = customDeliEndIdx;
    }

    private boolean endsWithSignal(int idx, String inputValue, int valueLength) {
        if (idx <= CUSTOM_DELI_START_SIGNAL.length() || idx >= valueLength - 1) {
            return false;
        }
        for (int d=0; d<CUSTOM_DELI_END_SIGNAL.length(); d++) {
            if (inputValue.charAt(idx+d) != CUSTOM_DELI_END_SIGNAL.charAt(d)) {
                return false;
            }
        }
        return true;
    }

    public boolean exists() {
        return value != "";
    }

    public String getValue() {
        return value;
    }

    public int getValueEndIdx() {
        return valueEndIdx;
    }
}
