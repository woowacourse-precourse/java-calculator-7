package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    // 기능1. 쉼표 또는 콜론으로 분리한 각 숫자의 합을 반환
    public static int basic_add(String string_to_calc){
        return basic_add(string_to_calc, ',');
    }

    // 기능2. 커스텀 구분자 추가
    public static int basic_add(String string_to_calc, char separator){
        int answer = 0;

        String[] numbers = string_to_calc.split("[" +separator + ": ,]");
        for (String number : numbers) {
            if (!number.isEmpty()) {
                try {
                    answer += Integer.parseInt(number);
                } catch (IllegalArgumentException e) { // 기능3. 잘못된 값 입력할 경우 예외 발생
                    System.exit(0);
                }
            }
        }

        return answer;
    }

    // 기능 2_1. 커스텀 구분자 찾기
    public static char find_separator(String string_contain_separator) {
        char separator = ',';
        int startIndex = string_contain_separator.indexOf("//");
        if (startIndex != -1) {
            int endIndex = string_contain_separator.indexOf("\n", startIndex);
            if (endIndex != -1) {
                String separator_string = string_contain_separator.substring(startIndex + 2, endIndex);
                if (!separator_string.isEmpty()) {
                    separator = separator_string.charAt(0);
                }
            }
        }
        return separator;
    }

    public static void main(String[] args) {
        String string_to_calc = Console.readLine();
        //\n을 인식하도록 입력 문자열 처리
        //string_to_calc = string_to_calc.replace("\\n", "\n");
        char separator = find_separator(string_to_calc);
        if (separator == ',') {
            System.out.println(basic_add(string_to_calc));
        } else {
            //커스텀 구분자가 있으면 \n 뒤 문자열에서 계산
            int newlineIndex = string_to_calc.indexOf("\n");
            if (newlineIndex != -1) {
                String numbersPart = string_to_calc.substring(newlineIndex + 1);
                System.out.println(basic_add(numbersPart, separator));
            }
        }
    }
}
