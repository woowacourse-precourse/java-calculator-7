package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();

        if (str.isEmpty()) {
            System.out.print("결과 : 0");
            Console.close();
        }

        ArrayList<String> delimeters = new ArrayList<>(List.of(",", ":"));

        if (str.substring(0, 2).equals("//")) {
            int delimeterIndex = -1;
            delimeterIndex = str.indexOf("\\n");
            if (delimeterIndex != -1) {
                String customDelimeter = str.substring(2, delimeterIndex);
                delimeters.add(customDelimeter);
                str = str.substring(delimeterIndex + 2, str.length());
            } else {
                throw new IllegalStateException();
            }
        }

        String splitDelimeters = "";

        for (int i = 0; i < delimeters.size(); i++) {
            if (i == delimeters.size() - 1) {
                splitDelimeters += delimeters.get(i);
            }
            splitDelimeters += delimeters.get(i) + "|";
        }
    }
}