package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현


        // 사용자 입력 받기
        System.out.println("구분자와 양수 구성된 문자열을 입력해 주세요.");
        String input = Console.readLine();

        input = input.replace("\\n", "\n");

        //빈 문자열 또는 null이 입력된 경우 0을 반환
        if(input == null || input.equals("")) {
            System.out.println("결과 : 0");
            return;
        }
        //기본 구분자 설정
        String delimiter = ",|:";
        String[] numbers;

        //커스텀 구분자 처리
        if (input.length() > 2 && input.charAt(0) == '/' && input.charAt(1) == '/') {
            int nIndex = input.indexOf("\n");
            if (nIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
            }
            String customDelimiter = input.substring(2, nIndex);
            numbers = (input.substring(nIndex + 1)).split(customDelimiter);
        } else {
            numbers = input.split(delimiter); //커스텀구분자가 없을경우
        }

        int sum = 0;

        // 음수이거나 숫자가 아닌경우 예외처리
        try {
            for (String number : numbers) {
                if (!number.trim().isEmpty()) {  // 빈 문자열 처리
                    int parseNumber = Integer.parseInt(number.trim());
                    if (parseNumber < 0) {
                        throw new IllegalArgumentException("음수는 입력할 수 없습니다");
                    }
                    sum += parseNumber;
                }
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력값이 있습니다.", e);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }

        //결과 출력
        System.out.println("결과 : " + sum);







    }
}

