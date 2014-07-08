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
    public partial class Form2 : Form
    {
        double minimo = 4.3;
        double maximo = 7.9;
        public Form2()
        {
            InitializeComponent();
        }

        private void trackBar1_Scroll(object sender, EventArgs e)
        {
            //txtlogsep.Text = (System.Math.Round(trackBar1.Value)).ToString();
            /*trackBar1.Minimum = minimo;
            trackBar1.Maximum = maximo;*/

        }

        private void Form2_Load(object sender, EventArgs e)
        {

        }

        private void txtlogsep_TextChanged(object sender, EventArgs e)
        {

        }

        private void trackBar1_Scroll_1(object sender, EventArgs e)
        {

        }

        private void guardarToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

     }
}
