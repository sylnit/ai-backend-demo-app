# AI Backend Demo App
This application is a Backend AI app written in Spring Boot that shows the capability for function calling in LLM powered apps. Function calling is one of the ways organizations can make an AI model to use their data in responding to user chats. This backend app uses a locally hosted model (qwen3:1.7b) that runs off ollama. However, any open source LLM model can be used as long as the resources to host the model are available on the users' computer.

## Prerequisites
This application requires an open source AI model to be hosted locally. Don't worry about it, you can get low power and memory models for test running the app. 

### Setup of Ollama
For an extensive guide on how to install Ollama on your OS environment, use this guide:
https://ollama.com/download , and follow the instructions to set it up.

### Run a open source model
After set up, make sure it's running.
Then run the model you want to use.
```agsl
ollama run modelName
eg. ollama run qwen3:1.7b
```

### Make sure Java is installed and running on system
Install Java in your environment. For a guide on how to install Java in your environment. use this link: https://www.oracle.com/ng/java/technologies/downloads/

### Install maven build tool
To install maven as a build tool in your environment, use this link: https://maven.apache.org/install.html

## Run the backend

### Clone the application
```agsl
git clone git@github.com:sylnit/ai-backend-demo-app.git (ssh)
or 
git clone https://github.com/sylnit/ai-backend-demo-app.git (https)
```

### Open app in code editor and Configure the model in the application.properties file
For this demo, I used the open source model qwen3:1.7b
```agsl
spring.application.name=ai-backend-demo
spring.ai.ollama.chat.options.model=qwen3:1.7b
```

### Install dependencies
```agsl
Reload the maven project
```

### Run the app
```agsl
mvn spring-boot:run
```