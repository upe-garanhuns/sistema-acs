# 2. Níveis

`/2. Níveis`

* [Sistema ACS | Docs](../README.md)
  * [1. Requisitos](../1.%20Requisitos/README.md)
    * [1.1 Requisitos do Sistema](../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/README.md)
    * [1.2 Casos de uso](../1.%20Requisitos/1.2%20Casos%20de%20uso/README.md)
      * [1.2.1 Usuário geral](../1.%20Requisitos/1.2%20Casos%20de%20uso/1.2.1%20Usu%C3%A1rio%20geral/README.md)
      * [1.2.2 Aluno](../1.%20Requisitos/1.2%20Casos%20de%20uso/1.2.2%20Aluno/README.md)
    * [1.3 Requisitos Arquiteturais](../1.%20Requisitos/1.3%20Requisitos%20Arquiteturais/README.md)
    * [1.4 Backlog do Sistema](../1.%20Requisitos/1.4%20Backlog%20do%20Sistema/README.md)
  * [**2. Níveis**](../2.%20N%C3%ADveis/README.md)
    * [2.1 Contexto - C1](../2.%20N%C3%ADveis/2.1%20Contexto%20-%20C1/README.md)
    * [2.2 Container - C2](../2.%20N%C3%ADveis/2.2%20Container%20-%20C2/README.md)
    * [2.3 Componente - C3](../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/README.md)
      * [2.3.1-Back](../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/2.3.1-Back/README.md)
    * [2.4 Código - C4](../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/README.md)
      * [2.4.1-Atividades](../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1-Atividades/README.md)
      * [2.4.2-Classes](../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.2-Classes/README.md)
      * [2.4.3-Sequência](../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.3-Sequ%C3%AAncia/README.md)
      * [2.4.4 Máquina de estados](../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.4%20M%C3%A1quina%20de%20estados/README.md)
  * [3. Manutenção da arquitetura](../3.%20Manuten%C3%A7%C3%A3o%20da%20arquitetura/README.md)

---

O modelo C4 é uma abordagem altamente amigável e de fácil aprendizado para a diagramação de arquitetura de software. Ao criar diagramas de arquitetura de software bem elaborados, é possível desempenhar um papel fundamental na comunicação eficaz, tanto internamente, entre as equipes de desenvolvimento e produto de software, quanto externamente, com outros stakeholders.

Esses diagramas são uma ferramenta valiosa para auxiliar na integração eficiente de novos membros da equipe, pois fornecem uma visão clara e concisa da estrutura e interações do sistema. Além disso, eles possibilitam análises e avaliações detalhadas da arquitetura, permitindo identificar pontos fortes e fracos, bem como oportunidades de melhoria.

Outro benefício importante dos diagramas de arquitetura de software é a capacidade de identificar riscos potenciais, como a tempestade de riscos, através da visualização clara das dependências e interações entre os componentes do sistema. Isso possibilita a tomada de medidas preventivas e o planejamento de estratégias para mitigar os riscos identificados.

Além disso, os diagramas de arquitetura também são úteis na modelagem de ameaças, permitindo visualizar possíveis vulnerabilidades e definir medidas de segurança adequadas. Com um entendimento aprofundado da arquitetura do sistema, é possível tomar decisões informadas para garantir a proteção adequada dos dados e a segurança geral do sistema.

## Nível 1: Diagrama de contexto do sistema
Um diagrama de contexto do sistema é um excelente ponto de partida para a diagramação e documentação de um sistema de software, pois permite uma visão geral do mesmo. Nele, é possível representar o sistema como uma caixa central, cercada por seus usuários e outros sistemas com os quais interage. Desenhar esse tipo de diagrama proporciona uma compreensão mais clara e abrangente do sistema, permitindo uma análise mais completa de sua interação com o ambiente ao seu redor.

O detalhe não é importante aqui, pois esta é a sua visão ampliada mostrando uma imagem grande da paisagem do sistema. O foco deve estar nas pessoas (atores, funções, personas, etc.) e sistemas de software, em vez de tecnologias, protocolos e outros detalhes de baixo nível. É o tipo de diagrama que você pode mostrar para pessoas não técnicas.

## Nível 2: Diagrama de contêiner
Após obter uma compreensão de como seu sistema se encaixa no ambiente geral de TI, uma etapa extremamente útil é expandir os limites do sistema por meio de um diagrama de contêiner. Um "contêiner" pode ser entendido como um componente como um aplicativo da Web do lado do servidor, um aplicativo de página única, um aplicativo de desktop, um aplicativo móvel, um esquema de banco de dados, um sistema de arquivos, entre outros. Basicamente, um contêiner é uma unidade autônoma e implantável separadamente, como um espaço de processo isolado, capaz de executar código ou armazenar dados de forma independente.

O diagrama do contêiner mostra a forma de alto nível da arquitetura de software e como as responsabilidades são distribuídas por ela. Ele também mostra as principais opções de tecnologia e como os contêineres se comunicam entre si. É um diagrama simples e focado em tecnologia de alto nível que é útil para desenvolvedores de software e equipe de suporte/operações.

## Nível 3: Diagrama de componentes
É possível expandir e decompor cada contêiner de forma mais detalhada, a fim de identificar os principais blocos de construção estruturais e suas interações. O diagrama de componentes oferece uma visão clara de como um contêiner é composto por diversos "componentes", fornecendo informações sobre a natureza de cada um desses componentes, suas responsabilidades e os detalhes relacionados à tecnologia e implementação utilizada. Esse tipo de diagrama permite uma compreensão mais aprofundada da estrutura do sistema, destacando os elementos fundamentais que o compõem e como eles se relacionam entre si.

## Nível 4: Diagrama de código
Por fim, é possível aprofundar cada componente para exibir como ele é implementado em forma de código, utilizando diagramas de classe UML, diagramas de entidade-relacionamento ou técnicas similares. Esses diagramas fornecem uma representação visual das relações entre as classes, entidades ou componentes, destacando seus atributos, métodos e associações. Ao utilizar tais diagramas, você pode comunicar de forma eficaz os detalhes técnicos da implementação do sistema e evidenciar o funcionamento interno de cada componente.

Este é um nível de detalhe opcional e, normalmente, pode ser acessado sob demanda por meio de ferramentas como IDEs. Idealmente, esse tipo de diagrama deveria ser gerado automaticamente utilizando ferramentas como uma IDE de modelagem ou UML. Ao criar esses diagramas, é importante considerar mostrar apenas os atributos e métodos relevantes que ajudem a contar a história desejada. É importante ressaltar que esse nível de detalhe não é recomendado para todos os componentes, sendo mais adequado para destacar os componentes mais importantes ou complexos.