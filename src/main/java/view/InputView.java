package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class InputView {
    String getInput() {
        System.out.print("덧셈할 문자열을 입력해 주세요.");
        String firstLine = readLine();
        if (firstLine == null) {
            Console.close();
            throw new NoSuchElementException("입력값이 없습니다.");
        }
        if (firstLine.isEmpty()) {
            Console.close();
            return "";
        }
        if (firstLine.startsWith("//")) {
            String secondLine = readLine();
            Console.close();
            if (secondLine != null && !secondLine.isEmpty()) {
                // 두 번째 줄이 비어 있지 않은 경우에만 \n을 추가하여 반환
                return firstLine + "\n" + secondLine;
            }
        }
        Console.close();
        return firstLine;
    }

    private String readLine() {
        try {
            return Console.readLine();
        } catch (java.util.NoSuchElementException e) {
            // 입력 스트림에 더 이상 읽을 데이터가 없을 때 처리
            return null;
        }
    }
}
