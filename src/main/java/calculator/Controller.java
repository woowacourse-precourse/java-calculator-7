package calculator;

public class Controller {
    private boolean isSuccess;
    private StringData stringData;
    private SumData sumData;

    public void controlFlow() throws IllegalArgumentException {
        try {
            stringData = new StringData();
            sumData = new SumData();

            controlInput();

            Output output = new Output();
            Checker checker = new Checker(stringData);

            isSuccess = controlStringChecker(checker);
            if (isSuccess) {
                controlOutput(output);
                return;
            }

            Calculator calculator = new Calculator(stringData, sumData);

            isSuccess = controlNumberChecker(checker, calculator);
            if (isSuccess) {
                controlOutput(output);
                return;
            }

            controlSeparatorChecker(checker);
            controlCleaner();

            isSuccess = controlStringChecker(checker);
            if (isSuccess) {
                controlOutput(output);
                return;
            }

            isSuccess = controlCalculator(calculator);
            controlOutput(output);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public void controlInput() {
        Input input = new Input();
        String inputString = input.requestInput();

        stringData.setInputString(inputString);
    }

    public void controlOutput(Output output) {
        if (isSuccess) {
            output.formatOutput(sumData);
        }
    }

    public boolean controlStringChecker(Checker checker) {
        isSuccess = false;

        if (checker.checkIsNotString()) {
            isSuccess = true;
        }
        return isSuccess;
    }

    public boolean controlNumberChecker(Checker checker, Calculator calculator) {
        isSuccess = false;

        if (checker.checkIsSingleNumber()) {
            Double sumResult = calculator.calculateSingleValue();

            sumData.setSumData(sumResult);
            isSuccess = true;
        }
        return isSuccess;
    }

    public void controlSeparatorChecker(Checker checker) throws IllegalArgumentException {
        String separator = checker.checkCustomSeparator();

        stringData.setSeparator(separator);
        if (separator != null) {
            stringData.setHasCustomSeparator(true);
        }

        if (separator == null) {
            separator = checker.checkDefaultSeparator();
            stringData.setSeparator(separator);
        }
    }

    public void controlCleaner() {
        boolean hasCustomSeparator = stringData.getHasCustomSeparator();

        if (hasCustomSeparator) {
            Cleaner cleaner = new Cleaner(stringData);

            String refinedString = cleaner.refineString();
            stringData.setInputString(refinedString);

            String refinedSeparator = cleaner.refineSeparator();
            stringData.setSeparator(refinedSeparator);
        }
    }

    public boolean controlCalculator(Calculator calculator) throws NumberFormatException {
        Double sumResult = calculator.calculateString();

        sumData.setSumData(sumResult);
        isSuccess = true;

        return isSuccess;
    }
}