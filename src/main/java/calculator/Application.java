package calculator;

import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;


public class Application {
    
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        
        try {
            int result = sumNumbersInString(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 주어진 문자열에서 숫자를 추출하여 합산하는 메서드.
     * 기본 구분자는 쉼표(,)와 콜론(:)이며, 커스텀 구분자를 사용할 수 있다.
     * 음수는 허용하지 않으며, 음수가 포함된 경우 IllegalArgumentException이 발생한다.
     *
     * @param input 문자열 입력
     * @return 숫자의 합
     */
    public static int sumNumbersInString(String input) {
        if (input.isEmpty()) {
            return 0;  // 빈 문자열은 0 반환
        }

        String delimiter = ",|:";  // 기본 구분자 (쉼표와 콜론)

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("잘못된 입력 형식: ");
            }
            // 커스텀 구분자 추출 (//와 \n 사이의 문자)
            String customDelimiter = input.substring(2, delimiterEndIndex);
            delimiter += "|" + Pattern.quote(customDelimiter);  // 기본 구분자에 커스텀 구분자를 추가
            input = input.substring(delimiterEndIndex + 2);  // 구분자 이후의 숫자 부분만 추출 바로 다음 숫자 하나 
        }

        // 구분자를 기준으로 문자열을 분리하여 숫자 추출
        String[] tokens = input.split(delimiter);
        List<Integer> negativeNumbers = new ArrayList<>();
        int totalSum = 0;

        // 각 분리된 토큰(숫자)을 처리
        for (String token : tokens) {
            if (!token.isEmpty()) {  // 빈 값 무시
                int number = Integer.parseInt(token);  // 문자열을 정수로 변환
                
                if (number < 0) {
                    // 음수는 예외 목록에 추가
                    negativeNumbers.add(number);
                    if (!negativeNumbers.isEmpty()) {
                        throw new IllegalArgumentException("음수는 허용되지 않습니다: " + negativeNumbers.toString().replaceAll("[\\[\\]]", ""));
                    }
            
                }
                
                totalSum += number;
            }
        }
        

        // 음수가 하나라도 포함된 경우 예외 발생

        return totalSum;  // 총합 반환
    }




}
