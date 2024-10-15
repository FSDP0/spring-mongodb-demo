# Spring MongoDB
Spring Data MognoDB 사용 예시 어플리케이션입니다.

### 기술 스택
 * Lombok
 * Spring Data MongoDB
 * Swagger(OpenAPI)

### 실행 방법
```bash
$ ./gradlew bootRun
```

### 호출 방법
Sensor 정보에 대한 예시 Document를 생성 및 호출합니다.

 * Endpoint : http://localhost:8080/api/v1/sensor
```
# Sensor Document 목록 조회
$ curl -X GET http://localhost:8080/api/v1/sensor

# 특정 Sensor Document 조회
$ curl -X GET http://localhost:8080/api/v1/sensor/{id}

# Sensor Document 생성
$ curl -X POST http://localhost:8080/api/v1/sensor -d '{ "temp": "31.1", "humi": "80.3"}'

# Sensor Document 갱신
$ curl -X PUT http://localhost:8080/api/v1/sensor/{id} -d '{ "temp": "31.1", "humi": "80.3"}'

# Sensor Document 삭제
$ curl -X DELETE http://localhost:8080/api/v1/sensor/{id}
```