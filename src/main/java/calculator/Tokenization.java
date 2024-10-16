package calculator;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.isDigit;

public class Tokenization {
    String str;
    List<Integer> numberlist;
    List<Character> characterfordivide;
    List<Character> problemcharacter;
    boolean isOkay = true;

    public Tokenization(String str) {
        this.str = str;
        numberlist = new ArrayList<Integer>();
        characterfordivide = new ArrayList<Character>();
        characterfordivide.add(',');
        characterfordivide.add(':');
        problemcharacter = new ArrayList<Character>();
    }

    public void AddNewCharacterfordivide(char newone) {
        if(problemcharacter.contains(newone)) {
            problemcharacter.remove(newone);
        }
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
                if(temp != 0) {
                    numberlist.add(temp);
                    temp = 0;
                }

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
                        if(i == str.length() - 1) break;
                    }
                    else if(str.charAt(i + 1) == 'n' && addingnewcharactrefordivision) {
                        addingnewcharactrefordivision = false;
                        i += 1;
                    }
                    else {
                        isOkay = false;
                    }
                }
                else if(addingnewcharactrefordivision)
                    AddNewCharacterfordivide(str.charAt(i));
                else {
                    if(problemcharacter.contains(str.charAt(i)))
                        continue;
                    else
                        problemcharacter.add(str.charAt(i));
                    isOkay = false;
                }
            }
        }

        if(!isOkay || problemcharacter.size() != 0) {
            throw new IllegalArgumentException("잘못된 문자열이 입력되었습니다.");
        }

        numberlist.add(temp);
        return numberlist;
    }
}