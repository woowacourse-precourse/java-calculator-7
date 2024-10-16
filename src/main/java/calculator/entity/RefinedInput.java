package calculator.entity;

import java.util.Objects;

public class RefinedInput {

    private final StringBuilder value;

    public RefinedInput(String value) {
        this.value = new StringBuilder(value);
    }

    public RefinedInput() {
        this.value = new StringBuilder();
    }

    public void append(Input input, Index index) {
        String oneLetter = input.oneLetter(index);

        value.append(oneLetter);
    }


    public NumList toNumList(RegexStr regexStr) {
        String[] numStringArray = split(regexStr);

        NumList numList = new NumList();
        for (String numString : numStringArray) {
            System.out.println(numString);
            numList.addNum(new Num(numString));
        }

        return numList;
    }

    private String[] split(RegexStr regex) {
        String regexStr = regex.toString();
        String inputStr = value.toString();

        return inputStr.split(regexStr);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StringBuilder thatValue = ((RefinedInput) o).value;

        String originalValue = value.toString();
        String compareValue = thatValue.toString();

        return Objects.equals(originalValue, compareValue);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "RefinedInput{" +
            "value='" + value + '\'' +
            '}';
    }
}
