# sudo-kill-robocode-ICO-IFSC
Robô em Java desenvolvido para a competição de Robocode da disciplina de Introdução à Computação 
do curso de ADS do IFSC.

O objetivo do robô é competir estrategicamente contra outros tanques automatizados através de 
inteligência programada em Java.

O robô SudoKill é um tanque avançado feito para o Robocode utilizando a classe AdvancedRobot.

## PROJETADO
O robô foi projetado com estratégias como:

- movimentação evasiva,
- rastreamento inteligente,
- troca de alvo,
- radar travado,
- mira preditiva,
- sobrevivência em combate.

## DIVISÃO
A divisão do projeto entre os participantes foi:

- **Movimentação** - Alyne: anda, desvios e fulgas;
- **Ataque/mira** - Isabelle: atacar, controlar arma e economia de energia;
- **Radar e estrateǵia** - Fabliny: detectar inimigos e tomar decisões.

## FUNCIONAMENTO 
O funcinamento do robô se resume em:

**1.** Configura as cores;
**2.** Desacopla radar, arma e corpo;
**3.** Mantém o radar girando infinitamente;
**4.** Procura inimigos continuamente;
**5.** Detecta um inimigo:
    - Escolhe um alvo,
    - Trava o radar nele,
    - Se movimenta lateralmente,
    - Calcula se vale a pena atirar,
    - Usa mira preditiva,
    - Dispara.