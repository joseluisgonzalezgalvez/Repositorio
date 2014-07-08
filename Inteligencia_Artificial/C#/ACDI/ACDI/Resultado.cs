using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace ACDI
{
    public partial class Resultado : Form
    {
        public Form2 f2 = new Form2();
        public Index f1 = new Index();
        public Resultado()
        {
            InitializeComponent();
            resultado_quizz();
        }
        public void resultado_quizz()
        {
            double[] resp = f2.red.Run(f1.resp);
            txtresult.Text = "C1=" + resp[0].ToString() + "   C2=" + resp[1].ToString() + "   C3=" + resp[2].ToString() + "   C4=" + resp[3].ToString();

            double max = 0;
            int ind = 0;
            for (int m = 0; m < 4; m++)
                if (resp[m] > max)
                {
                    max = resp[m];
                    ind = m;
                }

            if(int.Parse(f2.clase[ind].ToString())==1)
                txtcarrera.Text = "Administracion Publica";
            if (int.Parse(f2.clase[ind].ToString()) == 2)
                txtcarrera.Text = "Ciencias Empresariales";
            if (int.Parse(f2.clase[ind].ToString()) == 3)
                txtcarrera.Text = "Derecho";
            if (int.Parse(f2.clase[ind].ToString()) == 4)
                txtcarrera.Text = "Informática";
            //txtcarrera.Text = f2.clase[ind].ToString();
            f1.contador = 0;
        }

        private void Resultado_Load(object sender, EventArgs e)
        {

        }
    }
}
