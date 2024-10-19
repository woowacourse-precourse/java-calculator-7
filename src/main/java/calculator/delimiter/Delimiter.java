package calculator.delimiter;

import calculator.exception.CalculatorException;

import java.util.*;

public abstract class Delimiter {

    private static Delimiter instance;

    protected Set<String> delimiters;

    public Delimiter() {
        delimiters = new HashSet<>();
        delimiters.add(":");
        delimiters.add(",");
    }

    public static Delimiter getInstance() {
        instance = new CustomDelimiter();
        return instance;
    }

    public static void setInstance(Delimiter delimiter) {
        instance = delimiter;
    }

    public List<String> divideCharacter(String s) {
        List<String> result = new ArrayList<>();

        if (!hasCustomDelimiter(s)) {
            if (hasDelimiter(s)) {
                result = Arrays.stream(s.split("[:,]"))
                        .map(str -> str.isEmpty() ? "0" : str)
                        .toList();

                if (!areDigits(result)) {
                    CalculatorException.causeException("잘못된 문자가 들어있습니다.");
                }
            } else {
                CalculatorException.causeException("잘못된 문자가 들어있습니다.");
            }
        }

        return result;
    }

    public boolean containsDelimiter(String s) {
        return delimiters.stream().anyMatch(s::contains);
    }

    public boolean hasDelimiter(String s) {
        return s.contains(":") || s.contains(",");
    }

    public boolean areDigits(List<String> s) {
        return s.stream().allMatch(this::isDigit);
    }

    public boolean isDigit(String s) {
        return s.matches("\\d+"); //부호 포함x
    }

    public abstract boolean hasCustomDelimiter(String s);

    protected abstract void addDelimiter(String delimiter);

}
