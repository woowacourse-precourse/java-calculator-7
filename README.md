# java-calculator-precourse

#### 구현 기능 목록

- "덧셈할 문자열을 입력해 주세요.\n"을 출력하고, 입력 받는 기능

- 입력된 String을  List<Long>으로 변환하고, 예외처리
  
  - 문자열을 파싱해 더해야될 숫자 추출하는 기능
  
  - 입력 시 커스텀 구분자가 있는지 validation하는 기능
  - 문자열이 잘못된 문자열인지 validation하는 기능
  - 추출한 숫자가 long의 범위 안의 수로 구성되어 있는지 validation 하는 기능
  - 추출한 숫자에 음수, 0가 존재하는지 validation하는 기능
  
- 계산기 기능

  - 들어온 리스트의 모든 요소를 더하는 기능
  - 모든 요소를 더한 값인 sum이 long의 범위보다 커졌을 때 에러 처리하는 기능

- 만약 validation을 통과하지 못했다면 에러 메시지 출력 후 종료

- 모든 validation을 통과했다면 "결과 : " + sum 출력 