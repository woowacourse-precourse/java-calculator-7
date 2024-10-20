package calculator;

public class Calculator {
    private int total = 0;
    private String temporaryNumber = "";

    public void temporarySaveNumber(int number) {
        temporaryNumber += number;
    }

    public void saveNumber() {
        if (temporaryNumber.length() != 0) {
            total += Integer.parseInt(temporaryNumber);
            temporaryNumber = "";
        }
    }

    public int getTotal() {
        if (temporaryNumber.length() != 0) {
            saveNumber();
        }
        return total;
    }
}
