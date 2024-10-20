package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static String delimiters = ",|:";

    public static void main(String[] args) {
        // 문자열 입력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String sentence = Console.readLine();
        System.out.println("결과 : " + calculator(sentence));
    }
    
    // 주어진 문자열에서 커스텀 구분자를 추출
    public static String parseDelimiter(String sentence) {

        // 커스텀 구분자 업데이트를 위한 StringBuilder
        StringBuilder stringBuilder = new StringBuilder(delimiters);
        
        // 커스텀 구분자가 계속 존재한다면 탐색
        while (sentence.contains("//") && sentence.contains("\\n")) {
            // 커스텀 구분자의 위치 탐색
            int startIdx = sentence.indexOf("//");
            int endIdx = sentence.indexOf("\\n");
            
            // 커스텀 구분자 목록 업데이트
            String customDelimiter = sentence.substring(startIdx + 2, endIdx);
            stringBuilder.append("|").append(customDelimiter);
            
            // 커스텀 구분자를 제외한 나머지 문자열
            sentence = sentence.substring(0, startIdx) + sentence.substring(endIdx + 2);
        }

        // stringBuilder를 사용해 최종 업데이트 된 구분자 반영
        delimiters = stringBuilder.toString();
        
        return sentence;
    }

    public static int calculator(String sentence) {
        // 주어진 문자열에서 커스텀 구분자 추가하고 제외
        sentence = parseDelimiter(sentence);

        return 0;
    }
}
