package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class FunctionOperator {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Preprocessing preprocessing = new Preprocessing();

    public void operator() {
        // outputView.입력해주세요();
        String input = inputView.input();

        List<String> separated = new ArrayList<>();
        // 전처리
        if (preprocessing.firstLetter(input)) {
            // 커스텀 구분자 추출
            List<String> customAndLeft = preprocessing.findCustomSeparator(input);
            // 커스텀 구분자 ?에 저장. 커스텀구분자리스트.add(customAndLeft.get(1))

            // 숫자 - !숫자 구분
            separated = preprocessing.separation(customAndLeft.get(1));
        } else {
            // 숫자 - !숫자 구분
            separated = preprocessing.separation(input);
        }
    }

}
