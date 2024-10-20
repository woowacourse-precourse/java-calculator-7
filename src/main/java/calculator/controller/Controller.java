package calculator.controller;

import calculator.model.Equation;
import calculator.model.Separator;
import calculator.view.View;

public class Controller {
    Separator separator;
    Equation equation;

    public Controller(View view) {
        String expression = view.inputExpression();
        parseEquation(expression);
        parseSeparator(expression);

        if(!isEquationValid()) {
            throw new IllegalArgumentException();
        }

        Integer answer = calculateSum();
        view.printCalculateResult(answer);
    }

    public void parseSeparator(String expression) {
        separator = new Separator();

        if(expression.startsWith("//")) {
            String customSeparator = expression.substring(2, expression.indexOf("\\n"));
            separator.append(customSeparator);
        }
    }

    public void parseEquation(String expression) {
        if(expression.startsWith("//")) {
            equation = new Equation(expression.split("\\\\n")[1]);
        } else {
            equation = new Equation(expression);
        }
    }

    public boolean isEquationValid() {
        var a = equation.equation.replaceAll("[\\d" + separator.separator + "]", "");
        return a.isEmpty();
    }

    public Integer calculateSum() {
        String[] strNums = equation.equation.split("[" + separator.separator +"]");
        Integer sum = 0;

        for(String strNum : strNums) {
            sum += Integer.parseInt(strNum);
        }
        return sum;
    }
}
