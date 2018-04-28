/* Pizza Compartilhada
https://olimpiada.ic.unicamp.br/static/extras/obi2011/provas/ProvaOBI2011_f1i1.pdf

Uma grande pizza vai ser feita para comemorar a vitória do time de handebol da escola, composto por
seis alunos. A pizza vai ser dividida em seis pedaços da forma tradicional, como mostrado na figura
abaixo, e cada pedaço vai ser dado a um atleta do time.
Uma pizza dividida em seis pedaços
Cada atleta prefere um tipo diferente de pizza, e portanto a pizza vai ser feita com seis sabores distintos:
atum, bacon, calabresa, mussarela, napolitana e portuguesa. Por solicitação dos atletas, as seguintes
condições devem ser obedecidas:
• O pedaço de portuguesa não deve ser vizinho do pedaço de bacon.
• O pedaço de atum não deve ser vizinho do pedaço de mussarela.
• O pedaço de napolitana deve ser vizinho do pedaço de mussarela.
*/

regra1(S) :- not(nextto("portuguesa","bacon", S)),
  not(nextto("bacon","portuguesa", S)).

regra2(S) :- not(nextto("atum","mussarela", S)),
  not(nextto("mussarela","atum", S)).

regra3(S) :- nextto("napolitana","mussarela", S);
  nextto("mussarela","napolitana", S).

/* Questão 16. Se o pedaço de napolitana está imediatamente
à direita do pedaço de atum, qual pedaço
deve estar imediatamente à direita do pedaço
de napolitana?
(A) atum
(B) bacon
(C) calabresa
(D) mussarela
(E) portuguesa */

q16(S) :-  S = [_,_,_,_,_,_],
  Sabores = ["mussarela", "atum", "bacon", "portuguesa", "calabresa", "napolitana"],
  permutation(Sabores, S),
  nextto("atum", "napolitana", S),
  regra1(S),
  regra2(S),
  regra3(S).

/*
?- q16(S), !,nextto("napolitana", D, S).
*/
