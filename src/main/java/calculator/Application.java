package calculator;

public class Application {
    public static void main(String[] args) {
        // 입력과 출력 담당
        IOService ioService = new IOService();

        // 구분자 처리 담당
        DelimiterService delimiterService = new DelimiterService();

        // 숫자 처리 및 계산 담당
        NumberService numberService = new NumberService();

        // Coordinator에 필요한 의존성 주입
        Coordinator coordinator = new Coordinator(ioService, delimiterService, numberService);

        // 프로그램 실행
        coordinator.execute();
    }
}