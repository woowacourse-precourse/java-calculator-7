package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.stream.Stream;

public class Application {
    int answer = 0;
    public static void main(String[] args) {
        System.out.println(new Application().calculator());
    }

    public String calculator(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        if(input.startsWith("//")){
            // custom
            try {
                Stream.of(input.substring(5, input.length())
                                .split(String.valueOf(input.charAt(2))))
                        .forEach(e -> {
                            answer += Integer.valueOf(e);
                        });
            }catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }else{
            // defualt 정규식!!
            try {
                Stream.of(input.split("[,:]")).forEach(e -> {
                    answer += Integer.valueOf(e);
                });
            }catch (NumberFormatException e){
                throw new IllegalArgumentException();
            }
        }
        Console.close();
        return "answer : "+String.valueOf(answer);
    }
}