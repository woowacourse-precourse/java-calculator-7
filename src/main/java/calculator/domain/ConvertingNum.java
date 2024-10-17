package calculator.domain;

import calculator.exception.InvalidInputException;

public class ConvertingNum {
    public int[] convertNums(String[] str){
        int[] nums = new int[str.length];

        for(int i=0; i<str.length;i++){
            nums[i] = convertNum(str[i]);
            if(nums[i] < 0){
                throw new InvalidInputException("음수를 제외하고 입력해주세요. ➣ " + nums[i]);
            }
        }
        return nums;
    }

    // 문자열을 정수로 변환
    public int convertNum(String str){
        try{
            return Integer.parseInt(str);
        }catch(NumberFormatException e) {
            throw new InvalidInputException("잘못된 숫자 형식입니다. ➣ " +str);
        }
    }
}
