recorre([]):-
		write('fin').
recorre([H|T]):- 
		write(H),recorre(T).
