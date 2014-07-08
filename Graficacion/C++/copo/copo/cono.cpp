#include <GL/glut.h>
#include <stdlib.h>

#define MUNDO 4.0f

typedef struct {
	float x, y, z;
}Punto;

//Variables globales que guardan el tope de las coordenadas de mundo
float xMax, yMax;

void inicializar (void);
void redimensiona (int alto, int ancho);
void dibuja (void);
void teclado (unsigned char key, int cx, int cy);
void tecladoEspecial (int key, int cy, int cx);
void raton (int boton, int estado, int cx, int cy);
void koch (Punto p0, Punto p1, int profundidad);

//Variable Global que guarda los vertices del copo
Punto vertices[3];
//Variable que guarda el numero de vertices
int numPtos;
int fondo;

int main(int argc, char** argv) {
   
   glutInit(&argc, argv);
   glutInitDisplayMode (GLUT_SINGLE | GLUT_RGBA);
   glutInitWindowSize (640, 480);
   glutInitWindowPosition (100, 105);
   glutCreateWindow (argv[0]);
   inicializar();
   
   glutDisplayFunc(dibuja);
   glutReshapeFunc(redimensiona);
   glutKeyboardFunc(teclado);
   glutSpecialFunc(tecladoEspecial);
   glutMouseFunc(raton);
   
   glutMainLoop();
   
   return 0;
}

void inicializar () {
   glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
   glPointSize(5.0);
   numPtos = 0;
   fondo = 1;
}

void redimensiona (int ancho, int alto) {
   float aspect;
   
   glViewport (0, 0, ancho, alto);
   glMatrixMode (GL_PROJECTION);
   glLoadIdentity ();
   
   if (alto == 0){
   	  alto = 1;
   }
   
   aspect = (float) ancho / (float) alto;
   
   if (ancho <= alto) {
   	  glOrtho(-MUNDO, MUNDO, -MUNDO/aspect, MUNDO/aspect, -MUNDO, MUNDO);
   	  xMax = MUNDO;
   	  yMax = MUNDO / aspect;
   	  
   } else {
   	  glOrtho(-MUNDO * aspect, MUNDO * aspect, -MUNDO, MUNDO, -MUNDO, MUNDO);
   	  xMax = MUNDO * aspect;
   	  yMax = MUNDO;
   }
   
   glMatrixMode(GL_MODELVIEW);
   glLoadIdentity();
}

void teclado (unsigned char key, int cx, int cy) {
	
	switch (key) {
		case 27:
		   exit(0);
		break;
		
		default: break;
	}
	
	glutPostRedisplay();
}

void tecladoEspecial (int key, int cy, int cx) {
	
	switch (key) {
		case GLUT_KEY_PAGE_UP:
		   fondo++;
		break;
		
		case GLUT_KEY_PAGE_DOWN:
		   if (fondo > 1) fondo--;
		break;
		
		default: break;
	}
	
	glutPostRedisplay();
}

void raton (int boton, int estado, int cx, int cy) {
	float x, y;

	/* Calculamos las coordenadas de mundo (relativas) apartir de 
	 * las de ventana (absolutas) */
	
	x = ((GLfloat)cx * 2.0 * xMax) / glutGet(GLUT_WINDOW_WIDTH) - xMax;
	y = yMax - ((GLfloat)cy * 2.0 * yMax) / glutGet(GLUT_WINDOW_HEIGHT);
	
	if (boton == GLUT_LEFT_BUTTON && estado == GLUT_DOWN) {
		
		if (numPtos < 3) {
		   vertices[numPtos].x = x;
		   vertices[numPtos].y = y;
		   vertices[numPtos].z = 0.0;
		   ++numPtos;
	    }
	    else {
	       numPtos = 0;
	       vertices[numPtos].x = x;
		   vertices[numPtos].y = y;
		   vertices[numPtos].z = 0.0;
		   numPtos++;
	    }
	}
	
	glutPostRedisplay();
}


void dibuja (void) {
	int i;
	
	glClear(GL_COLOR_BUFFER_BIT);
	
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();
	
	
	if (numPtos != 3) {
	   glColor3f(1.0, 1.0, 1.0);
	   glBegin(GL_POINTS);
	      for (i = 0; i <numPtos; i++) {
	   	     glVertex3f(vertices[i].x, vertices[i].y, vertices[i].z);
	      }
	   glEnd();
	}
	
	if (numPtos == 3) {
	   glColor3f(1.0, 1.0, 0.0);
	   glBegin(GL_LINE_STRIP);
	      koch(vertices[0], vertices[1], 0);
	      koch(vertices[1], vertices[2], 0);
	      koch(vertices[2], vertices[0], 0);
	   glEnd();
	}	
	    
	glFlush();
}

//Funcion que genera los vertices de la curva de Koch
void koch (Punto p0, Punto p1, int profundidad) {
	Punto a, b, p2;
	
	if (profundidad < fondo) {
		a.x = 2.0 / 3.0 * p0.x + 1.0 / 3.0 * p1.x;
		a.y = 2.0 / 3.0 * p0.y + 1.0 / 3.0 * p1.y;
		a.z = 0.0;
		
		b.x = 1.0 / 3.0 * p0.x + 2.0 / 3.0 * p1.x;
		b.y = 1.0 / 3.0 * p0.y + 2.0 / 3.0 * p1.y;
		b.z = 0.0;
		
		p2.x = 0.5 * p0.x + 0.5 * p1.x + a.y - b.y;
		p2.y = 0.5 * p0.y + 0.5 * p1.y + b.x - a.x;
		p2.z = 0.0;
		
		glVertex3f(p0.x, p0.y, p0.z);
		koch(p0, a, profundidad + 1);
		glVertex3f(a.x, a.y, a.z);
		koch(a, p2, profundidad + 1);
		glVertex3f(p2.x, p2.y, p2.z);
		koch(p2, b, profundidad + 1);
		glVertex3f(b.x, b.y, b.z);
		koch(b, p1, profundidad + 1);
		glVertex3f(p1.x, p1.y, p1.z);
		
	} 
	
	return;
}
