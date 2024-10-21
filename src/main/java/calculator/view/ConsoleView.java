package calculator.view;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleView {


    public String request(){
        System.out.print("계산할 숫자를 입력하세요 (쉼표 또는 콜론) : ");
        String input = Console.readLine();

        while (input.trim().isEmpty()) {
            System.out.print("입력이 비어있습니다. 다시 입력하세요: ");
            input = Console.readLine();
        }
        return input;
    }
    public void printResult(int result) {
        System.out.println("결과 : " + result);
    }

    public void printError(String message) {
        System.err.println("에러가 발생하여 프로그램을 종료합니다.(" + message + ")");
    }
}
