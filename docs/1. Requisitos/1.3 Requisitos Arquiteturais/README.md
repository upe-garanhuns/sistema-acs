# 1.3 Requisitos Arquiteturais

`/1. Requisitos/1.3 Requisitos Arquiteturais`

* [Sistema ACS | Docs](../../README.md)
  * [1. Requisitos](../../1.%20Requisitos/README.md)
    * [1.1 Requisitos do Sistema](../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/README.md)
    * [1.2 Casos de uso](../../1.%20Requisitos/1.2%20Casos%20de%20uso/README.md)
      * [1.2.1 Usuário geral](../../1.%20Requisitos/1.2%20Casos%20de%20uso/1.2.1%20Usu%C3%A1rio%20geral/README.md)
      * [1.2.2 Aluno](../../1.%20Requisitos/1.2%20Casos%20de%20uso/1.2.2%20Aluno/README.md)
    * [**1.3 Requisitos Arquiteturais**](../../1.%20Requisitos/1.3%20Requisitos%20Arquiteturais/README.md)
    * [1.4 Backlog do Sistema](../../1.%20Requisitos/1.4%20Backlog%20do%20Sistema/README.md)
  * [2. Níveis](../../2.%20N%C3%ADveis/README.md)
    * [2.1 Contexto - C1](../../2.%20N%C3%ADveis/2.1%20Contexto%20-%20C1/README.md)
    * [2.2 Container - C2](../../2.%20N%C3%ADveis/2.2%20Container%20-%20C2/README.md)
    * [2.3 Componente - C3](../../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/README.md)
      * [2.3.1-Back](../../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/2.3.1-Back/README.md)
    * [2.4 Código - C4](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/README.md)
      * [2.4.1-Atividades](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1-Atividades/README.md)
      * [2.4.2-Classes](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.2-Classes/README.md)
      * [2.4.3-Sequência](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.3-Sequ%C3%AAncia/README.md)
      * [2.4.4 Máquina de estados](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.4%20M%C3%A1quina%20de%20estados/README.md)
  * [3. Manutenção da arquitetura](../../3.%20Manuten%C3%A7%C3%A3o%20da%20arquitetura/README.md)

---

| RA 001 | Fluxo de requisição |
|----------|----------|
| Referência:| RF 011, 014, 019, 020, 021, 025, 026. |
| Descrição:| Este requisito é de grande importância arquitetural, pois é responsável pelo fluxo das solicitações que envolvem alunos, coordenação e comissão. |
| Prioridade:  | Essencial.  |
| Decisão arquitetural:  | Utilização de estratégias no backend para realizar o fluxo de cadastro e avaliação da requisição.  |
| Atributo de qualidade:  | Performance. |

| RA 002 | Desempenho |
|----------|----------|
| Referência:  | RNF 001, 002.  |
| Descrição:  | Esse requisito impacta na percepção das informações e carregamento de telas pelo usuário.  |
| Prioridade:  | Importante.  |
| Decisão Arquitetural:  | Utilização de estratégias no back e front para evitar carregamento de informações desnecessárias que podem aumentar o tempo de resposta.  |
| Atributo de Qualidade:  | Performance.  |

| RA 003 | Disponibilidade |
|----------|----------|
| Referência:  | RNF 003. |
| Descrição:  | Esse requisito influencia o quanto o sistema estará disponível para os usuários efetuarem suas atividades.  |
| Prioridade:  | Essencial.  |
| Decisão Arquitetural:  | Utilização de servidor pessoal de um dos membros da equipe para disponibilização da API.|
| Atributo de Qualidade:  | Disponibilidade.  |

| RA 004 | Segurança |
|----------|----------|
| Referência:  | RNF 005, 006. |
| Descrição:  | Esse requisito impacta na segurança do sistema, sendo vital para preservar a privacidade dos usuários e sua segurança.  |
| Prioridade:  | Importante.  |
| Decisão Arquitetural:  | Utilização no HTTPs e Autenticação/autorização via sistema e OAuth2.|
| Atributo de Qualidade:  | Segurança.  |

| RA 005 | Documentação |
|----------|----------|
| Referência:  | RNF 007. |
| Descrição:  | O requisito impacta na capacidade de realizar manutenções, sendo vital para um bom entendimento do webservice.  |
| Prioridade:  | Importante.  |
| Decisão Arquitetural:  | Utilização do Swagger para gerar documentação dos endpoits da API.|
| Atributo de Qualidade:  | Manutenabilidade.  |