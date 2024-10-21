package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application{
    public static void main(String[] args){
/*
        문자열 덧셈 계산기
        0. 문자열 입력은 readLine()을 활용한다.
        1. 문자열에서 구분자로 분리된 숫자를 추출하여 더하는 계산기를 구현하자.
        2. 기본 구분자는 쉼표(,) or 콜론(:)이다.
        3. 커스텀 구분자는 //와 \n 사이에 작성되어 있다.
        4. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 종료된다.
*/
        try {
            System.out.println("덧셈할 문자열을 입력해주세요.\n");

            // 문자열 입력받기
            String input = Console.readLine();

            // 문자열을 계산하기 위한 클래스
            StringCalculator stringCalculator = new StringCalculator();

            // 입력 받은 값이 없다면 오류 발생시키기
            if(input == null) {
                throw new IllegalArgumentException();
            }

            Long output = 0L;
            // 입력 받은 값이 숫자로 시작되면 : 또는 ,로 구분되어 있는 경우이다.
            if (!input.startsWith("//")) {
                output = stringCalculator.Calculator(input);
            } else if(input.charAt(0) == '/'){
                String separator = input.split("\\\\n")[0].replaceAll("/", "").strip();
                String str = input.split("\\\\n")[1];
                output = stringCalculator.Calculator(str, separator);
            }else{
                // 입력 받은 값이 :과 ,로 구분되어 있지도 않고, //로 시작된 값이 아닌 경우
                throw new IllegalArgumentException();
            }

            // 결과 출력하기
            System.out.println("결과 : " + output);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

    }

}
class StringCalculator {

    public Long Calculator(String str, String separator) {
        Long sum = 0L;
        Long number;
        for(String num : str.split(separator)) {
            number = Long.parseLong(num.strip());
            if(number < 0){
                throw new IllegalArgumentException();
            }else {
                sum += number;
            }
        }

        return sum;
    }

    public Long Calculator(String str) {
        Long sum = 0L;
        Long number;
        for(String num : str.split(",|:")){
            number = Long.parseLong(num.strip());
            if(number < 0){
                throw new IllegalArgumentException();
            }else {
                sum += number;
            }
        }

        return sum;
    }
}
