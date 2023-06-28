# 1.2.2 Aluno

`/1. Requisitos/1.2 Casos de uso/1.2.2 Aluno`

* [Sistema ACS | Docs](../../../README.md)
  * [1. Requisitos](../../../1.%20Requisitos/README.md)
    * [1.1 Requisitos do Sistema](../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/README.md)
    * [1.2 Casos de uso](../../../1.%20Requisitos/1.2%20Casos%20de%20uso/README.md)
      * [1.2.1 Usuário geral](../../../1.%20Requisitos/1.2%20Casos%20de%20uso/1.2.1%20Usu%C3%A1rio%20geral/README.md)
      * [**1.2.2 Discente**](../../../1.%20Requisitos/1.2%20Casos%20de%20uso/1.2.2%20Aluno/README.md)
    * [1.3 Requisitos Arquiteturais](../../../1.%20Requisitos/1.3%20Requisitos%20Arquiteturais/README.md)
    * [1.4 Backlog do Sistema](../../../1.%20Requisitos/1.4%20Backlog%20do%20Sistema/README.md)
  * [2. Níveis](../../../2.%20N%C3%ADveis/README.md)
    * [2.1 Contexto - C1](../../../2.%20N%C3%ADveis/2.1%20Contexto%20-%20C1/README.md)
    * [2.2 Container - C2](../../../2.%20N%C3%ADveis/2.2%20Container%20-%20C2/README.md)
    * [2.3 Componente - C3](../../../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/README.md)
      * [2.3.1-Back](../../../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/2.3.1-Back/README.md)
    * [2.4 Código - C4](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/README.md)
      * [2.4.1-Atividades](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1-Atividades/README.md)
      * [2.4.2-Classes](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.2-Classes/README.md)
      * [2.4.3-Sequência](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.3-Sequ%C3%AAncia/README.md)
      * [2.4.4 Máquina de estados](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.4%20M%C3%A1quina%20de%20estados/README.md)
  * [3. Manutenção da arquitetura](../../../3.%20Manuten%C3%A7%C3%A3o%20da%20arquitetura/README.md)

---

![diagram](https://www.plantuml.com/plantuml/svg/0/fPJ1Ri8m38RlbVeE6LpO0JIk7Qf0av1sG-m1a4bSY9OcB75WFCyEUn1UR6axM3TQ2QsdsFBdFvR_A5D7OCddYYtdguVnE8xkQ8ivChS3ZWhMSUHUfTw1XPm19sDVwAYGmG6ToJ6EuYXPeCsaOZFbjKaOEBQOiJxXEoLhvGDYaHFeJUYo-EQbasHMcTTS6Wsgu7lBEGjtzmgrmHC8S6J1dkdJv-d3t1VSSbuCE7ZM3gsqp8Kv0uciB5wo6i7Haima1s5S2ScgiAeLQZX9yggwgWfRE86EszfSLSwXbGU22Wn12xCr5gePowY50f9xAK1WILwoDjg61Uwh6R_ZtsGS1Qk6mxJSR5XSUOo4EUXH-hFGlf8Qaus5u-F5LPQmoKHghhp0D3rtXgw63TyaqDGtKfXHqBmsu_-IGQxHhcwAVtpj97RbVoUrnZVIJV7w9Tsa5qTJr29yDN7q1G00)

![diagram](https://www.plantuml.com/plantuml/svg/0/ZP7FJW8n4CRlJVeE8rpmm0eIBYiXOCnwyK1s4wzaM0PexBROTXLy7Gy-WK_0YpbRWdyI3npQTFBzlczcqeaFw49TQSYpUQz_BSL5s515uBTOaiQ55Fv9cIqwh03BO5qHzfe0NydRYgIG8fsHMoaDKrqRcm9wc4sX7MWNqeMkwGSeb0zKuH4f_Y2Eoe1cpS6EdclbLR3pLMrAPGtgXc_b6V1uLxt-WC-mrJJkF2fVerPlwE21in6M1FdHV_WuV9A_RAnvrgpLAKXJp7E_c7TxGWQCt9DZ5HshBnPcTraKjyiLQxUeTl-8x1msi_3AtUuuzWAkYbX59r-G954QGbihG-dQuVxcUtj8OJJYWipIZyTIn8nHaiIfpdKCsE7KUXEIynj9CU4d_xqKNm00)

![diagram](https://www.plantuml.com/plantuml/svg/0/ZP8zJiD044PxIxx349fGn80KKPZ8YWjIMxP4QqtiILYntWtx0uJhKEG4d20NOxnMa04XKRZmp7kZ-KQxj0wDyvs4SbLVNS_vkucZC_T07O7TOKCIrt5a7uNQeS4Ei77QL6ul2V25hEueZjA2p4P8oALNEWMqKEHShOHrrE5GgEB8KEDGRTaqzEI55KxN6wyQeHNA7fgKA-0TBdc7IHp5qRH4wmoXEGd7m_63x4NFcj0IcgbxOJrAySQSKAreiDM6B5YzDXJGNtAvwbDESqc6uqFdMrJ70qBBcHqw_qND0-N8C3LqeCNHm7STI1oGUa3OkLFFWXLEpsVf3mUQ8RvEm8cxkWxDFcQHmsoMZH8LLIZyd7e2O94aOJaubq9HkZMultNqwjArz0GfB1RyGwgrMJQoaYGBmV-sX6gaRwctHYkUnFb_lEyx1tKywZyZucZ9k_EJZADF)

