package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String data = Console.readLine();
        try{
            int result = calculate(data);
        System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e){
            System.out.println(e);
        }
    }


    public static int calculate(String data) {
        if (data.isEmpty()) {
            return 0;
        }

        String[] numbers;

        if (data.startsWith("//")){
            int lastIndex = data.indexOf("\\n");
            if (lastIndex == -1){
                throw new IllegalArgumentException("커스텀 구분자 형식 오류가 발생 했습니다.");
            }
            String customSeparator = data.substring(2,lastIndex);
            data = data.substring(lastIndex + 2);
            numbers = data.split(customSeparator);
        } else if (data.contains(",")){
            numbers = data.split(",");
        } else if (data.contains(":")) {
            numbers = data.split(":");
        } else {
            throw new IllegalArgumentException("구분자 존재하지 않습니다.");
        }

        int sum = 0;

        for (String number : numbers) {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new IllegalArgumentException("음수 입력 불가능 합니다." );
            }
            sum += num;
        }
        return sum;

    }
}
