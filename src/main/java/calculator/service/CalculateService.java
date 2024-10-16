package calculator.service;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class CalculateService {

    /***
     * 사용자의 문자열을 기반으로 덧셈을 수행하는 서비스 메서드
     * @param inputString : 사용자가 입력한 문자열
     * @return : 계산 결과를 리턴해줌
     */
    public long calculate(String inputString) {
        long sum = 0;

        if(inputString.startsWith("//") && inputString.contains("\\n")) {
            // 커스텀 구분자를 사용하는 경우

            int firstIdx = inputString.indexOf("//") + 2;
            int secondIdx = inputString.indexOf("\\n");
            String delim = inputString.substring(firstIdx, secondIdx);

            String regex = Pattern.quote(delim) + "|,|:";
            String[] split = inputString.substring(secondIdx + 2, inputString.length()).split(regex);

            try {
                for (String s : split) {
                    System.out.println("s = " + s);
                    long intValue = Long.parseLong(s);
                    if (intValue < 0) {
                        throw new IllegalArgumentException("양수만 입력해주세요.");
                    }
                    sum += intValue;
                }
            } catch (NumberFormatException | PatternSyntaxException e) {
                throw new IllegalArgumentException("구분자(, 또는 :)와 숫자로만 입력해주세요.");
            }

        } else if (inputString.contains(",") || inputString.contains(":")){
            String[] split = inputString.split("[,:]");

            try {
                for (String s : split) {
                    System.out.println("s = " + s);
                    long intValue = Long.parseLong(s);
                    if (intValue < 0) {
                        throw new IllegalArgumentException("양수만 입력해주세요.");
                    }
                    sum += intValue;
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("구분자(, 또는 :)와 숫자로만 입력해주세요.");
            }
        } else {
            throw new IllegalArgumentException("올바른 문자열을 입력해주세요.");
        }
        return sum;
    }
}
