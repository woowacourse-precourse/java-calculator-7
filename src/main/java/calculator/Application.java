package calculator;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public void calculator() {
        String splitor = ",|:";
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String inputString = readLine();
        if (inputString.startsWith("//")){
            String[] findDelim = inputString.split("\\\\n");
            String delimiter = findDelim[0].substring(2);
            inputString = inputString.substring(4+delimiter.length());
            splitor += "|" + delimiter;
        }

        String[] separatedInput = inputString.split(splitor);
        int sumValue = 0;
        for(int i=0; i<separatedInput.length;i++){
            try{
                sumValue += Integer.parseInt(separatedInput[i]);
            }catch(Exception e){
                throw new IllegalArgumentException();
            }
        }
        System.out.println(String.format("결과 : %d", sumValue));
    }
    public static void main(String[] args) {
        new Application().calculator();
    }
}
