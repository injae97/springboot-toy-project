## 💡 SpringBoot-Record (CRUD)
- Spring boot + JSP + Mybatis(Oracle) + Spring Tool Suite (IDE)

## 💡 Spring Tool Suite Download 
https://github.com/spring-projects/sts4/wiki/Previous-Versions

    - 컨트롤 + F > Spring Tools 4.13.1 > spring-tool-suite-4-4.13.1.RELEASE-e4.22.0-win32.win32.x86_64.zip
        
## 💡 Spring Tool Suite Project Create
    - File > New > Spring Starter Project
        - Service URL: https://start.spring.io
        - Name: SpringBoot-Record
        - Type: Maven 
        - Packaging: War
        - Java Version: 8
        - Language: Java
        - Group: com.spring.boot
        - Artifact: SpringBoot-Record
        - Version: 0.0.1-SNAPSHOT
        - Description: SpringBoot-Record
        - Package: com.spring.boot
        
    - Dependencies
        - Spring Boot Version: 2.7.8
        - Available: Spring Web > Finish
        
## 💡 HOW TO AUTO IMPORT WITH SHORTCUT KEYS?
    - Ctrl + Shift + O

## 💡 HOW TO IMPORT DEPENDENCIES ON MAVEN? 
    - https://mvnrepository.com/
        - 해당 링크에서 추가 하려는 의존성을 검색 > 버전 클릭 > Maven > 복사한 후 pom.xml 
        - pom.xml 오른쪽 마우스 > Maven > Update > Force Update of ~ 
        
        <!-- https://mvnrepository.com/artifact/org.apache.tomcat.embed/tomcat-embed-jasper -->
        <dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-jasper</artifactId>
        </dependency>
        
        <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
        </dependency>
        
## 💡 TIL
    [2023-01-26]
    a.  webapp에 필요한 디렉토리 생성
        1. /src/main/webapp/index.html 에 index.html 생성
        2. /src/main/webapp/WEB-INF    
        3. /src/main/webapp/WEB-INF/views
            - /src/main/webapp/WEB-INF/views/html
                - 해당 경로에 테스트 목적으로 hello.html 생성
                * http://localhost:8080/html/hello.html 로 확인 가능
            - /src/main/webapp/WEB-INF/views/jsp
                - 해당 경로에 테스트 목적으로 hello.jsp 생성
                * http://localhost:8080/jsp/hello.jsp 로 확인 가능
    
    b. spring 환경 설정 
        - /src/main/resources/application.properties
            
            # port setting
            server.port = 8090
    
    c. BootStrap
        - https://getbootstrap.com/docs/5.3/getting-started/introduction/
            - Quick start > 2번 복사 > /src/main/webapp/base/bootstrap.html 에 붙여줌
                - 그런 후 bootstrap example에 들어가서 마음에 드는 UI 일부분 Ctrl + Shift + C 로 확인 후 페이지 소스보기 > 복사 > bootstrap.html에 붙여줌
                * Headers, Heroes, Footers
                
        - grid example(record.html, member_list.html)
            * https://getbootstrap.com/docs/5.3/layout/grid/ 
            
        - Sign-in example(login.html)
            * https://getbootstrap.com/docs/5.3/examples/sign-in/
        
        * Source file download
            - https://getbootstrap.com/docs/5.3/getting-started/download/
                - Source files, Examples download
                - "bootstrap-5.3.0-alpha1-examples\bootstrap-5.3.0-alpha1-examples\sign-in\sign-in.css"
                - /src/main/webapp/css/sign-in.css 폴더 생성 후 넣어줌
                
    
    [2023-01-27]
    a. MVC 흐름
        - Request > 1. Controller > 2. Model > 3. View
            * WAS : Controller, Model, View
    
    b. Home Page Setting
        a. src/main/java/com/spring/boot/controller(package create)
        b. src/main/java/com/spring/boot/controller/Home.java(class create)
            - @Controller : 내가 바로 컨트롤러다.
            - @RequestMapping : @RequestMapping("/") 으로 jsp file index 화면 설정 완료(GET, POST 둘다 접근 가능)
                - 명확하게 해주기 위해 @GetMapping, @PostMapping 사용 할 것    

    c. views에서 폴더를 만들어서 분리(home, login)
        - home(folder) : /src/main/webapp/WEB-INF/views/home/ (home.jsp, member_list.jsp, record.jsp)
        - login(folder): /src/main/webapp/WEB-INF/views/login (login.jsp, join.jsp)
            
        * 화면단(view jsp file)에서 버튼 클릭시 링크대로 이동하게 수정
            - 자바단(Controller)에서 RequestMapping 와 GetMapping을 적절하게 사용
               - 그런 후 컨트롤러에 설정한 값대로 각 화면단 jsp 파일의 href 수정
    
    d. 공통 헤더 분리 후 import
        - /src/main/webapp/WEB-INF/views/common/ (header.jsp, footer.jsp)
        - 각 화면단(jsp) 파일들에서 header, footer 부분을 지우고 공통 헤더 부분을 import
               <%@ include file="/WEB-INF/views/common/header.jsp" %>
            <%@ include file="/WEB-INF/views/common/footer.jsp" %>
            * 꼭 지운 header, footer 위치에서 import 해줘야함
    
    e. application.properties Setting(jsp)
        - spring.mvc.view.prefix=/WEB-INF/views
        - spring.mvc.view.suffix=.jsp
        
    [2023-01-28]
    a. application.properties Setting(Oracle DB Connection)
        spring.datasource.driver-class-name=oracle.jdbc.driver.OracleDriver
        spring.datasource.url=jdbc:oracle:thin:@localhost:1521
        spring.datasource.username=SYSTEM
        spring.datasource.password=PASSWORD
        
    [2023-01-29]
    a. ★ DB 흐름 ★
         - Service > DAO > Mapper > DB
            - Controller(대문) > Service(Service에서 DAO 값을 가져옴) > DAO(DAO 내용이 Mybatis 통해 Mapper) 
                * Controller 대문 역할을 하려면 @Autowired로 Service 값을 가져와야 한다.
                
    b. Service package, DAO package, Mapper package 생성
        a. /src/main/java/com/spring/boot/dao 
            - @Mapper interface로 생성해야함 (class X)
        b. /src/main/resources/sqlmapper
            - XML 파일 생성(DB 쿼리)
        c. /src/main/java/com/spring/boot/service
            - @Service, @Autowired(DAO), class로 생성 (interface X)
            
    c. jsp에 데이터 바인딩(Service > DAO > Mapper > DB > Controller(request) > View)
        <%@page import="java.util.List"%>
        <%@page import="java.util.Map"%>
    
        <%
            List<Map<String, String>> list = (List<Map<String, String>>) request.getAttribute("list");
        %>
        
        <% for(Map<String, String> map: list) { %>
        <div class="row mb-3">
            <div class="col"><%= map.get("KEY_ID") %></div>
            <div class="col"><%= map.get("STUDY_DAY") %></div>
            <div class="col"><%= map.get("CONTENTS") %></div>
            <div class="col"><%= map.get("REG_DAY") %></div>
        </div>
        <% } %>

        * Controller에서 jsp 렌더링 하는 과정에 @ResponseBody 사용할 경우 jsp에서 view 화면 보여주지 않음(@ResponseBody 어노테이션 삭제)

    d. Model에 값을 담아서 넣는 방법
        - Controller Parameter에 Model model 추가 후  model.addAttribute("이름", 값); 로 추가하면 됨
        
    e. VO package 생성
        a. /src/main/java/com/spring/boot/vo
            - Vo_record(class로 생성)        
            - VO는 DB Table의 컬럼값들을 선언해준다고 생각하면 된다.
                private String key_id;
                private String study_day;
                private String contents;
                private String reg_day;
                
        b. Mapper resultType 수정
            <select id="doStudyList" resultType="com.spring.boot.vo.Vo_record">        
        c. Dao 수정(VO 객체에 접근하기 위해 type 수정)
            - public List<Vo_record> doStudyList(); // VO 객체로 반환
        d. StudyService(VO 객체에 접근하기 위해 type 수정)
            - public List<Vo_record> doStudyList()
            - List<Vo_record> list = new ArrayList<>();
        e. Controller 수정(VO 객체에 접근하기 위해 type 수정)
            - List<Vo_record> list = new ArrayList<>();
            - for(Vo_record vo_record : list) 
                - Getter & Setter 사용(vo_record.getKEY_ID())
        f. JSP 수정
            <%@page import="com.spring.boot.vo.Vo_record"%>
            <%
                List<Vo_record> list = (List<Vo_record>) request.getAttribute("list");
            %>
            
            <% for(Vo_record vo_record : list) { %>
            <div class="row mb-3">
                <div class="col"><%= vo_record.getKEY_ID() %></div>
                <div class="col"><%= vo_record.getSTUDY_DAY() %></div>
                <div class="col"><%= vo_record.getCONTENTS() %></div>
                <div class="col"><%= vo_record.getREG_DAY() %></div>
            </div>
            <% } %>
            * STS에서 Syntax error on token ")", delete this token 해당 에러 무시 
    
    f. Lombok 사용
        - https://mvnrepository.com/artifact/org.projectlombok/lombok/1.18.24    
        a. pom.xml(dependency 추가)
            <dependency>
                <groupId>org.projectlombok</groupId>
                <artifactId>lombok</artifactId>
                <scope>provided</scope>
            </dependency>
        b. Vo class file 수정
            - @Data : @Getter, @Setter , @RequiredArgsConstructor(@Data 어노테이션에 @Getter, @Setter, @RequiredArgsConstructor 3개가 내장되어 있음)
        * DocumentSite: https://projectlombok.org/
        
    g. resultMap(존재하지 않는 column 별칭 사용 가능하게 해주는 기능)
        a. resultMap의 column값과 property에 지정한 값을 매핑할 수 있다.
            e.g VO 객체 컬럼에서 별칭을 사용해야한다면? resultMap을 사용하면된다.(기존 VO 값: study_day -> 별칭 사용할 컬럼 값:study_day20)
            * column은 VO객체 DB연결한 쿼리에서의 컬럼들이다.
            * column에서 지정한 값과 property에 지정한 값을 매핑 해준다를 뜻함.
            
        b. <resultMap type="com.spring.boot.vo.Vo_record" id="map_vo_study"></resultMap>
            a. id는 VO 객체 DB연결한 쿼리 <select id="doStudyList" resultType="com.spring.boot.vo.Vo_record" resultMap="map_vo_study">    에서 resultMap="" 값을 resultMap id에 적어줌
            b. resultMap type은 VO 객체 DB연결한 쿼리에서 resultType 그대로 복사 한 후 resultMap type에 넣어주면 된다. 
         
            <!-- Mybatis(resultMap) -->
            <resultMap type="com.spring.boot.vo.Vo_record" id="map_vo_study">
                <result column="key_id" property="key_id" jdbcType="NVARCHAR" javaType="String" />
                <result column="study_day" property="study_day" jdbcType="NVARCHAR" javaType="String" />
                <result column="contents" property="contents" jdbcType="NVARCHAR" javaType="String" />
                <result column="reg_day" property="reg_day" jdbcType="NVARCHAR" javaType="String" />
            </resultMap>
            
            <!-- VO 객체 연결 -->
            <select id="doStudyList" resultMap="map_vo_study">        
                SELECT to_char(key_id) AS key_id, study_day AS study_day20, contents AS contents20, to_char(reg_day,'YYYY-mm-dd hh24mi') AS reg_day 
                FROM Study_record
            </select>
            
            * https://mybatis.org/mybatis-3/configuration.html (typeHandlers)
            * https://mybatis.org/mybatis-3/sqlmap-xml.html
        
        c. VO, Controller, Mapper, jsp 파일 수정
            a. VO 
                private String key_id;
                private String study_day;
                private String contents;
                private String reg_day;
            b. Controller
                System.out.println(vo_record.getKey_id());
                System.out.println(vo_record.getStudy_day());
                System.out.println(vo_record.getContents());
                System.out.println(vo_record.getReg_day());
            c. Mapper
                <!-- Mybatis(resultMap) -->
                <resultMap type="com.spring.boot.vo.Vo_record" id="map_vo_study">
                    <result column="key_id" property="key_id" jdbcType="NVARCHAR" javaType="String" />
                    <result column="study_day" property="study_day" jdbcType="NVARCHAR" javaType="String" />
                    <result column="contents" property="contents" jdbcType="NVARCHAR" javaType="String" />
                    <result column="reg_day" property="reg_day" jdbcType="NVARCHAR" javaType="String" />
                </resultMap>
                
                <!-- VO 객체 연결 -->
                <select id="doStudyList" resultMap="map_vo_study">        
                    SELECT to_char(key_id) AS key_id, study_day, contents, to_char(reg_day,'YYYY-mm-dd hh24mi') AS reg_day 
                    FROM Study_record
                </select>
            d. jsp 
                <!-- returnType : VO 객체  -->
                <% for(Vo_record vo_record : list) { %>
                <div class="row mb-3">
                    <div class="col"><%= vo_record.getKey_id() %></div>
                    <div class="col"><%= vo_record.getStudy_day() %></div>
                    <div class="col"><%= vo_record.getContents() %></div>
                    <div class="col"><%= vo_record.getReg_day() %></div>
                </div>
            <% } %>
                
    h. mapUnderscoreToCamelCase(실무에서 거의 사용)        
        - 언더바 뒤에 첫글자는 대문자로 표기
            e.g key_id -> keyId
            
        a. application.properties Setting
            - mybatis.configuration.map-underscore-to-camel-case=true
                            
        b. VO, Controller, Mapper, jsp 파일 수정
            a. VO 
                private String keyId;
                private String studyDay;
                private String contents;
                private String regDay;
            b. Controller
                System.out.println(vo_record.getKeyId());
                System.out.println(vo_record.getStudyDay());
                System.out.println(vo_record.getContents());
                System.out.println(vo_record.getRegDay());
            c. Mapper
                <!-- VO객체 DB연결(mapUnderscoreToCamelCase) -->
                <select id="doStudyList" resultType="com.spring.boot.vo.Vo_record">        
                    SELECT to_char(key_id) AS key_id, study_day, contents, to_char(reg_day,'YYYY-mm-dd hh24mi') AS reg_day 
                    FROM Study_record
                </select>
            d. jsp 
                <!-- mapUnderscoreToCamelCase : VO 객체  -->
                <% for(Vo_record vo_record : list) { %>
                <div class="row mb-3">
                    <div class="col"><%= vo_record.getKeyId() %></div>
                    <div class="col"><%= vo_record.getStudyDay() %></div>
                    <div class="col"><%= vo_record.getContents() %></div>
                    <div class="col"><%= vo_record.getRegDay() %></div>
                </div>
                <% } %>
            
## 💡 Web Knowledge
    * forward(request) vs sendRedirect(response)
        - HTTP 통신으로 생각
        - forward(request): forward는 request를 계속적으로 던져주는 것 (WAS 내부에서만 요청자가 입력한 값을 던져줌)
        - sendRedirect(response): response를 다시 다른 곳으로 넘겨주는 것
        
        a. forward(request)  = Spring return "view path"
            - /WEB-INF/views/*.jsp (호출 성공)
            - /jsp/*.jsp (호출 성공)
            - https://www.naver.com (호출 실패 - Error)
            * 구조 : 요청자(Client) > request > localhost[WAS] Call > WEB-INF/views/list.jsp        
                    
        b. sendRedirect(response) = Spring redirect:/path 
            - /WEB-INF/views/*.jsp (호출 실패 - Error)
                - response는 요청자로 보내줘야하는데 자기 일 끝났다고 요청자 말고 직접 호출시킴(그래서 외부 접속이 됨)
            - /jsp/*.jsp (호출 성공)
            - https://www.naver.com (호출 성공)
                
    * Spring - Controller & RestController 에 대한 기본적인 이해
        a. Controller
            @Controller
            @RequestMapping("URL-PATH")
            public String doDefault() {
                return "result"; // result.jsp 화면 렌더링
            }
        
        b. RestController
            - @Controller + @ResponBody = @RestController
            
            /* RestController.class */
            @RestController
            public class RestController {
                @RequestMapping("URL-PATH")
                public String doResponse() {
                    String strContents = "View : ResponBody!! <HR>  ";
                    return strContents;
                }
            }    

        * HTTPServletResponse
            - java에서 jsp를 만든 것
            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println(" View : response Self");
            out.println("</body></html>");
            
        * @ResponBody
            @RequestMapping("URL-PATH")
            @ResponBody
            public String useResponsebody() {
                String strContents = "View : ResponBody!! ";
                return strContents;
            }
            
        * HTTPServletResponse 소스코드와 @ResponBody 안에 있는 소스코드와 동일