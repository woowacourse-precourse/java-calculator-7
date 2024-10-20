package calculator;

import java.util.HashSet;
import java.util.Set;

/**
 * 문자열 덧셈 클래스입니다.
 */
public class Calculator {
    /**
     * 문자열에서 숫자를 추출하여 더하여 반환합니다.
     * 문자열에서 구분자를 기준으로 숫자를 추출하여 더합니다.
     * 기본 구문자로는 ',', ':'가 있니다.
     * 문자열 맨 앞에 //와 \n 사이에 문자를 위치시켜 커스텀 구분자를 지정할 수 있습니다.
     * @param str
     * @return 숫자의 합
     */
    public static int calculate(String str){
        // 구분자 집합 생성 및 기본 구분자 추가
        Set<Character> delimiters = new HashSet<>();
        delimiters.add(',');
        delimiters.add(':');

        // 문자열이 비어있는 경우 0 반환
        if (str.isEmpty()) {
            return 0;
        }

        if(str.length() < 5 && !Character.isDigit(str.charAt(0)) && !delimiters.contains(str.charAt(0))) {
            throw new IllegalArgumentException("구분자나 양수로 시작하지않는 문자열이 커스텀 구분자 지정 구문보다 짧습니다.");
        }

        int i = 0;

        // 커스텀 구분자를 추출하고 커스텀 구분자 지정 구문이 잘못됐다면 오류를 발생시킵니다.
        if(str.startsWith("//")) {
            String custom = str.substring(0,5);
            if(custom.endsWith("\\n")) {
                char customDelimiter = str.charAt(2);
                if(Character.isDigit(customDelimiter)){
                    throw new IllegalArgumentException("양수는 구분자로 사용할 수 없습니다.");
                }
                delimiters.add(customDelimiter);
                i = 5;
            } else {
                throw new IllegalArgumentException("커스텀 구분자는 //과 \\n 사이에 위치한 문자여야 합니다.");
            }
        }

        int answer = 0;

        // 구분자를 기준으로 숫자를 추출하여 더하고, 구분자와 양수 이외의 문자가 있다면 오류를 반환합니다.
        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if(Character.isDigit(c)) {
                int startIdx = i;
                while(i + 1 < str.length() && Character.isDigit(str.charAt(i + 1))){
                    i++;
                }
                int endIdx = i + 1;
                String numString = str.substring(startIdx, endIdx);
                int num = Integer.parseInt(numString);
                answer += num;
            } else if (!delimiters.contains(c)){
                throw new IllegalArgumentException("구분자 양수 이외의 문자는 입력할 수 없습니다.");
            }
        }

        return answer;
    }

}
