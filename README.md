## π‘ SpringBoot-Toy-Project Env
    - Framework: Spring boot
    - View: JSP
    - DBMS: Oracle
    - Mapper: MyBatis
    - IDE: Spring Tool Suite
    
## π‘ Spring Tool Suite Download 
https://github.com/spring-projects/sts4/wiki/Previous-Versions

    - μ»¨νΈλ‘€ + F > Spring Tools 4.13.1 > spring-tool-suite-4-4.13.1.RELEASE-e4.22.0-win32.win32.x86_64.zip
        
## π‘ Spring Tool Suite Project Create
```java
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
```        
    
## π‘ HOW TO AUTO IMPORT WITH SHORTCUT KEYS?
    - Ctrl + Shift + O
    
## π‘ HOW DO AUTOMATICALLY TRANSLATE ENGLISH THROUGH DRAG?
    - https://chrome.google.com/webstore/detail/google-translate/aapbdbdomjkkjkaonfhkkikfgjllcleb?hl=ko
        - νμ₯ μΆκ° > νμ₯ νλ‘κ·Έλ¨μμ Google λ²μ­ μ€λ₯Έμͺ½ λ§μ°μ€ > μ΅μ > μ¦μ νμμ νμν©λλ€. > μ μ₯
            - μ¬λΆν ν μμ΄ λ¬Έμ₯μ λλκ·Έλ§ νλ² ν΄μ£Όλ©΄ μλμΌλ‘ λ²μ­λ νμμ°½ λμ΄

## π‘ HOW TO IMPORT DEPENDENCIES ON MAVEN?
```java
- https://mvnrepository.com/
    - ν΄λΉ λ§ν¬μμ μΆκ° νλ €λ μμ‘΄μ±μ κ²μ > λ²μ  ν΄λ¦­ > Maven > λ³΅μ¬ν ν pom.xml 
    - pom.xml μ€λ₯Έμͺ½ λ§μ°μ€ > Maven > Update > Force Update of ~ 
    
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
```

## π‘ How to set@Slf4j in STS Using Maven?    
    - https://mvnrepository.com/artifact/org.projectlombok/lombok/1.18.24   
    
    a. pom.xml(dependency μΆκ°)
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <scope>provided</scope>
        </dependency>

    b. logback-spring.xml μμ±
        - /src/main/resources/logback-spring.xml    
            <?xml version="1.0" encoding="UTF-8"?>
            <configuration>
                <appender name="console" class="ch.qos.logback.core.ConsoleAppender">
                    <encoder>
                        <Pattern>[%d{yyyy-MM-dd HH:mm:ss}:%-3relative] [%thread] %-5level %logger{36} - %msg%n</Pattern>
                    </encoder>
                </appender>

                <!-- Logback μ 5λ¨κ³μ λ‘κ·Έ λ λ²¨μ κ°μ§λ€.
                    μ¬κ°λ μμ€μ off > Error > Warn > Info > Debug > Trace μ΄λ€.
                -->
                
                <!-- nameμ package μ΄λ¦ -->
                <logger name="com.spring.boot" level="Debug"/>
                <root level="Info">
                    <appender-ref ref="console"/>
                </root>
            </configuration>
            
      c. Logback(@Slf4j)
          - Controllerμ @Slf4j μΆκ°(System.out.println > log.info())
              log.info(vo_record.getKeyId());
              log.info(vo_record.getStudyDay());
              log.info(vo_record.getContents());
              log.info(vo_record.getRegDay());
              
## π‘ TIL
    a.  webappμ νμν λλ ν λ¦¬ μμ±
        1. /src/main/webapp/index.html μ index.html μμ±
        2. /src/main/webapp/WEB-INF    
        3. /src/main/webapp/WEB-INF/views
            - /src/main/webapp/WEB-INF/views/html
                - ν΄λΉ κ²½λ‘μ νμ€νΈ λͺ©μ μΌλ‘ hello.html μμ±
                * http://localhost:8080/html/hello.html λ‘ νμΈ κ°λ₯
            - /src/main/webapp/WEB-INF/views/jsp
                - ν΄λΉ κ²½λ‘μ νμ€νΈ λͺ©μ μΌλ‘ hello.jsp μμ±
                * http://localhost:8080/jsp/hello.jsp λ‘ νμΈ κ°λ₯
            

    b. spring νκ²½ μ€μ  
        - /src/main/resources/application.properties
            
            # port setting
            server.port = 8090
        

    c. BootStrap
        - https://getbootstrap.com/docs/5.3/getting-started/introduction/
            - Quick start > 2λ² λ³΅μ¬ > /src/main/webapp/base/bootstrap.html μ λΆμ¬μ€
                - κ·Έλ° ν bootstrap exampleμ λ€μ΄κ°μ λ§μμ λλ UI μΌλΆλΆ Ctrl + Shift + C λ‘ νμΈ ν νμ΄μ§ μμ€λ³΄κΈ° > λ³΅μ¬ > bootstrap.htmlμ λΆμ¬μ€
                * Headers, Heroes, Footers
                
        - grid example(record.html, member_list.html)
            * https://getbootstrap.com/docs/5.3/layout/grid/ 
            
        - Sign-in example(login.html)
            * https://getbootstrap.com/docs/5.3/examples/sign-in/
        
        * Source file download
            - https://getbootstrap.com/docs/5.3/getting-started/download/
                - Source files, Examples download
                - "bootstrap-5.3.0-alpha1-examples\bootstrap-5.3.0-alpha1-examples\sign-in\sign-in.css"
                - /src/main/webapp/css/sign-in.css ν΄λ μμ± ν λ£μ΄μ€
            

    [2023-01-27]
    a. MVC νλ¦
        - Request > 1. Controller > 2. Model > 3. View
            * WAS : Controller, Model, View


    b. Home Page Setting
        a. src/main/java/com/spring/boot/controller(package create)
        b. src/main/java/com/spring/boot/controller/Home.java(class create)
            - @Controller : λ΄κ° λ°λ‘ μ»¨νΈλ‘€λ¬λ€.
            - @RequestMapping : @RequestMapping("/") μΌλ‘ jsp file index νλ©΄ μ€μ  μλ£(GET, POST λλ€ μ κ·Ό κ°λ₯)
                - λͺννκ² ν΄μ£ΌκΈ° μν΄ @GetMapping, @PostMapping μ¬μ© ν  κ²    


    c. viewsμμ ν΄λλ₯Ό λ§λ€μ΄μ λΆλ¦¬(home, login)
        - home(folder) : /src/main/webapp/WEB-INF/views/home/ (home.jsp, member_list.jsp, record.jsp)
        - login(folder): /src/main/webapp/WEB-INF/views/login (login.jsp, join.jsp)
            
        * νλ©΄λ¨(view jsp file)μμ λ²νΌ ν΄λ¦­μ λ§ν¬λλ‘ μ΄λνκ² μμ 
            - μλ°λ¨(Controller)μμ RequestMapping μ GetMappingμ μ μ νκ² μ¬μ©
               - κ·Έλ° ν μ»¨νΈλ‘€λ¬μ μ€μ ν κ°λλ‘ κ° νλ©΄λ¨ jsp νμΌμ href μμ 


    d. κ³΅ν΅ ν€λ λΆλ¦¬ ν import
        - /src/main/webapp/WEB-INF/views/common/ (header.jsp, footer.jsp)
        - κ° νλ©΄λ¨(jsp) νμΌλ€μμ header, footer λΆλΆμ μ§μ°κ³  κ³΅ν΅ ν€λ λΆλΆμ import
               <%@ include file="/WEB-INF/views/common/header.jsp" %>
            <%@ include file="/WEB-INF/views/common/footer.jsp" %>
            * κΌ­ μ§μ΄ header, footer μμΉμμ import ν΄μ€μΌν¨


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
    a. β DB νλ¦ β
         - Controller> Service > DAO > Mapper > DB
            - Controller(λλ¬Έ) > Service(Serviceμμ DAO κ°μ κ°μ Έμ΄) > DAO(DAO λ΄μ©μ΄ Mybatis ν΅ν΄ Mapper) 
                * Controller λλ¬Έ μ­ν μ νλ €λ©΄ @Autowiredλ‘ Service κ°μ κ°μ ΈμμΌ νλ€.
                
                
    b. Service package, DAO package, Mapper package μμ±
        a. /src/main/java/com/spring/boot/dao 
            - @Mapper interfaceλ‘ μμ±ν΄μΌν¨ (class X)
        b. /src/main/resources/sqlmapper
            - XML νμΌ μμ±(DB μΏΌλ¦¬)
        c. /src/main/java/com/spring/boot/service
            - @Service, @Autowired(DAO), classλ‘ μμ± (interface X)
           
           
    c. jspμ λ°μ΄ν° λ°μΈλ©(Service > DAO > Mapper > DB > Controller(request) > View)
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

        * Controllerμμ jsp λ λλ§ νλ κ³Όμ μ @ResponseBody μ¬μ©ν  κ²½μ° jspμμ view νλ©΄ λ³΄μ¬μ£Όμ§ μμ(@ResponseBody μ΄λΈνμ΄μ μ­μ )


    d. Modelμ κ°μ λ΄μμ λ£λ λ°©λ²
        - Controller Parameterμ Model model μΆκ° ν  model.addAttribute("μ΄λ¦", κ°); λ‘ μΆκ°νλ©΄ λ¨
        
        
    e. VO package μμ±
        a. /src/main/java/com/spring/boot/vo
            - Vo_record(classλ‘ μμ±)        
            - VOλ DB Tableμ μ»¬λΌκ°λ€μ μ μΈν΄μ€λ€κ³  μκ°νλ©΄ λλ€.
                private String key_id;
                private String study_day;
                private String contents;
                private String reg_day;
                
        b. Mapper resultType μμ 
            <select id="doStudyList" resultType="com.spring.boot.vo.Vo_record">   
            
        c. Dao μμ (VO κ°μ²΄μ μ κ·ΌνκΈ° μν΄ type μμ )
            - public List<Vo_record> doStudyList(); // VO κ°μ²΄λ‘ λ°ν
            
        d. StudyService(VO κ°μ²΄μ μ κ·ΌνκΈ° μν΄ type μμ )
            - public List<Vo_record> doStudyList()
            - List<Vo_record> list = new ArrayList<>();
            
        e. Controller μμ (VO κ°μ²΄μ μ κ·ΌνκΈ° μν΄ type μμ )
            - List<Vo_record> list = new ArrayList<>();
            - for(Vo_record vo_record : list) 
                - Getter & Setter μ¬μ©(vo_record.getKEY_ID())
                
        f. JSP μμ 
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
            * STSμμ Syntax error on token ")", delete this token ν΄λΉ μλ¬ λ¬΄μ         
        
    f. resultMap(μ‘΄μ¬νμ§ μλ column λ³μΉ­ μ¬μ© κ°λ₯νκ² ν΄μ£Όλ κΈ°λ₯)
        a. resultMapμ columnκ°κ³Ό propertyμ μ§μ ν κ°μ λ§€νν  μ μλ€.
            e.g VO κ°μ²΄ μ»¬λΌμμ λ³μΉ­μ μ¬μ©ν΄μΌνλ€λ©΄? resultMapμ μ¬μ©νλ©΄λλ€.(κΈ°μ‘΄ VO κ°: study_day -> λ³μΉ­ μ¬μ©ν  μ»¬λΌ κ°:study_day20)
            * columnμ VOκ°μ²΄ DBμ°κ²°ν μΏΌλ¦¬μμμ μ»¬λΌλ€μ΄λ€.
            * columnμμ μ§μ ν κ°κ³Ό propertyμ μ§μ ν κ°μ λ§€ν ν΄μ€λ€λ₯Ό λ»ν¨.
            
        b. <resultMap type="com.spring.boot.vo.Vo_record" id="map_vo_record"></resultMap>
            a. idλ VO κ°μ²΄ DBμ°κ²°ν μΏΌλ¦¬ <select id="doStudyList" resultType="com.spring.boot.vo.Vo_record" resultMap="map_vo_record">    μμ resultMap="" κ°μ resultMap idμ μ μ΄μ€
            b. resultMap typeμ VO κ°μ²΄ DBμ°κ²°ν μΏΌλ¦¬μμ resultType κ·Έλλ‘ λ³΅μ¬ ν ν resultMap typeμ λ£μ΄μ£Όλ©΄ λλ€. 
         
            <!-- Mybatis(resultMap) -->
            <resultMap type="com.spring.boot.vo.Vo_record" id="map_vo_record">
                <result column="key_id" property="key_id" jdbcType="NVARCHAR" javaType="String" />
                <result column="study_day" property="study_day" jdbcType="NVARCHAR" javaType="String" />
                <result column="contents" property="contents" jdbcType="NVARCHAR" javaType="String" />
                <result column="reg_day" property="reg_day" jdbcType="NVARCHAR" javaType="String" />
            </resultMap>
            
            <!-- VO κ°μ²΄ μ°κ²° -->
            <select id="doStudyList" resultMap="map_vo_record">        
                SELECT to_char(key_id) AS key_id, study_day AS study_day20, contents AS contents20, to_char(reg_day,'YYYY-mm-dd hh24mi') AS reg_day 
                FROM Study_record
            </select>
            
            * https://mybatis.org/mybatis-3/configuration.html (typeHandlers)
            * https://mybatis.org/mybatis-3/sqlmap-xml.html
        
        c. VO, Controller, Mapper, jsp νμΌ μμ 
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
                
                <!-- VO κ°μ²΄ μ°κ²° -->
                <select id="doStudyList" resultMap="map_vo_record">        
                    SELECT to_char(key_id) AS key_id, study_day, contents, to_char(reg_day,'YYYY-mm-dd hh24mi') AS reg_day 
                    FROM Study_record
                </select>
            
            d. jsp 
                <!-- returnType : VO κ°μ²΄  -->
                <% for(Vo_record vo_record : list) { %>
                <div class="row mb-3">
                    <div class="col"><%= vo_record.getKey_id() %></div>
                    <div class="col"><%= vo_record.getStudy_day() %></div>
                    <div class="col"><%= vo_record.getContents() %></div>
                    <div class="col"><%= vo_record.getReg_day() %></div>
                </div>
            <% } %>
            
            
    g. mapUnderscoreToCamelCase(μ€λ¬΄μμ κ±°μ μ¬μ©)        
        - μΈλλ° λ€μ μ²«κΈμλ λλ¬Έμλ‘ νκΈ°
            e.g key_id -> keyId
            
        a. application.properties Setting
            - mybatis.configuration.map-underscore-to-camel-case=true
                            
        b. VO, Controller, Mapper, jsp νμΌ μμ 
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
                <!-- VOκ°μ²΄ DBμ°κ²°(mapUnderscoreToCamelCase) -->
                <select id="doStudyList" resultType="com.spring.boot.vo.Vo_record">        
                    SELECT to_char(key_id) AS key_id, study_day, contents, to_char(reg_day,'YYYY-mm-dd hh24mi') AS reg_day 
                    FROM Study_record
                    ORDER BY key_id
                </select>
            
            d. jsp 
                <!-- mapUnderscoreToCamelCase : VO κ°μ²΄  -->
                <% for(Vo_record vo_record : list) { %>
                <div class="row mb-3">
                    <div class="col"><%= vo_record.getKeyId() %></div>
                    <div class="col"><%= vo_record.getStudyDay() %></div>
                    <div class="col"><%= vo_record.getContents() %></div>
                    <div class="col"><%= vo_record.getRegDay() %></div>
                </div>
                <% } %>         
