package calculator.view;

public class UserViewResponse {

    public static void errorMessage() {
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    public static void showResult(String res){
        System.out.println("결과 : "+res);
    }
}
