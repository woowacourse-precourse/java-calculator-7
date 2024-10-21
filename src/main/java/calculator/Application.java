package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // Model, Servcie, view 객체 생성
        CalculatorModel model = new CalculatorModel(); // 결과 데이터 저장 객체
        CalculatorService service = new CalculatorService(model); // 비즈니스 로직 처리 서비스
        CalculatorView view = new CalculatorView(); // 입출력 view따로 뺌.

        // controller로 프로그램 실행 조작
        CalculatorController controller = new CalculatorController(service, view);
        controller.run(); // 실행
    }
}
