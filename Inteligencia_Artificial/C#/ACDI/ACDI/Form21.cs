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
    public partial class Form21 : Form
    {
        public Index f1 = new Index();
        public Form21()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (radioButton1.Checked == true)
            {
                //MessageBox.Show("hola");
                f1.resp[f1.contador] = 1;
                f1.contador++;
            }
            if (radioButton2.Checked == true)
            {
                f1.resp[f1.contador] = 0;
                f1.contador++;
            }
            
            
            Form22 f22 = new Form22();
            f22.Show();

            this.Close();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Close();
            Form20 f20 = new Form20();
            f20.Show();
        }
    }
}
