package calculator.view;

import calculator.domain.view.View;

public class ConsoleOutPut implements View<Integer> {
    @Override
    public void render(Integer result) {
        System.out.println("결과 : " + result);
    }
}
