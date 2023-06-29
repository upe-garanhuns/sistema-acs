# 1.2.3 Coordenador

`\1. Requisitos\1.2 Casos de uso\1.2.3 Coordenador`

* [Sistema ACS | Docs](../../../README.md)
  * [1. Requisitos](../../../1.%20Requisitos/README.md)
    * [1.1 Requisitos do Sistema](../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/README.md)
    * [1.2 Casos de uso](../../../1.%20Requisitos/1.2%20Casos%20de%20uso/README.md)
      * [1.2.1 Usuário geral](../../../1.%20Requisitos/1.2%20Casos%20de%20uso/1.2.1%20Usu%C3%A1rio%20geral/README.md)
      * [1.2.2 Aluno](../../../1.%20Requisitos/1.2%20Casos%20de%20uso/1.2.2%20Aluno/README.md)
      * [**1.2.3 Coordenador**](../../../1.%20Requisitos/1.2%20Casos%20de%20uso/1.2.3%20Coordenador/README.md)
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
      * [2.4.4 Máquina de estados](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.4%20M%C3%A1quina%20de%20estados/README.md)
  * [3. Manutenção da arquitetura](../../../3.%20Manuten%C3%A7%C3%A3o%20da%20arquitetura/README.md)

---

![diagram](https://www.plantuml.com/plantuml/svg/0/VPBDIWCn58NtWRp35JUwQD6LC9IX8Fe05jVbDhcsmVoK_5Hz777X4_W4ys8cqqwRQfMi9lETatDkCWqHVKn6myFz_EhwXhEpk2934DOeIEE2i_2ix1ez6a0HdP_5Dqs0BnIS8SuuQnv3wjwzSY0T11KY6Mm0C40A2Sl-UQJNs2nqodnpwvoNP54wtnH87BwFmTbWbQ6TxH70cISHqIvpd25yMHSpfvLGkHUioHiLGlT50IJjZ-e-kmztsViEw7o7eii6TtQZibewaGpPw0AK_h11hMGbfXwRPon0Lcr_rxAUscqNx62TkoYzZMIVb3U_NNkYr1c6E1grf-FMCSPUBLTntDQdLaE31YOJPOLEajesXpvX2ECihpt_adDMNrs9TrIrJh2FLPVxntYuxcBwSnvJiZA_Lyw-0G00)

![diagram](https://www.plantuml.com/plantuml/svg/0/dPHDRjim48Nt0dI7QRff5tOShrh1CD84yRg8jmQ4aJIEYLAamvyqFKyNFK5Fa8jrH4cs9Ki9KXW6HCtttWmv75rRXyRvKiBz2cPNNoRpUHpP7qBjqM09c3jjrkwN9C2VP7L9SVJ1xQWai7lCIM8MHt5aA7Ue7fYwk5-no-NiwklbR3xZ__oY0f9RhKr12Wjj4a0B-N4D7nqzkoIJdisJjR2EIWoGhPyxG1nzkjNAUibrWsG0DweWCFJeXHKlVrx-alrSPsYeD51fGMa3vQY3pqf8PzZbNBkj8mU19XiKtxdQ0Xq6g7eulBLy9DOP2f5sSOmwTBvIdEJwhMisXFgbLIAKNjLCU0hlroGf5rfrgcwT3h6-svtAiHHgrrD1rMD0FgbIMDlQq07kszoWU4QpKMUPin0up_eaE2CtK4ZW5d53jiAKUDHH8D90f7KLZNRjiv8STUlTABHMy9r1KBgz7FNM6_oaXBI91xjlpeZC2mDxCjpRS6EwkyQ6I6kYKqtzExsnaydohVlLmILj7Ki6pgdl-kfE-l1uqHtIY8TTbNwqiwzk1HRJwT10d4mb9B1Oy89KiLp6qH1ScLG3ytvLEqp_eUoFrlijmkIDozu-kC6X73TiltYJqAwHwHZi8qod8v9-Dg5owGkgqbrpMlxsnz4_)

![diagram](https://www.plantuml.com/plantuml/svg/0/VPDDJiCm48NtaNA7eMnWqGXOHb5K2TerIWyGJUqfM3XsiHr-piE2W_HYE0wX8NAwYsVUUvxvhAoiG-FQHaArWPkxspInBq8Tq603o9msM_Sf2V2Th6ueJIxSCpK4ze2C9ExI94qCCOVgoQiMrSP7BD8alzVQS5B8jSa1BR3J6IuTVRXy9riVbs-5TTHW4Dd--vyWJQugT68l61emzDeAAuxVnozztJdCqAf_Mmnry3pGdeo8E7ZVcEg5udEElzRKirPlmW_b9nOoA2aKwb2eoTPXwI1zz3nXO7AA7gWCYK6sjanBD88ZfpvsLEXaOvRBPJa38LQ58iiY14R08OUYy0TIl2pFXCIWpCSC3zjDEmCfMeOiAyUGfZS8nMJBgRjYtZ_6ToOWkchmHvFdWrP-QVy__G00)