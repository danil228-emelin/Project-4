FROM openjdk:14
COPY target/Lab4.jar /tmp
WORKDIR /tmp
CMD java -jar 'Lab4.jar'