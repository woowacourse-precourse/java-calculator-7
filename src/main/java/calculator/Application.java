package calculator;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner testInput = new Scanner(System.in); // Scanner 기능 추가

        System.out.println("덧셈할 문자열을 입력해 주세요."); // 질문 출력
        String source = testInput.nextLine(); // 콘솔 입력란 추가 및입력

        int calculator = 0; // 문자열 인덱스별 구분하여 계산할 식 정의
        char customChar; // 커스텀 문자 정의

        if (source.startsWith("//")) {
            if (source.indexOf("\\n") == 3) {                   // 줄바꿈 인식고려 \\n으로 입력
                customChar = source.charAt(2);                  // "//" 와 "\n" 사이에 있는 값 커스텀문자로 입력
                for (int i = 5; i < source.length(); i++) {     // 이후 숫자 커스텀 문자로 구분하여 덧셈
                    char eachIndex = source.charAt(i);          // 문자별 인덱스값 추출
                    if (Character.isDigit(eachIndex)) {         // 숫자인지 판별 및 정수값으로 변환 후 덧셈
                        calculator += Character.getNumericValue(eachIndex);
                    } else if (eachIndex == customChar) {       // 커스텀문자 확인 되면 넘어감
                        continue;
                    } else {
                        System.out.println("IllegalArgumentException");
                        return;                                 // 올바르지 않은 입력시 출력
                    }
                }
            }
            else{
                System.out.println("IllegalArgumentException");
                return;                                         // 올바르지 않은 입력시 출력
            }
        }
        else {
            for (int i = 0; i < source.length(); i++) {
                char eachIndex = source.charAt(i);

                if (Character.isDigit(eachIndex)) {
                    calculator += Character.getNumericValue(eachIndex);
                } else if (eachIndex == ',' || eachIndex == ':') {
                    continue;
                } else {
                    System.out.println("IllegalArgumentException");
                    return;
                }
            }
        }
        System.out.println("결과 : " + calculator);

    }
}
