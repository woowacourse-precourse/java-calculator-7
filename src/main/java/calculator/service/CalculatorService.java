package calculator.service;

import calculator.Model.Input;

public class CalculatorService {

    /**
     * 사용자로부터 얻어온 String을 계산하는 로직
     */
    public Number calculate(Input input){
        double sum = input.sum();
        return checkInteger(sum);
    }

    /**
     * 합계가 정수형인지 실수형인지 판단
     */
    Number checkInteger(double sum){
        if(sum %1 ==0){
            return (int) sum;
        }
        else{
            return sum;
        }
    }


}




//        double sum =0.0; //총합
//
//        String[] cal;
//        String delim = "[,:]";
//
//        //커스텀 구분자 포함시
//        if(inputString.startsWith("//")){
//            int idx = inputString.indexOf("\\n"); // \n인덱스
//
//            if(idx == -1){
//                throw new IllegalStateException("\\n가 입력되지 않았습니다.");
//            }
//
//            // 커스텀 구분자 추출
//            String customDelimiter = inputString.substring(2, idx);
//
//            // 커스텀 구분자에 숫자가 포함되어 있는지 체크
//            if (customDelimiter.chars().anyMatch(Character::isDigit)) {
//                throw new IllegalStateException("구분자로 숫자는 사용할 수 없습니다.");
//            }
//
//            delim = Pattern.quote(inputString.substring(2, idx))+ "|,|:";
//            inputString = inputString.substring(idx + 2); // \n 이후 문자열
//
//        }
//
//        cal = inputString.split(delim);
//
//
//            try{
//                double number = Double.parseDouble(num);
//
//                if(number<0){
//                    throw new IllegalStateException("양수를 입력해주세요");
//                }
//                sum+=number;
//
//            }catch (NumberFormatException e){
//                throw new IllegalStateException("구분자로[: 혹은 ,]와 숫자로만 입력해주세요:");
//            }
//        }
//
//        //합계가 정수형인지 실수형인지 판단
//        if(sum %1 ==0){
//            return (int)sum;
//        }else{
//            return sum;