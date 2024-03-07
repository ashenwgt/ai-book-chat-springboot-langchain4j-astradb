# ai-book-chat-springboot-langchain4j-astradb

## Overview

Upload a book in PDF format and ask questions through REST API.

## Initial Setup

Generate a fresh project with Springboot Web dependency (https://start.spring.io/).

    cd chat-api
    mvn -N wrapper:wrapper -Dmaven=3.9.6

Create Serverless Vector DB instance on AstraDB (https://astra.datastax.com/).

    DB Name: vector-db-1
    Provider: AWS
    Region: us-east-1
    Namespace: ai_book_chat
    Table: vectordb

Create API Key from OpenAI (https://platform.openai.com/api-keys).

Set required environment variables.

    export ASTRA_DB_ID="XXXXX"
    export ASTRA_DB_TOKEN="AstraCS:XXXXXXX"
    export ASTRA_DB_REGION="us-east-1"
    export ASTRA_DB_NAMESPACE="ai_book_chat"
    export ASTRA_DB_TABLE="vectordb"
    export OPENAI_API_KEY="XXXXX"

Build and run application.

    ./mvnw clean install
    ./mvnw spring-boot:run

Test REST endpoint via a tool like Postman or `curl`.

    curl --location 'http://localhost:8080/api/chat' --header 'Content-Type: application/json' --data 'What is Cassandra?'

## Tech Stack

- AstraDB: Serverless, multi-cloud DBaaS built on Apache Cassandra. Used as the embedding store (a.k.a vector database).
- OpenAI: Chat language model. Used to feed embeddings from vector DB to GPT LLM and get responses for queries.
- Java 21
- Springboot 3.2.3
- Maven 3.9.6




