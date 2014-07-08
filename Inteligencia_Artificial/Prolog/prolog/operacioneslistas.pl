pertenece(_X,[_X|_Y]).
pertenece(X,[_C|Y]):-pertenece(X,Y).
%%%%%%%%%%%%%%%
eliminarPri(_X,[],[]):-!.
eliminarPri(_X,[_X|_M],_M):-!.
eliminarPri(X,[_R|M],[_R|L]):-eliminarPri(X,M,L).
%%%%%%%%%%%%%%%
%interseccion(_L,[],[]):-!.
%%%interseccion([],_L,[]):-!.
%interseccion([_X|L],[_X|H],[_X|Z]):-interseccion(L,H,Z),!.
%%%interseccion([X|L],[R|H],[X|Z]):-pertenece(X,H),eliminarPri(X,[R|H],L2),
%%%interseccion(L,L2,Z),!.
%%%interseccion([_X|L],[R|H],Z):-interseccion(L,[R|H],Z),!.
%%%%%%%%%%%%%%%
interseccion([],_L,1):-!.
interseccion([X|L],[R|H],C):-pertenece(X,H),eliminarPri(X,[R|H],L2),
interseccion(L,L2,C1),C is C1+1,!.
interseccion([_X|L],[R|H],C):-interseccion(L,[R|H],C),!.
