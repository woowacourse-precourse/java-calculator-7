package model;

public class Calculator {

    public int operationAdd(String[] tokens){
        int result = 0;
        for (String token : tokens) {
            if (!token.trim().isEmpty()) {
                result += Integer.parseInt(token);
            }
        }
        return result;
    }
}
