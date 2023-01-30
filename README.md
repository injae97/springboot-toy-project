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
    
## 💡 HOW DO AUTOMATICALLY TRANSLATE ENGLISH THROUGH DRAG?
    - https://chrome.google.com/webstore/detail/google-translate/aapbdbdomjkkjkaonfhkkikfgjllcleb?hl=ko
    - 확장 추가 > 확장 프로그램에서 Google 번역 오른쪽 마우스 > 옵션 > 즉시 팝업을 표시합니다. > 저장
    - 재부팅 후 영어 문장에 드래그만 한번 해주면 자동으로 번역된 팝업창 나옴

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
         - Controller> Service > DAO > Mapper > DB
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
            
        b. <resultMap type="com.spring.boot.vo.Vo_record" id="map_vo_record"></resultMap>
            a. id는 VO 객체 DB연결한 쿼리 <select id="doStudyList" resultType="com.spring.boot.vo.Vo_record" resultMap="map_vo_record">    에서 resultMap="" 값을 resultMap id에 적어줌
            b. resultMap type은 VO 객체 DB연결한 쿼리에서 resultType 그대로 복사 한 후 resultMap type에 넣어주면 된다. 
         
            <!-- Mybatis(resultMap) -->
            <resultMap type="com.spring.boot.vo.Vo_record" id="map_vo_record">
                <result column="key_id" property="key_id" jdbcType="NVARCHAR" javaType="String" />
                <result column="study_day" property="study_day" jdbcType="NVARCHAR" javaType="String" />
                <result column="contents" property="contents" jdbcType="NVARCHAR" javaType="String" />
                <result column="reg_day" property="reg_day" jdbcType="NVARCHAR" javaType="String" />
            </resultMap>
            
            <!-- VO 객체 연결 -->
            <select id="doStudyList" resultMap="map_vo_record">        
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
                <resultMap type="com.spring.boot.vo.Vo_record" id="map_vo_record">
                    <result column="key_id" property="key_id" jdbcType="NVARCHAR" javaType="String" />
                    <result column="study_day" property="study_day" jdbcType="NVARCHAR" javaType="String" />
                    <result column="contents" property="contents" jdbcType="NVARCHAR" javaType="String" />
                    <result column="reg_day" property="reg_day" jdbcType="NVARCHAR" javaType="String" />
                </resultMap>
                
                <!-- VO 객체 연결 -->
                <select id="doStudyList" resultMap="map_vo_record">        
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
                    ORDER BY key_id
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
                
    i. YAML(application.yml)
        - 사람이 쉽게 읽을 수 있는 데이터 직렬화 양식
        * application.yml
            --- # port setting
            server:
                port: 8090

            --- # Spring MVC view
            spring:
                mvc:
                    view:
                        prefix: /WEB-INF/views
                        suffix: .jsp

            --- # devtools reload(html, jsp)
            spring:
                devtools:
                    livereload:
                        enable: true 
                    restart:
                        enabled: false

            --- # Oracle
            spring:
                datasource:
                    driver-class-name: oracle.jdbc.driver.OracleDriver
                    url: jdbc:oracle:thin:@localhost:1521
                    username: SYSTEM
                    password: PASSWORD
             
            --- # Mybatis
            mybatis:
                mapper-locations: classpath:sqlmapper/*.xml
                configuration.map-underscore-to-camel-case: true
                
    j. logback
        - 어떤 쿼리가 나오는지 로그로 찍는 방법
        a. logback-spring.xml 생성(/src/main/resources/logback-spring.xml)
            <?xml version="1.0" encoding="UTF-8"?>
            <configuration>
                <appender name="console" class="ch.qos.logback.core.ConsoleAppender">
                    <encoder>
                        <Pattern>[%d{yyyy-MM-dd HH:mm:ss}:%-3relative] [%thread] %-5level %logger{36} - %msg%n</Pattern>
                    </encoder>
                </appender>

                <!-- Logback 은 5단계의 로그 레벨을 가진다.
                    심각도 수준은 off > Error > Warn > Info > Debug > Trace 이다.
                -->
                
                <!-- name은 package 이름 -->
                <logger name="com.spring.boot" level="Debug"/>
                <root level="Info">
                    <appender-ref ref="console"/>
                </root>
            </configuration>
        
        b. Logback(@Slf4j)
            - Controller에 @Slf4j 추가(System.out.println > log.info())
                log.info(vo_record.getKeyId());
                log.info(vo_record.getStudyDay());
                log.info(vo_record.getContents());
                log.info(vo_record.getRegDay());
        
        
## 💡 게시판(CRUD) - 41:52 / 1:04:08
    * CRUD
        a. C(Create) = Insert
        b. R(Read) = Select
        c. U = Update
        d. D = Delete
        
    * 화면단 - 수정, 삭제 버튼 추가(record.jsp) 
        - /src/main/webapp/WEB-INF/views/home/record.jsp
            <button type="button" onclick="location.href='/record_reg/insert'">게시글 등록</button>

            <div class="row mb-3">
                <div class="col">수정</div>
                <div class="col">삭제</div>
            </div>

            <% for(Vo_record vo_record : list) { %>
            <div class="row mb-3">
                <div class="col"><a href="/record_reg/modify?key_id=<%= vo_record.getKeyId() %>">수정</a></div>
                <div class="col"><a href="/record_reg/delete?key_id=<%= vo_record.getKeyId() %>">삭제</a></div>
            </div>
            <% } %>
            
    * ★ DB 흐름 ★
        - Controller > Service > DAO > Mapper > DB
            - Controller(대문) > Service(Service에서 DAO 값을 가져옴) > DAO(DAO 내용이 Mybatis 통해 Mapper) 
                * Controller 대문 역할을 하려면 @Autowired로 Service 값을 가져와야 한다.
                                
## 💡 게시글 수정 버튼 클릭 했을 때 DB 데이터 가져오는 법
    a. Controller
        - @Autowired를 사용해서 Service를 주입해줘야 한다.(StudyService)
        - /src/main/java/com/spring/boot/controller/record_reg.java  
            package com.spring.boot.controller;

            import javax.servlet.http.HttpServletRequest;

            import org.springframework.beans.factory.annotation.Autowired;
            import org.springframework.stereotype.Controller;
            import org.springframework.web.bind.annotation.GetMapping;
            import org.springframework.web.bind.annotation.RequestMapping;

            import com.spring.boot.service.StudyService;
            import com.spring.boot.vo.Vo_record;

            @Controller
            @RequestMapping("record_reg")
            public class record_reg {

                /* @Autowired: 서비스 주입 */
                @Autowired
                StudyService studyService;    
                
                /* Insert(등록) 
                 * 입력이 a tag Mapping으로 들어왔기 때문에 GetMapping
                 */
                @GetMapping("/insert")
                public String doInsert() {
                    return "";
                }
                            
                /* 수정 화면 페이지(게시글 수정 눌렀을 때 기존 데이터 들고옴) - 고전적인 방식 */
                @GetMapping("/modify")
                public String doModify(HttpServletRequest request) {
                    String strKeyId = request.getParameter("key_id");
                    
                    Vo_record vo_record = new Vo_record();
                    vo_record = studyService.doStudyListOne(strKeyId); // 인자 값을 strKeyId로 던져줌
                    
                    request.setAttribute("vo_record", vo_record); // request에서 vo_record 값을 담아서 저장
                    
                    return "/record/record_modify";
                }           
                
                /* Delete(삭제) */
                @GetMapping("/delete")
                public String doDelete() {
                    return "";
                }
            }

    b. Service
        - /src/main/java/com/spring/boot/service/StudyService.java
            package com.spring.boot.service;
            import java.util.ArrayList;
            import java.util.List;
            import java.util.Map;

            import org.springframework.beans.factory.annotation.Autowired;
            import org.springframework.stereotype.Service;

            import com.spring.boot.dao.StudyDao;
            import com.spring.boot.vo.Vo_record;

            @Service
            public class StudyService {
                
                @Autowired
                StudyDao studyDao;
                
                /* 
                 * returnType : VO
                 */                    
                public List<Vo_record> doStudyList() {
                    List<Vo_record> list = new ArrayList<>();
                    list = studyDao.doStudyList();
                    return list;
                }
                        
                /* 
                 * One Row Select 
                 * returnType : VO
                 */
                public Vo_record doStudyListOne(String strKeyId) {
                    Vo_record vo_record = new Vo_record();
                    vo_record = studyDao.doStudyListOne(strKeyId); // strKeyId 값을 그대로 전달
                    return vo_record;
                }
            }
            
    c. DAO
        - /src/main/java/com/spring/boot/dao/StudyDao.java
            package com.spring.boot.dao;

            import java.util.List;

            import org.apache.ibatis.annotations.Mapper;
            import com.spring.boot.vo.Vo_record;

            @Mapper
            public interface StudyDao {
                /* public List<Map<String, String>> doStudyList(); // Mapper(resultType = map) */
                public List<Vo_record> doStudyList(); // 기록 전체 리스트: VO 객체로 반환
                
                /* One row Select: VO 객체로 반환(strKeyId 값을 그대로 전달) */
                public Vo_record doStudyListOne(String strKeyId);    
            }
            
    d. Mapper
        <!-- VO객체 DB연결(doStudyListOne(one row select)) -->
        <select id="doStudyListOne" resultType="com.spring.boot.vo.Vo_record">        
            SELECT to_char(key_id) AS key_id, study_day, contents, to_char(reg_day,'YYYY-mm-dd hh24mi') AS reg_day 
            FROM Study_record
            WHERE key_id = #{strKeyId}
        </select>
    
    e. 화면단(JSP) - 수정 페이지 생성(record_modify.jsp)
        - /src/main/webapp/WEB-INF/views/record/record_modify.jsp    
            <%
                Vo_record vo_record = (Vo_record) request.getAttribute("vo_record");
            %>
            <!-- 게시글 수정화면 페이지 -->
            <!-- VO객체를 보면서 사용(name = VO 객체 컬럼들) -->
            <!-- 수정하기 버튼 클릭시 action의 /record_reg/modify_exe로 이동함  -->
            <!-- ★★★ record_reg.java Controller에서 @RequestMapping("record_reg") + @PostMapping("/modify_exe") 를 더해서 action에 기입 ★★★ -->
            <form name="form_record_mod" action="/record_reg/modify_exe" method="post">
                <div>keyId: <input type="text" name="keyId" value="<%=vo_record.getKeyId()%>" readonly></div><br>
                <div>StudyDay: <input type="text" name="StudyDay" value="<%=vo_record.getStudyDay()%>"></div><br>
                <div>Contents: <input type="text" name="contents" value="<%=vo_record.getContents()%>" size="80"></div><p>    
                
                <br><input type="submit" value="게시글 수정"> 
            </form>
                
## 💡 [UPDATE] - 내용(contents) 변경 후 게시글 수정 시 UPDATE(수정)
    - 화면단(JSP) - 수정 페이지(record_modify.jsp)에서 수정 > 공부일자(StudyDay), 공부내용(contents) 변경 후 게시글 수정하기 버튼 클릭시 UPDATE(수정) 작동 
   
    a. Controller
        /src/main/java/com/spring/boot/controller/record_reg.java
            /* Upate(수정) - VO 사용 */
            /* @ModelAttribute: 쿼리 스트링 자동 매핑  */
            @PostMapping("/modify_exe")
            public String doModExe(@ModelAttribute Vo_record vo_record) {
                
                int intI = studyService.doStudyUp(vo_record); // Mybatis - Update는 int형으로 반환
                        
                return "redirect:/home/record"; // home.java(Controller)을 그대로 호출 
            }
            
    b. Service
        - /src/main/java/com/spring/boot/service/StudyService.java        
            /* 
             * /src/main/java/com/spring/boot/controller/record_reg.java 에서 VO객체(@ModelAttribute 사용했기 때문에 VO객체로 맞춤)
             * 기록 수정(UPDATE)
             * UPDATE 할 때 int로 받기로 컨트롤러에 선언했기 때문에 int형 
             */
            public int doStudyUp(Vo_record vo_record) {
                int intI = studyDao.doStudyUp(vo_record); //  Mybatis - Update는 int형으로 반환
                return intI;
            }
            
    c. DAO
        - /src/main/java/com/spring/boot/dao/StudyDao.java
            /* 기록 수정 (UPDATE) - 컨트롤러에서 VO객체를 사용했기 때문에 VO 파라미터 설정 */
            public int doStudyUp(Vo_record vo_record);
            
    d. Mapper
        - /src/main/resources/sqlmapper/study_sql.xml
            <!-- [UPDATE] VO객체 수정 > 게시글 내용 수정 후 > 수정하기(기록 수정) - doStudyUp -->
            <!-- VO를 사용하기 때문에 Vo_record.java 선언한 변수명 그대로 값을 사용 -->
            <update id="doStudyUp" parameterType="com.spring.boot.vo.Vo_record">
                UPDATE Study_record
                SET study_day = #{studyDay}, contents = #{contents}, reg_day = SYSDATE
                WHERE key_id = #{keyId}    
            </update>
        
                
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