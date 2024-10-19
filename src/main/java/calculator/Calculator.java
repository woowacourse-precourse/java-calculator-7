package calculator;

public class Calculator {
    private StringData stringData;
    private SumData sumData;

    public Calculator(StringData stringData, SumData sumData) {
        this.stringData = stringData;
        this.sumData = sumData;
    }

    public double calculateSingleValue() {
        String inputString = stringData.getInputString();
        double singleValue = Double.parseDouble(inputString);

        return singleValue;
    }

    public double calculateString() throws NumberFormatException {
        String inputString = stringData.getInputString();
        String separator = stringData.getSeparator();
        String[] slicedString = inputString.split(separator);
        double sumValue = sumData.getSumData();

        for (String slice : slicedString) {
            sumValue += Double.parseDouble(slice);
        }
        return sumValue;
    }
}