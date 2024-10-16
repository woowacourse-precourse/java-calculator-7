package calculator;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.isDigit;

public class Tokenization {
    String str;
    List<Integer> numberlist;
    List<Character> characterfordivide;
    boolean isOkay = true;

    public Tokenization(String str) {
        this.str = str;
        numberlist = new ArrayList<Integer>();
        characterfordivide = new ArrayList<Character>();
        characterfordivide.add(',');
        characterfordivide.add(':');
    }

    public void AddNewCharacterfordivide(char newone) {
        characterfordivide.add(newone);
    }

    public List<Integer> tokenize() {
        int temp = 0;
        boolean addingnewcharactrefordivision = false;
        for(int i = 0; i < str.length(); i++) {
            if(isDigit(str.charAt(i))) {
                temp = temp * 10 + str.charAt(i) - '0';
            }
            else {
                if(temp == 0)
                    continue;
                else
                    numberlist.add(temp);
                temp = 0;
                if(characterfordivide.contains(str.charAt(i))) {
                    continue;
                }
                else if (str.charAt(i) == '/') {
                    if(i == str.length() - 1) {
                        isOkay = false;
                        break;
                    }
                    else if(str.charAt(i + 1) == '/') {
                        addingnewcharactrefordivision = true;
                        AddNewCharacterfordivide(str.charAt(i + 2));
                        i += 2;
                    }
                    else if(str.charAt(i + 1) == 'n' && addingnewcharactrefordivision) {
                        addingnewcharactrefordivision = false;
                    }
                    else {
                        isOkay = false;
                    }
                }
            }
        }

        if(!isOkay) {
            throw new IllegalArgumentException("잘못된 문자여이 입력되었습니다.");
        }

        numberlist.add(temp);
        return numberlist;
    }
}