package calculator;

public class Calculator {

    public int sumResult(String[] filteredString) {
        int sum = 0;

        try {
            for(int i = 0; i<=filteredString.length-1; i++) {
                if(Integer.parseInt(filteredString[i])< 0) {
                    throw new IllegalArgumentException("음수는 사용할 수 없습니다.");
                }
                sum += Integer.parseInt(filteredString[i]);
            }
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 형식입니다.");
        }
        return sum;
    }




}
