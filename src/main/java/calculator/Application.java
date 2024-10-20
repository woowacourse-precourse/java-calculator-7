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
            int flag = 0;

            // 숫자만 있는 경우
            if (isNumeric(str)) { // 문자열에 문자가 포함되어 있나?
                return Integer.parseInt(str);
            } //공백만 있는 경우
            else if (str.isEmpty() || str.trim().isEmpty()) { // 문자가 포함되어 있지만 공백만 있나?
                return 0;
        }
    }
