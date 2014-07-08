/*El siguiente programa ha sido probado y testeado bajo MS-DOS*/
/*Programado en Borland C++ 5.0*/
/*Grafica el Fractal de Von Koch en forma recursiva.*/


#include <stdio.h>
#include <conio.h>
#include <glut.h>
#include <math.h>
#define PI 3.14159

/************************Funciones*****************/

/*Dibuja una linea de longitud r y angulo angulo*/

void draw(double r,double angulo);

/*Simplemente arma el denominado copo de Koch */

void copoKoch(int orden, double r);

/*Grafica la curva de Von Koch en forma recursiva como es de esperarse*/

void koch(int orden,double r,double angulo);

/*Inicia el modo grafico*/

int iniModoGrafico(int *X_max, int *Y_max);

/****************************************************/
int
main(void)
{


  int Xm,Ym;
  float lado;  /*Longitud de cada lado de */
  int orden;  /*Indica el orden del fractal.Orden 0 es el caso Base*/


  printf("Ingrese el orden: ");
  scanf("%d",&orden);

  printf("Ingrese el lado: ");
  scanf("%f",&lado);

  iniModoGrafico(&Xm,&Ym);
  moveto( ((Xm+1)/2)-(Xm+1)/4,((Ym+1) /2)+(Ym+1)/4);

  copoKoch(orden,lado);

   getch();
   closegraph();

return 0;

}

/**************************/
void
copoKoch(int orden, double r)
{
    koch(orden,r,PI/3);
    koch(orden,r,-PI/3);
    koch(orden,r,PI);

}
/**************************/
void
draw(double r,double angulo)
{
     linerel(r*cos(angulo), -r*sin (angulo));

}
/*********************************/

int
iniModoGrafico(int *X_max, int *Y_max)
{
   int controlador = DETECT, modo, numerror;

   initgraph(&controlador, &modo, "C:\\BC5\\BGI");
	numerror = graphresult();   /*Si queres podes usar numerror*/

   if (numerror != grOk)            /* grOk vale 0 si no hay error */
      return numerror;

   *X_max = getmaxx();
   *Y_max = getmaxy();

   return 0;
}
/**************************/
void
koch(int orden,double r,double angulo)
{
   if(orden==0)
     draw(r,angulo);

   else
   {
     koch(orden-1,r/3,angulo);
     koch(orden-1,r/3,angulo+(PI/3));
     koch(orden-1,r/3,angulo-(PI/3));
     koch(orden-1,r/3,angulo);
   }

}

/**************************/

