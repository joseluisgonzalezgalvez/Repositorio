mcd(A,B,MCD):-
        A=:=B,
		MCD is A.
		%writeln(MCD).
mcd(A,B,MCD):-
        B>A,
	    C is B-A,
	    %writeln(C),
	    mcd(A,C,MCD).
mcd(A,B,MCD):-
        A>B,
		C is A-B,
		writeln(C),
		mcd(B,C,MCD).
