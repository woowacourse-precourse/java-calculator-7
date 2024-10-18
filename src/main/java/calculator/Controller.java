package calculator;

public class Controller {
    public void controlFlow() throws IllegalArgumentException {
        try {
            StringData stringData = new StringData();
            Input input = new Input();
            String inputString = input.requestInput(stringData);
            stringData.setInputString(inputString);

            SumData sumData = new SumData();
            Output output = new Output(sumData);
            Checker checker = new Checker(stringData);
            if (checker.checkIsNotString()) {
                output.formatOutput();
                return;
            }

            Calculator calculator = new Calculator(stringData, sumData);
            if (checker.checkIsSingleNumber()) {
                Double sumResult = calculator.calculateSingleValue();
                sumData.setSumData(sumResult);
                output.formatOutput();
                return;
            }

            String separator = checker.checkCustomSeparator();
            stringData.setSeparator(separator);
            if (separator != null) {
                stringData.setHasCustomSeparator(true);
            }
            if (separator == null) {
                separator = checker.checkDefaultSeparator();
                stringData.setSeparator(separator);
            }

            boolean hasCustomSeparator = stringData.getHasCustomSeparator();
            boolean isEmptyString = false;
            if (hasCustomSeparator) {
                Cleaner cleaner = new Cleaner(stringData);

                String refinedString = cleaner.refineString();
                stringData.setInputString(refinedString);
                isEmptyString = refinedString.isEmpty();

                String refinedSeparator = cleaner.refineSeparator();
                stringData.setSeparator(refinedSeparator);
            }
            if (isEmptyString) {
                output.formatOutput();
                return;
            }

            Double sumResult = calculator.calculateString();
            sumData.setSumData(sumResult);
            output.formatOutput();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}