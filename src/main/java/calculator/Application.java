package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) throws Exception {
        // TODO: 프로그램 구현

        String line;
        /**
         * 사용자로부터 입력을 받는다. 입력이 null이면 0을 출력하고 종료한다.
         * 제공되는 Console 라이브러리는 내부적으로 scanner 를 싱글톤으로 사용하고 있다.
         * nextLine() 함수같은 경우 입력이 없으면 NoSuchElementException이 발생한다.
         */
        try {
            line = Console.readLine();
        } catch (NoSuchElementException e) {
            Printer.printResult(0);
            return;
        }

        /* 입력이 빈 문자열일 경우 0을 출력하고 종료한다. */
        if (line.isBlank()) {
            Printer.printResult(0);
            return;
        }

    }
}
