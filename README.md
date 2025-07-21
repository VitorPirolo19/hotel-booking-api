<h1 align="center" style="font-weight: bold;">Hotel Booking API</h1>

<p align="center">
 <a href="#tech">Tecnologias</a> • 
 <a href="#started">Primeiros Passos</a> • 
  <a href="#routes">Endpoints</a> 
</p>

<p> 
  <b>Projeto desenvolvido com o objetivo de praticar e consolidar conhecimentos em desenvolvimento backend utilizando Spring Boot.
A aplicação simula um sistema de reservas de quartos, com funcionalidades como criação, validação e listagem de reservas, além de filtros personalizados.

O sistema também inclui autenticação com JWT, permitindo o controle de acesso às funcionalidades protegidas da API.

Este projeto foca em boas práticas de organização de código, uso de camadas (controller, service, repository), manipulação de dados com JPA, tratamento de exceções e documentação com Swagger.</b>
</p>

<h2 id="technologies">💻 Tecnologias</h2>

- Java
- Spring Boot
- Maven

<h2 id="started">🚀 Primeiros Passos</h2>

<h3>Pré-requistos</h3>


- [Java 17 ou superior](https://www.oracle.com/java/technologies/downloads/#java21)
- [Maven 3.8.7 ou superior](https://maven.apache.org/)

<h3>Clonando</h3>

Como clonar o projeto

```bash
git clone https://github.com/VitorPirolo19/hotel-booking-api.git 
```

<h3>Iniciando</h3>

Como iniciar o projeto

```bash
cd hotel-booking-api 
mvn spring-boot:run
```

<h2 id="routes">📍Endpoints</h2>

### Quartos (`/rooms`)

| Método | Caminho     | Descrição                                        |
|--------|--------------|--------------------------------------------------|
| `GET`  | `/rooms`    | Retorna todos os quartos cadastrados.           |

**Exemplo de Resposta:**
```json
[
  {
    "number": 101,
    "room_type": "DOUBLE",
    "description": "Quarto com vista para o mar",
    "capacity_of_people": 2,
    "price_per_night": 350.0
  }
]
```

---

| `POST` | `/rooms`    | Cria um novo quarto com os dados enviados.      |

**Exemplo de Requisição:**
```json
{
  "number": 102,
  "room_type": "SUITE",
  "description": "Quarto de luxo com banheira",
  "capacity_of_people": 3,
  "price_per_night": 600.0
}
```

**Exemplo de Resposta:**
```json
{
  "number": 102,
  "room_type": "SUITE",
  "description": "Quarto de luxo com banheira",
  "capacity_of_people": 3,
  "price_per_night": 600.0
}
```

---

| `GET`  | `/rooms/{id}` | Retorna os detalhes de um quarto pelo ID.   |

| `DELETE` | `/rooms/{id}` | Remove um quarto com base no ID informado. |

---

### 🔹 Verificar Disponibilidade (`/rooms/available`)

| Método | Caminho               | Descrição                                                                  |
|--------|------------------------|------------------------------------------------------------------------------|
| `GET`  | `/rooms/available`    | Retorna todos os quartos disponíveis para o intervalo de datas informado.  |
|        | Parâmetros obrigatórios: `checkin`, `checkout` (formato: `yyyy-MM-dd'T'HH:mm:ss`) |

**Exemplo de Requisição:**
```
GET /rooms/available?checkin=2025-08-01T14:00:00&checkout=2025-08-05T12:00:00
```

**Exemplo de Resposta:**
```json
[
  {
    "number": 105,
    "room_type": "SINGLE",
    "description": "Quarto individual simples",
    "capacity_of_people": 1,
    "price_per_night": 200.0
  }
]
```

---

### 🔹 Reservas (`/rooms/bookings`)

| Método | Caminho                   | Descrição                                                                 |
|--------|----------------------------|-----------------------------------------------------------------------------|
| `GET`  | `/rooms/bookings`         | Lista todas as reservas ou filtra por `username` e/ou `room_number`.      |
|        | Parâmetros opcionais: `username`, `room_number`                  |

**Exemplo de Requisição:**
```
GET /rooms/bookings?username=joao&room_number=102
```

**Exemplo de Resposta:**
```json
[
  {
    "id": 1,
    "room": {
      "number": 102,
      "room_type": "SUITE",
      "description": "Quarto de luxo com banheira",
      "capacity_of_people": 3,
      "price_per_night": 600.0
    },
    "username": "joao",
    "number_of_people": 2,
    "checkin": "2025-08-01T14:00:00",
    "checkout": "2025-08-05T12:00:00",
    "price": 2400.0
  }
]
```

---

| `POST` | `/rooms/bookings`         | Cria uma nova reserva.                            |

**Exemplo de Requisição:**
```json
{
  "roomNumber": 102,
  "username": "joao",
  "numberOfPeople": 2,
  "checkin": "2025-08-01T14:00:00",
  "checkout": "2025-08-05T12:00:00"
}
```

**Exemplo de Resposta:**
```json
{
  "id": 1,
  "room": {
    "number": 102,
    "room_type": "SUITE",
    "description": "Quarto de luxo com banheira",
    "capacity_of_people": 3,
    "price_per_night": 600.0
  },
  "username": "joao",
  "number_of_people": 2,
  "checkin": "2025-08-01T14:00:00",
  "checkout": "2025-08-05T12:00:00",
  "price": 2400.0
}
```

---

| `DELETE` | `/rooms/bookings/{id}` | Remove uma reserva com base no ID.              |