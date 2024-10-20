package calculator.service;

public class CalculatorService {

    /**
     * 사용자로부터 얻어온 String을 계산하는 로직
     */
    public int calculate(String inputString){

        int sum =0;

        String[] cal;
        String delim = "[,:]";

        //커스텀 구분자 포함시
        if(inputString.startsWith("//")){
            int idx = inputString.indexOf("\\n"); // \n인덱스
            delim = inputString.substring(2, idx); //구분자
            inputString = inputString.substring(idx + 2); // \n 이후 문자열
        }

        cal = inputString.split(delim);

        for(String num : cal){
            sum += Integer.parseInt(num);
        }

        return sum;

    }
}
