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
    public int add(String input) {
        //입력 x or 빈 문자열
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String division = ",|:";
        String numbers = input;

        if (input.startsWith("//")) {
            int division_index = input.indexOf("\n");
            if (division_index == -1) {
                throw new IllegalArgumentException("잘못된 입력 형식입니다.");
            }
            division = input.substring(2, division_index); //구분자 추출
            numbers = input.substring(division_index + 1); //구분자 이후 숫자 추출
        }

        String[] num_split = numbers.split(division);
        Queue<Integer> queue = new LinkedList<>();
        for (String split : num_split) {
            int num = Integer.parseInt(split.trim());
            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + split);
            }
            queue.offer(num);
        }
        int sum = 0;

        return sum;
    }
}
