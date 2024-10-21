package Validate;

public class NumValidate {
    public int[] validate(String[] inputNum) {
        int[] num = new int [inputNum.length];
        for (int i = 0; i < inputNum.length; i++) {
            try{
                num[i] = Integer.parseInt(inputNum[i]);
            }catch(IllegalArgumentException e){
                System.out.println("수가 아닙니다.");
            }
            if(num[i] < 0) {
                throw new IllegalArgumentException("음수가 입력됐습니다.");
            }
        }
        return num;
    }
}
