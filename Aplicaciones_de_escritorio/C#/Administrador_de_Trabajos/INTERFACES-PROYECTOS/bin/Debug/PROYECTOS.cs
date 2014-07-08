using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace INTERFACES_PROYECTOS
{
    public partial class PROYECTOS : Form
    {
        public PROYECTOS()
        {
            deshabilitar();
            InitializeComponent();
        }
        private void button1_Click(object sender, EventArgs e)
        {
            habilitar();
            ARTICULOS articulo = new ARTICULOS();
            articulo.Show();
        }
        private void groupBox2_Enter(object sender, EventArgs e)
        {

        }
        public void deshabilitar()
        {
            //txtdescripcion.Enabled = false;
            //txtnombre.Enabled = false;
            //txttipo.Enabled = false;
            //dtpinicio.Enabled = false;
            //dtpfin.Enabled = false;
        }
        public void habilitar()
        {
            txtdescripcion.Enabled = true;
            txtnombre.Enabled = true;
            txttipo.Enabled = true;
            dtpinicio.Enabled = true;
            dtpfin.Enabled = true;
        }

       private void PROYECTOS_Load(object sender, EventArgs e)
        {
            checkBox1.Checked = true;
            
        }
    }
}
