package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    /**
     * 구분자 기준으로 문자열 분리
     * 문자열 배열 생성
     * @param separator 구분자
     * @param str 입력받은 문자열
     */
    public String[] separate(String separator, String str){
        return str.split(separator);
    }

    // 시작 함수
    public void start(){
        // 문자열 입력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();

    }
}
