package calculator.controller;

import calculator.domain.UserExpression;
import calculator.view.Users;
import java.util.List;

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

    public static void init() {
        input();
        prepExpressionAndCalc();
        outputPrint();
    }

    private static void input() {
        userExpression = inputController.input();
    }

    private static void prepExpressionAndCalc() {
        List<String> prepToSend = expressionController.init(userExpression);
        calcController.init(prepToSend);
    }

    private static void outputPrint() {
        Users.resultOfMatchingOutputFormat(calcController.calcTheNumbers());
    }


}
