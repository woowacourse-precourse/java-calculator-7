package calculator;

import java.util.Scanner;

public class Application {

    public static boolean isRightCustomForm(String s) {
        // 5글자 이상, //로 시작, 문자열 3번째 자리는 \n
        return !(s.length() >= 5 && s.startsWith("//") && s.charAt(3) == '\n');
    }

    public static void main(String[] args) {
        String str;
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열을 입력해주세요: ");
        str = sc.nextLine(); // 전체 문자열을 입력받음

        try {
            if (str.charAt(0) == '/') { // 문자열 앞자리 문자로 시작한다면
                System.out.println("if문 통과");
                if (!(str.charAt(0) == '/')) {
                    throw new IllegalArgumentException("문자열 맨 앞에는 //이외에 문자가 들어올 수 없습니다");
                }
                if (isRightCustomForm(str)) {
                    throw new IllegalArgumentException("커스텀 구분자 형식에 맞지 않습니다"); // /c\n인지 검사
                }
                char customSeparator = str.charAt(2);
                str = str.substring(5);
                str = str.replace(customSeparator, ',');
            }

            System.out.println(str);
            str = str.replace(":", ",");

        } catch (IllegalArgumentException e) {// 예외 발생 시 프로그램을 종료
            System.out.println(e.getMessage());
        }

        String[] splitName = str.split(",");
        int sum = 0;

        for (String s : splitName) {
            try {
                if (s.isBlank()) {
                    throw new IllegalArgumentException("구분자가 연속으로 들어올 수 없습니다");
                }
                if (Integer.parseInt(s) < 0) {
                    throw new IllegalArgumentException("음수가 들어올 수 없습니다");
                }
                sum += Integer.parseInt(s); // 숫자로 변환하여 더하기
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 숫자 형식: " + s);
            }
        }

        System.out.println(sum);
    }
}
