# sudo-kill-robocode-ICO-IFSC

## INTRODUÇÃO
O projeto, proposto na disciplina de Introdução à Computação, teve como objetivo promover o trabalho colaborativo, o aprendizado de programação e o controle versão em trabalhos em grupo. Para isso, o docente propôs a criação de robôs no Robocode para participarem de um duelo entre equipes. 

O Robocode é um ambiente de programação no qual os participantes desenvolvem robôs capazes de competir automaticamente em uma arena virtual. Por meio do código implementado em Java, o robô toma decisões de forma autônoma, definindo seus movimentos, a mira, os disparos e as reações aos adversários.

Nesse contexto, foi utilizado o controle de versão com Git e GitHub, ferramentas essenciais no desenvolvimento de software. Elas permitem registrar e gerenciar alterações no código, facilitando o trabalho em equipe, o acompanhamento das contribuições e a recuperação de versões anteriores. Dessa forma, o uso do controle de versão garantiu mais organização, colaboração e segurança no desenvolvimento do projeto.
No contexto do Robocode, o controle de versão também desempenha um papel importante no acompanhamento da evolução das estratégias implementadas nos robôs, permitindo:

 - Salvar diferentes versões do robô para comparar seu desempenho;
 - Testar novas estratégias sem comprometer versões anteriores;
 - Facilitar o trabalho colaborativo entre os membros da equipe;
 - Identificar quais alterações contribuíram para melhorar ou piorar os resultados obtidos nas batalhas.

Dessa forma, tanto em projetos profissionais quanto em atividades acadêmicas envolvendo o Robocode, o controle de versão contribui para um processo de desenvolvimento mais organizado, seguro e eficiente.

## OBJETIVOS
Os principais objetivos esperados pelo grupo ao desenvolver esse projeto foram:

 - **GANHAR A BATALHA**
 - Aprender os conceitos básicos de programação em Java.
 - Compreender o funcionamento da plataforma Robocode e o desenvolvimento de robôs autônomos.
 - Utilizar o Git para realizar o controle de versão do projeto.
 - Aprender a utilizar o GitHub para armazenar e compartilhar código.
 - Desenvolver habilidades de trabalho em equipe e colaboração em projetos de software.
 - Praticar a resolução de problemas por meio da criação de estratégias para o robô.
 - Aplicar conceitos de lógica de programação e algoritmos em um projeto prático.
 - Acompanhar e documentar a evolução do projeto por meio do histórico de versões.

## DESCRIÇÃO
Inicialmente, foi criado um grupo no WhatsApp para facilitar a comunicação entre as integrantes e a divisão das tarefas. Cada participante ficou responsável por uma área específica do desenvolvimento do robô:

- **Movimentação** - Alyne: anda, desvios e fulgas.
- **Ataque/mira** - Isabelle: atacar, controlar arma e economia de energia.
- **Radar e estrateǵia** - Fabliny: detectar inimigos e tomar decisões.

A partir dessa divisão, cada integrante desenvolveu sua parte do código em arquivos separados, possibilitando um trabalho mais organizado e colaborativo. Entre as principais estratégias implementadas no robô, destacam-se os métodos de:

- Movimentação evasiva;
- Rastreamento inteligente de adversários;
- Troca dinâmica de alvos;
- Radar travado no inimigo detectado;
- Mira preditiva;
- Estratégias de sobrevivência em combate.

Posteriormente, foi criado um repositório no GitHub para integrar as diferentes partes do projeto, permitindo a realização de ajustes, correções e melhorias necessárias para o funcionamento do robô como um todo.

O desenvolvimento do projeto foi conduzido com comunicação clara e objetiva entre as integrantes, buscando constantemente a implementação de novas funcionalidades e o apoio mútuo na resolução de dúvidas. O GitHub foi a principal ferramenta utilizada para o gerenciamento do projeto, permitindo o acompanhamento das alterações realizadas, a visualização das branches e o histórico de commits.

Além disso, o Git foi amplamente utilizado para diversas atividades, tais como:

- Configuração dos usuários para identificação dos autores das alterações;
- Envio e recebimento de atualizações entre os repositórios local e remoto;
- Criação e gerenciamento de commits;
- Integração de branches por meio de merges;
- Visualização do histórico de commits e do estado dos arquivos;
- Clonagem do repositório para diferentes ambientes de desenvolvimento;
- Busca e sincronização de alterações disponíveis no repositório remoto.

Dessa forma, o uso do Git e do GitHub foi essencial para garantir a organização, o controle de versões e a colaboração eficiente entre as integrantes da equipe.

## ESTRUTURA
Durante o desenvolvimento do projeto, foi adotada uma estrutura de controle de versão baseada no Git e no GitHub, permitindo que as integrantes trabalhassem simultaneamente sem comprometer a estabilidade do código principal. O repositório foi criado no GitHub e utilizado como repositório remoto para centralizar todas as alterações realizadas pela equipe.

### Repositório 

O repositório foi organizado para armazenar todo o código-fonte do robô, os arquivos de configuração, o arquivo .jar utilizado para execução no Robocode e a documentação do projeto. Cada integrante trabalhou em sua própria branch, realizando alterações localmente e sincronizando-as com o repositório remoto por meio do Git.

### Branches

Para facilitar a organização do desenvolvimento, foram criadas diferentes branches, cada uma destinada a uma parte específica do projeto:

- **main:** branch principal, responsável por armazenar a versão estável e integrada do robô.
- **ataques:** utilizada para implementar e aperfeiçoar as funcionalidades relacionadas ao ataque, mira e disparos do robô.
- **movimentacoes:** destinada ao desenvolvimento das estratégias de movimentação, desvio de tiros e deslocamento na arena.
- **estilizacao:** utilizada para personalizar aspectos visuais do robô, como cores e aparência.
- **ajustes:** empregada para realizar correções, melhorias de desempenho e refinamento das estratégias implementadas.
- **readme:** criada para elaborar e atualizar a documentação do projeto, incluindo o relatório e o arquivo README.

Essa organização permitiu que diferentes funcionalidades fossem desenvolvidas em paralelo, reduzindo conflitos e facilitando a integração das alterações.

### Commits

Ao longo do desenvolvimento, foram realizados diversos commits para registrar a evolução do projeto. Procurou-se utilizar mensagens objetivas que identificassem claramente a alteração realizada, como "Implementa movimentacao", "Atualiza estratégia", "adiciona funcoes de ataque", "Melhora imprevisibilidade", "Atualiza versão .jar" e "comentario". Embora algumas mensagens pudessem ser mais descritivas, os commits permitiram acompanhar a evolução do robô, identificar responsáveis pelas alterações e recuperar versões anteriores quando necessário.

### Pull Requests e Integração

Após o desenvolvimento das funcionalidades em suas respectivas branches, as alterações foram integradas à branch principal por meio de processos de merge. Durante esse processo, o GitHub foi utilizado para centralizar o código e facilitar a revisão das modificações antes da integração. A utilização de branches e merges permitiu que cada integrante desenvolvesse sua parte do projeto de forma independente, reduzindo conflitos e garantindo que apenas versões testadas fossem incorporadas à branch principal.

A estrutura adotada demonstrou, na prática, como o Git e o GitHub contribuem para a organização, colaboração e rastreabilidade em projetos de desenvolvimento de software, tornando o trabalho em equipe mais eficiente e seguro.

## RESULTADOS

A realização do projeto proporcionou diversos aprendizados práticos relacionados tanto à programação quanto ao trabalho colaborativo. No aspecto técnico, o grupo pôde compreender melhor a linguagem Java e aplicar conceitos de lógica de programação, estruturas de decisão, repetição e organização de código no desenvolvimento de um robô autônomo para o Robocode.

Também foi possível aprender como estratégias diferentes influenciam diretamente o desempenho do robô nas batalhas. Recursos como movimentação evasiva, radar inteligente, troca dinâmica de alvos e mira preditiva mostraram, na prática, a importância do raciocínio lógico e da tomada de decisões automatizadas.

No aspecto da colaboração, o uso do Git e do GitHub foi um dos principais aprendizados da atividade. A equipe aprendeu a trabalhar com repositórios remotos, branches, commits e integração de código, entendendo como essas ferramentas são utilizadas em projetos reais de desenvolvimento de software.

Entre os principais desafios enfrentados, destacam-se:
- Integrar as diferentes partes do código desenvolvidas por cada integrante;
- Resolver conflitos entre alterações feitas em arquivos semelhantes;
- Ajustar o comportamento do robô para evitar movimentos previsíveis;
- Testar e equilibrar estratégias de ataque e defesa.

Esses desafios foram superados por meio de comunicação constante no grupo, realização de testes frequentes no Robocode e utilização do GitHub para organizar as alterações e acompanhar o histórico do projeto.

Ao final da atividade, as integrantes desenvolveram habilidades importantes, como:
- Programação em Java;
- Desenvolvimento de algoritmos;
- Uso de Git e GitHub;
- Resolução de problemas;
- Trabalho em equipe;
- Planejamento e divisão de tarefas;
- Documentação de projetos.

## CONCLUSÃO
O desenvolvimento do robô no Robocode foi uma experiência significativa para consolidar conhecimentos de programação e introduzir práticas utilizadas no desenvolvimento profissional de software. A atividade permitiu aplicar conceitos teóricos em um projeto prático e dinâmico, tornando o aprendizado mais motivador e interativo.

Além da criação do robô, o projeto destacou a importância do controle de versão com Git e GitHub, ferramentas fundamentais para organizar o trabalho, registrar alterações e colaborar de forma eficiente em equipe. A utilização de branches, commits e integração de código mostrou como projetos maiores podem ser desenvolvidos de maneira estruturada e segura.

Por fim, conclui-se que a atividade contribuiu não apenas para o aprendizado técnico, mas também para o desenvolvimento de competências de comunicação, cooperação e resolução de problemas, habilidades essenciais para futuras experiências acadêmicas e profissionais na área de computação.

## ANEXO
