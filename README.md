# 우아한테크코스 프리코스 1주차 : 문자열덧셈계산기

<br>

## 주요 목표

1. 많이 부족하지만 간단하게나마 객체지향의 장점을 활용해보려고 시도했습니다 (레코드 클래스).
2. 기능 요구 사항을 여러번 꼼꼼하게 읽으면서 놓친 부분이 있지 않은지, 요구사항과 다른 부분이 있지 않은지 확인하고 테스트했습니다.
3. 코드를 보는 다른 분들이 쉽게 이해할 수 있도록 작성하려고 노력했습니다.
   <br>

## 구현할 기능 목록

1. 올바른 문자열을 받았을때 쉼표(,) 또는 콜론(:)을 기준으로 분리한 순자의 합을 반환
2. "//"와 "\n"사이에 위치하는 커스텀 구분자 기능
3. 잘못된 값을 입력하는 경우 IllegalArgumentException 발생
   <br>

## 체크리스트

- [x] 사용자 입력 받기 (`camp.nextstep.edu.missionutils.Console.readLine()`)
- [x] scanner 적절하게 닫기 (`camp.nextstep.edu.missionutils.Console.close()`)


- [x] 구분자 기능 구현
    - [x] //와 \n 사이의 텍스트 뽑아내기 (`getCustomDelimiters()`로 자른 후, `InputSliceResult` 레코드 클래스에 저장 )
    - [x] 받은 구분자에 대한 적절한 이스케이프 문자 처리 (`Pattern.quote()`)


- [x] Exception 처리
    - [x] 음수나 0이 들어왔을때
    - [x] NumberFormatException
    - [x] ArrayIndexOutOfBoundsException


- [x] 특수한 경우
    - [x] 빈 문자열 ""이 들어왔을때 0을 반환
    - [x] 소수(decimals)가 들어왔을때를 위해 BigDecimal로 계산


