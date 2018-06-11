FROM openjdk:8
COPY target/*.jar ibreath.jar
CMD ["java", "-jar", "ibreath.jar"]