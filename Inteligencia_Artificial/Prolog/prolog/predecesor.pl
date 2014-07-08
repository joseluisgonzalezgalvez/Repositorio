padre(jose,jesus).
padre(jesus,juan).
padre(juan,gabriel).
predecesor(A,C):-padre(A,C).
predecesor(A,C):-padre(A,B),predecesor(B,C).

