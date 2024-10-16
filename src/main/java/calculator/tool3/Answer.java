package calculator.tool3;

public class Answer {

  private long[] nums;

  public long calSum() {
    long sum = 0;
    for (long num : this.nums) {
      sum += num;
    }
    return sum;
  }

  public void printAns(){
    System.out.println("결과 : " + this.calSum());
  }

  public Answer(long[] nums) {
    this.nums = nums;
  }

}
