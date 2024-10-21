package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("입력:");
        String input = Console.readLine();

        try {
            String[] numbers = Distiniction.splitInput(input); // 입력을 분리
            int[] pickedNumbers = NumberPick.pickNumbers(numbers); // 숫자 배열로 변환

            // 숫자 출력
            System.out.print("추출된 숫자: ");
            for (int num : pickedNumbers) {
                System.out.print(num + " ");
            }
            System.out.println(); // 줄바꿈

            int sum = PickNumberTotal.sum(pickedNumbers); // 숫자 배열의 합 계산
            System.out.println("결과: " + sum);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // 예외 메시지 출력
        }
    }
}
