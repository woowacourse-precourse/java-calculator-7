package calculator;

import adder.Adder;
import io.Input;
import io.Output;
import parser.Parser;
import separator.Separator;

public class Calculator {

    public void calculator() {
        Adder adder = new Adder();
        Separator separator = new Separator();
        Parser parser = new Parser();
        Input i = new Input();
        Output o = new Output();

        String input = i.input();

        separator.saveSeparator(input);

        String stringToCalculate = parser.parseStringToCalculate(input);

        int result = adder.add(stringToCalculate);

        o.output(result);

        Separator.separators.clear();
    }


}
