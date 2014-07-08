#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define max 100

typedef struct jugadores
{
        char nombre[30];
        char nacionalidad[30];
        char posicion[30];
        int  numero_camisola;
        char baja_temporal;
        char causa_baja[30];
}jugador;

typedef struct lanzadores
{
        int juegosganados;
        int juegosperdidos;
        int hits_admitidos;
        int base_bola;
        int ponches;
        int entradas_lanzadas; 
}lanzador;

typedef struct bateadores
{
        char posicion[30];
        int juegos_jug;
        int turnos;
        int carreras;
        int hits;
        int hits_dobles;
        int hits_triples;
        int homerum;
        int carreras_pro;
        int base_bolas;
        int ponches;
        int bases_robadas;
        float porcentaje_bateo;
}bateador;

typedef struct fildeadores
{
        bateador infilderes[5];      
        bateador outfilderes[5];
        lanzador picher_lanzador[5];
}filder;    

typedef union lineop
{
        filder jardineros_cuadros;
        lanzador picheres;
}alineacion;

typedef struct equipo
{
        char nombre[30];
        char estado[30];
        jugador datos[max];
        filder estadisticas;
        alineacion posiciones[max];
        
};

equipo lectura (int *num,FILE *archivo)
{
       archivo=fopen("jugadores.dat","ab");
       equipo equip;
       int i,j;
       char pos;
       const char cuadro[9]="infilder";
       const char jardin[10]="outfilder";
       const char picher[7]="picher";
       printf("\tEquipo: Zanateros\n");
       printf("\tEstado: Oaxaca\n");
       printf("ingrese la cantidad de jugadores: ");
       scanf("%d",&j);
       for(i=0;i<j;i++)
       {
                         printf("Ingrese nombre jugador: ");
                         fflush(stdin);
                         gets(equip.datos[i].nombre);
                         printf("Ingrese nacionalidad: ");
                         fflush(stdin);
                         gets(equip.datos[i].nacionalidad);
                         printf("Ingrese posicion: ");
                         fflush(stdin);
                         gets(equip.datos[i].posicion);
                         printf("Ingrese numero de camisola: ");
                         fflush(stdin);
                         scanf("%d",&equip.datos[i].numero_camisola);
                         printf("Se encuentra dado de baja?: S/N ");
                         fflush(stdin);
                         equip.datos[i].baja_temporal=tolower(getchar());
                         if(equip.datos[i].baja_temporal=='S' || equip.datos[i].baja_temporal=='s')
                         {
                                                              printf("Ingrese causa de baja: ");
                                                              fflush(stdin);
                                                              gets(equip.datos[i].causa_baja);
                         }
                         
       }
       
       for(i=0;i<j;i++)
       {                       
                               if(strcmp(equip.datos[i].posicion,cuadro)==0)
                               {
                                                              printf("\tInfilder\n");
                                                              printf("\nJugador: %s\n",equip.datos[i].nombre);
                                                              printf("Ingrese posicion: ");
                                                              fflush(stdin);
                                                              gets(equip.estadisticas.infilderes[i].posicion);
                                                              printf("Ingrese juegos jugados: ");
                                                              fflush(stdin);
                                                              scanf("%d",&equip.estadisticas.infilderes[i].juegos_jug);
                                                              printf("Ingrese turnos al bate: ");
                                                              fflush(stdin);
                                                              scanf("%d",&equip.estadisticas.infilderes[i].turnos);
                                                              printf("Ingrese numero de carreras anotadas: ");
                                                              fflush(stdin);
                                                              scanf("%d",&equip.estadisticas.infilderes[i].carreras);
                                                              printf("Ingrese cantidad de sencillos: ");
                                                              fflush(stdin);
                                                              scanf("%d",&equip.estadisticas.infilderes[i].hits);
                                                              printf("Ingrese hits dobles: ");
                                                              fflush(stdin);
                                                              scanf("%d",&equip.estadisticas.infilderes[i].hits_dobles);
                                                              printf("Ingrese hits triples: ");
                                                              fflush(stdin);
                                                              scanf("%d",&equip.estadisticas.infilderes[i].hits_triples);
                                                              printf("Ingrese home run: ");
                                                              fflush(stdin);
                                                              scanf("%d",&equip.estadisticas.infilderes[i].homerum);
                                                              printf("Ingrese carreras producidas: ");
                                                              fflush(stdin);
                                                              scanf("%d",&equip.estadisticas.infilderes[i].carreras_pro);
                                                              printf("Ingrese bases por bolas: ");
                                                              fflush(stdin);
                                                              scanf("%d",&equip.estadisticas.infilderes[i].base_bolas);
                                                              printf("Ponches: ");
                                                              fflush(stdin);
                                                              scanf("%d",&equip.estadisticas.infilderes[i].ponches);
                                                              printf("Bases robadas: ");
                                                              fflush(stdin);
                                                              scanf("%d",&equip.estadisticas.infilderes[i].bases_robadas);
                                                              printf("Pocentaje de bateo: ");
                                                              fflush(stdin);
                                                              scanf("%f\n\n",&equip.estadisticas.infilderes[i].porcentaje_bateo);
                               }
                               if(strcmp(equip.datos[i].posicion,jardin)==0)
                               {
                                                              printf("\tOutfilder\n");
                                                              printf("\nJugador: %s\n",equip.datos[i].nombre);
                                                              printf("Ingrese posicion: ");
                                                              fflush(stdin);
                                                              gets(equip.estadisticas.outfilderes[i].posicion);
                                                              printf("Ingrese juegos jugados: ");
                                                              fflush(stdin);
                                                              scanf("%d",&equip.estadisticas.outfilderes[i].juegos_jug);
                                                              printf("Ingrese turnos al bate: ");
                                                              fflush(stdin);
                                                              scanf("%d",&equip.estadisticas.outfilderes[i].turnos);
                                                              printf("Ingrese numero de carreras anotadas: ");
                                                              fflush(stdin);
                                                              scanf("%d",&equip.estadisticas.outfilderes[i].carreras);
                                                              printf("Ingrese cantidad de sencillos: ");
                                                              fflush(stdin);
                                                              scanf("%d",&equip.estadisticas.outfilderes[i].hits);
                                                              printf("Ingrese hits dobles: ");
                                                              fflush(stdin);
                                                              scanf("%d",&equip.estadisticas.outfilderes[i].hits_dobles);
                                                              printf("Ingrese hits triples: ");
                                                              fflush(stdin);
                                                              scanf("%d",&equip.estadisticas.outfilderes[i].hits_triples);
                                                              printf("Ingrese home run: ");
                                                              fflush(stdin);
                                                              scanf("%d",&equip.estadisticas.outfilderes[i].homerum);
                                                              printf("Ingrese carreras producidas: ");
                                                              fflush(stdin);
                                                              scanf("%d",&equip.estadisticas.outfilderes[i].carreras_pro);
                                                              printf("Ingrese bases por bolas: ");
                                                              fflush(stdin);
                                                              scanf("%d",&equip.estadisticas.outfilderes[i].base_bolas);
                                                              printf("Ponches: ");
                                                              fflush(stdin);
                                                              scanf("%d",&equip.estadisticas.outfilderes[i].ponches);
                                                              printf("Bases robadas: ");
                                                              fflush(stdin);
                                                              scanf("%d",&equip.estadisticas.outfilderes[i].bases_robadas);
                                                              printf("Pocentaje de bateo: ");
                                                              fflush(stdin);
                                                              scanf("%f\n\n",&equip.estadisticas.outfilderes[i].porcentaje_bateo);
                               }
                               if(strcmp(equip.datos[i].posicion,picher)==0)
                               {
                                                                            printf("\tLanzador\n");
                                                                            printf("\njugador: %s\n",equip.datos[i].nombre);
                                                                            printf("Ingrese juegos ganados: ");
                                                                            fflush(stdin);
                                                                            scanf("%d",&equip.estadisticas.picher_lanzador[i].juegosganados);
                                                                            printf("Ingrese juegos perdidos: ");
                                                                            fflush(stdin);
                                                                            scanf("%d",&equip.estadisticas.picher_lanzador[i].juegosperdidos);
                                                                            printf("Ingrse hits admitidos: ");
                                                                            fflush(stdin);
                                                                            scanf("%d",&equip.estadisticas.picher_lanzador[i].hits_admitidos);
                                                                            printf("Ingrese bases por bolas: ");
                                                                            fflush(stdin);
                                                                            scanf("%d",&equip.estadisticas.picher_lanzador[i].hits_admitidos);
                                                                            printf("Ingrse ponches: ");
                                                                            fflush(stdin);
                                                                            scanf("%d",&equip.estadisticas.picher_lanzador[i].ponches);
                                                                            printf("Ingrese entradas lanzadas: ");
                                                                            fflush(stdin);
                                                                            scanf("%d",&equip.estadisticas.picher_lanzador[i].entradas_lanzadas);
                                                                                                                                                        
                           
                               }
       }
       fwrite(&equip,sizeof(equipo),1,archivo);
       fclose(archivo);
       *num=j;
       system("cls");
       return equip;
}


/*void escritura(equipo x, int num)
{
     int i;
     const char cuadro[9]="infilder";
     const char jardin[10]="outfilder";
     const char picher[7]="picher";
     for(i=0;i<num;i++)
     {
                       printf("\tJugador: %d\n",i+1);
                       printf("Nombre: %s\n",x.datos[i].nombre);
                       printf("Nacionalidad: %s\n",x.datos[i].nacionalidad);
                       printf("Camisola: %d\n",x.datos[i].numero_camisola);
                       if(strcmp(x.datos[i].posicion,cuadro)==0)
                       {
                                                                    printf("Posicion: %s\n",x.estadisticas.infilderes[i].posicion);
                                                                    printf("Juegos jugados: %d\n",x.estadisticas.infilderes[i].juegos_jug);
                                                                    printf("Turnos al bate: %d\n",x.estadisticas.infilderes[i].turnos);
                                                                    printf("Carreras anotadas: %d\n",x.estadisticas.infilderes[i].carreras);
                                                                    printf("Sencillos conectador: %d\n",x.estadisticas.infilderes[i].hits);
                                                                    printf("Hits dobles: %d\n",x.estadisticas.infilderes[i].hits_dobles);
                                                                    printf("Hits triples: %d\n",x.estadisticas.infilderes[i].hits_triples);
                                                                    printf("Home rum: %d\n",x.estadisticas.infilderes[i].homerum);
                                                                    printf("Carreras producidas: %d\n",x.estadisticas.infilderes[i].carreras_pro);
                                                                    printf("Bases por bolas: %d\n",x.estadisticas.infilderes[i].base_bolas);
                                                                    printf("Ponches: %d\n",x.estadisticas.infilderes[i].ponches);
                                                                    printf("Bases robadas: %d\n",x.estadisticas.infilderes[i].bases_robadas);
                                                                    printf("Pocentaje de bateo: %f\n",x.estadisticas.infilderes[i].porcentaje_bateo);
                       }
                       else
                       {
                           if(strcmp(x.datos[i].posicion,jardin)==0)
                           {
                                                                    printf("Posicion: %s\n",x.estadisticas.outfilderes[i].posicion);
                                                                    printf("Juegos jugados: %d\n",x.estadisticas.outfilderes[i].juegos_jug);
                                                                    printf("Turnos al bate: %d\n",x.estadisticas.outfilderes[i].turnos);
                                                                    printf("Carreras anotadas: %d\n",x.estadisticas.outfilderes[i].carreras);
                                                                    printf("Sencillos conectador: %d\n",x.estadisticas.outfilderes[i].hits);
                                                                    printf("Hits dobles: %d\n",x.estadisticas.outfilderes[i].hits_dobles);
                                                                    printf("Hits triples: %d\n",x.estadisticas.outfilderes[i].hits_triples);
                                                                    printf("Home rum: %d\n",x.estadisticas.outfilderes[i].homerum);
                                                                    printf("Carreras producidas: %d\n",x.estadisticas.outfilderes[i].carreras_pro);
                                                                    printf("Bases por bolas: %d\n",x.estadisticas.outfilderes[i].base_bolas);
                                                                    printf("Ponches: %d\n",x.estadisticas.outfilderes[i].ponches);
                                                                    printf("Bases robadas: %d\n",x.estadisticas.outfilderes[i].bases_robadas);
                                                                    printf("Pocentaje de bateo: %f\n",x.estadisticas.outfilderes[i].porcentaje_bateo);
                                                                    
                           }
                       }
                       if(x.datos[i].baja_temporal =='S' || x.datos[i].baja_temporal=='s')
                       {
                                                   printf("Esta dado de baja temporal: \n");
                                                   printf("Causa: %s\n",x.datos[i].causa_baja);
                       }
                       else
                       {
                           printf("Activo (Està jugando): \n");
                       }
                       printf("\n");
                       printf("\n");
     }
     system("cls");
}*/

equipo busqueda(equipo x, int num,FILE *archivo)
{
     archivo=fopen("jugadores.dat","rb");
     fread(&x,sizeof(equipo),1,archivo);
     int i;
     char nom[30];
     const char cuadro[9]="infilder";
     const char jardin[10]="outfilder";
     const char picher[7]="picher";
     printf("Ingrese nombre jugador: \n");
     fflush(stdin);
     scanf("%s",&nom);
     while(!feof(archivo))
     {
     for(i=0;i<num;i++)
     {
                       if(strcmp(x.datos[i].posicion,cuadro)==0)
                       if(strcmp(x.datos[i].nombre,nom)==0)
                       {
                                                           printf("Posicion: %s\n",x.estadisticas.infilderes[i].posicion);
                                                           printf("Juegos jugados: %d\n",x.estadisticas.infilderes[i].juegos_jug);
                                                           printf("Turnos al bate: %d\n",x.estadisticas.infilderes[i].turnos);
                                                           printf("Carreras anotadas: %d\n",x.estadisticas.infilderes[i].carreras);
                                                           printf("Sencillos conectador: %d\n",x.estadisticas.infilderes[i].hits);
                                                           printf("Hits dobles: %d\n",x.estadisticas.infilderes[i].hits_dobles);
                                                           printf("Hits triples: %d\n",x.estadisticas.infilderes[i].hits_triples);
                                                           printf("Home rum: %d\n",x.estadisticas.infilderes[i].homerum);
                                                           printf("Carreras producidas: %d\n",x.estadisticas.infilderes[i].carreras_pro);
                                                           printf("Bases por bolas: %d\n",x.estadisticas.infilderes[i].base_bolas);
                                                           printf("Ponches: %d\n",x.estadisticas.infilderes[i].ponches);
                                                           printf("Bases robadas: %d\n",x.estadisticas.infilderes[i].bases_robadas);
                                                           printf("Pocentaje de bateo: %f\n",x.estadisticas.infilderes[i].porcentaje_bateo);                             
                                                           if(x.datos[i].baja_temporal =='S' || x.datos[i].baja_temporal=='s')
                                                           {
                                                                                       printf("Esta dado de baja temporal: \n");
                                                                                       printf("Causa: %s\n",x.datos[i].causa_baja);
                                                           }
                                                           else
                                                           {
                                                                                       printf("Activo (Està jugando): \n");
                                                           }
                       }                                                           
                       if(strcmp(x.datos[i].posicion,jardin)==0)
                       if(strcmp(x.datos[i].nombre,nom)==0)
                       {
                                                           printf("Posicion: %s\n",x.estadisticas.outfilderes[i].posicion);
                                                           printf("Juegos jugados: %d\n",x.estadisticas.outfilderes[i].juegos_jug);
                                                           printf("Turnos al bate: %d\n",x.estadisticas.outfilderes[i].turnos);
                                                           printf("Carreras anotadas: %d\n",x.estadisticas.outfilderes[i].carreras);
                                                           printf("Sencillos conectador: %d\n",x.estadisticas.outfilderes[i].hits);
                                                           printf("Hits dobles: %d\n",x.estadisticas.outfilderes[i].hits_dobles);
                                                           printf("Hits triples: %d\n",x.estadisticas.outfilderes[i].hits_triples);
                                                           printf("Home rum: %d\n",x.estadisticas.outfilderes[i].homerum);
                                                           printf("Carreras producidas: %d\n",x.estadisticas.outfilderes[i].carreras_pro);
                                                           printf("Bases por bolas: %d\n",x.estadisticas.outfilderes[i].base_bolas);
                                                           printf("Ponches: %d\n",x.estadisticas.outfilderes[i].ponches);
                                                           printf("Bases robadas: %d\n",x.estadisticas.outfilderes[i].bases_robadas);
                                                           printf("Pocentaje de bateo: %f\n",x.estadisticas.outfilderes[i].porcentaje_bateo);                                                           
                                                           if(x.datos[i].baja_temporal =='S' || x.datos[i].baja_temporal=='s')
                                                           {
                                                                                       printf("Esta dado de baja temporal: \n");
                                                                                       printf("Causa: %s\n",x.datos[i].causa_baja);
                                                           }
                                                           else
                                                           {
                                                                                       printf("Activo (Està jugando): \n");
                                                           }
                       }
                       if(strcmp(x.datos[i].posicion,picher)==0)
                       if(strcmp(x.datos[i].nombre,nom)==0)
                       {
                                                           printf("Lanzador\n");
                                                           printf("JUegos ganados: %d\n",x.estadisticas.picher_lanzador[i].juegosganados);
                                                           printf("Juegos perdidos: %d\n",x.estadisticas.picher_lanzador[i].juegosperdidos);
                                                           printf("Hist admitidos: %d\n",x.estadisticas.picher_lanzador[i].hits_admitidos);
                                                           printf("Bases por bolas: %d\n",x.estadisticas.picher_lanzador[i].base_bola);
                                                           printf("Ponches: %d\n",x.estadisticas.picher_lanzador[i].ponches);
                                                           printf("Entradas lanzadas: %d\n",x.estadisticas.picher_lanzador[i].entradas_lanzadas);
                                                           if(x.datos[i].baja_temporal =='S' || x.datos[i].baja_temporal=='s')
                                                           {
                                                                                       printf("Esta dado de baja temporal: \n");
                                                                                       printf("Causa: %s\n",x.datos[i].causa_baja);
                                                           }
                                                           else
                                                           {
                                                                                       printf("Activo (Està jugando): \n");
                                                           }
                       }
                       fread(&x,sizeof(equipo),1,archivo);
                       printf("\n");
                       printf("\n");
     }
     }
     fclose(archivo);
     system("pause");     
     system("cls");
     
}

equipo lista_bateadores(equipo x,int num,FILE *archivo)
{
     archivo=fopen("jugadores.dat","rb");
     fread(&x,sizeof(equipo),1,archivo);
     int i;
     const char cuadro[9]="infilder";
     const char jardin[10]="outfilder";
     const char picher[7]="picher";
     alineacion ali_bateadores;
     while(!feof(archivo))
     {
     for(i=0;i<num;i++)
     {
     if(strcmp(x.datos[i].posicion,picher)!=0)
     {
                                              printf("Nombre: %s\n",x.datos[i].nombre);
                                              fread(&x,sizeof(equipo),1,archivo);                                                                                     
     }
     }
     //fread(&x,sizeof(equipo),1,archivo);
     }
     fclose(archivo);
//     return;
     system("pause");
     system("cls");
     
}


equipo lista_lanzadores(equipo x,int num,FILE *archivo)
{
     archivo=fopen("jugadores.dat","rb");
     fread(&x,sizeof(equipo),1,archivo);
     int i;
     const char cuadro[9]="infilder";
     const char jardin[10]="outfilder";
     const char picher[7]="picher";
     alineacion ali_lanzadores;
     while(!feof(archivo))
     {
     for(i=0;i<num;i++)
     {
                       if(strcmp(x.datos[i].posicion,jardin)!=0  && strcmp(x.datos[i].posicion,cuadro)!=0)
                       {
                                                                  printf("Nombre: %s\n",x.datos[i].nombre);
                                                                  fread(&x,sizeof(equipo),1,archivo);
                       }
     }
     //fread(&x,sizeof(equipo),1,archivo);
     }
     fclose(archivo);
     return;
     
     
}

char menu()
{
     char op;
     printf("seleccione opcion\n");
     printf("a.- crear archivo\n");
     printf("b.- Dar de alta un jugador\n");
     printf("c.- Buscar informacion de un jugador\n");
     printf("d.- mostrar lista de jugadores\n");
     printf("e.- salir\n");
     fflush(stdin);
     op=tolower(getchar());
     return op;
}


void creararchivo(FILE *archivo)
{
     archivo=fopen("jugadores.dat","rb");
     if(!archivo)
     {
                 archivo=fopen("jugadores.dat","wb");
                 printf("archivo creado\n");
     }
     else
     {
         printf("archivo ya existe\n");
     }
     fclose(archivo);
     return;
}

int main(void)
{
    FILE *archivo;
    equipo equipo1;
    int i,j,n,c=0;
    char opc[20];
    char sel;
    const char clave[8]="melchor";
    const char cuadro[9]="infilder";
    const char jardin[10]="outfilder";
    for (c=0;c<3;c++)
    {
         printf("ingrese clave:");
         fflush(stdin);
         scanf("%s",&opc);
         if(strcmp(opc,clave)==0)
         {
                                 do
                                 {
                                      c=2;
                                      fflush(stdin);
                                      sel=tolower(menu());
                                      switch(sel)
                                      {
                                                 char opl;
                                                 case 'a':
                                                      creararchivo(archivo);
                                                 break; 
                                             case 'b':
                                                  equipo1=lectura(&n,archivo);
                                                  //escritura(equipo1,n,archivo);
                                             break;
                                             case 'c':
                                                  busqueda(equipo1,n,archivo);
                                             break;
                                             case 'd':                                                  
                                                  printf("Seleccione que lista desea ver\n");
                                                  printf("x.- Bateadores\n");
                                                  printf("y.- Lanzadores\n");
                                                  printf("z.- Ninguna\n");
                                                  fflush(stdin);
                                                  opl=getchar();
                                                  switch (opl)
                                                  {
                                                         case 'x':
                                                              lista_bateadores(equipo1,n,archivo);
                                                         break;
                                                         case 'y':
                                                              lista_lanzadores(equipo1,n,archivo);
                                                         break;
                                                         case 'z':
                                                              continue;
                                                         break;
                                                  }
                                                  system("pause");
                                                  system("cls");
                                                  //lista(equipo1,n);
                                             break;
                                             case 'e':
                                                  getch();
                                                  exit(0);
                                             break;
                                      }
                                 }while(sel!='c' || sel!='C');
         }
    }
    
    
getch();
return 0;
}
