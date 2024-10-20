package calculator;

public class Output {
    public void formatOutput(SumData sumData) {
        double sumResult = sumData.getSumData();
        boolean isInteger = false;

        if (sumResult == (int) sumResult) {
            isInteger = true;
        }
        if (isInteger) {
            sumResult = (int) sumResult;
        }
        System.out.println("결과 : " + sumResult);
    }
}