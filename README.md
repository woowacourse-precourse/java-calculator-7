# 문자열 덧셈 계산기

### 1. 사용자 입력을 받아 처리하는 함수

   str: 문자열을 입력받는다.
    
   input[]: \n을 기준으로 쪼개 input[0]은 "//커스텀 문자열", input[1]은 "커스텀 구분자 및 숫자가 담겨있는 문자열"을 받는다.
   
   dividedIntoBasic[]: input[1]을 기본 구분자로 쪼개어 나눠 받는다.
   
   custom: input[0]에서 커스텀 구분자 추출.
   
   regesChar: 이스케이프 처리가 필요한 특수기호들.
   
   sb: stringBuilder로 동적 문자열로 받기. 만일 커스텀 문자열이 이스케이프 처리가 필요한 특수기호가 담겨있다면 이스케이프 처리하여 추가하기.
   
   DividedIntoCustom[]: 커스텀 구분자가 담긴 문자열을 쪼개기.
   
   sum: 숫자로 이뤄진 문자열들을 int 타입으로 바꿔 더한다.
   
   
### 2. 입력값 검증 로직 구현

   입력 값이 //n.?\n12,3;5n.1 이면 커스텀 문자열은 "n.?"이지 각각의 문자가 아니기 때문에 IllegalArgumentException 발생시킨다.
   
   입력 값이 //??\n15,7??2;1 이면 커스텀 문자열은 "??"로 이스케이프 처리시켜 "//?//?"가 들어가도록 하였다. 문제 없이 25 출력
   
### 3. 처리된 결과를 출력하는 함수 작성
   Integer.parseInt(쪼개고 남은 숫자를 담고 있는 배열)의 숫자 데이터를 sum에 합산시킨다.
   
     for(int i =0;i<dividedIntoBasic.length;i++){
   
            String dividedIntoCustom[] = dividedIntoBasic[i].split(sb.toString());
            
            for(String answer: dividedIntoCustom){
            
               sum += Integer.parseInt(answer);
               
               System.out.println(answer+ " ");
               
            }
            
         }
         
    }
    
### 4. 오류 처리 기능 추가
   커스텀 구분자가 필요할 때 //와 \n이 제대로 있는지 확인하여 만약 없다면 IllegalArgumentException 발생시킨다.
   
   쪼개진 숫자들을 더할 때 만약 숫자가 아닌 기호나 문자가 존재한다면 IllegalArgumentException 발생시킨다.
