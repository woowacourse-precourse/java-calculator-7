package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String question = "";
        int answer = 0;
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        question = Console.readLine();
        Console.close();
        if(question.equals("")){
            System.out.println("결과 : " + 0);
            return;
        }
        if(!question.contains("//") || !question.contains("\\n")){
            answer = noCustom(question);
        }

        System.out.println("결과 : " + answer);
    }
    public static int noCustom(String question){
        String[] str = question.split("[,:]");
        int num = 0;
        for(int i = 0; i<str.length; i++){
            num += Integer.parseInt(str[i]);
        }
        return num;
    }


}