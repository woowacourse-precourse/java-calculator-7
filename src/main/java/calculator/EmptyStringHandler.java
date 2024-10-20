package calculator;

public class EmptyStringHandler {
    public boolean isEmptyString(String[] seperatedNumbers) {
        return seperatedNumbers.length == 1 && seperatedNumbers[0].isEmpty();
    }
}
