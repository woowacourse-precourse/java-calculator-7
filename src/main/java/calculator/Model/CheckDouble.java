package calculator.Model;

public class CheckDouble {
    public Number checkDecimalPoint(String input){
        Calculate calc = new Calculate();

        double doubleNum = calc.plusNum(input);

        if (doubleNum % 1 != 0){
            return doubleNum;
        }
        else{
            return (long) doubleNum;
        }
    }
}
