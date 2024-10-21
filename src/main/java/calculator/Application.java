package calculator;

import calculator.extract.ExtractRepository;
import calculator.extract.ExtractService;
import calculator.number.Calculator;
import calculator.number.IntegerCalculator;
import calculator.separator.SeparatorRepository;
import calculator.separator.SeparatorService;

public class Application {
    public static void main(String[] args) {
        Calculator<Integer> calculator = new IntegerCalculator();

        SeparatorRepository separatorRepository = new SeparatorRepository();
        ExtractRepository extractRepository = new ExtractRepository();

        ExtractService extractService = new ExtractService(extractRepository);
        SeparatorService separatorService = new SeparatorService(separatorRepository, extractRepository);

        Controller controller = new Controller(separatorService, extractService, calculator);

        controller.run();
    }
}
