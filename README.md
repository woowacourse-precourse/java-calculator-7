# java-calculator-precourse


**기능 목록 단위**

커스텀 구분자 추출

- CusTomDelimiterParser 클래스 생성
  구분자 문법에 맞는지 확인, 아니라면 예외처리
  패턴이 일치하는지 확인하고, 커스텀 구분자 반환
  구분자를 이용하여 문자열을 split으로 나눈 뒤 배열에 저장

- StringSplitter 클래스 생성
  커스텀 구분자가 있을 때와 없을 때 두 개의 메소드 생성( splitWithCustomDelimiter, splitWithDefaultDelimiter)
  구분자를 이용하여 문자열을 numberList[]로 저장
  양수가 아닌 다른 숫자나, 문자가 왔을 때 예외처리
  메인 클래스에서 커스텀 구분자가 있는지, 없는지에 따라 if문을 이용하여 numberList 받아오기
  StringSplitter클래스에서 생성한 numberList를 for문을 이용해 총 합 계산

- ArraySumCalculator 클래스 생성
  result 값을 메인에 리턴 후 출력
