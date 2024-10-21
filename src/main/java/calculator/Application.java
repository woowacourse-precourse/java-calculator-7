package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    //문자열을 구분자로 구분하여 합을 구하는 메서드
    public static int SplitSum(String str){
        int sum = 0;
        int arrIndex = 0;
        String intStr = "";

        //빈문자열일 경우 0 반환
        if(str.isEmpty()){
            return 0;
        //커스텀 구분자일 경우
        }else if(str.startsWith("//")){
            char sep = str.charAt(2);
            str = str.substring(5);

            for (int i = 0; i < str.length(); i++){
                if(str.charAt(i)==sep){
                    //구분자로 나눈 값 숫자로 변환하여 더하기
                    intStr = str.substring(arrIndex, i);
                    if(intStr.isEmpty() || strToNum(intStr)== -1){
                        //잘못된 입력일 경우 -1 반환
                        return -1;
                    }else{
                        sum += strToNum(intStr);
                    }
                    arrIndex = i + 1;
                }
            }
            //구분된 문자열 중 맨 마지막 문자열 포함
            intStr = str.substring(arrIndex);
            sum += strToNum(intStr);
        // 쉼표 또는 세미콜론일 경우
        }else{
            for (int i = 0; i < str.length(); i++){
                if(str.charAt(i)==',' || str.charAt(i)==':'){
                    //구분자로 나눈 값 숫자로 변환하여 더하기
                    intStr = str.substring(arrIndex, i);
                    if(intStr.isEmpty() || strToNum(intStr)== -1){
                        //잘못된 입력일 경우 -1 반환
                        return -1;
                    }else{
                        sum += strToNum(intStr);
                    }
                    arrIndex = i + 1;
                }
            }
            //구분된 문자열 중 맨 마지막 문자열 포함
            intStr = str.substring(arrIndex);
            sum += strToNum(intStr);
        }
        return sum;
    }

    //문자열 -> 숫자 변환
    public static int strToNum(String str){
        String intStr = "";
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(48 <= ch && ch <=57){
                intStr += ch;
            }else{
                //숫자가 아닐 경우 -1 반환
                return -1;
            }
        }
        //숫자로 반환
        return Integer.parseInt(intStr);
    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        //IllegalArgumentException 예외처리를 위한 try~catch 구문
        try{
            //문자열 입력
            String str = Console.readLine();
            //SplitSum 메서드 사용하여 result에 값 저장
            int result = SplitSum(str);
            //-1 값 반환한 경우
            if(result == -1){
                throw new IllegalArgumentException("잘못된 입력");
            }else{
                System.out.println(result);
            }
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
