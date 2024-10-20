package calculator;

import calculator.controller.CalculateController;

public class Application {
    public static void main(String[] args) {
        // CalculateController 인스턴스 생성 및 실행
        CalculateController controller = new CalculateController();
        controller.run();
    }
}
