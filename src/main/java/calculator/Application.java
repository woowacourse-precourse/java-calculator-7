package calculator;
import java.util.*;

public class Application {
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
