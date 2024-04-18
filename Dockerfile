# Build stage
FROM eclipse-temurin:21-jdk-alpine as build
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

# Skipping unit tests to speed up the build
RUN ./mvnw clean install -DskipTests

# Runtime stage
FROM eclipse-temurin:21-jre-alpine
VOLUME /tmp

# Run as non-root user for security
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
USER appuser

COPY --from=build /workspace/app/target/*.jar app.jar

# Health check
HEALTHCHECK --interval=30s --timeout=30s --start-period=5s --retries=3 \
  CMD curl -f http://localhost:8080/actuator/health || exit 1

ENTRYPOINT ["java","-jar","/app.jar"]


