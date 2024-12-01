package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public List<Integer> readString() {
        Scanner sc = new Scanner(System.in);

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = sc.nextLine();

        // , 또는 :을 구분자로 가지는지

        // //와 \n 사이에 커스텀 구분자가 있는지

        // 구분자로 split한 문자들이 숫자 문자인지

        return new ArrayList<>();
    }
}
