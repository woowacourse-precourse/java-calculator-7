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

    // 구분자 리스트 반환
    public List<String> getDelimiters(String input) {
        String newDelimiter = checkCustomDelimiter(input);

        if(newDelimiter != null) {
            addDelimiter(newDelimiter);
        }

        return delimiterList;
    }

    // 커스텀 구분자 존재 여부 확인
    private String checkCustomDelimiter(String input) {
        if(!input.startsWith("//")) {
            return null;
        }

        int delimiterEndIndex = input.indexOf("\\n");
        if (delimiterEndIndex == -1) {
            throw new IllegalArgumentException(
                "커스텀 구분자 지정 양식이 잘못되었습니다. 구분자를 //(구분자)\\n 형태로 감싸야 합니다."
            );
        }

        // 구분자를 추출 (// 이후부터 \n 이전까지)
        String customDelimiter = input.substring(2, delimiterEndIndex);

        // 구분자가 1자가 아닌 경우 예외 처리
        if (customDelimiter.length() != 1) {
            throw new IllegalArgumentException(
                "커스텀 구분자가 존재하지 않거나 2자 이상입니다. 커스텀 구분자는 1자로 제한됩니다."
            );
        }

        return customDelimiter;
    }

    // 커스텀 구분자를 구분자 리스트에 추가
    private void addDelimiter(String newDelimiter) {
        delimiterList.add(newDelimiter);
    }
}
