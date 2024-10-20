package calculator.service;

public class CalculatorService {

    /**
     * 사용자로부터 얻어온 String을 계산하는 로직
     */
    public Number calculate(String inputString){

        double sum =0.0; //총합

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
            try{
                double number = Double.parseDouble(num);

                if(number<0){
                    throw new IllegalStateException("양수를 입력해주세요");
                }
                sum+=number;

            }catch (NumberFormatException e){
                throw new IllegalStateException("구분자로[: 혹은 ,]와 숫자로만 입력해주세요:");
            }
        }

        //합계가 정수형인지 실수형인지 판단
        if(sum %1 ==0){
            return (int)sum;
        }else{
            return sum;

        }
    }
}
