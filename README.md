# Producer Microservice

A simple Spring Boot microservice that sends JSON messages to RabbitMQ.

## Tech Stack

- **Java 21**
- **Spring Boot 3.2**
- **Spring AMQP** (RabbitMQ integration)
- **Lombok**
- **Maven**

## Project Structure

```
src/main/java/com/example/producer/
├── ProducerMsApplication.java      # Main application entry point
├── config/
│   └── RabbitMQConfig.java         # RabbitMQ configuration properties
├── controller/
│   └── MessageController.java      # REST endpoint
├── dto/
│   └── MessageDto.java             # Message DTO
└── service/
    └── MessageProducerService.java # Service to send messages to RabbitMQ
```

## Setup

### Prerequisites

- Java 21
- Maven 3.8+
- RabbitMQ running locally (default: `localhost:5672`)

### Configuration

Update `src/main/resources/application.properties` if your RabbitMQ credentials differ:

```properties
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest
```

## Running the Application

```bash
mvn spring-boot:run
```

The application will start on **port 8081**.

## API Endpoint

### POST /api/messages/publish

Sends a JSON message to RabbitMQ.

**Request Body:**

```json
{
  "title": "Hello World",
  "content": "This is a test message",
  "author": "miguelg"
}
```

**Example with curl:**

```bash
curl -X POST http://localhost:8081/api/messages/publish \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Hello World",
    "content": "This is a test message",
    "author": "miguelg"
  }'
```

**Example with Postman:**

1. Set method to **POST**
2. URL: `http://localhost:8081/api/messages/publish`
3. Set header: `Content-Type: application/json`
4. In the **Body** tab, select **raw** and **JSON**
5. Paste your JSON payload
6. Click **Send**

**Response (Success):**

```json
{
  "status": "success",
  "message": "Message sent to RabbitMQ",
  "data": {
    "title": "Hello World",
    "content": "This is a test message",
    "author": "miguelg"
  }
}
```

**Response (Validation Error):**

```json
{
  "status": "error",
  "message": "Validation failed",
  "errors": [
    {
      "field": "title",
      "message": "Title is required"
    }
  ]
}
```

## Build

```bash
mvn clean package
```

Then run the JAR:

```bash
java -jar target/producer-ms-0.0.1-SNAPSHOT.jar
```
