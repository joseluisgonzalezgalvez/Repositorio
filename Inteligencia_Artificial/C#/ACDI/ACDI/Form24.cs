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
    public partial class Form24 : Form
    {
        public Index f1 = new Index();
        public Form24()
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
            
            Form25 f25 = new Form25();
            f25.Show();

            this.Close();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Close();
            Form23 f23 = new Form23();
            f23.Show();
        }
    }
}
