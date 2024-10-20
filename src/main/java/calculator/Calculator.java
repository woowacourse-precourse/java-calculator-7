package calculator;

import java.util.HashSet;
import java.util.Set;

public class Calculator {

    public static int calculate(String str){
        Set<Character> delimiters = new HashSet<>();
        delimiters.add(',');
        delimiters.add(':');

        int answer = 0;
        int i = 0;
        if(str.startsWith("//")){
            String custom = str.substring(0,5);
            if(custom.endsWith("\\n")) {
                delimiters.add(str.charAt(2));
                i = 5;
            } else {
                throw new IllegalArgumentException("커스텀 구분자는 //과 \\n 사이에 위치해야합니다.");
            }
        }

        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if(Character.isDigit(c)) {
                int startIdx = i;
                while(i < str.length() && Character.isDigit(str.charAt(i))){
                    i++;
                }
                int endIdx = i;
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
