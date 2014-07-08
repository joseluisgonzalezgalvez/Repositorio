using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Iris
{
    public partial class Form3 : Form
    {
        public int funcion;
        public Form3()
        {
            InitializeComponent();
        }
        public void funcion_set(int n) {
            this.funcion = n;
        

        }
        public int get_funcion() {
            return this.funcion;
        }

        private void button1_Click(object sender, EventArgs e)
        {
           
            Form1 f1 = new Form1();
            f1.Show();
        }

        private void radioButton1_CheckedChanged(object sender, EventArgs e)
        {
            funcion_set(0);
        }

        private void radioButton2_CheckedChanged(object sender, EventArgs e)
        {
            funcion_set(1);
        }
    }
}
