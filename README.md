# person-api
"reference" impl of the kotlin-ktor-moshi API setup

NOTE: in progress, just a seed, too many TODOs to mention

### run with gradle:
- ```./gradlew  run```

### run fat jar:
- ```java -jar ./build/libs/personapi.jar```

### run in docker:
- ```docker build -t ktorone .``` then ```docker run -p 8080:8080 ktorone```

### api endpoints:
- ```curl -X POST -H "Content-Type: application/json" -d @SampleCreatePerson.json localhost:8080/api/v1/addperson```
- ```curl http://localhost:8080/api/v1/listall```
- ```curl http://localhost:8080/api/v1/removeall```
