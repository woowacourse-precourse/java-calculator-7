package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class ExtractionData {
    static final private List<String> Separators= new ArrayList<>();;

    public ExtractionData(){
        //this.customSeparators.add("//");
        //this.customSeparators.add("\\n");
        this.Separators.add(":");
        this.Separators.add(",");
    }
    public List<String> getSeparators(){
        return Separators;
    }

    public void setSeparators(String separator){
        Separators.add(separator);
    }


}
