# 2.3.1-Back

`\2. Níveis\2.3 Componente - C3\2.3.1-Back`

* [Sistema ACS | Docs](../../../README.md)
  * [1. Requisitos](../../../1.%20Requisitos/README.md)
    * [1.1 Requisitos do Sistema](../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/README.md)
    * [1.2 Casos de uso](../../../1.%20Requisitos/1.2%20Casos%20de%20uso/README.md)
      * [1.2.1 Usuário geral](../../../1.%20Requisitos/1.2%20Casos%20de%20uso/1.2.1%20Usu%C3%A1rio%20geral/README.md)
      * [1.2.2 Aluno](../../../1.%20Requisitos/1.2%20Casos%20de%20uso/1.2.2%20Aluno/README.md)
      * [1.2.3 Coordenador](../../../1.%20Requisitos/1.2%20Casos%20de%20uso/1.2.3%20Coordenador/README.md)
      * [1.2.4 Comissão](../../../1.%20Requisitos/1.2%20Casos%20de%20uso/1.2.4%20Comiss%C3%A3o/README.md)
    * [1.3 Requisitos Arquiteturais](../../../1.%20Requisitos/1.3%20Requisitos%20Arquiteturais/README.md)
    * [1.4 Backlog do Sistema](../../../1.%20Requisitos/1.4%20Backlog%20do%20Sistema/README.md)
  * [2. Níveis](../../../2.%20N%C3%ADveis/README.md)
    * [2.1 Contexto - C1](../../../2.%20N%C3%ADveis/2.1%20Contexto%20-%20C1/README.md)
    * [2.2 Container - C2](../../../2.%20N%C3%ADveis/2.2%20Container%20-%20C2/README.md)
    * [2.3 Componente - C3](../../../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/README.md)
      * [**2.3.1-Back**](../../../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/2.3.1-Back/README.md)
    * [2.4 Código - C4](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/README.md)
      * [2.4.1-Atividades](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1-Atividades/README.md)
      * [2.4.2-Classes](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.2-Classes/README.md)
      * [2.4.3-Sequência](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.3-Sequ%C3%AAncia/README.md)
      * [2.4.4 Máquina de estados](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.4%20M%C3%A1quina%20de%20estados/README.md)
  * [3. Manutenção da arquitetura](../../../3.%20Manuten%C3%A7%C3%A3o%20da%20arquitetura/README.md)

---

![diagram](https://www.plantuml.com/plantuml/svg/0/bPNDRjD04CVlaV8Eq-ISNX1210arIW1ng5gvL1nGX2RUIRB2ksjsrnK5yJ0zzSGfuWdyOiok4sotJfhwaEp7Vxv-dbsVEO_M5og3cSILHOKmVG4Zc1gL6qtQa-ltJloQ587BCQKC5_rUlwUD81YyjqRxqJij1e0Ebc46Gtorm9UluLUG_Gu_RFODLooVN7wCGinbKmRyB4qcoCBWYkoDBEzDrBamIGqCFw-bfvqqF5-c7CgQZ2OfEMUkAk6y8KZeUo6TJD5CoNgvv94uhElOF6Yg3UTKP_arpeSVBDxMcl1S6kSA2GXPkLcnBs1ocbRb9fK6X6cBdNIU59xMgwH535MjHA1DO5iGdA6DpD9w_ZItXl4UTYt1uzeRqVRMF_45ib0PA1H8xYYhICZopdBvt62MsdAiD4lkDQO3XIksqffWsu15pwQMK6wSzEM6FKTijbem8L87jcjN86ybjQgRrnv1eu-w5JkUZJJsyap8yT5qvTqDPP3pQrxYJww9hKrE5ilxycyuj2r41DFaUiPXO86QJnGl24x67KziPbJvHszf2QEaxYPrpXT3PkP1fUAmiJVxT14tX3SjUbmFNqFp2a0rUOnc6_C0bfoDkQ4mgFbVSeNa8BTIfp97-P29SRk-EGP3lDj6LgxMVZHw6wwmtLRpnF7E_qihavh6VANUll7qmuyNMK4mvdxUrhRJiKch-GwOTSIBrXMofcaOdGfqQn8jDmgrp8liOGhiXT_9ynqq4mzEgZT-Z9-Bv3n-7SwODtzz_W40)

O diagrama de componentes em questão oferece uma representação visual dos componentes principais do sistema. Esses componentes são elementos fundamentais que desempenham papéis específicos no funcionamento do sistema como um todo.

## Back-end
### Convenções
Para promover a separação de responsabilidades, a coesão e a manutenção da arquitetura, são adotados padrões de nomenclatura para pastas, arquivos, funções e variáveis. As pastas são organizadas para representar as diferentes camadas do software e são nomeadas como "controlador", "serviço", "repositório" e "modelo". Os arquivos seguem a convenção de "nome da entidade + nome da camada", por exemplo, "RequisicaoController". Em relação às funções e variáveis, é recomendado utilizar o camelCase, pois isso melhora a legibilidade do código.

### Camadas
* **Controlador:** O Controlador atua como uma ponte entre a interface do usuário e a lógica de negócio da aplicação. Ele recebe os dados fornecidos pelo usuário, faz a validação dos parâmetros de entrada e decide qual ação precisa ser tomada com base nas informações recebidas. Essa camada também é responsável por traduzir as respostas do serviço em uma representação adequada para a interface do usuário, como um JSON ou uma página HTML.
* **Serviço:** A camada Serviço, por sua vez, contém a lógica de negócio da aplicação. Ela é responsável por processar as requisições recebidas do Controller, realizar as operações necessárias e coordenar as interações entre diferentes componentes do sistema. O serviço encapsula as regras de negócio e pode fazer chamadas a outras camadas, como a camada de acesso a dados (Repositório), para buscar ou persistir informações no banco de dados.
* **Repositório:** O Repositório é a camada responsável pelo acesso aos dados. Ele fornece métodos para recuperar, armazenar e manipular informações no banco de dados ou em outros meios de armazenamento. Essa camada abstrai os detalhes do acesso ao banco de dados, permitindo que o serviço trabalhe com objetos de domínio sem precisar conhecer os detalhes da implementação do banco de dados.
* **Modelo:** A camada Modelo representa os objetos de domínio da aplicação. Ela define as entidades e seus atributos, bem como os relacionamentos entre elas. Os objetos de domínio são usados pelo serviço e pelo Repositório para manipular as informações da aplicação de acordo com as regras de negócio.
* **Config:** Inclui várias classes de configuração, como as responsáveis pela autenticação e autorização, além das classes de configuração do Swagger.
* **Utils:** Possui os utilitários do sistema (Classes de exceção).

### Novos casos de uso
Para implementar novos casos de uso na API, siga o passo-a-passo abaixo:

* Crie o **modelo** para a entidade em questão, definindo seus atributos.
* Crie o **repositório** responsável pela camada de acesso aos dados da entidade.
* Crie o **serviço** que irá implementar a lógica de negócio relacionada à entidade.
* Crie o **controlador** responsável por receber as requisições relacionadas à entidade e retornar as respostas correspondentes.