package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        System.out.print("덧셈할 문자열을 입력해 주세요.\n");

        String input = null;
        try {
            input = Console.readLine();
        } catch (NoSuchElementException e) {
            System.err.println("입력이 없습니다. 프로그램을 종료합니다.");
            return;
        }
    }
}
