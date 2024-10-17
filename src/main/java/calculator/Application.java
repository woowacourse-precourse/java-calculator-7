package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.print("덧셈할 문자열을 입력해주세요." + "\n");
        String Input = Console.readLine();

        int sum = 0;

        String[] tokens = Input.split("[,:]");

        for (String token : tokens) {
            if (token.isEmpty()) {
                token = "0";
            }
            sum += Integer.parseInt(token);
        }
        System.out.println("결과 : " + sum);
        }
    }
