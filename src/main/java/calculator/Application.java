package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputValue = Console.readLine().strip(); // 스페이스를 제외한 모든 공백 관련 문자 제거

        int sum = 0;

        if(!inputValue.isEmpty()){
            try{
                String[] delimiterAndSplitStr = checkDelimiter(inputValue);

                for(String value : delimiterAndSplitStr[1].split(delimiterAndSplitStr[0])){
                    if(!value.equals("")) {
                        sum += checkValueCorrect(value);
                    }
                }
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage()+"프로그램을 종료합니다.");
                throw new IllegalArgumentException();
            }
        }

        System.out.printf("결과 : %d", sum);
    }

    private static String[] checkDelimiter(String inputValue){
        String[] res = {",|:", inputValue};

        if(inputValue.contains("//") && inputValue.contains("\\n")){
            int slashIdx = inputValue.indexOf("//");
            int newLineIdx = inputValue.indexOf("\\n");

            if(slashIdx!=0 || slashIdx>newLineIdx || newLineIdx-slashIdx>3){
                throw new IllegalArgumentException("커스텀 구분자가 문자열 앞부분의 //와 \\n 사이에 위치하는지, 또는 커스텀 문자가 두 글자 이상인지 확인이 필요합니다.\n");
            }

            res[0] += "|\\"+inputValue.substring(slashIdx+2,newLineIdx);
            res[1] = inputValue.substring(newLineIdx+2);
        }

        return res;
    }

    private static int checkValueCorrect(String value){
        int intValue;

        try {
            intValue = Integer.parseInt(value);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("정수가 아닌 입력이 감지되었습니다.\n");
        }

        if(intValue < 0) {
            throw new IllegalArgumentException("음수를 입력했습니다.\n");
        }

        return intValue;
    }
}
