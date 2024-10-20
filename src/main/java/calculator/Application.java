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
        if (input == null || input.isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }
        try {
            int result = app.add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // System.out으로 수정
        }
    }

    public int add(String input) {
        // 빈 문자열 처리
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String division = ",|:"; // 기본 구분자 설정
        String numbers = input;

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            int divisionIndex = input.indexOf("\n");
            if (divisionIndex == -1) {
                throw new IllegalArgumentException("잘못된 입력 형식입니다.");
            }
            division = input.substring(2, divisionIndex); // 커스텀 구분자 추출
            numbers = input.substring(divisionIndex + 1); // 구분자 이후 숫자 추출
        }

        // 구분자에 따라 숫자 분리 및 합산
        String[] numSplit = numbers.split(division);
        Queue<Integer> queue = new LinkedList<>();
        for (String split : numSplit) {
            int num = Integer.parseInt(split.trim()); // 공백 제거
            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + split);
            }
            queue.offer(num);
        }

        // 합계 계산
        int sum = 0;
        while (!queue.isEmpty()) {
            sum += queue.poll();
        }
        return sum;
    }
}