package calculator.controller;

import calculator.calculate.CalculateService;
import calculator.calculate.CalculateServiceImpl;
import calculator.separator.SeparatorService;
import calculator.separator.SeparatorServiceImpl;
import calculator.view.InputView;
import calculator.view.OutputView;

/**
 * 계산을 제어하는 컨트롤러 클래스.
 * SeparatorService와 CalculateService를 사용해 문자열을 처리하고 계산합니다.
 */
public class CalculateController {
    private static final int LENGTH_OF_CUSTOM_SEPARATOR_HEADER = 5;
    private final SeparatorService separatorService;
    private final CalculateService calculateService;
    private final InputView inputView;
    private final OutputView outputView;


    public CalculateController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.separatorService = new SeparatorServiceImpl();
        this.calculateService = new CalculateServiceImpl();
    }

    /**
     * 계산 과정을 시작하는 메서드.
     * 문자열 입력부터 결과 출력까지의 흐름을 제어합니다.
     */
    public void run() {
        // 입력 받기
        String input = inputView.input();

        // 구분자 추출
        String separator = separatorService.getSeparator(input);

        if (separatorService.checkCustomSeparator(input)) {
            input = input.substring(LENGTH_OF_CUSTOM_SEPARATOR_HEADER);
        }

        // 구분자를 기준으로 문자열 분리
        String[] splitNumbers = separatorService.splitBySeparator(input, separator);

        // 문자열 배열을 정수 배열로 변환
        int[] numbers = calculateService.parseIntArray(splitNumbers);

        // 숫자 합 계산
        int result = calculateService.calculateSum(numbers);

        // 결과 출력
        outputView.output(result);
    }
}
