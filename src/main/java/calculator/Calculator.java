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
        return Double.parseDouble(inputString);
    }

    public double calculateString() throws NumberFormatException {
        String inputString = stringData.getInputString();
        String separator = stringData.getSeparator();

        String[] slicedString = inputString.split(separator);
        double sum = sumData.getSumData();
        for (String slice : slicedString) {
            sum += Double.parseDouble(slice);
        }
        return sum;
    }
}