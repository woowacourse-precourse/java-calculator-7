package calculator.Manager;

public class CalculatorManager {

    private static CalculatorManager instance;

    private CalculatorManager() {
    }

    public static CalculatorManager getInstance() {
        if (instance == null) instance = new CalculatorManager();
        return instance;
    }


    public void run(){

    }
}
