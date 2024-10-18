package calculator;

public class Output {
    private SumData sumData;

    public Output(SumData sumData) {
        this.sumData = sumData;
    }

    public void formatOutput() {
        double sumResult = sumData.getSumData();
        boolean isInteger = sumResult == (int) sumResult;
        if (isInteger) {
            System.out.println("결과 : " + (int) sumResult);
            return;
        }
        System.out.println("결과 : " + sumResult);
    }
}