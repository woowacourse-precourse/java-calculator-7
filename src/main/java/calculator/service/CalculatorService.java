package calculator.service;

import calculator.model.StringCalculator;

public class CalculatorService {
        private final StringCalculator stringCalculator;

        public CalculatorService(StringCalculator stringCalculator) {
            this.stringCalculator = stringCalculator;
        }
    }
