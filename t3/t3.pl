/* Exercício 1 */
zeroInit(L) :- L = [H|_], H = 0.

/* Exercício 2 */
has5(L) :- L = [_,_,_,_,_].

/* Exercício 3 */
hasN(L,N) :- length(L, N1), N = N1.

/* Exercício 4 */
potN0(0,[1]).
potN0(N,L) :- N > 0,
    P is 2^N,
    L = [P|T],
    N1 is N -1,
    potN0(N1,T).

/* Exercício 5 */
zipmult([],[],[]).
zipmult(L1,L2,L3) :- L1 = [H|T], L2 = [H1|T1],
    M is H1*H,
    L3 = [M|L],
    zipmult(T,T1,L).
