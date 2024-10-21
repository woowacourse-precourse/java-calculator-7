package calculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {
    public List<Integer> extractNumbers(String str) {
        Validation inputValidation = new Validation();
        List<String> stringList;
        String delimiter = findDelimiter(str);

        str = trimInputString(str);

        stringList = Arrays.stream(str.split(delimiter)).map(s -> s.isEmpty() ? "0" : s).collect(Collectors.toList());

        if (!inputValidation.isValidInput(stringList)) {
            throw new IllegalArgumentException("입력된 문자열에 유효하지 않은 값이 포함되어 있습니다.");
        }

        List<Integer> numbers = stringList.stream().map(Integer::parseInt).collect(Collectors.toList());

        return numbers;
    }

    //커스텀 구분자 찾기
    private String findDelimiter(String str) {
        if (str.startsWith("//") && str.contains("\\n")) {
            String delimiter = str.substring(2, str.indexOf("\\n"));
            return escapeSpecialCharacters(delimiter);
        }
        return ",|:";
    }

    //커스텀 구분자 이후 문자열 반환
    private String trimInputString(String str) {
        if (str.startsWith("//") && str.contains("\\n")) {
            return str.substring(str.indexOf("\\n") + 2);
        }
        return str;
    }

    //특수문자 예외처리
    private String escapeSpecialCharacters(String delimiter) {
        return delimiter.replaceAll("([\\[\\](){}.*+?^$|\\\\])", "\\\\$1");
    }

}
