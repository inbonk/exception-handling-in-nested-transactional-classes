### Catching RuntimeException at nested @Transactional classes

This application is an example for showing how exception handling works in Spring transaction manager.

#### launch mysql with docker and create a test schema
```bash
docker run --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1234 -d --rm mysql:5 --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
sleep 20
docker exec -i -t mysql mysql -p1234 -e 'create database exercise'
```

#### run the application runner
```bash
./gradlew bootRUn
```


#### run test
```bash
./gradlew test
```
