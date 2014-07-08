sumaelementos([], 0).
sumaelementos([X|Xs], S):-
          sumaelementos(Xs, S2),
          S is S2 + X.
          
longitud([],0).
longitud([L|Ll], N):-longitud(Ll, N1), N is N1+1.
