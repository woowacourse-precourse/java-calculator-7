package calculator;

import java.util.Arrays;
import java.util.HashSet;

public class Separator {
    final private HashSet<Character> separatorSet = new HashSet<>();


    public Separator(Character... separators){
        separatorSet.addAll(Arrays.asList(separators));
    }

    public void addSeparator(Character c){
        separatorSet.add(c);
    }

    public boolean isSeparator(Character c){
        return separatorSet.contains(c);
    }

}
