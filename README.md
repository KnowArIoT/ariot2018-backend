# ariot2018-backend #

To connect to a database, one must add a file named application.conf to src/main/resources:
```
db.default.poolInitialSize=10
db.default.poolMaxSize=20
db.default.poolConnectionTimeoutMillis=1000

db.default.driver="org.postgresql.Driver"
db.default.url="jdbc:postgresql://localhost:5432/postgres"
db.default.user="postgres"
db.default.password="SUPERSECRETPASSWORD"
```

## Build & Run ##

```sh
$ sbt package
```

Then move the generated war-file into a running servlet container, e.g. Tomcat, and open a browser! Tomcat runs on localhost:8080 by default, if you called the war api.war the server will run on localhost:8080/api.

