package calculator;

import camp.nextstep.edu.missionutils.Console;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    enum Type {
        DEFAULT, CUSTOM;
    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();

//        char[] character = str.toCharArray();

        Type strType = getType(str);

        int sum = 0;

        switch (strType) {
            case DEFAULT:

                // 쉼표(,) 또는 콜론(:)을 기준으로 문자열 분리
                String[] parts = str.split("[, :]+");

                for (int i=0; i<parts.length; i++) {
                    sum += Integer.parseInt(parts[i]);
                }

                break;

            case CUSTOM:
                break;
        }


        System.out.println("결과 : " + sum);
    }

    private static Type getType(String str) {
        if (str.startsWith("//")) {
            return Type.CUSTOM;
        } else {
            return Type.DEFAULT;
        }
    }

    // 숫자 추출 후 합산하는 함수
//    private static int[] extractNumberSum(String str) {
//
//
//
//
//    }
}
