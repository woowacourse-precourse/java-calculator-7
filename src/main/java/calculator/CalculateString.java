package calculator;

public class CalculateString {


    public int customString(String str) {
        int endCheck = str.indexOf("\\n");
        if (endCheck == -1) {
            return basicString(str);
        }

        String userCustom = String.valueOf(str.charAt(2));
        String inputString = str.substring(endCheck + 2).trim();

        int finalValue = calString(inputString, userCustom);
        if (finalValue == 0) {
            return 0;
        }
        return finalValue;
    }

    public int basicString(String str) {
        int finalValue = calString(str, "[;,]");
        if (finalValue == 0) {
            return 0;
        }
        return finalValue;

    }

    public int calString(String str, String delimeters) {
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
