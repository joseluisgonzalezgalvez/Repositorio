factorial(1,1).
factorial(N,M):-
	N>1,
	N1 is N-1,
	factorial(N1,M1),
	M is N*M1.
