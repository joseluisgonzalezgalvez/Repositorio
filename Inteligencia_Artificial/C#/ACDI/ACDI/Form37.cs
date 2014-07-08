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
    public partial class Form37 : Form
    {
        public Index f1 = new Index();
        public Form37()
        {
            InitializeComponent();
        }

        private void radioButton1_CheckedChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (radioButton1.Checked == true)
            {
                //MessageBox.Show("hola");
                f1.resp[f1.contador] = 4;
                //f1.contador++;
            }
            if (radioButton2.Checked == true)
            {
                f1.resp[f1.contador] = 3;
                //f1.contador++;
            }
            if (radioButton3.Checked == true)
            {
                f1.resp[f1.contador] = 2;
                //f1.contador++;
            }
            if (radioButton4.Checked == true)
            {
                f1.resp[f1.contador] = 1;
                //f1.contador++;
            }
            if (radioButton5.Checked == true)
            {
                f1.resp[f1.contador] = 5;
                //f1.contador++;
            }
        }

        private void Form37_Load(object sender, EventArgs e)
        {
            this.Visible = false;
        }
    }
}
