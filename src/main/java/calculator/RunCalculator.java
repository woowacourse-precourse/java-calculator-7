package calculator;

import calculator.calculation.CalculationManager;
import calculator.calculation.CalculationManagerImpl;
import calculator.input.InputManager;
import calculator.input.InputManagerImpl;
import calculator.output.OutputManager;
import calculator.output.OutputManagerImpl;
import calculator.repository.number.NumberRepository;
import calculator.repository.number.NumberRepositoryImpl;
import calculator.repository.separator.SeparatorRepository;
import calculator.repository.separator.SeparatorRepositoryImpl;

public class RunCalculator {
    public static void run() {
        //싱글톤 리포지토리 참조
        SeparatorRepository separatorRepository = SeparatorRepositoryImpl.getInstance();
        NumberRepository numberRepository = NumberRepositoryImpl.getInstance(separatorRepository);

        //기본 구준자 넣기
        separatorRepository.saveSeparator(Constants.DEFAULT_SEPARATOR_1);
        separatorRepository.saveSeparator(Constants.DEFAULT_SEPARATOR_2);

        //각 매니저 초기화(필요한 리포지토리 주입)
        InputManager inputManager = new InputManagerImpl(numberRepository, separatorRepository);
        CalculationManager calculationManager = new CalculationManagerImpl(numberRepository);
        OutputManager outputManager = new OutputManagerImpl();

        //출력 매니저로 출력 형식에 맞게 질문 프롬프트 출력
        outputManager.printPrompt();

        //입력 매니저로 리포지토리에 덧셈에 필요한 값 저장
        inputManager.saveSeparatorAndNumbers();

        //계산 매니저로 리포지토리에서 값을 가져와 덧셈 계산
        int result = calculationManager.doAdd();

        //출력 매니저로 출력 형식에 맞게 결과 출력
        outputManager.printResult(result);
    }
}
