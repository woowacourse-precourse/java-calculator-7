package calculator.controller;

import calculator.domain.UserExpression;

public class TotalController {
    private static InputController inputController;
    private static ExpressionController expressionController;
    private static CalcController calcController;
    private static UserExpression userExpression;

    public TotalController() {
        inputController = new InputController();
        expressionController = new ExpressionController();
        calcController = new CalcController();
    }

    private static void input() {
        userExpression = inputController.input();
    }
}
