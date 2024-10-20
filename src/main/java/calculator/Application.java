package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // 입력받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String line = readLine();

        // custom 판별
        boolean custom = isCustom(line);
    }

    // 기본 구분자 및 커스텀 구분자 판별
    public static boolean isCustom(String line) {
        //*\n
        if (line.length() >= 5) {
            if (line.charAt(0) == '/'
                    && line.charAt(1) == '/'
                    && line.charAt(3) == '\\'
                    && line.charAt(4) == 'n') {
                return true;
            } else return false;
        } else return false;
    }
}
