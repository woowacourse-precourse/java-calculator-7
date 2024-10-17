package calculator.View;
import static calculator.Constants.ViewConstants.END;
public class OutputView {
    public static void userOutput(long result){
        System.out.println(END.getMessage() + result);
    }

}
