package calculator;

public class CalculatorController {
    private CalculatorService service;
    private CalculatorView view;

    // Service와 View를 주입받음
    public CalculatorController(CalculatorService service, CalculatorView view){
        this.service = service;
        this.view = view;
    }

    // 실질적인 계산프로그램 동작 시작
    public void run() {
        String input = view.getInput(); // view에서 input 가져온 후
        service.calculate(input); // service 계층에서 계산 수행
        int result = service.getModel().getResult(); // service에서 계산을 통해 저장된 result가 model에 저장됨 해당 결과 모델에서 뽑고 담아줌.
        view.printResult(result); // 뷰를통해 결과 출력
    }
}
