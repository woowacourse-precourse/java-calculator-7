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
            
            // 커스텀 구분자가 special token인 경우
            String customDelimiter = sentence.substring(startIdx + 2, endIdx);
            customDelimiter = customDelimiter.replace("\\", "\\\\");
            customDelimiter = customDelimiter.replace("|", "\\|");

            // 커스텀 구분자 목록 업데이트
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

        // 결과를 저장할 변수
        int sum = 0;
        
        // 구분자들을 기준으로 문자열을 분리하여 덧셈 계산
        String[] numbers = sentence.split(delimiters);
        for (String number : numbers) {
            try {
                // 문자형 숫자를 정수형으로 변환
                int parsedNumber = Integer.parseInt(number);

                // 입력은 양의 정수만 가능
                if (parsedNumber < 0)
                    throw new IllegalArgumentException("음수는 계산에 포함될 수 없습니다. 양수만 입력해주세요.");

                sum += parsedNumber;

            } catch (NumberFormatException nfe) {
                throw new IllegalArgumentException("잘못된 문자가 포함되어 있습니다: 구분자 또는 숫자를 확인해주세요.");
            }
        }

        return sum;
    }
}
