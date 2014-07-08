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
    public partial class Form36 : Form
    {
        public Index f1 = new Index();
        public Resultado result = new Resultado();
        public Form36()
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
                f1.resp[f1.contador] = 0;
                result.Show();
                this.Close();
            }
            if (radioButton2.Checked == true)
            {
                f1.resp[f1.contador] = 0;
                f1.contador++;
                Form37 f37 = new Form37();
                f37.Show();
                this.Close();
            }
        }

        private void Form36_Load(object sender, EventArgs e)
        {
            this.Visible = false;
        }
    }
}
