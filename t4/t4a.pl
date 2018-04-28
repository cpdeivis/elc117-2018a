/* Uma banda formada por alunos e alunas da escola está gravando um CD com exatamente sete músicas
distintas – S, T, V, W, X, Y e Z. Cada m´usica ocupa exatamente uma das sete faixas contidas no
CD. Algumas das músicas são sucessos antigos de rock; outras são composições da própria banda. As
seguintes restrições devem ser obedecidas:
  • S ocupa a quarta faixa do CD.
  • Tanto W como Y precedem S no CD (ou seja, W e Y estão numa faixa que é tocada antes de S
  no CD).
  • T precede W no CD (ou seja, T está numa faixa que é tocada antes de W).
  • Um sucesso de rock ocupa a sexta faixa do CD.
  • Cada sucesso de rock é imediatamente precedido no CD por uma composição da banda (ou seja,
  no CD cada sucesso de rock toca imediatamente após uma composição da banda).
  • Z é um sucesso de rock.
*/
% S ocupa a quarta faixa do CD.
regra1(E) :- nth0(F, E, s),
    F = 3.
/* Tanto W como Y precedem S no CD (ou seja, W e Y estão numa faixa que é
  tocada antes de S no CD) */
regra2(E) :- nth0(W, E, w),
    nth0(Y, E, y),
    W < 3,
    Y < 3.
% T precede W no CD (ou seja, T está numa faixa que é tocada antes de W).
regra3(E) :- nth0(W, E, w),
    nth0(T, E, t),
    N is T + 1,
    W = N.
% Diz se é um sucesso de rock
% [n,r,n,r,n,r,n]
regra4(E, R) :- nth0(T, E, R),
    (T = 1; T = 3; T = 5).

valida(E) :- E = [_,_,_,_,_,_,_],
  Val = [s,t,v,w,x,y,z],
  permutation(Val, E),
  regra1(E),
  regra2(E),
  regra3(E),
  regra4(E, z).

/* Questão 11. Qual das seguintes alternativas poderia
ser a ordem das músicas no CD, da primeira
para a sétima faixa?
(A) T, W, V, S, Y, X, Z
(B) V, Y, T, S, W, Z, X
(C) X, Y, W, S, T, Z, S
(D) Y, T, W, S, X, Z, V
(E) Z, T, X, W, V, Y, S

?- valida([t,w,v,s,y,x,z]).
?- valida([v,y,t,s,w,z,x]).
?- valida([x,y,w,s,t,z,s]).
?- valida([y,t,w,s,x,z,v]).
?- valida([z,t,x,w,v,y,s]).

*/
