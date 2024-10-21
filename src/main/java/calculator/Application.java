package calculator;

import calculator.controller.CalculatorController;
import calculator.service.Service;
import calculator.service.ServiceV2;
import calculator.validator.Validator;
import calculator.validator.ValidatorImpl;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //Service service = new ServiceV1();
        Validator validator = new ValidatorImpl();
        Service service = new ServiceV2();
        CalculatorController calculatorController = new CalculatorController(service, validator);
        calculatorController.execute();
    }
}
