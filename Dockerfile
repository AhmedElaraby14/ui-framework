FROM maven:3.6.0-jdk-8-alpine

# copying src of the framework
COPY src /home/SeleniumTestFramework/src

# copying pom.xml of the farmework
COPY pom.xml /home/SeleniumTestFramework

# copying testng.xml of the farmework
COPY testng.xml /home/SeleniumTestFramework

# running the actual command
RUN mvn -f /home/SeleniumTestFramework/pom.xml clean test -DskipTests=true