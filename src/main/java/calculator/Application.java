package calculator;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Application {
    public String getInput(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = scanner.nextLine();

        return input;
    }

    public Set<String> separatorCheck(String input){
        Set<String> separator=new HashSet<>();
        separator.add(",");
        separator.add(":");
        if (input.startsWith("//")){
            int delimiterIndex = input.indexOf("\\n");
            String customDelimiter = input.substring(2, delimiterIndex);
            separator.add(customDelimiter);
        }
        return separator;
    }



    public static void main(String[] args) {

        Application application=new Application();
        String input= application.getInput();
        Set<String>separator=application.separatorCheck(input);
//        int result=application.sum(input,separator);







        // TODO: 프로그램 구현
    }
}
