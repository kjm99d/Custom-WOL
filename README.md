Custom-WOL 개발 일지
=========================


### 2021-01-17
- 프로젝트 생성
- Member / DataInfo Service O
- MemoryMemberRepository O
  - MemoryDataInfoRepository X

-----------------------------------------------------

### 2021-01-20
- Spring Security 적용(이거 어려움)
  - 스프링 시큐리티 적용하다가 위에 만든거 다 버림..

-----------------------------------------------------

### 2021-01-24
- Spring Security 메소드 이해
  - 로그인 서비스에 적용
  
- Thymleaf + Security 사용
  - Thymleaf Security 사용하니까 진짜 편함.
  
- MariaDB Wol Table 생성
  - 도메인에 Entity / Data 설정해주니 Getter Setter 無필요 해짐.
    - 이건 진짜 편한 것 같음.
  - 데이터 가져오기 까지 성공
    - 하지만 DB 부분에서 데이터를 가져올 때 테이블 부분을 조금 수정해야함. </br>
      <strong>select * from wol where xxx=bbb</strong> 처리가 필요할 것 같음.</br>
        - 이 부분에 대해서는 키값 매핑 해줄 때 USER Table에서 id 값으로(username 값 아님) 맵핑 해주면 될 것 같기도하고(is 여러개의 MAC Address는 한개의 아이디 값을 갖으니 ManyToOne ..??)
  - 맵핑(@ManyToMany 등...)에 대한 이해가 필요.

-----------------------------------------------------
  
### 2021-01-25
- 맵핑 방법에 대한 이해
  - 이전 날 생각했던 ManyToOne 방식이 맞았음(여러개의 Wol 데이터 들은 한개의 사용자와 연결되어 있다.)
  - Wol 테이블에서 FK 지정, User에 id값으로 FK 지정해주고</br>
  Wol Domain 에서 @JoinColumn 어노테이션 지정. 특정 테이블이 ManyToOne Mapping 되어 있고, 그 맵핑된 컬럼은 xxx 컬럼이다! 라고 지정해주는 것임.
  - Authentication 객체에 대한 이해
    - Controller 부분에서 매개변수로 Authentication을 받으면 서버에서 인증된 사용자의 정보를 스프링 시큐리티가 가져다 줌.
      - 해당 부분에서 Authentication.getName() 해주면 사용자 명을 갖다주고, 갖다준 키로 user 조회를 해서 user의 Id값을 가져와 findAllByUser_id 지정을 하면 여러개의 데이터중 user_id 값이 매개변수로 들어온 값과 같은 값을 필터링 해서 갖다준다.

  


- <span style="color:#ABABAB"><strong>다음번 작업에 해야할 것.</strong></span>
  - wol 목록 추가 페이지 제작
  - WolController 에서 수정 페이지 연결 및 API 제작
  - WolController 에서 삭제 페이지 연결 및 API 제작
-----------------------------------------------------
  