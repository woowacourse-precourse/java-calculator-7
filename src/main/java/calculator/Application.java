package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Console.close;


public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String inputString = readLine();

        // TODO:  기본 구분자로 분리, 덧셈
        String[] separatedInput = inputString.split(",|:");
        int sumValue = 0;
        for(int i=0; i<separatedInput.length;i++){
            sumValue += Integer.parseInt(separatedInput[i]);
        }
        System.out.println(String.format("결과 : %d", sumValue));

        // TODO:  커스텀 구분자
        // TODO:  예외처리
    }
}