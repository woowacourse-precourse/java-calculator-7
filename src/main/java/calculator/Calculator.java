package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    // 구분자는 정규표현식 사용
    String separator = ",|:";

    public int run() {
        // 입력값 받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // 입력받은 값이 빈문자열이라면
        if(input.isEmpty()) {
            return 0;
        }

        // 구분자가 있다면
        if (checkCustom(input)) {
            separator += "|" + input.charAt(2);
            input = input.substring(5);
        }

        // 구분자로 구분
        String[] split = input.split(separator);
        int sum = 0;

        // 덧셈 로직
        try{
            for(String s : split) {
                int num = Integer.parseInt(s);
                if (num <= 0) {
                    throw new IllegalArgumentException();
                } else {
                    sum += num;
                }
            }
        }catch (Exception e) {
            throw new IllegalArgumentException();
        }
        System.out.println(sum);

        return sum;
    }

    //커스텀 구분자가 입력되어 있는지 판단
    private boolean checkCustom(String input) {
        if (input.length() < 4) {
            return false;
        }
        if (input.substring(0, 2).equals("//")) {
            if (input.substring(3,5).equals("\\n")) {
                return true;
            }else{
                throw new IllegalArgumentException();
            }
        }
        return false;
    }
}
