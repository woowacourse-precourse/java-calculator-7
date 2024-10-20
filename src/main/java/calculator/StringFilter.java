package calculator;

import java.util.Arrays;

public class StringFilter {

    private String str;

    public StringFilter(String str) {
        this.str = str;
    }

    public String[] getFilteredString() {
        //만약 공백입력시
        if(str==null || str.isEmpty())
            return new String[]{"0"};


        str = str.replaceAll(" ", "");
        String delimiter = "[,|:]";
        String numberPart;

        // 만약 커스텀 구분자가 존재한다면.
        if(str.startsWith("//")) {
            //구분자의 추출
            String customDelimiter = str.substring(2, str.indexOf("\\"));
            delimiter += "|" + customDelimiter;
            // //, \n, 구분자를 제외한 나머지 숫자들 추출
            numberPart = str.substring(str.indexOf("n") + 1);

            //빈 문자열 필터링 및 결과 반환
//            return numberPart.split(delimiter);
        } else {
            numberPart = str;
        }
//        return str.split(delimiter);
        return Arrays.stream(numberPart.split(delimiter))
                .filter(s -> !s.isEmpty()) // 빈 문자열 제거
                .toArray(String[]::new);
    }
}
