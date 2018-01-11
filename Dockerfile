FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/tutorial-clojure.jar /tutorial-clojure/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/tutorial-clojure/app.jar"]
