package view;

public class UserOutputView {

    public void printUserOutput(String userInput){
        if(userInput.equals("0")) {
            System.out.println("사용자가 아무 값도 입력하지 않았습니다.");
            return;
        }
        System.out.println("사용자가 입력한 값 : " + userInput);
    }

    public void printTokens(String[] tokens){
        for(String token : tokens){
            System.out.print(token + " ");
        }
    }


}
