package calculator.domain;

import java.util.Arrays;

public class StringValue {
    private String originalValue;
    private String[] separatedValue;

    public StringValue(String stringValue){
        this.originalValue = stringValue;
    }

    public String getOriginalValue(){
        return this.originalValue;
    }

    public String[] getSeparatedValue(){
        return separatedValue;
    }

    public void saveSeparatedValue(String[] parts){
        this.separatedValue = Arrays.copyOf(parts, parts.length);
    }

    public void removeMarking(){
        String stringWithRemovedMarking = this.originalValue.substring(5);
        originalValue = stringWithRemovedMarking;
    }

}
