medico(otorrino,jarabe).
medico(otorrino,contrex).
medico(endocrinologo, vacuna).
medico(nutrionista,vitamina).
medico(medicogener,vacuna).
medico(medicogener,pastilla).
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
%medicoreceta(A,C):-medico(A,C).
%medicoreceta(A,C):-medico(A,B),receta(B,C),A\==C.
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
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
%medicamentos en base a los sintomas
%receta(jarabe,gripe).%
%sintomas(gripe,tos).%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
jaraberecetado(A,C):-
					receta(A,B),sintomas(B,C).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
medicamentorecetado(A,C):-
						receta(A,C).
medicamentorecetado(A,C):-
						receta(A,B),medicamentorecetado(B,C).



