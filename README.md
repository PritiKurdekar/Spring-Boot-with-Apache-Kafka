#H2 DATABASE
http://localhost:8081/h2-console

SELECT * FROM ACCOUNT;

INSERT INTO ACCOUNT (account_number, balance) VALUES ('A1', 1000);
INSERT INTO ACCOUNT (account_number, balance) VALUES ('A2', 500);
======================================================================================================
#TO TEST APPLICATION
http://localhost:8080/transactions

{
  "transactionId": "T1",
  "fromAccount": "A1",
  "toAccount": "A2",
  "amount": 500
}
========================================================================================================

**APACHE KAFKA**

Transaction Service → Kafka → Account Service

Benefits:
Async processing
Loose coupling
Scalable
Real-world microservices

**1. Add Kafka Dependency**
<dependency>
    <groupId>org.springframework.kafka</groupId>
    <artifactId>spring-kafka</artifactId>
</dependency>

**2. Kafka Config 
transaction-service (Producer)**
spring.kafka.producer.bootstrap-servers=localhost:9092
spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer=org.springframework.kafka.support.serializer.JsonSerializer

**account-service(Consumer)**
spring.kafka.consumer.bootstrap-servers=localhost:9092
spring.kafka.consumer.group-id=bank-group
spring.kafka.consumer.auto-offset-reset=earliest
spring.kafka.consumer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer=org.springframework.kafka.support.serializer.JsonDeserializer

spring.kafka.consumer.properties.spring.json.trusted.packages=*

**3. Install Kafka**
**4. Generate cluster id**
bin\windows\kafka-storage.bat random-uuid
Y4L-ja26K8owTBWGC2I_66WWxw

**5. Format storage**
bin\windows\kafka-storage.bat format -t Kwz7ETPVTxOKaGh-q-WAMg -c config\controller.properties --standalone

bin\windows\kafka-storage.bat format -t Kwz7ETPVTxOKaGh-q-WAMg -c config\server.properties --standalone

**6. Start controller**
bin\windows\kafka-server-start.bat config\controller.properties

**7.Start Broker**
bin\windows\kafka-server-start.bat config\server.properties

**8. Create Topic**
Open NEW Command Prompt [Go to kafka folder again: cd D:\SOFTWARE-SETUP\kafka_2.13-4.0.2]

bin\windows\kafka-topics.bat --create --topic bank-topic --bootstrap-server localhost:9092

**9. Verify Topic**
bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092














INSERT INTO ACCOUNT (account_number, balance) VALUES ('A1', 1000);
INSERT INTO ACCOUNT (account_number, balance) VALUES ('A2', 500);
