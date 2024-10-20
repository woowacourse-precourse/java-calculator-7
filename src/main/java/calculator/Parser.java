package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Parser {

    // 커스텀 구분자와 기본 구분자로 문자열 분리 기능
    public List<String> extractNumberList(String userInput) {
        //구분자 목록 선언
        String separators = ",|:";

        //userInput에 커스텀 구분자가 있다면 커스텀구분자를 추출하여 구분자 목록에 추가
        if (userInput.startsWith("//") && userInput.contains("\n")) {
            int endOfCustomSeparator = userInput.indexOf("\n");
            String customSeparator = userInput.substring(2, endOfCustomSeparator + 1);
            separators = separators + "|" + Pattern.quote(customSeparator);
        }

        //userInput을 구분자 목록으로 쪼갠 다음, 그 결과를 문자열 리스트로 만들어 반환
        List<String> numberList = List.of(userInput.split(separators));

        return numberList;
    }

    // 분리한 문자열 정수로 파싱 기능
    public List<Integer> parseNumberList(List<String> numberList) {

        List<Integer> parsedNumberList = new ArrayList<>();

        for (int i = 0; i < numberList.size(); i++) {
            Integer parsedNumber = Integer.parseInt(numberList.get(i));
            parsedNumberList.add(parsedNumber);
        }
        
        return parsedNumberList;
    }
}
