INSERT INTO public.atividade(
        id,
        ch_maxima,
        descricao,
        eixo,
        criterios_para_avaliacao,
        ch_por_certificado
    )
VALUES (
        10036,
        30,
        'Disciplinas concluídas pelo acadêmico com carga horária mínima de 30h em cursos de graduação de IES credenciadas pelo MEC (presencial ou EAD)',
        'ENSINO',
        'Apresentação de documento comprobatório da atividade e da carga horária. Apresentação do programa analítico da disciplina.',
        null
    ),
    (
        10037,
        30,
        'Cursos de capacitação profissional.',
        'ENSINO',
        'Apresentação de certidão ou documento comprobatório da atividade e da carga horária.',
        null
    ),
    (
        10038,
        60,
        'LIBRAS (Lingua Brasileira de Sinais)',
        'ENSINO',
        'Apresentação de certidão ou documento comprobatório da atividade e da carga horária',
        null
    ),
    (
        10039,
        60,
        'Atividade de monitoria Acadêmica.',
        'ENSINO',
        'Apresentação de certidão ou documento comprobatório da atividade e da carga horária',
        30
    ),
    (
        10040,
        20,
        'Cursos de informática, língua estrangeira e LIBRAS, realizados em estabelecimentos reconhecidos pela Comissão de Validação das atividades complementares ou de nível superior.',
        'ENSINO',
        'Apresentação de certidão ou documento comprobatório da atividade e da carga horária.',
        5
    ),
    (
        10041,
        60,
        'Estágios curriculares não obrigatórios.',
        'ENSINO',
        'Apresentação de documentos de certificação do estágio.',
        30
    ),
    (
        10042,
        20,
        'Disciplinas concluídas em cursos de lato sensu em áreas afins durante o curso da graduação',
        'ENSINO',
        'Apresentação de documento comprobatório da atividade e da carga horária.',
        5
    ),
    (
        10043,
        4,
        'Premiações em trabalhos desenvolvidos na área de ensino.',
        'ENSINO',
        'Certificado de premiação emitido por IES',
        2
    ),
    (
        10044,
        30,
        'Participação em Atléticas',
        'ENSINO',
        'Certificado emitido pela Proec',
        15
    ),
    (
        10045,
        60,
        'Participação de atividades de iniciação científica',
        'PESQUISA',
        'Declaração de docente orientado, constando carga horária da atividade.',
        60
    ),
    (
        10046,
        60,
        'Capítulo de livro publicado',
        'PESQUISA',
        'Cópia das referências e sumário do livro',
        20
    ),
    (
        10047,
        10,
        'Participação em projetos ou grupos de estudos e pesquisa',
        'PESQUISA',
        'Declaração da Coordenação do Grupo de Estudo, que precisará ser registrado em ata de Reunião do Pleno de Psicologia e/ou autorizada no semestre suplementar',
        2
    ),
    (
        10048,
        90,
        'Artigo publicado ou aceito com classificação de B2 para cima',
        'PESQUISA',
        'Carta de Aceite ou cópia da primeira página com o doi.',
        30
    ),
    (
        10049,
        60,
        'Trabalhos científicos publicados: periódicos até qualificação b3, anais de eventos, jornais e revistas.',
        'PESQUISA',
        'Apresentação do aceite de publicação. Apresentação de cópia do artigo publicado.',
        10
    ),
    (
        10050,
        20,
        'Participação em defesas públicas, como ouvinte, de trabalhos de mestrado ou doutorado (stricto sensu)',
        'PESQUISA',
        'Declaração da IES da participação na defesa como ouvinte.',
        4
    ),
    (
        10051,
        10,
        'Participação em defesas públicas, como ouvinte, de trabalhos de nível lato sensu.',
        'PESQUISA',
        'Declaração da IES da participação na defesa como ouvinte.',
        2
    ),
    (
        10052,
        15,
        'Apresentação de Pôster em Eventos Científicos',
        'PESQUISA',
        'Certificado de apresentação (apenas para quem apresentou, não para os demais autores)',
        5
    ),
    (
        10053,
        30,
        'Apresentação de Comunicação Oral em Eventos Científicos',
        'PESQUISA',
        'Certificado de Apresentação',
        10
    ),
    (
        10054,
        20,
        'Membro de Laboratório ou Grupo de Pesquisa registrado na Propegi',
        'PESQUISA',
        'Declaração da Coordenação do grupo do Laboratório ou do Grupo de Pesquisa',
        4
    ),
    (
        10055,
        40,
        'Participação em Ligas Acadêmicas',
        'PESQUISA',
        'Participação como ouvinte em defesas de trabalho de conclusão de curso de Graduação e/ou Pós -Graduação',
        10
    ),
    (
        10056,
        10,
        'Declaração da IES da participação na defesa como ouvinte.',
        'PESQUISA',
        'Comprovante da Proec',
        2
    ),
    (
        10057,
        60,
        'Participação em Projetos de Extensão da instituição',
        'EXTENSAO',
        'Declaração de docente orientador, constando carga horária da atividade.',
        60
    ),
    (
        10058,
        60,
        'Mediação em mesa-redonda de eventos científicos',
        'EXTENSAO',
        'Apresentação de documento comprobatório da atividade e da carga horária.',
        15
    ),
    (
        10059,
        10,
        'Participação na organização de eventos acadêmicos e científicos na área',
        'EXTENSAO',
        'Apresentação de documento comprobatório da atividade e carga horária',
        2
    ),
    (
        10060,
        40,
        'Apresentação de trabalhos em congressos, seminários, semanas acadêmicas ou outros eventos na área..',
        'EXTENSAO',
        'Apresentação de documento comprobatório da atividade e da carga horária.',
        10
    ),
    (
        10061,
        20,
        'Viagens de estudo',
        'EXTENSAO',
        'Declaração do docente responsável que acompanhou a viagem, incluindo a carga horária.',
        null
    ),
    (
        10062,
        18,
        'Trabalho como Mesário ou presidente de mesa eleitoral, quer por convocação do TRE ou iniciativa voluntária.',
        'GESTAO',
        'Declaração oficial do Tribunal Regional Eleitoral (TRE) que comprove e especifique a participação na atividade.',
        null
    ),
    (
        10063,
        10,
        'Participação em eventos acadêmicos - reflexivos promovidos por órgãos de política estudantil do ensino superior como a UNE e DCEs.',
        'GESTAO',
        'Declaração comprobatória da participação e da temática do evento.',
        null
    ),
    (
        10064,
        10,
        'Participação voluntária em ações e campanhas humanitárias promovidas por órgãos representativos da sociedade civil organizada.',
        'GESTAO',
        'Declaração comprobatória da participação e do teor da ação ou campanha.',
        null
    ),
    (
        10065,
        30,
        'Estágio em gestão: administrativo, planejamento, financeiro, biblioteca, TIs e outros setores administrativos da IES.',
        'GESTAO',
        'Declaração comprobatória das atividades desenvolvidas com carga horária discriminada',
        null
    ),
    (
        10066,
        40,
        'Participação como representante de cursos/turma em plenos de curso ou junto às coordenações',
        'GESTAO',
        'Declaração da Coordenação de Curso',
        10
    ),
    (
        10067,
        40,
        'Participação como membro do Centro Acadêmico',
        'GESTAO',
        'Declaração do Diretório Acadêmico da UPE',
        10
    ),
    (
        10068,
        60,
        'Participação como membro do Diretório Acadêmico',
        'GESTAO',
        'Declaração da União Nacional dos Estudantes',
        20
    );