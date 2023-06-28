# 1.1 Requisitos do Sistema

## Requisitos funcionais

Os requisitos funcionais desempenham um papel fundamental no desenvolvimento de um sistema ou software, pois eles definem as funcionalidades e comportamentos esperados do sistema. Eles descrevem o que o sistema deve ser capaz de fazer, quais tarefas deve executar e como deve responder a determinados inputs do usuário ou do ambiente.

O papel dos requisitos funcionais é estabelecer uma base clara para o projeto, implementação e teste do sistema. Eles servem como um contrato entre os stakeholders (partes interessadas) e os desenvolvedores, garantindo que todas as partes envolvidas tenham uma compreensão comum das funcionalidades esperadas.

## Prioridade dos requisitos

No processo de priorização dos requisitos, adotamos uma técnica baseada no uso de tags classificadoras, sendo elas: Alta, Média e Baixa.

A prioridade alta é atribuída aos requisitos indispensáveis para o sistema. Esses requisitos são essenciais e sua ausência resultaria na interrupção do funcionamento adequado do sistema, impedindo o cumprimento de seus objetivos. Portanto, é imperativo que esses requisitos sejam implementados obrigatoriamente e de forma impreterível.

A prioridade média é atribuída aos requisitos que são extremamente relevantes para o sistema. A ausência desses requisitos não impede que o sistema seja executado, porém, pode resultar no cumprimento parcial de seus objetivos ou procedimentos, geralmente de maneira insatisfatória. Esses requisitos devem ser implementados, mas caso não sejam, o sistema pode ser implantado em sua forma atual.

A prioridade baixa é atribuída aos requisitos que não comprometem as funcionalidades básicas do sistema, permitindo sua execução de forma satisfatória. Esses requisitos podem ser deixados para versões futuras do software, sendo introduzidos como recursos adicionais em um pacote de atualização.

Ao utilizar essa técnica de classificação, é possível estabelecer uma hierarquia de importância para os requisitos, permitindo uma melhor alocação de recursos e garantindo que os aspectos essenciais do sistema sejam tratados prioritariamente. Isso ajuda a orientar o desenvolvimento de acordo com as necessidades críticas do projeto, enquanto permite o planejamento de implementações futuras para requisitos de menor prioridade

| RF 001 - Realizar cadastro via sistema                                                                                                                            |
| ----------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:**   Um usuário deve ser capaz de realizar cadastro no sistema. |
| **Atores:**   Nenhum.                                                                                                                                             |
| **Prioridade:**   Alta.                                                                                                                                          |
| **Entrada:**  Inserir nome completo, função, período em caso de discente, telefone, email, senha, cep, rua, bairro, cidade, UF, número.                                                       |
| **Pré-condições:** Cadastrar-se com email institucional, senha com 8 ou mais caracteres incluindo caracteres especiais, letras maiúsculas, minúsculas e números.            |
| **Saída:** Confirmação de cadastro.                                                                                                                               |
| **Pós-condições:** O usuário será direcionado para a tela de perfil para certificar que é membro da instituição, passando por um processo de verificação.         |

| RF 002 - Realizar login via sistema                                                                                                      |
| ---------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** Um usuário deve ser capaz de realizar login via sistema.                                                                  |
| **Atores:** Usuário geral.                                                                                                               |
| **Prioridade:** Média.                                                                                                                   |
| **Entrada:** Inserir e-mail e senha.                                                                                                     |
| **Pré-condições:** O usuário deve estar cadastrado.                                                                                      |
| **Saída:** Confirmação de login.                                                                                                         |
| **Pós-condições:** O usuário será direcionado para a tela inicial do sistema, caso informe as credenciais corretamente (e-mail e senha). |

| RF 003 - Escolher perfil do usuário |
| ------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de escolher seu perfil antes de realizaar login caso ele tenha mais de um perfil.                                 |
| **Atores:** Nenhum.                                            |
| **Prioridade:** Alta.                                        |
| **Entrada:** Escolha do perfil de usuário.                                   |
| **Pré-condições:** Já possuir cadastro no sistema.                             |
| **Saída:** Confirmação de perfil escolhido.                                     |
| **Pós-condições:** Usuário será redirecionado para a tela inicial do sistema mediante ao perfil escolhido.                             |


| RF 004 - Realizar login via Google                                                                                                     |
| -------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de fazer login no aplicativo utilizando o serviço de SSO (Single Sign-On) do Google, o OAuth2. |
| **Atores:** Nenhum.                                                                                                                    |
| **Prioridade:** Baixa.                                                                                                                 |
| **Entrada:** Selecionar a conta do Google.                                                                                             |
| **Pré-condições:** Possuir uma conta Google.                                                                                           |
| **Saída:** Confirmação de login.                                                                                                       |
| **Pós-condições:** O usuário será direcionado para a tela de perfil para completar os dados de cadastro.                               |

| RF 005 - Sair do sistema                                                       |
| ------------------------------------------------------------------------------ |
| **Descrição:** O usuário deve ser capaz de sair do sistema.                    |
| **Atores:** Usuário geral.                                                     |
| **Prioridade:** Baixa.                                                         |
| **Entrada:** Selecionar o botão de logoff presente na tela inicial do sistema. |
| **Pré-condições:** O usuário deve estar logado.                                |
| **Saída:** Confirmação de logoff.                                              |
| **Pós-condições:** O usuário será direcionado para a tela de login.            |

| RF 006 - Verificar usuário institucional                                                                                                                   |
| ---------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve realizar o processo de verificação, o qual receberá um token via e-mail para confirmar se é uma conta institucional própria. |
| **Atores:** Usuário geral.                                                                                                                                 |
| **Prioridade:** Alta.                                                                                                                                      |
| **Entrada:** Inserir token recebido por e-mail.                                                                                                            |
| **Pré-condições:** O usuário não pode ser verificado e deve estar logado.                                                                                  |
| **Saída:** Saídas: Confirmação da verificação institucional do usuário.                                                                                    |
| **Pós-condições:** O usuário será direcionado para a tela inicial do sistema.                                                                              |

| RF 007 - Alterar senha                                                                            |
| ------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de alterar sua própria senha.                             |
| **Atores:** Usuário geral.                                                                        |
| **Prioridade:** Baixa.                                                                            |
| **Entrada:** Inserir a senha antiga para ser possível realizar a alteração da nova senha.         |
| **Pré-condições:** O usuário deve estar logado.                                                   |
| **Saída:** Confirmação da alteração da senha.                                                     |
| **Pós-condições:** O usuário recebe uma mensagem informando que a senha foi alterada com sucesso. |

| RF 008 - Recuperar senha                                                                          |
| ------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de recuperar sua senha.                                   |
| **Atores:** Usuário geral.                                                                        |
| **Prioridade:** Baixa.                                                                            |
| **Entrada:** Recuperar senha.                                                                     |
| **Pré-condições:** Recebe o link de recuperação de senha por e-mail.                              |
| **Saída:** Confirmação da alteração da senha.                                                     |
| **Pós-condições:** O usuário recebe uma mensagem informando que a senha foi alterada com sucesso. |

| RF 009 - Consultar dados do próprio usuário                                                                                                                                                                  |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **Descrição:** O usuário deve ser capaz de visualizar todos os seus dados. Sendo possível visualizar o nome completo, cpf, período, telefone, e-mail, senha oculta, status de verificação, curso e endereço. |
| **Atores:** Usuário geral.                                                                                                                                                                                   |
| **Prioridade:** Baixa.                                                                                                                                                                                       |
| **Entrada:** Não possui entradas.                                                                                                                                                                            |
| **Pré-condições:** O usuário deve estar logado.                                                                                                                                                              |
| **Saída:** Não possui saídas.                                                                                                                                                                                |
| **Pós-condições:** O usuário é direcionado para a página de perfil.                                                                                                                                          |

| RF 010 - Editar dados do próprio usuário                                                                |
| ------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de editar seus dados exceto e-mail, matrícula e CPF.            |
| **Atores:** Usuário geral.                                                                              |
| **Prioridade:** Baixa.                                                                                  |
| **Entrada:** Inserir dados a serem alterados.                                                           |
| **Pré-condições:** O usuário deve estar logado.                                                         |
| **Saída:** Confirmação da alteração dos dados.                                                          |
| **Pós-condições:** O usuário recebe uma mensagem informando que seus dados foram alterados com sucesso. |

| RF 011 - Apagar dados do usuário                                                                        |
| ------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de solicitar que todos os seus dados sejam apagados do sistema. |
| **Atores:** Usuário geral.                                                                              |
| **Prioridade:** Média.                                                                                  |
| **Entrada:** Inserir senha do usuário para confirmação da exclusão.                                     |
| **Pré-condições:** O usuário deve estar logado.                                                         |
| **Saída:** Confirmação da exclusão dos dados.                                                           |
| **Pós-condições:** O usuário é redirecionado para a tela de login do sistema.                           |

| RF 012 - Solicitar Desbloqueio de Perfil |
| ------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de solicitar à escolaridade o desbloqueio do seu perfil no sistema em caso de perda de senha e bloqueio geral.                                 |
| **Atores:** Nenhum.                                            |
| **Prioridade:** Média .                                        |
| **Entrada:** Não possui.                                   |
| **Pré-condições:** Possuir um perfil bloqueado no sistema.                             |
| **Saída:** Perfil desbloqueado.                                     |
| **Pós-condições:** Não possui.                             |


### Perfil Aluno

O aluno possui acesso ao sistema para enviar requisições juntamente com suas atividades complementares. Além de obter informações sobre o progresso da validação da sua requisição, permitindo que você acompanhe em qual etapa do processo ela se encontra.

| RF 013 - Dashboard do Discente|
| ------------------------------------------------------------- |
| **Descrição:** O usuário deve ter uma tela inicial para centralizar todas as operações relacionadas ao requerimento.                                 |
| **Atores:** Discente.                                            |
| **Prioridade:** Alta.                                        |
| **Entrada:** Não possui.                                   |
| **Pré-condições:** Estar logado no sistema.                             |
| **Saída:** Acesso ao dashboard.                                     |
| **Pós-condições:** Não possui.                             |

| RF 014 - Cadastrar Requisição                                                                         |
| --------------------------------------------------------------------------------------------------------|
| **Descrição:** O usuário deve ser capaz de cadastrar uma requisição com o intuito de ratificar uma determinada quantidade de horas das suas atividades complementares. Para cadastrar a requisição é preciso que o discente acesse o barema   disponibilizado no dashboard principal para responder todas as informações necessárias.                                                             |
| **Atores:** Discente.                                                                                   |
| **Prioridade:** Alta.                                                                                   |
| **Entrada:** Inserir informações da requisição, como semestre e quantidade de certificados. Para cada certificado, fornecer título, descrição, data, horas, atividade em que se enquadra de acordo com o barema e o arquivo no formato PDF. |
| **Pré-condições:** O usuário deve estar logado.                                                         |
| **Saída:** Confirmação do envio da requisição.                                                          |
| **Pós-condições:** O usuário é redirecionado para a tela específica da requisição enviada, e a coordenação recebe a notificação por e-mail.                                                                                   |

| RF 015 - Consultar lista de requisições                                                                               |
| --------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de visualizar sua lista de requisições.                                       |
| **Atores:** Discente.                                                                                                    |
| **Prioridade:** Alta.                                                                                                 |
| **Entrada:** Não possui entradas.                                                                                     |
| **Pré-condições:** O usuário deve estar logado.                                                                       |
| **Saída:** Não possui saídas.                                                                                         |
| **Pós-condições:** Caso selecione alguma requisição, o usuário é redirecionado para a tela da requisição selecionada. |

| RF 016 - Buscar requisição específica                                               |
| ----------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de visualizar uma requisição específica.    |
| **Atores:** Discente.                                                                  |
| **Prioridade:** Média.                                                              |
| **Entrada:** Não possui entradas.                                                   |
| **Pré-condições:** O usuário deve estar logado.                                     |
| **Saída:** Não possui saídas.                                                       |
| **Pós-condições:** O usuário é redirecionado para a tela da requisição selecionada. |

| RF 017 - Baixar arquivo PDF referente à requisição                                                       |
| -------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ter a opção de fazer o download da requisição em formato PDF.              |
| **Atores:** Discente.                                                                                       |
| **Prioridade:** Baixa.                                                                                   |
| **Entrada:** Não possui entradas.                                                                        |
| **Pré-condições:** O usuário deve estar logado e selecionar a opção de fazer download do arquivo em PDF. |
| **Saída:** Confirmação do download do arquivo.                                                           |
| **Pós-condições:** O usuário vê o arquivo baixado na pasta selecionada.                                  |

| RF 018 - Visualizar indicadores sobre as requisições enviadas |
| ------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de visualizar o status da solicitação em ACEITO ou NEGADO.                                 |
| **Atores:** Discente.                                            |
| **Prioridade:** Média.                                        |
| **Entrada:** Não possui.                                   |
| **Pré-condições:** Possuir solicitações enviadas.                             |
| **Saída:** Resultado do veredito da requisição.                                     |
| **Pós-condições:** Não possui.                             |

| RF 019 - Criar rascunhos de requisições |
| ------------------------------------------------------------- |
| **Descrição:** O usuário deve ter o poder de salvar as informações de uma solicitação, junto de documentos anexos, que ainda possa estar incompleta. Nesse caso, é feito um rascunho da requisição que será encaminhado para a coordenação somente após o usuário solicitá-lo.                                 |
| **Atores:** Discente.                                            |
| **Prioridade:** Alta.                                        |
| **Entrada:** Inserir dados de requerimento: Título, Data Inicial/Data Final, Eixo de Ensino, Atividade, Quantidade de Horas, Anexar Certificado.                                   |
| **Pré-condições:** Ter preenchido o requerimento com parte das informações solicitadas.                         |
| **Saída:** Confirmação de requisição em rascunho.                                     |
| **Pós-condições:** O usuário é redirecionado para a dashboard atualizada com a fila de rascunhos.                             |

| RF 020 - Deletar rascunhos de requisições |
| ------------------------------------------------------------- |
| **Descrição:** O usuário deve poder apagar um rascunho de requisição caso ache necessário.                                 |
| **Atores:** Discente.                                            |
| **Prioridade:** Alta.                                        |
| **Entrada:** Não possui.                                   |
| **Pré-condições:** Ter um rascunho salvo.                             |
| **Saída:** Rascunho apagado.                                     |
| **Pós-condições:** A fila de requisição atualizada com o rascunho apagado.                             |

| RF 021 - Alterar rascunhos de requisições  |
| ------------------------------------------------------------- |
| **Descrição:** O usuário deve poder alterar dados de uma requisição em situação de rascunho quando achar necessário.                                 |
| **Atores:** Discente.                                            |
| **Prioridade:** Alta.                                        |
| **Entrada:** Inserir ou alterar os dados de requerimento: Título, Data Inicial/Data Final, Eixo de Ensino, Atividade, Quantidade de Horas, Anexar Certificado.                                   |
| **Pré-condições:** Ter requerimento em rascunho.                             |
| **Saída:** Rascunho atualizado.                                     |
| **Pós-condições:** A fila de requisição atualizada com o rascunho também atualizado.                             |

| RF 022 - Enviar solicitação à coordenação|
| ------------------------------------------------------------- |
| **Descrição:** O usuário deve poder fazer o envio da solicitação completa criada anteriormente para o próximo ator do fluxo dentro do sistema.                                 |
| **Atores:** Discente.                                            |
| **Prioridade:** Alta.                                        |
| **Entrada:** Não possui.                                   |
| **Pré-condições:** Ter solicitação de contagem já  criada.                             |
| **Saída:** Enviado para o coordenador.                                     |
| **Pós-condições:** Usuário é redirecionado pra o dashboard.                             |

| RF 023 - Alterar solicitação|
| ------------------------------------------------------------- |
| **Descrição:** O usuário deve poder alterar dados de uma solicitação já enviada caso esta não tenha alcançado uma fase muito avançada da requisição.                                 |
| **Atores:** Discente.                                            |
| **Prioridade:** Média.                                        |
| **Entrada:** Alterar dados da solicitação do requerimento.                                   |
| **Pré-condições:** Ter uma solicitação encaminhada para a coordenação e não entregue.                             |
| **Saída:** Solicitação enviada atualizada.                                     |
| **Pós-condições:** Redirecionamento para o dashboard do usuário.                             |

| RF 024 - Visualizar dados do discente|
| ------------------------------------------------------------- |
| **Descrição:** O usuário deve ter acesso em parte especificada no sistema a um quantitativo de horas cumpridas, junto de poder conferir um extrato de horas, apenas visualização.                                 |
| **Atores:** Discente.                                            |
| **Prioridade:** Importante.                                        |
| **Entrada:** Não possui.                                   |
| **Pré-condições:** Não possui.                             |
| **Saída:** Não possui.                                     |
| **Pós-condições:** Não possui.                             |

| RF 025 - Visualizar fluxo de requisição|
| ------------------------------------------------------------- |
| **Descrição:** O usuário deve, caso tenha requisições enviadas, poder conferir o andamento de seu requerimento, com uma análise de trânsito visível e atualizada. (Apenas visualização)                                 |
| **Atores:** Discente.                                            |
| **Prioridade:** Baixo.                                        |
| **Entrada:** Não possui.                                   |
| **Pré-condições:** Ter requisição enviada.                             |
| **Saída:** Não possui.                                     |
| **Pós-condições:** Não possui.                             |

---

## Requisitos não funcionais

Os requisitos não funcionais fornecem diretrizes e critérios para avaliar a qualidade do sistema ou software, além de definir os padrões e metas a serem alcançados em relação a essas características. Eles desempenham um papel fundamental na satisfação dos usuários finais, garantindo que o sistema ou software atenda aos requisitos e expectativas não apenas em termos de funcionalidade, mas também em relação a outros atributos que afetam sua usabilidade, desempenho e segurança.

### Desempenho

A velocidade de resposta, a capacidade de processamento e a eficiência são fatores críticos que influenciam diretamente a experiência do usuário e o sucesso de um sistema. Logo, os requisitos abaixo definem as métricas de desempenho que deverão ser atingidas para alcançar uma boa usabilidade e experiência do usuário.

| RNF 001 - Tempo de Resposta                                                                                                                          |
| ---------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O aplicativo deverá apresentar tempos de resposta inferiores a 1000 ms, de forma a apresentar um carregamento suficientemente rápido. |
| **Prioridade:** Alta.                                                                                                                                |

| RNF 002 - Usuários online                                                                                                                                                                                                          |
| ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O aplicativo deve ser altamente eficiente e capaz de gerenciar perfeitamente a conexão de até 100 usuários online simultaneamente, proporcionando uma experiência fluida e sem interrupções para todos os usuários. |
| **Prioridade:** Alta.                                                                                                                                                                                                              |

### Disponibilidade

A disponibilidade é um fator crítico para a confiabilidade e eficácia de um sistema, especialmente em ambientes onde a interrupção de serviços pode resultar em perdas financeiras, danos à reputação e insatisfação dos usuários.Os requisitos a seguir estabelecem métricas que determinam o nível de disponibilidade do sistema, ou seja, a capacidade do sistema de estar prontamente disponível para executar um serviço solicitado por um usuário.

| RNF 003 - Período ativo                                                                                                                                                                                           |
| ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O aplicativo deve permanecer online 24 horas por dia, 7 dias por semana, com tolerância a interrupções de no máximo 2 horas em situações excepcionais para manutenções ou atualizações planejadas. |
| **Prioridade:** Média                                                                                                                                                                                             |

### Hardware

É fundamental considerar as características e limitações do hardware que será utilizado, para permitir que os desenvolvedores entendam claramente quais requisitos são necessários para garantir o desempenho, a compatibilidade e a estabilidade do sistema.

| RNF 004 - Compatibilidade                                                                                                                                                                                                                                               |
| ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** Para o perfeito funcionamento do sistema, é necessário apenas possuir um navegador com acesso à internet. Essa simplicidade na exigência de recursos garante que o aplicativo seja facilmente acessível e utilizado por uma ampla variedade de usuários. |
| **Prioridade:** Alta                                                                                                                                                                                                                                                    |

### Segurança

São descritas as medidas necessárias para proteger o sistema contra ameaças internas e externas, garantindo a confidencialidade, integridade e disponibilidade dos dados. Com isso, garantir que os desenvolvedores compreendam claramente os desafios e requisitos de segurança envolvidos no projeto, fornecendo diretrizes claras para a implementação de medidas de proteção eficazes.

| RNF 005  Criptografia                                                                                                                                                                                                                                                                                                                                                                                                    |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **Descrição:** O sistema deve priorizar a segurança dos dados e a proteção da privacidade dos usuários, adotando o uso do protocolo HTTPS (Hyper Text Transfer Protocol Secure) como uma camada de criptografia confiável. Ao utilizar o HTTPS, todas as informações transmitidas entre o aplicativo e os usuários serão criptografadas, garantindo a confidencialidade e a integridade dos dados durante a comunicação. |
| **Prioridade:** Baixa.                                                                                                                                                                                                                                                                                                                                                                                                   |

| RNF 006  Autenticação                                                                                                                                                                                                                             |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de realizar login através de sua conta Google utilizando o serviço SSO (Single Sign-On) da Google além de poder fazer pelo próprio sistema utilizando a lógica de autenticação com Spring security e JWT. |
| **Prioridade:** Alta.                                                                                                                                                                                                                             |

### Documentação

A documentação de sistemas desempenha um papel fundamental no desenvolvimento, implementação e manutenção eficazes de um software ou sistema. A importância de documentar sistemas reside em fornecer um registro completo e estruturado de informações essenciais sobre o sistema, suas funcionalidades, configurações, requisitos, fluxos de trabalho e outras características relevantes. Abaixo são descritas as documentações de caráter importante para o desenvolvimento do sistema.

| RNF 007  Documentação APIs REST                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** É fundamental que o endpoint do aplicativo seja cuidadosamente documentado, a fim de facilitar integrações futuras com outros sistemas e permitir correções eficientes de implementações no front-end. Nesse sentido, o uso da ferramenta Swagger desempenha um papel crucial. O Swagger proporciona uma abordagem estruturada e padronizada para documentação de API, permitindo que os desenvolvedores compreendam facilmente a funcionalidade e os parâmetros do endpoint. |
| **Prioridade:** Alta.|
