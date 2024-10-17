# java-calculator-precourse

## 문제해석 및 설계
사용자에게 입력받는 문자열을 구분자 파싱을 통한 덧셈 코드 작성 

1. 구분자 ( , ), ( : ) if , or :
    
    구분자 기준으로 문자열 자르기
    
    저장된 문자 정수 확인
    
    공백은 0으로 간주 
    
    파싱된 모든 정수 더하기 
    
2. 사용자 입력 커스텀 구분자 추가 
    
    ( //<Separator>\n<Number1><Separator><Number2><Separator><Number3> )
    
    커스텀 구분자를 인식하는 문자 패턴 생성 Start String ( // ) EndString ( \n ) 포함 확인
    
    확인된 커스텀 구분자 기준으로 문자열을 자르기
    
    1번 루틴으로 이동 
    
3. 잘못 입력된 경우 예외처리<IllegaIArgumentException>후 애플리케이션 종료
    
     정수범위가 아닐 경우 예외처리로 애플리케이션 종료
    
     정수판단 함수 isDigit(), isNumeric() 판단
    
     정규표현식 함수 matches() 판단
    
4. 예외상황
    
    최대 N자릿수 정수 처리 방법 > integer array 사용으로 고려할 필요 없음
    
    실수처리 > round() 반올림 처리 
    
    커스텀 구분자 문자열 체크  > 정규표현식 사용으로 Start와 End String 체크
    
    객체화 > 중복되는 코드 통일

## 주요기능
