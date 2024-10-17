package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        String[] arr = st.split("[:;]");

        if(st.contains("//") && st.contains("\\n")) {
            String[] arr1 = st.split("\\D");
            for (String s : arr1) {
                System.out.print(s);
            }
        } else {
            for (String s : arr) {
                System.out.print(s);
            }
        }
    }
}