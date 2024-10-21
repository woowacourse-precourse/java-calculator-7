package processor;

import calculator.CalculatorProcess;
import display.ConsoleDisplay;
import utility.Const;

public class ManageProcess implements Processor{

    @Override
    public void calculate(){
        startCalculate();
    }

    public void startCalculate(){
        ConsoleDisplay display = new ConsoleDisplay();
        display.output(Const.START_MESSAGE);
    }

    public void printAnswer(){
        ConsoleDisplay display = new ConsoleDisplay();
        CalculatorProcess cal = new CalculatorProcess();
        display.output(Const.ANSWER_MESSAGE+cal.getAnswer());
    }
}
