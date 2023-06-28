# Sistema ACS | Docs

* [**Sistema ACS | Docs**](README.md)
  * [1. Requisitos](1.%20Requisitos/README.md)
    * [1.1 Requisitos do Sistema](1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/README.md)
    * [1.2 Casos de uso](1.%20Requisitos/1.2%20Casos%20de%20uso/README.md)
      * [1.2.1 Usuário geral](1.%20Requisitos/1.2%20Casos%20de%20uso/1.2.1%20Usu%C3%A1rio%20geral/README.md)
      * [1.2.2 Aluno](1.%20Requisitos/1.2%20Casos%20de%20uso/1.2.2%20Aluno/README.md)
    * [1.3 Requisitos Arquiteturais](1.%20Requisitos/1.3%20Requisitos%20Arquiteturais/README.md)
    * [1.4 Backlog do Sistema](1.%20Requisitos/1.4%20Backlog%20do%20Sistema/README.md)
  * [2. Níveis](2.%20N%C3%ADveis/README.md)
    * [2.1 Contexto - C1](2.%20N%C3%ADveis/2.1%20Contexto%20-%20C1/README.md)
    * [2.2 Container - C2](2.%20N%C3%ADveis/2.2%20Container%20-%20C2/README.md)
    * [2.3 Componente - C3](2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/README.md)
      * [2.3.1-Back](2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/2.3.1-Back/README.md)
    * [2.4 Código - C4](2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/README.md)
      * [2.4.1-Atividades](2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1-Atividades/README.md)
      * [2.4.2-Classes](2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.2-Classes/README.md)
      * [2.4.3-Sequência](2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.3-Sequ%C3%AAncia/README.md)
      * [2.4.4 Máquina de estados](2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.4%20M%C3%A1quina%20de%20estados/README.md)
  * [3. Manutenção da arquitetura](3.%20Manuten%C3%A7%C3%A3o%20da%20arquitetura/README.md)

---

# Descrição

Este artefato tem como objetivo documentar a arquitetura do sistema de atividades complementares da UPE (**ACs-UPE**). Ele proporciona uma visão abrangente da arquitetura do sistema, servindo como uma forma de comunicação entre os membros da equipe do projeto, abordando decisões arquiteturais significativas tomadas durante o desenvolvimento. O documento apresenta uma descrição detalhada da estrutura e organização do sistema, incluindo seus principais componentes, interfaces, fluxos de informação e dependências. Ele também destaca as principais decisões arquiteturais, como a escolha de tecnologias, padrões de projeto e estratégias de integração.

É essencial para garantir uma compreensão compartilhada entre os membros da equipe e permitir a colaboração efetiva no desenvolvimento do sistema. Além disso, serve como um ponto de referência para futuras discussões e análises de impacto, à medida que o projeto evolui e novas funcionalidades são adicionadas. Ao fornecer uma visão geral da arquitetura, o documento facilita a comunicação entre os stakeholders do projeto, incluindo desenvolvedores, gerentes de projeto e partes interessadas, permitindo que todos tenham uma compreensão clara das principais decisões arquiteturais e do funcionamento geral do sistema.

Em resumo, o objetivo deste artefato é documentar de forma clara e abrangente a arquitetura do sistema ACs-UPE, promovendo a comunicação efetiva entre os membros da equipe e permitindo uma base sólida para o desenvolvimento e evolução do projeto.

## O que é o ACs-UPE?

O ACs-UPE é um sistema online que disponibiliza uma plataforma web para que os alunos possam enviar suas requisições de atividades complementares e acompanhar o processo de avaliação realizado pelos membros avaliadores. Essa plataforma oferece uma maneira conveniente e acessível para os alunos registrarem suas atividades complementares, fornecendo uma interface interativa para o preenchimento dos dados e o envio das solicitações.

Uma vez submetidas, as requisições passam por um fluxo de avaliação, onde os membros avaliadores podem revisar e avaliar as atividades apresentadas pelos alunos. O sistema facilita esse processo, fornecendo ferramentas e recursos que permitem aos avaliadores realizar as avaliações de forma mais eficiente e precisa. Isso inclui a visualização dos detalhes da requisição, a análise dos documentos comprobatórios e a atribuição das horas correspondentes às atividades realizadas. Além disso, o ACs-UPE oferece recursos para o gerenciamento das requisições entre os avaliadores. Isso inclui a possibilidade de compartilhar informações e comentários sobre as requisições, facilitando a comunicação e colaboração entre os membros da equipe de avaliação. O sistema também fornece mecanismos para o controle do status das requisições, permitindo que os avaliadores definam se uma solicitação é deferida ou indeferida, garantindo uma gestão eficiente do fluxo de avaliação.

## Tecnologias utilizadas

A escolha das tecnologias e componentes arquiteturais foi baseada em uma análise criteriosa, considerando a expertise da equipe, a disponibilidade de recursos de aprendizado e suporte, além do ecossistema envolvido. Garantir uma integração suave com outros sistemas e a capacidade de comunicação eficiente foram fatores cruciais na seleção das tecnologias adequadas.

### Front-end

* [TypeScript](https://www.typescriptlang.org/docs/)
* [React](https://react.dev/reference/react)
* [NextJs](https://nextjs.org/)
* [Styled Components](https://styled-components.com/)

## Back-end

* [Java](https://dev.java/)
* [Spring boot](https://spring.io/)
