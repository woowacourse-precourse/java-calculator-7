package calculator;


public class StringHandler {

    public int checkString(String str) {

        CalculateString calculateString = new CalculateString();
        if (str.trim().isEmpty()) {
            return 0;
        }
        if (str.startsWith("//")) {
            return calculateString.customString(str);

        } else {
            return calculateString.basicString(str);
        }

    }

}
