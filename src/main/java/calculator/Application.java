package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputValue="";
        try{
            inputValue = Console.readLine().strip();
        } catch (RuntimeException e) { }

        int sum = 0;

        if(!inputValue.isEmpty()){
            try{
                String[] delimiterAndSplitStr = checkDelimiter(inputValue);

                for(String value : delimiterAndSplitStr[1].split(delimiterAndSplitStr[0])){
                    if(!value.isEmpty()) {
                        sum += checkValueCorrect(value);
                    }
                }
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage()+"-".repeat(58)+"\n" +
                        "프로그램을 종료합니다.\n");
                throw new IllegalArgumentException();
            }
        }

        System.out.printf("결과 : %d\n", sum);
    }

    private static String[] checkDelimiter(String inputValue){
        String[] res = {",|:", inputValue};

        if(inputValue.contains("//") && inputValue.contains("\\n")){
            int slashIdx = inputValue.indexOf("//");
            int newLineIdx = inputValue.indexOf("\\n");

            if(slashIdx!=0 || slashIdx>newLineIdx || newLineIdx-slashIdx>3){
                throw new IllegalArgumentException("-".repeat(58)+"\n" +
                        "커스텀 구분자 지정시, 아래의 형식에 맞게 입력해 주세요.\n" +
                        "➣ 문자열의 맨 앞에 지정해 주어야 합니다.\n" +
                        "➣ [ //구분자\\n ]를 순서를 지켜 지정해 주어야 합니다.\n" +
                        "➣ 커스텀 문자는 한 글자여야 합니다.\n");
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
        }catch (Exception e){
            throw new IllegalArgumentException("-".repeat(58)+"\n" +
                    "정수로 변환할 수 없는 값이 감지되었습니다. 아래의 형식에 맞게 입력해 주세요.\n" +
                    "➣ 커스텀 구분자 지정시, //와 \\n를 모두 사용하며 순서를 지켜야 합니다.\n" +
                    "➣ 구분자를 제외한 모든 문자는 양수인 정수여야 합니다.\n");
        }

        if(intValue < 0) {
            throw new IllegalArgumentException("-".repeat(58)+"\n" +
                    "음수를 입력하였습니다. 양수인 정수를 입력해 주세요.\n");
        }

        return intValue;
    }
}
