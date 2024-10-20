package calculator;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        StringTokenizer st = new StringTokenizer(input);
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

        /*for (int i = 0; i < str.size(); i++) {
            if (str.get(i).equals("//") && str.get(i + 2).equals("\\") && str.get(i + 3).equals("n")) {
            }
        }

         */
    }
}
//  //;\n1;2;3