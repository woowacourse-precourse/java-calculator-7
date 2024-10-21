package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    //문자열을 구분자로 구분하여 합을 구하는 메서드
    public static int SplitSum(String str){
        int sum = 0;
        int arrIndex = 0;
        String intStr = "";

        if(str.isEmpty()){
            return 0;
        }
        for (int i = 0; i < str.length(); i++){
            if(str.charAt(i)==',' || str.charAt(i)==':'){
                //구분자로 나눈 값 숫자로 변환하여 더하기
                intStr = str.substring(arrIndex, i);
                if(intStr.isEmpty() || strToNum(intStr)== -1){
                    return -1;
                }else{
                    sum += strToNum(intStr);
                }
                arrIndex = i + 1;
            }
        }
        intStr = str.substring(arrIndex);
        sum += strToNum(intStr);

        return sum;
    }

    public static int strToNum(String str){
        String intStr = "";
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(48 <= ch && ch <=57){
                intStr += ch;
            }else{
                return -1;
            }
        }
        return Integer.parseInt(intStr);
    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        //IllegalArgumentException 예외처리를 위한 try~catch 구문
        try{
            String str = Console.readLine();

            int result = SplitSum(str);
            if(result == -1){
                throw new IllegalArgumentException("잘못된 입력");
            }else{
                System.out.println(result);
            }
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("애플리케이션 종료");
        }
    }
}
