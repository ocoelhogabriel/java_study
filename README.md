# 📖 **Manual da Aplicação - ConexX Middleware V2**

## 📌 **Introdução**
A aplicação **ConexX Middleware V2** é um sistema de integração para comunicação entre dispositivos via ConexX entre APIs e Protocolos de Comunicação. O projeto inclui **três módulos de integração**:

1. **SARA** – Integração com a API **TOTVS Sara** para controle de acesso e biometria.
2. **SENIORX** – Integração com a plataforma **SeniorX**, incluindo WebSockets e comunicação de pendências.
3. **PROTOCOLO 8** – Integração via **socket TCP/IP** para troca de mensagens com dispositivos conectados.


## ⚙️ **Configurações Gerais da Aplicação**
### 🌐 **Servidor**
```properties
server.port=8090
spring.main.banner-mode=off
spring.application.name=conexx.md.v2
```
- A aplicação roda na porta **8090**.
- O banner do Spring Boot está **desativado**.

### 📑 **Documentação API**
```properties
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/
```
- A documentação **OpenAPI (Swagger)** pode ser acessada em:
  - **Docs JSON:** `http://localhost:8090/api-docs`
  - **Swagger UI:** `http://localhost:8090/`

### ⏳ **Configuração de Timezone**
```properties
spring.jackson.time-zone=America/Sao_Paulo
spring.jackson.serialization.write-dates-as-timestamps=false
```
- O **fuso horário** padrão é **America/São_Paulo**.
- Datas **não serão serializadas como timestamps**.

### 🔗 **Integração com Conex API**
```properties
conex.api.url=http://localhost:59976
```
- Local onde deve passar a **URL da API Conex**, host e porta de comunicação.


## 🛠️ **Integrações**

### **1️ Integração - Sara**
```properties
tenant.client=sara
sara.api.authUsername=telematica
sara.api.authPassword=tele@1234
sara.api.manufacturerList=telematica,dimep
sara.api.keepAliveDeviceSeconds=200
sara.api.baseUrlAccess=https://sandbox.tlra.totvs.com.br
sara.api.baseUrlBiometry=https://sandbox.tlra.totvs.com.br
```
🔹 **Descrição:**  
A integração **Sara** é responsável por autenticação e gerenciamento de dispositivos dos fabricantes **Telemática** e **DIMEP**.

🔹 **Principais Configurações:**
- **Autenticação**: `telematica / tele@1234`
- **Fabricantes suportados**: `telematica, dimep`
- **Tempo de KeepAlive do dispositivo**: `200s`
- **URLs de acesso e biometria**:  
  - Acesso: `https://sandbox.tlra.totvs.com.br`
  - Biometria: `https://sandbox.tlra.totvs.com.br`


### **2️ Integração - SeniorX**
```properties
tenant.client=seniorx
senior.api.timePoolingPendencySeconds=60
senior.api.reconnectIntervalWebSocketSeconds=5000
senior.api.timeDriverAliveSeniorSeconds=30
senior.api.timeDeviceAliveSeniorSeconds=60
senior.api.timeWaitingRestTemplateSeconds=10000
senior.api.sdkSenior=https://sam-api.senior.com.br/sdk/v1
senior.api.websocket=wss://sam-api.senior.com.br/websocket/pendency?driver_key=...
```
🔹 **Descrição:**  
A integração **SeniorX** gerencia **pendências**, **status de dispositivos** e **comunicação WebSocket** com a plataforma **Senior**.

🔹 **Principais Configurações:**
- **Tempo de pooling de pendências**: `60s`
- **Intervalo de reconexão do WebSocket**: `5000s`
- **Tempo de vida do Driver e do Dispositivo**:
  - Driver: `30s`
  - Dispositivo: `60s`
- **Tempo máximo de espera do RestTemplate**: `10000ms`
- **SDK da Senior**: `https://sam-api.senior.com.br/sdk/v1`
- **Conexão WebSocket para pendências**:
  ```properties
  senior.api.websocket=wss://sam-api.senior.com.br/websocket/pendency?driver_key=...
  ```


### **3️ Integração - Protocolo 8**
```properties
tenant.client=protocolo8
senior.protocolo.driver=800
senior.protocolo.socketHost=192.168.0.240
senior.protocolo.socketPort=61000
senior.protocolo.certificate=TSI.CER
senior.protocolo.timeOutAwaitSocketSecond=60
senior.protocolo.timeOutAwaitSearchDeviceSecond=5
senior.protocolo.scheduledKeepAliveDeviceSecond=30
```
🔹 **Descrição:**  
A integração **Protocolo 8** é uma comunicação baseada em **Sockets** para envio e recebimento de mensagens com equipamentos conectados na rede.

🔹 **Principais Configurações:**
- **ID do Driver**: `800`
- **Configuração do Socket**:
  - **Host**: `192.168.0.240`
  - **Porta**: `61000`
- **Certificado de autenticação**: `TSI.CER`
- **Timeouts**:
  - Tempo de espera do Socket: `60s`
  - Tempo de espera ao buscar dispositivos: `5s`
- **KeepAlive agendado a cada** `30s`


## 📡 **Documentação das APIs**

### 🔹 **Webhook de Recebimento de Eventos**
```http
POST /api/conex/webhook
```
- **Descrição:** Recebe eventos de Webhook do sistema externo.
- **Body:** `WebHookModel`
- **Respostas:**
  - `200 OK` - Processado com sucesso.
  - `400 Bad Request` - Erro na requisição.


### 🔹 **Validação de Acesso**
```http
POST /api/conex/accessValidation
```
- **Descrição:** Valida um acesso enviado pelo Webhook.
- **Body:** `WebhookAccessValidateModel`
- **Respostas:**
  - `200 OK` - Validação bem-sucedida.
  - `400 Bad Request` - Erro na validação.
  - `500 Internal Server Error` - Erro no processamento.

### 🔹 **Ativação de Leitor Biométrico**
```http
POST /api/conex/biometricActivation
```
- **Descrição:** Ativa um leitor biométrico via IP.
- **Parâmetros:**
  - `ipAddress` (String) - IP do leitor.
  - `card` (String) - Código do cartão associado.
  - `typeBiometric` (Enum) - Tipo de leitor (`FINGERPRINT`, `FACIAL`, `IRIS`).
- **Respostas:**
  - `204 No Content` - Ativação bem-sucedida.
  - `400 Bad Request` - Erro na requisição.
  - `500 Internal Server Error` - Erro no servidor.


### 🔹 **Listagem de Dispositivos**
```http
GET /api/conex/devices
```
- **Descrição:** Retorna a lista de dispositivos conectados.
- **Respostas:**
  - `200 OK` - Lista de dispositivos.
  - `404 Not Found` - Nenhum dispositivo encontrado.
  - `400 Bad Request` - Erro na requisição.


### 🔹 **Limpeza de Pendências**
```http
DELETE /api/conex/clean-pendency
```
- **Descrição:** Remove pendências de acesso e dispositivos.
- **Respostas:**
  - `200 OK` - Pendências removidas.
  - `400 Bad Request` - Erro na requisição.

