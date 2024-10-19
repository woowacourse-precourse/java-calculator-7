package calculator;

import java.util.Scanner;

public class Calculator {
    Scanner scanner;
    String input;
    String separator;

    Calculator() {
        scanner = new Scanner(System.in);
        separator = ",|:";
    }

    public void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        input = scanner.nextLine();
        input = input.trim();

        //입력 값이 없으면 결과 값은 0
        if (input.equals("")) {
            System.out.println("결과 : 0");
            return;
        }

        switch (checkCustom()) {
            case 1:
                separator = separator + '|' + input.charAt(2);
                input = input.substring(5);
                break;
            case 2:
                input = input.substring(4);
                break;
        }
        String operandList[] = input.split(separator);
        for (int i = 0; i < operandList.length; i++) {
        }

        if (operandList.length == 0) {
            System.out.println("결과 : 0");
        } else if (input.length() == 0) {
            System.out.println("결과 : 0");
        } else {
            Integer sum = getResult(operandList);
        }

        scanner.close();
    }

    //커스텀 구분자가 입력되어 있는지 판단
    private int checkCustom() {
        if (input.length() < 4) {
            return 0;
        }

        if (input.substring(0, 2).equals("//")) {
            if (input.charAt(3) == '\\' && input.charAt(4) == 'n') {
                return 1;
            } else if (input.charAt(2) == '\\' && input.charAt(3) == 'n') {
                return 2;
            } else {
                throw new IllegalArgumentException();
            }
        }
        return 0;
    }

    //구분자를 기준으로 숫자들의 합 구하기
    private Integer getResult(String list[]) {
        Integer sum = Integer.valueOf(0);
        try {
            for (int i = 0; i < list.length; i++) {
                sum += Integer.valueOf(list[i]);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return sum;
    }


}
