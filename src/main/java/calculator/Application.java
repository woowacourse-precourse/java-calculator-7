package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static String inputLine(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public static String[] separateString(String line){
        if(line.startsWith("//")){
            String[] parts = line.split("\\\\n"); //\n으로 구분

            String separator = parts[0].replace("//","");
            separator += ",:"; //기본 문자열 추가

            return new String[]{separator, parts[1]};
        }
        return new String[]{",:", line};
    }

    public static void main(String[] args){
        String line= inputLine();
        String[] separatorAndOperation = separateString(line);
    }
}
