package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final String MSG_GUIDE_INPUT = "덧셈할 문자열을 입력해 주세요.\n";

    public static void main(String[] args) {
        int inputNum = 0;
        String inputString = null;
        char customDelim = 0;
        List<Integer> inputNumbers = new ArrayList<>();

        // 1. 입력
        // 1-1. 입력 안내 메시지 출력
        System.out.println(MSG_GUIDE_INPUT);
        // 1-2. 입력 받아오기
        inputString = Console.readLine();
        // 1-3. 입력 유효성 검증
        // 2-1. 커스텀 구분자 검증
        if (inputString.charAt(0) == '/' && inputString.charAt(1) == '/') {
            // 2. 커스텀 구분자
            customDelim = inputString.charAt(2);
            inputString = inputString.substring(5);

            if (customDelim == '\\') {
                throw new IllegalArgumentException("커스텀 구분자가 지정되지 않았습니다.");
            }
        }
        try {
            if (inputString == null || inputString.isEmpty()) {
                throw new IllegalArgumentException("빈 문자열이 입력되었습니다.");
            }
        }
        catch (IllegalArgumentException e) {
            return;
        }
        // 1-4. 입력 내 숫자 문자 추출
        for (char c : inputString.toCharArray()) {
            if ((customDelim == 0 && (c == ':' || c == ',')) || c == customDelim) {
                if (inputNum != 0) {
                    inputNumbers.add(inputNum);
                    inputNum = 0;
                }
                else {
                    throw new IllegalArgumentException("입력된 구분자 사이에 숫자가 없습니다.");
                }
            }
            else if (c > '0' && c < '9') {
                inputNum *= 10;
                inputNum += Integer.parseInt(String.valueOf(c));
            }
            else {
                throw new IllegalArgumentException("입력 내에 숫자가 아닌 문자가 존재합니다.");
            }
        }
    }
}
