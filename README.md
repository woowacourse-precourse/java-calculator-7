# java-calculator-precourse

기능 상세

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열의 경우 구분자를 기준으로 분리한 각 숫자를 공백으로 구분하여 반환해야 한다.
    
    예시 )| "" => 0 | "1,2" => 1 2 | "1,2,3" => 1 2 3 | "1,2:3" => 1 2 3 |
    숫자가 2자리를 넘으면 숫자 간 구분이 안됨
  
- "//" 와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용할 수 있다.
    
    예시 ) "//;\n1;2;3" 커스텀 구분자 = 세미콜론(;) 이고 결과 값 = 6
    
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 예외 발생 후 종료
    - 구분자를 기준으로 분리해야 하는데 구분자가 연속 2개 나온다면.. "1,,2"
    - 구분자를 기준으로 왼쪽 오른쪽에는 숫자가 있어야 하는데, 오른쪽에 숫자가 없거나 왼쪽에 숫자가 없거나...
      예시) "1,"
    - 구분자가 아닌 것이 문자열에 있다.. 
    - 양수만을 입력하도록 돼있는데, 음수가 나온다면..
      
`고민해봐야 할 점`

- 문자열인데 공백이 포함되어 있는 경우 공백을 없애야 하는지? 예외 처리를 해야 하는지?
    - 예시) “1,2  ,3 “
    - 예외처리를 해야 하는 쪽으로 기운다..

- //;az\n 이런 경우는 없는 건가? 아니면 //; a z \n 인 경우는 나올 수가 있나?
  - 그니까 “//” 과 “\n” 사이에는 문자 1개만 올 수 있는 건가? 만약 //abc\n이면 abc가 구분자인가?
  - 예외처리를 해야 하는 쪽으로 기운다..
      
- 계산기이기때문에 덧셈만 생각하는 게 아니고, 나눗셈 뺄셈을 고려한다면 어떤 식으로 구조를 만들어야 요구사항 변경에 최소화로 변화하는지?
  
- ~도중에 구분자로 구분된 숫자 사이에 연산자가 각각 다르게 바뀐다면?~
