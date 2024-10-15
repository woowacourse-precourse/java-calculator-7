package calculator.feature;

import java.util.regex.Pattern;

public class SplitNumber {

    Character[] delimiters;
    String str;

    public SplitNumber(Character[] delimiters, String str) {
        this.delimiters = delimiters;
        this.str = str;
    }

    public int[] getNumber(){
        StringBuilder sb = new StringBuilder(); // 정규표현식 만들기
        sb.append(",|:"); // 정규표현식에 ,: 추가
        for (Character delimiter : delimiters) {
            sb.append("|").append(Pattern.quote(String.valueOf(delimiter))); // 입력받은 구분자들 추가
        }

        String[] split = str.split(String.valueOf(sb)); // 문자열 분리

        int[] result = new int[split.length];

        try {
            for (int i = 0; i < split.length; i++) {
                result[i] = Integer.parseInt(split[i]); // 분리한 문자열을 정수 배열에 추가
            }
        } catch (NumberFormatException e) { // 숫자와 구분자 외에 다른 문자를 입력했을 경우 예외 발생
            throw new IllegalStateException(e);
        }

        return result;
    }

}
