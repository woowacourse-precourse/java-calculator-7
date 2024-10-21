# java-calculator-precourse

### Step1 : 덧셈 계산 기능
* Integer형 List를 매개변수로 받는 함수. 반환형은 int
* 결과를 확인하는 기능

### Step2 : 문자열에서 기본 구분자로 된 구분된 숫자를 읽어오는 기능
* 사용자에게 문자열을 입력 받는 기능
* Character형 List를 구분자 charset으로 보고 이를 매개변수로 받는 함수. 반환형은 Integer형 List
* 커스텀 구분자가 들어오는 자리 없이 "숫자,숫자;숫자" 와 같은 형식임을 가정
* 숫자가 양수임을 검사하는 기능

### Step3 : 문자열에서 커스텀 구분자를 읽어 오는 기능 추가
* 입력은 문자열, 반환형은 Character형 List (구분자 charset)
* 읽는 도중 잘못된 형식 ex) //1;2;3, \n1;2;3인 경우 예외처리 기능
* 읽는 도중 기본 구분자 발견 시 예외처리 기능
