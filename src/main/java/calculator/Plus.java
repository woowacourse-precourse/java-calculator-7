package calculator;

public class Plus {
    public int convertToInteger(String str) {
        return Integer.parseInt(str);
    }

    public int plus(String[] lst) {
        int result = 0;

        for (int i = 0; i < lst.length; i++) {
            result += convertToInteger(lst[i]);
        }

        return result;
    }
}
