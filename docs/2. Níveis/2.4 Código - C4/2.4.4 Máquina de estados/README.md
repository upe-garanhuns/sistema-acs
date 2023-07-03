# 2.4.4 Máquina de estados

`\2. Níveis\2.4 Código - C4\2.4.4 Máquina de estados`

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
      * [2.3.1-Back](../../../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/2.3.1-Back/README.md)
    * [2.4 Código - C4](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/README.md)
      * [2.4.1-Atividades](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1-Atividades/README.md)
      * [2.4.2-Classes](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.2-Classes/README.md)
      * [2.4.3-Sequência](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.3-Sequ%C3%AAncia/README.md)
      * [**2.4.4 Máquina de estados**](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.4%20M%C3%A1quina%20de%20estados/README.md)
  * [3. Manutenção da arquitetura](../../../3.%20Manuten%C3%A7%C3%A3o%20da%20arquitetura/README.md)

---

![diagram](https://www.plantuml.com/plantuml/svg/0/VP9DJWCn34Rt8yqTl4QQ2x107GsLMCEIOM4IjqHgR8WJgUfrM72GNWndIZNbRtQHzRsNsCvACwPSuWu6IZbiWaClRTCsZrTFqDr0pxIt2bn3hoekr3EEdEYj1BMmPS-HhiQt1PD7zj8pxeAIWG_bEGRLuxkCx15cT6Gd4Tnyhvhiby2izoVa-66ETPpDQtOO0xzW9Cu2hvZiQOD8yiGufTlcRtQIkgAdrYvQj-TzbHVGtb78Fq6SYWlK89nnI_6MxYIXBZHYKxgqZ0nrKDyMzA-iMvZN6O9DgBK3UgohNX5x-m6V)

![diagram](https://www.plantuml.com/plantuml/svg/0/ZLFBJiCm4Bn7oZ_uZ9GVu82AGZXNuKWvBFOgjPJijdOI8Nw70n_I7sCJDu-657gprhEpC-FrnjVWwgOgLOx7ndfx-ZvzSHp5qUlTcqeUL5Rbu7L3UrRt0qO3gzHPC117i_kaXxyqxvNr7XPuBsMixKhB4vPO0ncU3ngEsOSk6sj4qM-Oz8h8Zc-QsKju92YjnvJP6IJGIor86YfBUp6memCuK7g2Tdmh19V4eyECMic1HvfmSOr3I59spXQsyp494Xxdn2nffje9do9OFCXgNtAJtNDhY7vfuJf3A0PpMDvaBXk3vQtaaNdD9JYPR71Ec5wa_KTFy9UZRfpl96tHo2ueWxi-AIYmwjVf35XRmDPs9pWuReTzdQ5Jfh1VConX4P3_29ltFjlEsoUO_gM6UZ9iQ1nja8pyiXy0)

Foi reiterado que a "Solicitação de contagem" deve incluir um status específico (como rascunho, submetida, em análise pela coordenação, em análise pela comissão, em despacho pela coordenação, concluída ou em recurso). Além disso, foi ratificado que cada certificado possui o seu próprio status correspondente (anexado, aguardando análise, em análise, aceito ou recusado), acompanhado de observações pertinentes elaboradas pela comissão para melhor compreensão da análise. A Figura 1 representa o diagrama de máquina de estados do fluxo de certificados, enquanto a Figura 2 refere-se ao fluxo de requisições.