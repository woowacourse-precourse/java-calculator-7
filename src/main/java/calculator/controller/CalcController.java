package calculator.controller;

import calculator.entity.CalcEntity;
import calculator.view.Input;
import calculator.view.Output;

public class CalcController {
    private final Input input;
    private final Output output;
    private final CalcEntity calcEntity;

    public CalcController() {
        this.input = new Input();
        this.output = new Output();
        this.calcEntity = new CalcEntity();
    }

    public void run() {
        String[] nums = input.inputCalcNum();
        int result = calcEntity.addNum(nums);
        output.printResult(result);
    }
}
