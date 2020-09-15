FROM java:8
COPY ./target/*.jar /app/shopping-cart-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/app/shopping-cart-0.0.1-SNAPSHOT.jar"]