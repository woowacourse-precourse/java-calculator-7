package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Scanner;

/*class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}*/
public class ApplicationTest {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("덧셈할 문자열을 입력해주세요: ");
		String str = sc.nextLine();
		String[] arraystr = str.split("[;,]");
		int sum = 0;

		for(int i=0;i<arraystr.length;i++){
				int num = Integer.parseInt(arraystr[i]);
				if(num < 0) {
					throw new IllegalArgumentException(); 
				}
				else {

					sum += num;
				}
				
		}
		System.out.println(sum);
 	}
}
