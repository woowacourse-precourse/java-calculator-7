package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
       System.out.println("덧셈할 문자열을 입력해 주세요");
        String input = Console.readLine();
        try {
            int result = plus(input);
            System.out.printf("결과: %d%n", result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int plus(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        int sum = 0;
        String separator = "";
        if(Character.isDigit(input.charAt(0))) {
        	separator = "[,:]";  
        	
        }
        else if(input.startsWith("//")) {
            separator = input.substring(2, input.indexOf("\\n"));
            input = input.substring(input.indexOf("\\n")+2);
         }else {
     		throw new IllegalArgumentException();
     	}

         
         String[] answer = input.split(separator);
         for (int i = 0; i < answer.length; i++) {
             try {
                 if (answer[i] == null || answer[i].isEmpty()) {
                	 sum+=0;
                  } else if(Integer.parseInt(answer[i]) >= 0){
                	  sum += Integer.parseInt(answer[i]);
                  }else {
                      throw new IllegalArgumentException("잘못된 입력값이 있습니다: " + answer[i]);
                  }
              } catch (NumberFormatException e) {
                  throw new IllegalArgumentException("잘못된 입력값이 있습니다: " + answer[i]);
              }
         }
         return sum;

    }
}