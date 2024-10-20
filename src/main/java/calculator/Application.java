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

    public static int makeResult(String str) {
        int result;
        char ndiv, ndiv1, ndiv2;
        ArrayList<Integer> arr;
        div whereDiv;

        // 숫자만 있는 경우
        if (isNumeric(str)) { // 문자열에 문자가 포함되어 있나?
            return Integer.parseInt(str);
        } //공백만 있는 경우
        else if (str.isEmpty() || str.trim().isEmpty()) { // 문자가 포함되어 있지만 공백만 있나?
            return 0;
        } // 구분 지정자(//@\n) 경우
        else if (str.length() > 4 && str.substring(0, 2).equals("//") && str.substring(3, 5).equals("\\n")) { // //@\n 꼴의 양식인가?
            ndiv = str.charAt(2);
            whereDiv = new div(str, ndiv);
            arr = whereDiv.makeArr();

            // 구분지정자를 설정했지만 뒤에 구분지정자를 생성하지 않은 경우 (#1. 숫자도 없는 경우 #2. 숫자만 있음 #3. 다른 구분자가 있음)
            if (arr.isEmpty()) {
                if (str.length() == 5) { // #1
                    return 0;
                } else if (isNumeric(str.substring(5))) { // #2
                    return Integer.parseInt(str.substring(5));
                } else { // #3
                    throw new IllegalArgumentException("구분자와 입력 형식이 잘못되었습니다.");
                }
            }else { //구분 지정자를 설정하고, 뒤에도 구분 지정자가 나오는 경우

                try { //구분 지정자가 정상적으로 작동하지만, 다른 문자가 나오는 경우 예외처리 (처음 부분을 더해줌)
                    result = Integer.parseInt(str.substring(5, arr.get(0)));
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
                // 마지막 구분 지정자부터 끝까지 더해줌
                // 만약 문자로 끝나는 경우
                if (arr.get(arr.size() - 1) == str.length() - 1) {
                    return result;
                } else { //문자로 안끝나는 경우
                    result += Integer.parseInt(str.substring(arr.get(arr.size() - 1) + 1));
                    return result;
                }
            }
        }
            return 0;

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

        public ArrayList<Integer> makeArr() { // 구분자 위치를 반환한다
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
