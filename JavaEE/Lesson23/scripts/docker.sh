docker run --rm \
    --name postgres \
    --network some-network \
    -e POSTGRES_USER=postgres \
    -e POSTGRES_PASSWORD=postgres \
    -p 15432:5432 \
    -v "/mnt/d/rep/TeachMeSkillsLessons/JavaEE/Lesson23/dev-env/postgres/init.sql:/docker-entrypoint-initdb.d/1-init.sql" \
    postgres:13.4-alpine

docker run --rm \
            --name tomcat \
            -p 8080:8080 \
            --network some-network \
            -v "/mnt/d/rep/TeachMeSkillsLessons/JavaEE/Lesson23/target/Lesson23-1.0-SNAPSHOT.war:/usr/local/tomcat/webapps/servlet.war" \
    tomcat:9.0.53-jdk17-corretto

