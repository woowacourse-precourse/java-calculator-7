package calculator;

public abstract class RegexCheck {
  protected String sort = ",:";
  protected String regex = "^([1-9][0-9]*[" + sort + "]|[" + sort + "][1-9][0-9]*)+$";
  private static final String SORT = "^//[^0-9\\\\n]\\\\n([^\\\\n]+)$";
  private String strNumber;
  private String strSort;
  private String input;
  protected int[] numbers;
  RegexCheck(String input) {
    this.input = input;
  }

  public Boolean isSort() {
    return input.matches(SORT);
  }

  public Boolean isBasic() {
    return input.matches(regex);
  }

  public void sortCheck(String input) {
    String[] split = input.split("\\\\n");
    strSort = split[0];
    strNumber = split[1];
    sort=String.valueOf(strSort.charAt(2));
    if(strNumber.matches(regex)){
      intChange(strNumber.split(sort));
    }else{
      throw new IllegalArgumentException("지정 구분자로 숫자를 구분해주세요");
    };
  }

  public int[] intChange(String[] args){
    numbers = new int[args.length];
    for(String num : args){
      numbers[Integer.parseInt(num)]++;
    }
    return numbers;
  }



}
