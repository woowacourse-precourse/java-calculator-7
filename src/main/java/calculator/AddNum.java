package calculator;

public class AddNum {
    int add(String[] numList) {
        int answer = 0;
        for (String num : numList) {
            answer += Integer.parseInt(num);
        }
        return answer;
    }
}
