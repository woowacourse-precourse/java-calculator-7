package calculator;
import java.util.ArrayList;
import java.util.Scanner;

// 프로그램을 실행하는 메인 메서드
public class Application {
    public static void main(String[] args) {
        // 게임의 사용자 생성
        User user = new User();
        user.Useroutput();
    }
}

class User {
    public static String s;
    public static final String final_sum = "결과: ";

    User() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            s = sc.nextLine();
            Calculator cal = new Calculator(s);  // 계산기 객체 생성
        } finally {
            sc.close();  // Scanner 자원 닫기
        }
    }

    void Useroutput() {
        System.out.println(final_sum + Calculator.answer);
    }
}

// 계산기
class Calculator {
    protected final String Trim1 = ",";  // 기본 구분자
    protected final String Trim2 = ":";  // 기본 구분자
    protected String Trim3 = "";  // 사용자 정의 구분자
    ArrayList<Integer> list = new ArrayList<>();  // 숫자 리스트
    static int answer = 0;  // 계산 결과

    // 초기화
    Calculator(String s) {
        s = extraSplitCheck(s);  // 구분자 확인
        Parse(s);  // 문자열을 구분자로 나누기
        sumNumber(list);  // 숫자 합산
    }

    // 주어진 문자열을 구분자로 나누는 메서드
    void Parse(String s) {
        // 기본 구분자를 결합한다.
        String delimiter = Trim1 + "|" + Trim2;
        if (!Trim3.isEmpty()) {
            delimiter += "|" + Trim3;  // 사용자 정의 구분자 추가
        }

        // 문자열을 구분자로 나눈다.
        String[] tokens = s.split(delimiter);

        // 숫자 리스트에 추가.
        for (String token : tokens) {
            try {
                list.add(Integer.parseInt(token.trim()));
            } catch (NumberFormatException e) {
                System.out.println("숫자 형식이 올바르지 않습니다: " + token);
            }
        }
    }

    // 구분자를 처리한 후 숫자 문자열만 남기는 메서드
    String extraSplitCheck(String str) {
        if (str.startsWith("//")) {
            Trim3 = String.valueOf(str.charAt(2));
            // 구분자를 처리한 후 실제 숫자 문자열만 남기기.
            return str.substring(4);
        }
        return str;
    }

    // 주어진 문자열의 숫자를 합하는 메서드
    void sumNumber(ArrayList<Integer> numbers) {
        for (int num : numbers) {
            answer += num;
        }
    }
}
