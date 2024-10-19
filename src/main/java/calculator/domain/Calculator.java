package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    String rawValue;
    List<Integer> processedValue;
    int sumValue;
    List<String> separators;

    public List<String> getSeparators() {
        return separators;
    }

    public void setSeparators(List<String> separators) {
        this.separators = separators;
    }

    public Calculator() {
        this.separators = new ArrayList<>(Arrays.asList(":", ","));
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
