Parte A — Análise Comparativa

Ao comparar as classes Heroi e Monstro, foi possível perceber que ambas possuem diversos atributos e métodos em comum, como:

nome

vida

ataque

defesa

atacar()

receberDano()

estaVivo()

Esses atributos e métodos representam características básicas de qualquer personagem do jogo, independentemente de ser herói ou monstro. Por isso, faz sentido movê-los para uma classe separada chamada Personagem, evitando assim a repetição de código.

Por outro lado, existem atributos específicos que pertencem apenas a uma das classes:

Herói: pocoes, xp

Monstro: xp, emoji

Esses atributos permanecem nas classes correspondentes, já que são exclusivos de cada tipo de personagem.

Parte C — Reflexão Escrita

Pergunta 1:
Se Heroi estende Personagem (ou seja, Heroi herda de Personagem), quais linhas de Heroi.java poderiam ser removidas sem perda de funcionalidade?

Resposta:
Os seguintes atributos e métodos já estariam definidos na classe Personagem, portanto não precisariam ser duplicados em Heroi:

private String nome;

private int ataque;

private int defesa;

public int atacar()

public void receberDano(int dano)

public boolean estaVivo()

Pergunta 2:
Qual é a vantagem de ter o método receberDano() definido em um único lugar (Personagem) em vez de duplicado em Heroi e Monstro? Dê um exemplo de situação onde a duplicação poderia causar problemas.

Resposta:
A principal vantagem é evitar duplicação de código. Se a lógica de dano precisar ser alterada, bastaria modificar o método na classe Personagem, e todos os personagens se beneficiariam da mudança.

Por outro lado, se o método estivesse copiado em Heroi e Monstro, seria necessário lembrar de atualizar ambos. Caso alguém esquecesse de atualizar uma das classes, isso poderia gerar inconsistências e bugs difíceis de identificar, prejudicando a jogabilidade.

Pergunta 3:
Por que o método exibirStatus() provavelmente ainda precisaria existir separadamente em Heroi e Monstro, mesmo depois de implementar a herança?

Resposta:
Embora heróis e monstros compartilhem atributos básicos, eles possuem informações exclusivas que precisam ser exibidas de forma diferente. Por exemplo:

Herói: exibe poções e xp

Monstro: exibe xp de recompensa e emoji

Portanto, o método exibirStatus() precisa ser implementado separadamente para cada classe, garantindo que cada personagem mostre as informações corretas.
