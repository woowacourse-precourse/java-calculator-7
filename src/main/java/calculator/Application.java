package calculator;

import calculator.cotroller.UserApiController;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        UserApiController userApiController = new UserApiController();

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        final String strs = Console.readLine();
        userApiController.saveData(strs);  //controller로 이동

    }




}
