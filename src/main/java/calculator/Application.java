package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static int add(String input) {
        String delimiter = "";
        String[] numbers;
        int sum = 0;
        if (input == null || input.isEmpty() || input.isBlank()) {
            return 0;
        } else if (input.startsWith("//")) {
            String[] s = input.split("");
            if((s[3].equals("\\")) && (s[4].equals("n"))) {
                delimiter += input.charAt(2);
                if(input.length() == 5) {
                    return 0;
                }
                input = input.substring(5);
                if(input == null || input.isEmpty() || input.isBlank()) {
                    return 0;
                }
                String first = "" + input.charAt(0);
                String last = "" + input.charAt(input.length()-1);
                if(first.equals(":") || first.equals(",") || first.equals(delimiter)) {
                    throw new IllegalArgumentException("구분자로 시작할 수 없습니다.");
                } else if(last.equals(":") || last.equals(",") || last.equals(delimiter)) {
                    throw new IllegalArgumentException("구분자로 끝날 수 없습니다.");
                }
            } else {
                throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
    }
}
