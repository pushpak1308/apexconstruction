# Stage 1: Build with Maven Wrapper
FROM eclipse-temurin:17-jdk-focal AS builder
WORKDIR /app

COPY .mvn .mvn
COPY mvnw pom.xml ./
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

COPY src src
RUN ./mvnw clean package -DskipTests

# Stage 2: Lightweight runtime
FROM eclipse-temurin:17-jre-focal
WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

# ✅ Expose the same port that your app uses (Render will override this with $PORT anyway)
EXPOSE 8000

# ✅ Use the PORT environment variable from Render, defaulting to 8000 locally
ENTRYPOINT ["java", "-Dserver.port=${PORT:8000}", "-jar", "app.jar"]
