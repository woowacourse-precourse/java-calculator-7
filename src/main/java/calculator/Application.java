package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        // 결과값 변수 생성
        long answer = 0L;

        // camp.nextstep.edu.missionutils.Console의 readLine()을 사용해 문자열을 String으로 저장
        String input = readLine();

        //쉼표(,)와 콜론(:)을 구분자로 하여 각 숫자로 분리한다.
        String[] strArr = input.split("[,:]");

        // strArr의 숫자들을 더한 결과를 answer에 할당
        for (String str : strArr) {
            answer += Long.parseLong(str);
        }

        // 테스트 결과 출력
        System.out.println("결과 : " + answer);
    }
}
