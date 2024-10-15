package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int result = 0;
        String delimiters = ",|:";

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = camp.nextstep.edu.missionutils.Console.readLine();

        // 기능 1,2,3 : basic & custom delimiters + handling incorrect input exception
        if (!input.isEmpty()) {
            //custom delimiter
            if (input.contains("//")) {
                int custom_end_idx = input.indexOf("\\n");
                String custom_delimiter = input.substring(2, custom_end_idx);
                input = input.substring(custom_end_idx + 2);
                delimiters = delimiters + "|" + custom_delimiter;
            }
            // basic delimiters
            String[] input_array = input.split(delimiters);

            for (String operand: input_array) {
                // handling incorrect input exception with IllegalArgumentException
                try {
                    int item = Integer.parseInt(operand);
                    if (item < 0) {
                        throw new IllegalArgumentException("음수 값은 허용되지 않습니다 : " + item);
                    }
                    result += item;
                }
                catch (NumberFormatException e) {
                    throw new IllegalArgumentException("잘못된 입력 값입니다 : " + input, e);
                }
            }
        }
        System.out.println("결과 : " + result);
    }
}
