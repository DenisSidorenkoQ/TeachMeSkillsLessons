docker run --rm \
            --name tomcat \
            -p 8080:8080 \
            --network some-network \
            -v "/mnt/d/rep/TeachMeSkillsLessons/demo-servlet/target/demo-servlet-1.0-SNAPSHOT.war:/usr/local/tomcat/webapps/servlet.war" \
    tomcat:9.0.53-jdk11-openjdk

docker build -t "servlet:latest" .

docker run --rm \
            --name custom-tomcat \
            -p 8080:8080 \
            --network some-network \
            servlet:latest



docker run --network some-network --rm curlimages/curl:7.85.0 http://custom-tomcat:8080/servlet/test

docker run --network some-network --rm curlimages/curl:7.85.0 -X POST http://custom-tomcat:8080/servlet/test
