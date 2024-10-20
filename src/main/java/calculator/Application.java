package calculator;

public class Application {
    public static void main(String[] args) {
        // 입력과 출력 담당
        ConsoleService consoleService = new ConsoleService();

        // 구분자 처리 담당
        DelService delService = new DelService();

        // 숫자 처리 및 계산 담당
        CalculatorService calculatorService = new CalculatorService();

        // DependencyInjection 필요한 의존성 주입
        DependencyInjection dependencyInjection = new DependencyInjection(consoleService, delService,
                calculatorService);

        // 프로그램 실행
        dependencyInjection.execute();
    }
}