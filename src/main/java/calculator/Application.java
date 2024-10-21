package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Console.readLine();
        int ans = 0;

        if(input.equals("")) {
        }
        else{
            if (!ValidChk(input)) {
                throw new IllegalArgumentException();
            }
            String split = ",|:";
            if (input.startsWith("//")) {
                int end = input.indexOf("\\n");
                split += ("|" + input.substring(2, end));
                input = input.substring(end + 2);
            }

            String num[] = input.split(split);
            int sum = 0;

            for (String number : num) {
                int n = Integer.parseInt(number);
                if (n < 0) {
                    throw new IllegalArgumentException();
                }
                sum += n;
            }

            ans = sum;
        }

        System.out.println("결과 : " + ans);

    }

    private static boolean ValidChk(String input) {
        if(input.trim().isEmpty()) {
            return false;
        }

        if(input.startsWith("//")) {
            int end = input.indexOf("\\n");

            if(end == -1 || end == 2) {
                return false;
            }
        }
        return true;
    }
}
