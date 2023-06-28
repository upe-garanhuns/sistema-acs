# 3. Manutenção da arquitetura

`/3. Manutenção da arquitetura`

* [Sistema ACS | Docs](../README.md)
  * [1. Requisitos](../1.%20Requisitos/README.md)
    * [1.1 Requisitos do Sistema](../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/README.md)
    * [1.2 Casos de uso](../1.%20Requisitos/1.2%20Casos%20de%20uso/README.md)
      * [1.2.1 Usuário geral](../1.%20Requisitos/1.2%20Casos%20de%20uso/1.2.1%20Usu%C3%A1rio%20geral/README.md)
      * [1.2.2 Aluno](../1.%20Requisitos/1.2%20Casos%20de%20uso/1.2.2%20Aluno/README.md)
    * [1.3 Requisitos Arquiteturais](../1.%20Requisitos/1.3%20Requisitos%20Arquiteturais/README.md)
    * [1.4 Backlog do Sistema](../1.%20Requisitos/1.4%20Backlog%20do%20Sistema/README.md)
  * [2. Níveis](../2.%20N%C3%ADveis/README.md)
    * [2.1 Contexto - C1](../2.%20N%C3%ADveis/2.1%20Contexto%20-%20C1/README.md)
    * [2.2 Container - C2](../2.%20N%C3%ADveis/2.2%20Container%20-%20C2/README.md)
    * [2.3 Componente - C3](../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/README.md)
      * [2.3.1-Back](../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/2.3.1-Back/README.md)
    * [2.4 Código - C4](../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/README.md)
      * [2.4.1-Atividades](../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1-Atividades/README.md)
      * [2.4.2-Classes](../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.2-Classes/README.md)
      * [2.4.3-Sequência](../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.3-Sequ%C3%AAncia/README.md)
      * [2.4.4 Máquina de estados](../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.4%20M%C3%A1quina%20de%20estados/README.md)
  * [**3. Manutenção da arquitetura**](../3.%20Manuten%C3%A7%C3%A3o%20da%20arquitetura/README.md)

---

A fim de garantir a aderência contínua da arquitetura ao ciclo de vida do software, é fundamental adotar estratégias que promovam uma manutenção efetiva das diretrizes arquiteturais, bem como da cultura necessária para sua incorporação. Para alcançar esse objetivo, são apresentados a seguir alguns pontos relevantes juntamente com as estratégias que devem ser aplicadas.

## Ciclo de vida

O sistema ACs da UPE adota uma abordagem de ciclo de vida iterativo e incremental, o que traz benefícios significativos para seu desenvolvimento contínuo. Esse ciclo de vida é iterativo, pois busca melhorias contínuas ao longo do tempo, através de iterações bem definidas. Além disso, é incremental, pois visa aumentar gradualmente as funcionalidades do sistema.

Em cada iteração, a equipe de desenvolvimento identifica os requisitos relevantes para uma determinada funcionalidade específica. Esses requisitos são cuidadosamente analisados e projetados, utilizando a arquitetura escolhida como guia. Esse enfoque permite que a equipe foque em um conjunto específico de funcionalidades em cada iteração, o que facilita o planejamento e a execução.

Após a conclusão da fase de projeto, a equipe parte para a implementação do que foi projetado. É nessa etapa que os requisitos são transformados em código funcional. Ao finalizar a implementação, ocorre uma verificação detalhada para assegurar que os requisitos estabelecidos foram devidamente atendidos.

Ao adotar essa abordagem, o sistema ACs da UPE se beneficia da melhoria contínua, da adaptação às necessidades dos usuários e da entrega de valor incremental ao longo do tempo. Isso resulta em um sistema mais robusto, confiável e alinhado com as expectativas dos usuários finais.

## Testes

Os testes desempenham um papel fundamental na validação da aderência da arquitetura, garantindo que os desenvolvedores estejam seguindo as diretrizes estabelecidas e que os resultados estejam em conformidade com as expectativas. Em particular, os testes de carga, estresse e segurança desempenham um papel crucial na verificação dos requisitos arquiteturais de desempenho, disponibilidade e segurança.