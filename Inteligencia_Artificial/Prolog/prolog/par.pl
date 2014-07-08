par(1):-
	write(' Impar').
par(0):-
	write(' Par').
par(X):-
	R is X-2,
	par(R).
	
lectura(N):-
	C is abs(N),
	write(C),
	par(C).
