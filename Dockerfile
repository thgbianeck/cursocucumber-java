FROM maven:3.8.7-openjdk-18-slim

WORKDIR /app

CMD ["tail", "-f", "/dev/null"]