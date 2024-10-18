package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionOperator {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Preprocessing preprocessing = new Preprocessing();
    Addition addition = new Addition();

    public void operator() {
        outputView.askInput();
        String input = inputView.input();

        List<String> separated = new ArrayList<>();
        List<String> separators = new ArrayList<>(Arrays.asList(",", ":"));
        // 전처리
        if (preprocessing.firstLetter(input)) {
            // 커스텀 구분자 추출
            List<String> customAndLeft = preprocessing.findCustomSeparator(input);
            separators.add(customAndLeft.get(0));

            // 숫자 - !숫자 구분
            separated = preprocessing.separation(customAndLeft.get(1), separators);
        } else {
            // 숫자 - !숫자 구분
            separated = preprocessing.separation(input, separators);
        }

        // 구분자 유효하면 sum
        int answer = addition.pickNumbers(separated);

        // 결과 출력
        outputView.printAnswer(answer);
    }

}
