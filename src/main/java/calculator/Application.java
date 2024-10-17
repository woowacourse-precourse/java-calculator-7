package calculator;


import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static void main(String[] args) {

        String inputString = readLine();

        if(!checkEmpty(inputString)){
            return;
        }
    }

    static boolean checkEmpty(String string){
        try {
            if(string == null || string.trim().equals("")){
                throw new IllegalArgumentException("IllegalArgumentException 발생");
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    static void checkCustom(String string){ // 구분자 표시 : //(구분자)\n

    }
}
