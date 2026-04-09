FROM gradle:8.14.3-jdk-21-and-24-corretto

WORKDIR /app

# Копируем gradle файлы
COPY build.gradle .
COPY settings.gradle .
RUN gradle dependencies --no-daemon || true

# Копируем исходники
COPY src ./src

# Запускаем тесты (проверьте, что это корректные задачи gradle)
ENTRYPOINT ["gradle"]
CMD ["regressionTest", "e2eTest", "smokeUIAndApiTest"]
