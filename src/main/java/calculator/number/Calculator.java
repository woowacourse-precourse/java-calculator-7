package calculator.number;

public class Calculator {
    private final StringNumber stringNumber;

    public Calculator(StringNumber stringNumber) {
        this.stringNumber = stringNumber;
    }

    public void temporarySaveNumber(Character c) {
        stringNumber.temporarySave(c);
    }

    public void saveNumber() {
        stringNumber.save();
    }

    public Number getTotal() {
        saveNumber();
        return stringNumber.getNumber();
    }
}
