package calculator;

public class CalculateString {


    public int customString(String str) {
        int endCheck = str.indexOf("\\n");
        if (endCheck == -1) {
            return basicString(str);
        }

        String userCustomDel = str.substring(2, endCheck);
        String inputString = str.substring(endCheck + 2).trim();

        int finalValue = calString(inputString, userCustomDel);
        if (finalValue == 0) {
            return 0;
        }
        return finalValue;
    }

    public int basicString(String str) {
        int finalValue = calString(str, "[:,]");
        if (finalValue == 0) {
            return 0;
        }
        return finalValue;

    }

    public int calString(String str, String delimeters) {
        if (delimeters.equals(".")) {
            delimeters = delimeters.replace(".", "\\.");
        }

        String[] splitString = str.trim().split(delimeters);

        if (splitString.length == 0) {
            return 0;
        }

        int total = 0;
        for (int i = 0; i < splitString.length; i++) {
            if (Integer.parseInt(splitString[i]) < 0) {
                throw new IllegalArgumentException("값을 잘못 입력하셨습니다.");
            }
            total += Integer.parseInt(splitString[i].trim());
        }

        return total;
    }


}



