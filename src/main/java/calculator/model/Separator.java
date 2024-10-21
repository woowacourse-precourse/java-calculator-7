package calculator.model;

import calculator.util.ErrorCode;

import java.util.ArrayList;
import java.util.List;

public class Separator {
    private final String regex;
    private final List<Character> chars = new ArrayList<>(List.of('.', ','));
    public Separator() {
        this.regex = buildRegex();
    }
    public Separator(char customChar) {
        validate(customChar);
        chars.add(customChar);
        this.regex = buildRegex();
    }

    private void validate(char ch){
        if (Character.isDigit(ch)) {
            throw new IllegalArgumentException(ErrorCode.SEPARATOR_ERROR.getMessage());
        }
    }
    private String buildRegex() {
        final String regex;
        StringBuilder tmpRegex = new StringBuilder("[");
        for (Character ch : chars) {
            tmpRegex.append(ch);

            if (ch == '\\') {
                tmpRegex.append(ch);
            }
        }
        tmpRegex.append("]");

        return tmpRegex.toString();
    }

    public List<Number> separate(String str){
        List<Number> ret = new ArrayList<>();
        String[] splitStr = str.split(regex);

        for(String strNumber: splitStr){
            Number number = new Number(strNumber);
            ret.add(number);
        }

        return ret;
    }
}
