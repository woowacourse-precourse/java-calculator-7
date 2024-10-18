package calculator;

public abstract class RegexCheck {
  private static final String SORT = "^//[^0-9\\\\n]\\\\n([^\\\\n]+)$";
  protected String input;
  private String strNumber;
  private String sort = ",:";

  protected int[] numbers;

  RegexCheck(String input) {
    this.input = input;
  }

  public void setSort(String sort) {
    this.sort = sort;
  }

  public String getStrNumber(){
    return strNumber;
  }

  private String getRegex(){
    return "^[" + sort + "]?[1-9][0-9]*([" + sort + "][1-9][0-9]*)*$";
  }

  public Boolean isSort() {
    return input.matches(SORT);
  }

  public Boolean isBasic() {
    return input.matches(getRegex());
  }

  public void sortCheck(String input) {
    String[] split = input.split("\\\\n");
    String strSort = split[0];
    strNumber = split[1];
    setSort(String.valueOf(strSort.charAt(2)));
    String regex = getRegex();
    if(strNumber.matches(regex)){
      intChange(strNumber.split(sort));
    }else{
      throw new IllegalArgumentException("지정 구분자로 숫자를 구분해주세요");
    };
  }

  public void intChange(String[] args){
    numbers = new int[args.length];
    for(int i=0;i<args.length;i++){
      numbers[i] = Integer.parseInt(args[i]);
    }
  }



}
