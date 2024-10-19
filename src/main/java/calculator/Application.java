package calculator;

import java.util.Scanner;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        int result;
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        try {
            result = makeResult(str);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);  // 애플리케이션 종료
        }
    }

    // 문자를 숫자로 바꿀 수 있는지 확인
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str); // 문자열을 숫자로 변환 시도

            return true; // 변환 성공
        } catch (NumberFormatException e) {
            return false; // 변환 실패
        }
    }

    // 합치는 코드 만들기
    public static int makeResult(String str) {
        int result;
        char ndiv, ndiv1, ndiv2;
        ArrayList<Integer> arr;
        div a;
        int flag = 0;

        if (isNumeric(str)) { // 문자열에 문자가 포함되어 있나?
            return Integer.parseInt(str);
        } else if (str.isEmpty() || str.trim().isEmpty()) { // 문자가 포함되어 있지만 공백만 있나?
            return 0;
        } else if (str.length() > 4 && str.substring(0, 2).equals("//") && str.substring(3, 5).equals("\\n")) { // //@\n 꼴의 양식인가?
            ndiv = str.charAt(2);
            a = new div(str, ndiv);
            arr = a.arr();
            if (arr.isEmpty()) {
                flag = 1;
            }
            if (str.length() == 5) { // //@\n만 입력되었을 때
                return 0;
            }
            if (isNumeric(str.substring(5))) { // //@\n20 처럼 숫자만 입력되었을 때
                return Integer.parseInt(str.substring(5));
            }

            if (flag == 1) { // //@\n20,42,115 일 때, 즉, 길이는 5 이상(//@\n + a), 뒤의 문자가 @가 아닌 경우
                throw new IllegalArgumentException("구분자와 입력 형식이 잘못되었습니다.");
            }

            try {
                result = Integer.parseInt(str.substring(5, arr.get(0))); // 에러 발생할 수 있는 부분 처리
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                throw new IllegalArgumentException("숫자 변환 또는 인덱스 오류 발생: " + e.getMessage(), e);
            }

            for (int i = 0; i < arr.size() - 1; i++) {
                try {
                    String substring = str.substring(arr.get(i) + 1, arr.get(i + 1));
                    int num = Integer.parseInt(substring);
                    result += num;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("숫자 변환 오류 발생: " + e.getMessage(), e);
                }
            }

            result += Integer.parseInt(str.substring(arr.get(arr.size() - 1) + 1));
            return result;
        } else { // str = //@@\n1,3,2,4,5 면 여기로 들어옴 (처리 가능함)
            ndiv1 = ',';
            ndiv2 = ':';
            a = new div(str, ndiv1, ndiv2);
            arr = a.arr();
            try {
                result = Integer.parseInt(str.substring(0, arr.get(0))); // 여기서 오류가 발생할 수 있음
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                throw new IllegalArgumentException("숫자 변환 또는 인덱스 오류 발생: " + e.getMessage(), e);
            }

            for (int i = 0; i < arr.size() - 1; i++) {
                try {
                    String substring = str.substring(arr.get(i) + 1, arr.get(i + 1));
                    int num = Integer.parseInt(substring); // 숫자 변환 오류 처리
                    result += num;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("숫자 변환 오류 발생: " + e.getMessage(), e);
                }
            }

            result += Integer.parseInt(str.substring(arr.get(arr.size() - 1) + 1));
            return result;
        }
    }
}

class div { // 구분자 위치 반환
    String str;
    char std1, std2;

    div(String str, char std1) {
        this.str = str;
        this.std1 = std1;
        this.std2 = std1;
    }

    div(String str, char std1, char std2) {
        this.str = str;
        this.std1 = std1;
        this.std2 = std2;
    }

    public ArrayList<Integer> arr() { // 구분자 위치를 반환한다
        ArrayList<Integer> arr = new ArrayList<>();
        if (std1 == std2) { // 구분자 같은 경우
            for (int i = 5; i < str.length(); i++) {
                if (str.charAt(i) == std1) {
                    arr.add(i);
                }
            }
        } else { // 구분자가 다른 경우
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == std1 || str.charAt(i) == std2) {
                    arr.add(i);
                }
            }
        }
        return arr;
    }
}
