package calculator;

import java.math.BigInteger;
import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Separator separator = new Separator(',',':');

        InputStructure input = new InputStructure(IOController.input());

        separator.addSeparator(input.getCustomSeparator());
        Validator.validateFormula(input.getFormulaString(), separator);

        ArrayList<BigInteger> tokens = Parser.inputParse(input.getFormulaString(), separator);

        IOController.printAnswer(Calculator.adder(tokens));

    }
}
