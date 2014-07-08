%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%Sintomas para la gripa
sintomas(gripe,tos).
sintomas(gripe,cansancio).
sintomas(gripe,fiebre).
sintomas(gripe,dolordecabeza).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%Sintomas para la rubeola
sintomas(rubeola,fiebre).
sintomas(rubeola,escalofrios).
sintomas(rubeola,jaqueca).
sintomas(rubeola,secrecion).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%Sintomas para la malaria
sintomas(malaria,fiebre).
sintomas(malaria,diarrea).
sintomas(malaria,ictericia).
sintomas(malaria,escalofrios).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%Sintomas para la hepatitis
sintomas(hepatitis,diarrea).
sintomas(hepatitis,nauseas).
sintomas(hepatitis,ictericia).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%Sintomas para la tubercolisis
sintomas(tubercolosis,tos).
sintomas(tubercolosis,cansancio).
sintomas(tubercolosis,fiebre).
sintomas(tubercolosis,escalofrios).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%Sintomas para la anemia
sintomas(anemia,cansancio).
sintomas(anemia,nauseas).
sintomas(anemia,apatia).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
receta(jarabe,gripe).
receta(contrex,gripe).
receta(vacuna,gripe).
receta(vacuna,rubeola).
receta(vacuna,malaria).
receta(vacuna,hepatitis).
receta(vitamina,anemia).
receta(pastilla,rubeola).
receta(pastilla,hepatitis).
receta(pastilla,tuberculosis).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
jaraberecetado(A,C):-
	sintomas(B,C),receta(A,B).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
medicoatiende(A,C):-
	writeln('Especialista atiende a Juan: '),medico(A,B),receta(B,C).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
medicamentorecetado(A,C):-
	receta(A,C).
medicamentorecetado(A,C):-
	receta(A,B),medicamentorecetado(B,C).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%paciente(A,B,C):-
%medico().
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
especialistamedicina(A,C):-
	writeln('Especilista atiende Maria'),medico(A,B),receta(B,C),A\==B.
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
especialistamedicina(A,B):-
	writeln('Especialista receta a Maria'),receta(A,B).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
medico(otorrino,jarabe).
medico(otorrino,contrex).
medico(endocrinologo, vacuna).
medico(nutrionista,vitamina).
medico(medicogener,vacuna).
medico(medicogener,pastilla).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%









