package calculator;

public class Calculator {


    public int result(String[] s) {
        int sum = 0;

        for(String number : s) {
            try{


                if(Integer.parseInt(number) < 0) {
                    throw new IllegalArgumentException("음수입니다.");
                }
                sum += Integer.parseInt(number);
            }catch(NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 형식의 값입니다." + Integer.parseInt(number));
            }
        }
        return sum;
    }
}
