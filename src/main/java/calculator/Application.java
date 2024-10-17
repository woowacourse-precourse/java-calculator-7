package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        
        // 입력된 문자열을 처리하고 결과를 출력
        int result = processInput(input);
        System.out.println("결과 : " + result);
    }
    
    // 입력 문자열을 처리하는 함수
    private static int processInput(String input) {
        // 입력 문자열의 길이가 0일 경우 0 반환
        if (input.length() == 0) {
            return 0;
        }
        
        // 이후 로직 추가 예정
        return 0; // 기본 반환값
    }
}
