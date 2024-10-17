# java-calculator-precourse


0. 초기화
   * 기본 구분자 [,],[:] 저장
   * 어떤 자료형을 사용할 지 hashSet vs vector
     * 해싱 오버헤드 vs 배열순회
     * 일단 해시셋으로

   
1. 사용자 입력
   * "덧셈할 문자열을 입력해 주세요.\n"
   * string = readline()

   
2. 입력 오류 확인
   * 커스텀 구분자가 입력될 경우 토큰 저장 
   * IllegalArgumentException
     * 문자열 시작이 [//]인데 [\n]이 나오지 않는 경우
     * 숫자와 구분자를 제외한 문자가 등장한 경우 
   * 입력받는 숫자는 int 범위 내인가?
   * 입력받는 숫자는 음수를 포함하는가?
     * 테스트 보니까 음수 입력 안되는 듯? 


3. 토큰 별로 분할
   * return Vector\<int\>
   * 문자열 초반 커스텀 구분자 입력은 무시


4. 덧셈 진행
   * Integer Overflow 확인해주기


5. 값 출력
   * "결과 : " + ans
