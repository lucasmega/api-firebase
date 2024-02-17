# Use uma imagem base do OpenJDK
FROM openjdk:17

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo JAR da sua aplicação para o contêiner
COPY target/api-firebase-0.0.1-SNAPSHOT.jar /app

# Expose the port that your application will run on
EXPOSE 8080


# Comando para executar a aplicação Spring Boot quando o contêiner iniciar
CMD ["java", "-jar", "api-firebase-0.0.1-SNAPSHOT.jar"]
