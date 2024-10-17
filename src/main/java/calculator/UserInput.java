package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class UserInput {

    public String userInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();
        return str;
    }

    public List<String> substringInput(String in) {
        System.out.println(in);
        // 커스텀 구분자 여부
        if(in.contains("//") && in.contains("\\n")) {
            return customInput(in);
        } else if(in.contains(",") || in.contains(":")) { // ',' or ':' 구분
            return defaultInput(in);
        } else { // 잘못된 입력
            throw new IllegalArgumentException();
        }
    }

    private List<String> customInput(String in) {
        int idx = in.indexOf("n");
        System.out.println(idx);
        String custom = in.substring(0, idx+1).replaceAll("//", "").replaceAll("\\n", "");

        List<String> number = List.of(in.substring(idx+1).split(custom));
        return number;
    }

    private List<String> defaultInput(String in) {
        List<String> number = List.of(in.split(",|:"));
        return number;
    }
}
