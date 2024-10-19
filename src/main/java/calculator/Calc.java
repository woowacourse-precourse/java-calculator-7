package calculator;


public class Calc {
    public int calculate(String s, String determine) {
        int sum = 0;

        if (s.isBlank()){ // 공백일 경우 [] 리턴
            return sum;

        } else if (s.length() == 1) { // 숫자가 하나만 입력 될 경우
            return Integer.parseInt(s);

        }else{
            String[] inputArr = s.split(determine);
            for(String c : inputArr){

                sum += Integer.parseInt(c);
                }
            }

            return sum;
        }
    }

