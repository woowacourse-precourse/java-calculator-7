package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    String rawValue;
    List<Double> processedValue;
    Double sumValue;
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

    public List<Double> getProcessedValue() {
        return processedValue;
    }

    public void setProcessedValue(List<Double> processedValue) {
        this.processedValue = processedValue;
    }

    public Double getSumValue() {
        return sumValue;
    }

    public void setSumValue(Double sumValue) {
        this.sumValue = sumValue;
    }
}
