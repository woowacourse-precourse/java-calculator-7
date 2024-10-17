package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        String[] arr = st.split("[:;]");
        for (String s : arr) {
            System.out.print(s);
        }
    }
}
