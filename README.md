### Catching RuntimeException at nested @Transactional classes

This application is an example for showing how exception handling works in Spring transaction manager.

#### launch mysql with docker and create a database
```bash
docker run --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1234 -d --rm mysql:5.7 --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
sleep 3
docker exec -i -t mysql mysql -p1234 -e 'create database exercise'

```

#### run test
```bash
./gradlew test
```

#### confirm result
```bash
docker exec -i -t mysql mysql -p1234 -e 'select * from exercise.post'
```