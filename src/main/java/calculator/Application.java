package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();

        if (st.contains(":") || st.contains(";")) {
            String[] arr = st.split("\\D");

            for (String s : arr) {
                System.out.print(s);
            }

        } else if (st.contains("//") && st.contains("\\n")) {
            String[] arr1 = st.split("\\D");

            for (String s : arr1) {
                System.out.print(s);
            }

        } else {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }
}