
# Spring AI Chatbot Platform 🤖

This project is a **Spring AI-based** backend platform designed to build intelligent applications like **chatbots**, **assistants**, and more — all powered by modern LLMs (Large Language Models).

## 🚀 Features

- ✨ **Spring AI Integration** – Easily connect to different LLM providers using Spring AI abstractions.
- 💬 **Chatbot Framework** – Build and extend intelligent chat agents.
- 🧠 **Multi-Provider Support**:
  - [x] OpenAI (ChatGPT, GPT-4, etc.)
  - [x] Ollama (local LLM runner)
  - [x] Mistral
- ⚡ **Local & Cloud Inference** – Use both local and remote models.
- 🔌 Pluggable architecture – Add your own providers or switch between them easily.

## 🛠️ Technologies Used

- Java 17+
- Spring Boot
- Spring AI
- Ollama (local LLM runner)
- OpenAI API
- Mistral models
- Maven

## 📦 Project Structure

```bash
├── .idea/             # IDE configs (ignored now)
├── src/               # Source code
├── .gitignore         # Git ignore rules
├── HELP.md            # Spring Boot starter help
├── mvnw, mvnw.cmd     # Maven wrapper scripts
├── pom.xml            # Maven dependencies and configs
├── system.yml         # App configuration (e.g. Spring AI setup)
```

## 🧪 Running Locally

1. **Install Ollama** (for local model inference):
   [https://ollama.com](https://ollama.com)

2. **Start a local model**:
   ```bash
   ollama run mistral
   ```

3. **Configure your environment** (API keys, models, etc.):
   - Edit `system.yml` or use environment variables.

4. **Run the app**:
   ```bash
   ./mvnw spring-boot:run
   ```

## 📄 Environment Configuration

Example for `system.yml`:

```yaml
spring:
  ai:
    openai:
      api-key: ${OPENAI_API_KEY}
    ollama:
      base-url: http://localhost:11434
      model: mistral
```

## 🧠 Model Flexibility

This project can dynamically switch between:

- 🧠 **OpenAI** (GPT-3.5, GPT-4)
- 🧠 **Mistral** (lightweight, local)
- 🧠 **Other providers** with minimal configuration

## 📍 Goals & Roadmap

- [x] Base integration with Spring AI
- [x] Dynamic provider support (OpenAI, Ollama, Mistral)
- [ ] Build conversational agents (chatbots)
- [ ] Add memory/context support
- [ ] REST APIs for chatbot services
- [ ] Integration with frontend (Angular, React, etc.)

## 🧑‍💻 Author

Built by **azhar-infomover** with ❤️

## 📄 License

This project is open-source and free to use under the [MIT License](LICENSE).
