package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();

        String[] parts = input.split("\\D+");

        ArrayList<Integer> numbers = new ArrayList<>();

        for (String part : parts) {
            if (!part.isEmpty()) { // 빈 문자열이 아닌 경우에만 처리
                numbers.add(Integer.parseInt(part));
            }
        }

        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        System.out.println("결과 : " + sum);
    }
}
