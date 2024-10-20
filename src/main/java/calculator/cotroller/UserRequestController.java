package calculator.cotroller;

import calculator.view.UserViewResponse;

public class UserRequestController {
    public static void isIllegalArgumentElement(){
        UserViewResponse.errorMessage();
    }
    public static void requestView(int res){
        UserViewResponse.showResult(String.valueOf(res));
    }
}
