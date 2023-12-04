CREATE TABLE IF NOT EXISTS atividade
(
    id                       BIGINT  NOT NULL,
    eixo                     VARCHAR(255),
    descricao                VARCHAR(255),
    criterios_para_avaliacao VARCHAR(255),
    ch_maxima                INTEGER NOT NULL,
    ch_por_certificado       INTEGER,
    CONSTRAINT pk_atividade PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS certificado
(
    id                 BIGINT NOT NULL,
    titulo             VARCHAR(255),
    observacao         TEXT,
    data_inicial       date,
    data_final         date,
    carga_horaria      FLOAT  NOT NULL,
    certificado        BYTEA,
    status_certificado VARCHAR(255),
    requisicao_id      BIGINT,
    atividade_id       BIGINT,
    CONSTRAINT pk_certificado PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS curso
(
    id                   BIGINT  NOT NULL,
    nome                 VARCHAR(255),
    sigla                VARCHAR(255),
    horas_complementares INTEGER NOT NULL,
    CONSTRAINT pk_curso PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS endereco
(
    id          BIGINT  NOT NULL,
    cep         VARCHAR(255),
    rua         VARCHAR(255),
    bairro      VARCHAR(255),
    cidade      VARCHAR(255),
    uf          VARCHAR(255),
    numero      INTEGER NOT NULL,
    complemento VARCHAR(255),
    CONSTRAINT pk_endereco PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS requisicao
(
    id                          BIGINT  NOT NULL,
    id_requisicao               VARCHAR(255),
    criacao                     date,
    observacao                  TEXT,
    data_de_submissao           date,
    token                       VARCHAR(255),
    arquivada                   BOOLEAN NOT NULL,
    requisicao_arquivo_assinada BYTEA,
    status_requisicao           VARCHAR(255),
    usuario_id                  BIGINT,
    curso_id                    BIGINT,
    CONSTRAINT pk_requisicao PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS usuario
(
    id                 BIGINT  NOT NULL,
    nome_completo      VARCHAR(255),
    cpf                VARCHAR(255),
    matricula          VARCHAR(255),
    periodo            INTEGER NOT NULL,
    telefone           VARCHAR(255),
    email              VARCHAR(255),
    senha              VARCHAR(255),
    codigo_verificacao VARCHAR(255),
    is_verificado      BOOLEAN NOT NULL,
    horas_ensino       FLOAT   NOT NULL,
    horas_extensao     FLOAT   NOT NULL,
    horas_gestao       FLOAT   NOT NULL,
    horas_pesquisa     FLOAT   NOT NULL,
    enabled            BOOLEAN NOT NULL,
    perfil             VARCHAR(255),
    endereco_id        BIGINT,
    curso_id           BIGINT,
    CONSTRAINT pk_usuario PRIMARY KEY (id)
);