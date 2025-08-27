# 1. Build aşaması
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Sadece pom.xml'i kopyala ve bağımlılıkları indir
COPY pom.xml .
RUN mvn dependency:go-offline

# Kaynak kodu kopyala ve package veya install çalıştır
COPY src ./src
RUN mvn clean install -DskipTests

# Oluşan jar'ı kontrol et
RUN echo "Target dizini içeriği:" && ls -l /app/target

# 2. Run aşaması
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Build aşamasından jar'ı al
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
