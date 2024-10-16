package calculator.entity;

import java.util.Objects;

public class RefinedInput {

    private final String input;

    public RefinedInput(String input) {
        this.input = input;
    }

    public NumList toNumList(RegexStr regexStr) {
        String[] numStringArray = split(regexStr);

        NumList numList = new NumList();
        for (String numString : numStringArray) {
            numList.addNum(new Num(numString));
        }

        return numList;
    }

    private String[] split(RegexStr regex) {
        String regexStr = regex.toString();

        return input.split(regexStr);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RefinedInput that = (RefinedInput) o;
        return Objects.equals(input, that.input);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(input);
    }

    @Override
    public String toString() {
        return "RefinedInput{" +
            "input='" + input + '\'' +
            '}';
    }
}
