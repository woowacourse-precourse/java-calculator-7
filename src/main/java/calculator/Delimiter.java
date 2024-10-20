package calculator;

import java.util.ArrayList;
import java.util.List;

public class Delimiter {
    private final List<String> delimiterList;

    public Delimiter() {
        this.delimiterList = new ArrayList<>();
        delimiterList.add(",");
        delimiterList.add(":");
    }

    public List<String> getDelimiters(String input) {
        String newDelimiter = checkCustomDelimiter(input);

        if(newDelimiter != null) {
            addDelimiter(newDelimiter);
        }

        return delimiterList;
    }

    private String checkCustomDelimiter(String input) {
        if(!input.startsWith("//")) {
            return null;
        }

        if(!input.contains("\n")) {
            throw new IllegalArgumentException(
                "커스텀 구분자 지정 양식이 잘못되었습니다. 구분자를 //(구분자)\\n 형태로 감싸야 합니다."
            );
        }

        int delimiterEndIndex = input.indexOf("\n");
        String customDelimiter = input.substring(2, delimiterEndIndex);

        if(customDelimiter.length() != 1) {
            throw new IllegalArgumentException(
                "커스텀 구분자가 존재하지 않거나 2자 이상입니다. 커스텀 구분자는 1자로 제한됩니다."
            );
        }

        return customDelimiter;
    }

    private void addDelimiter(String newDelimiter) {
        delimiterList.add(newDelimiter);
    }
}
