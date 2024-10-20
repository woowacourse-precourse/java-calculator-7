# java-calculator-precourse


### 0. 초기 설정
    Separator 클래스로 구분자 관리
    기본 구분자 [,],[:] 저장
    hashSet 이용

   
### 1. 사용자 입력 - IOController.input()
    "덧셈할 문자열을 입력해 주세요.\n"
    string = readline()

   
### 2. 사용자 입력 분할 - InputStructure
    { 커스텀 구분자, 연산식 }으로 분할
    커스텀 구분자는 단 한글자 또는 0글자로 주어진다고 가정
     [//]와[\n] 사이에 문자가 없을 수 있음


### 3. 커스텀 구분자 저장 - Separator.addSeparator()
    　

### 4. 연산식 오류 확인 - Validator.validateFormula()
    * IllegalArgumentException
     - 숫자와 구분자를 제외한 문자가 등장하는 경우
     - 구분자가 연속으로 등장하는 경우
     - 연산식의 처음과 끝에 구분자가 입력되는 경우 


### 5. 구분자를 기준으로 연산식 분할 - Parser.inputParse()
    return Array<BigInteger>
    입력 숫자의 범위가 명시되어있지 않으므로 충분히 큰 수가 입력될 수 있음을 가정


### 6. 덧셈 진행
    calculator.adder()


### 7. 답 출력 - IOController.printAnswer()
    "결과 : " + ans


