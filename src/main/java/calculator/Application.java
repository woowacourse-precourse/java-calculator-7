package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Float.sum;

public class Application {
    // TODO: 입력한 문자열에서 숫자를 추출하여 더하는 계산기

    // 1. 커스텀구분자 알아내기
    // 2. 커스텀구분자, 콜론, 쉼표로 구분하여 숫자 알아내고 배열에 저장
    // 3. 메인함수에서 2번 함수의 배열 호출하여 sum하고 출력
    
    public static void main(String[] args) {
        float result=0;
        float[] numbers=null;
        //문자열입력
        String enter = readLine();

        //커스텀구분자 추출하는 클래스 호출
        DelimiterExtractor delimiterExtractor=new DelimiterExtractor(enter);
        String customDelimiter = delimiterExtractor.getCustomDelimiter();

        //구분자를 기준으로 추출한 숫자를 실수 배열에 담는 클래스 호출
        NumberExtractor numberExtractor = new NumberExtractor(enter, customDelimiter);
        numbers=numberExtractor.getNumbers();

        //출력
        //배열에 담긴 숫자를 모두 합산
        for (float number : numbers) {
            result += number;
        }

        System.out.println("결과 : "+result);

    }
}
