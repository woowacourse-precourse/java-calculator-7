package calculator.domain;

import java.util.List;

public class Calculator {

    String rawValue;
    List<Integer> processedValue;
    int sumValue;

    public Calculator() {
    }

    public String getRawValue() {
        return rawValue;
    }

    public void setRawValue(String rawValue) {
        this.rawValue = rawValue;
    }

    public List<Integer> getProcessedValue() {
        return processedValue;
    }

    public void setProcessedValue(List<Integer> processedValue) {
        this.processedValue = processedValue;
    }

    public int getSumValue() {
        return sumValue;
    }

    public void setSumValue(int sumValue) {
        this.sumValue = sumValue;
    }
}
