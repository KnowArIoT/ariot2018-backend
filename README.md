# ariot2018-backend #

## Build & Run ##

```sh
$ sbt package
```

Then move the generated war-file into a running servlet container, e.g. Tomcat, and open a browser! Tomcat runs on localhost:8080 by default, if you called the war api.war the server will run on localhost:8080/api.

If `browse` doesn't launch your browser, manually open [http://localhost:8080/](http://localhost:8080/) in your browser.
