# CaveClicker
게임설명
=============
이 게임은 2019년 제가 고등학교 1학년때 2학기 프로그래밍 실습과목의 수행평가 자유 프로젝트로 제작했습니다.    
기본적으로 단순한 클리커 게임의 형식을 취하여 만들어졌으며, 상점과 퀘스트기능도 포함되어있습니다.    
javaFX를 이용해서 제작하였으며 당시 미숙한 흔적이 남아있으며 추후 계속 업데이트할예정입니다.    


기능소개
====================
1.로그인 Login
---------------------- 

![login](https://user-images.githubusercontent.com/55703253/105954558-2c650900-60b8-11eb-8891-e139d40ba75a.png)
처음 게임을 실행하면 로그인 화면이 나옵니다.  
이때의 UI는 라이엇게임즈에서 제작한  리그오브레전드의 로그인 UI를 참고했으며 리그오브레전드의 UI디자인이 머터리얼 테마였으면 어땠을까라는 생각으로 어두운 계열의 색으로 디자인 했습니다.    
로그인을 하기위해 회원가입버튼을 누르면 회원가입 폼이 옆에서 슬라이드 되듯이 날아오고
ID,PW,이름,전화번호,간단한 설명을 입력받고 회원가입을 진행합니다.
이러한 정보는 DB에 저장되며 PW같은 민감한 정보는 hash함수를 통해 암호화되어 저장됩니다.    
회원가입 도중 중복 ID나 특정값이 입력되지 않았다면 입력되지 않았다는 경고창이 뜨며 다시입력하게 됩니다.
이렇게 회원가입후 다시 로그인 화면으로 돌아가 로그인을 진행하면 게임에 입장할수있으며    
ID나 비밀번호를 틀린다면 역시 경고창이뜨며 다시 입력하게됩니다.

2.메인화면 mainPage
-------------------------

![main](https://user-images.githubusercontent.com/55703253/105954614-4868aa80-60b8-11eb-8876-75b0784ec38d.png)
메인화면에는 왼쪽에는 스테이지정보와 몬스터의 이름,오른편에는 상점과 퀘스트를 받으러 가는 곳이 있으며 중앙에는 해당 몬스터와 클릭버튼이 있습니다.    
몬스터에는 애니메이션이 적용되어있어 계속 움직이게 되어있고 가운데에 위치한 클릭버튼이나 스페이스버튼을 연타하여   
왼쪽에 표시되는 몬스터의 체력을 0으로 만들면 다음 스테이지로 넘어가는 방식으로 제작되었습니다.
![monster](https://user-images.githubusercontent.com/55703253/105954630-50284f00-60b8-11eb-884e-f47464a93fe9.png)
몬스터를 한대 때릴때마다 기본적으로 골드가 1 오릅니다. 몬스터의 체력이 0이되어 스테이지가 넘어가면 더 높은 체력을 가지고 등장하게 됩니다.  
우측 상단의 로그아웃 버튼으로 로그아웃도 가능합니다.

3.상점 SHOP
---------------------------

![shop](https://user-images.githubusercontent.com/55703253/105954641-561e3000-60b8-11eb-9bcf-eede320ec2c7.png)
상점은 우측에서 위쪽에 있는 표지판 형태의 버튼을 눌러 입장할수있으며 골드를 소모할수있는 장소입니다.  
각각 공격력증가, 보상증가, 공격당 보상증가입니다.  
각각의 업그레이드마다 초기가격과 가격상승률이 다르게 설정되어있으며  
업그레이드를 통해 더 쉽게 게임을 즐길수있습니다. 

4.퀘스트 Quest
---------------------------------

![quest](https://user-images.githubusercontent.com/55703253/105954651-5b7b7a80-60b8-11eb-8dc0-0e459666c774.png)
상점에서 갖은 업그레이드를 하고 광클을 해도 돈이 부족하다면 퀘스트를 이용하여 돈을 벌수있습니다.  
스테이지 달성, 공격횟수등의 퀘스트를 받아보실수있으며 퀘스트 보상으로 소정의 골드를 제공합니다. 
만약 조건이 달성되지 않았다면 달성되지 않았다는 표시를 볼수있습니다.  
퀘스트를 클리어할때마다 요구치와 보상이 증가하며 이 역시 퀘스트의 종류에 따라 다릅니다. 

