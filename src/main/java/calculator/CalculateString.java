package calculator;

public class CalculateString {

    public int basicString(String str) {
        int finalValue = calString(str, "[;,]");
        if (finalValue == 0) {
            return 0;
        }
        return finalValue;

    }

    public int calString(String str, String delimeters) {
        String[] splitString = str.trim().split(delimeters);
        
        int total = 0;
        for (int i = 0; i < splitString.length; i++) {
            total += Integer.parseInt(splitString[i].trim());
        }

        return total;
    }


}
