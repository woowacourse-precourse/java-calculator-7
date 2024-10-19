package calculator;
import calculator.Controller.StringProcessorController;
import calculator.Service.InputReader;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // InputReader 객체 생성
        InputReader inputReader = new InputReader();

        // StringProcessorController에 의존성 주입
        StringProcessorController stringProcessorController = new StringProcessorController(inputReader);

        // 프로세스 시작
        stringProcessorController.process();
    }
}
