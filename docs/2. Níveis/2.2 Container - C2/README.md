# 2.2 Container - C2

`\2. Níveis\2.2 Container - C2`

* [Sistema ACS | Docs](../../README.md)
  * [1. Requisitos](../../1.%20Requisitos/README.md)
    * [1.1 Requisitos do Sistema](../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/README.md)
    * [1.2 Casos de uso](../../1.%20Requisitos/1.2%20Casos%20de%20uso/README.md)
      * [1.2.1 Usuário geral](../../1.%20Requisitos/1.2%20Casos%20de%20uso/1.2.1%20Usu%C3%A1rio%20geral/README.md)
      * [1.2.2 Aluno](../../1.%20Requisitos/1.2%20Casos%20de%20uso/1.2.2%20Aluno/README.md)
    * [1.3 Requisitos Arquiteturais](../../1.%20Requisitos/1.3%20Requisitos%20Arquiteturais/README.md)
    * [1.4 Backlog do Sistema](../../1.%20Requisitos/1.4%20Backlog%20do%20Sistema/README.md)
  * [2. Níveis](../../2.%20N%C3%ADveis/README.md)
    * [2.1 Contexto - C1](../../2.%20N%C3%ADveis/2.1%20Contexto%20-%20C1/README.md)
    * [**2.2 Container - C2**](../../2.%20N%C3%ADveis/2.2%20Container%20-%20C2/README.md)
    * [2.3 Componente - C3](../../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/README.md)
      * [2.3.1-Back](../../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/2.3.1-Back/README.md)
    * [2.4 Código - C4](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/README.md)
      * [2.4.1-Atividades](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1-Atividades/README.md)
      * [2.4.2-Classes](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.2-Classes/README.md)
      * [2.4.3-Sequência](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.3-Sequ%C3%AAncia/README.md)
      * [2.4.4 Máquina de estados](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.4%20M%C3%A1quina%20de%20estados/README.md)
  * [3. Manutenção da arquitetura](../../3.%20Manuten%C3%A7%C3%A3o%20da%20arquitetura/README.md)

---

![diagram](https://www.plantuml.com/plantuml/svg/0/ZLLDRzD04BrRydyOaYDAAPKGD9MgXhGgLAM49eK3HMXiRvnLxHrhTvrI43y6SK3YYhXmpHzZrlR6QMbAVOdN-sRcpPkFx1cBsfPv1liIKuqvGhm5FOX9MPHAw31uO6SY5s0AZ4M6KHYO2waAP2nWR4cFxLKc02-5eLo4GHWeIWHqnj9OmUu6GzE1BZwDyCasV0a3uEVzeCXaZ8iVY-y4bo8wLnC33-5Ki4F-FH6Vx97v06XWgfc8DngzF5T7E4U6Z0ijLGeHaQrm4SONDIn1Yn4QPZ0YOrCjnc-EEuwMkwpSGK_BT6PxlTtAh0-bmVhQ7LTkMmTz69wUxOV1rpQ_OIQ5iWB6hoQZZgFWNg0xtKoURM_wH1KnWkzEDg5xgF6g_kgUuyMlb2K0TYNKN5BrqijHPeRbFtGl6pLQgAJoSoswLvVViRHCnCjPKHcKThQMokERL5Py7LDA2XP_b8oP4K5Ab79nNpk7Tz5vAn66ee1tuoe-7zrf7OEjcmo6f4oPLnfmaHlpTV5g9rKbFrQd5MSZJVF5pnmi9Onni5B5aXHcCi54cAP524oJCn9NlrnyqtK5C2QTK8sAAGSZIYY4dieC4BZdhTJSOAvbcLtBhANbEcWDgrleE5_8ez1h8ZOJCMSrdGv7XjIZ5vF9Q4sm9Fedr43d-5aeTDTIJOcFxFCtXp8KQMVbLRMUmbAC6r6QMIaBdeHLjJDU2trU5LSxOL0F34EQMRe5qWwHdwpTblWgC0m6Rft0cQz7ztbMYXq7sU1gpaIoOtanz2F-wh479gOCTPMARxTr5fvjGfUAETGpqX9O8g5P2DVGzN3_5rqhuTl_3lWooHLzxpJWZ1rXnhRwt0vVxeCmg5ZNATp3y42vngkNa6lsfGDVjkjgtzl97dSL_yFy1G00)

Após compreender como o sistema de Atividades Complementares (ACs) se encaixa no ambiente geral de Tecnologia da Informação (TI), a próxima etapa consiste em ampliar os limites do sistema por meio de um diagrama de contêiner. Um "contêiner" pode ser entendido como uma entidade autônoma, como um aplicativo da web do lado do servidor, um aplicativo de página única, um aplicativo desktop, um aplicativo móvel, um esquema de banco de dados, um sistema de arquivos ou uma API, entre outros exemplos. Em essência, um contêiner é uma unidade independente e implantável, que opera em seu próprio espaço de processo, executando código ou armazenando dados.

Ao representar esses contêineres em um diagrama, é possível visualizar a estrutura e as interações entre eles. Isso proporciona uma visão clara da arquitetura do sistema, identificando os componentes principais e suas dependências. O diagrama de contêiner ajuda a compreender como essas entidades autônomas colaboram para fornecer funcionalidades do sistema de ACs e como se relacionam com outros sistemas e recursos de TI. Esse diagrama é uma ferramenta valiosa para comunicar a arquitetura do sistema, permitindo que as equipes de desenvolvimento, gerentes de projeto e outras partes interessadas tenham uma visão abrangente da estrutura do sistema e das tecnologias envolvidas. Ele serve como base para a análise, aprimoramento e manutenção contínua da arquitetura, facilitando o entendimento do sistema e auxiliando na tomada de decisões técnicas.

* **Escopo:** Um único sistema de software.
* **Elementos primários:** Contêineres dentro do sistema de software no escopo.
* **Público alvo:** Técnicos dentro e fora da equipe de desenvolvimento de software, incluindo arquitetos de software, desenvolvedores e equipe de operações/suporte.
* **Observações:** Este diagrama não diz nada sobre cenários de implantação, clustering, replicação e failover etc.

## Principais elementos
### Containers
* **Aplicação web:** 
  * A plataforma web foi desenvolvida utilizando o framework React e Next.js, juntamente com a linguagem TypeScript. Essa combinação tecnológica proporciona uma base sólida para a criação de uma interface interativa e responsiva, que permite aos usuários interagir com todas as funcionalidades do sistema.
  * Ao utilizar o framework React, a plataforma se beneficia de uma arquitetura de componentes reutilizáveis, o que facilita a criação e a manutenção de uma interface consistente e escalável. O Next.js oferece recursos avançados, como renderização do lado do servidor e roteamento simplificado, que aprimoram o desempenho e a experiência do usuário.
  * A integração com a API é essencial para garantir a funcionalidade completa da plataforma. Por meio de comunicação eficiente com a API, a interface pode enviar e receber dados de forma transparente, permitindo que os usuários realizem ações e obtenham informações atualizadas em tempo real.
  * Essa abordagem de desenvolvimento, utilizando React, Next.js e TypeScript, resulta em uma plataforma web moderna, robusta e escalável, que oferece aos usuários uma experiência interativa e completa. A combinação dessas tecnologias possibilita a criação de interfaces de usuário atraentes e funcionais, ao mesmo tempo em que facilita a integração eficiente com os dados do sistema.
* **API:**
  * A API de backend desempenha um papel central no sistema, sendo desenvolvida com as tecnologias Java e Spring Boot. Essa combinação tecnológica é altamente adequada para lidar com o processamento de solicitações dos usuários, gerenciar a lógica de negócios e facilitar a integração com bancos de dados, sistemas externos e serviços.
  * Ao utilizar Java e Spring Boot, a API se beneficia de recursos avançados e padrões de desenvolvimento estabelecidos. O Java é uma linguagem amplamente adotada, conhecida por sua estabilidade, desempenho e suporte à orientação a objetos. O Spring Boot, por sua vez, é um framework que simplifica o desenvolvimento de aplicativos Java, oferecendo recursos integrados, configuração automática e uma arquitetura baseada em convenções.
  * Essa escolha tecnológica permite que a API seja robusta, escalável e segura. O Java e o Spring Boot fornecem um ambiente confiável para o processamento de solicitações, garantindo que o sistema possa lidar com um grande volume de tráfego e oferecer desempenho consistente. Além disso, o ecossistema do Spring Boot oferece recursos de segurança abrangentes, como autenticação e autorização, que podem ser facilmente implementados.
  * Por meio dessa combinação de Java e Spring Boot, a API de backend se torna uma solução eficiente e confiável para o sistema, capaz de atender às necessidades de processamento de dados, gerenciamento de lógica de negócios e integração com outros componentes do sistema.