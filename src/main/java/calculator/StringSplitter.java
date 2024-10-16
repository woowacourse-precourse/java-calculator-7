package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringSplitter {
    public List<String> split(String str) {
        // 구분자를 담는 리스트 생성
        List<String> delimiterList = new ArrayList<>();
        delimiterList.add(",");
        delimiterList.add(":");

        // 커스텀 구분자 유무 확인 후, 리스트에 추가
        if (str.startsWith("//") && str.contains("\n")) {
            if (str.indexOf("\n") - 2 > 0) {
                String[] customDelimiters = getCustomDelimiter(str);
                delimiterList.addAll(Arrays.asList(customDelimiters));
            }
            str = str.substring(str.indexOf("\n") + 1);
        }

        // 분리한 문자열을 담을 리스트 생성
        List<String> splitStringList = new ArrayList<>();
        splitStringList.add(str);

        // 각 구분자로 문자열 분리
        for (String delimiter : delimiterList) {
            splitStringList = splitByDelimiter(splitStringList, delimiter);
        }

        return splitStringList;
    }

    private List<String> splitByDelimiter(List<String> stringList, String delimiter) {
        List<String> splitStringList = new ArrayList<>();

        for (String str : stringList) {
            if (str.contains(delimiter)) {
                String[] splitStringArr = str.split(delimiter);
                splitStringList.addAll(Arrays.asList(splitStringArr));
            } else {
                splitStringList.add(str);
            }
        }

        return splitStringList;
    }
    
    private String[] getCustomDelimiter(String str) {
        return str.substring(2, str.indexOf("\n")).split("");
    }
}
