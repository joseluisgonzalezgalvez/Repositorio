namespace Iris
{
    partial class Form1
    {
        /// <summary>
        /// Variable del diseñador requerida.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén utilizando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben eliminar; false en caso contrario, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido del método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.abrirToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.guardarToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.cargarToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.entrenarToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.funciónDeTransferenciaToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.purelineToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.sigmoidalToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.comprobarToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.probarToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.BackColor = System.Drawing.SystemColors.ButtonHighlight;
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.abrirToolStripMenuItem,
            this.guardarToolStripMenuItem,
            this.cargarToolStripMenuItem,
            this.entrenarToolStripMenuItem,
            this.probarToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(599, 24);
            this.menuStrip1.TabIndex = 0;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // abrirToolStripMenuItem
            // 
            this.abrirToolStripMenuItem.Image = ((System.Drawing.Image)(resources.GetObject("abrirToolStripMenuItem.Image")));
            this.abrirToolStripMenuItem.Name = "abrirToolStripMenuItem";
            this.abrirToolStripMenuItem.Size = new System.Drawing.Size(61, 20);
            this.abrirToolStripMenuItem.Text = "Abrir";
            // 
            // guardarToolStripMenuItem
            // 
            this.guardarToolStripMenuItem.Image = ((System.Drawing.Image)(resources.GetObject("guardarToolStripMenuItem.Image")));
            this.guardarToolStripMenuItem.Name = "guardarToolStripMenuItem";
            this.guardarToolStripMenuItem.Size = new System.Drawing.Size(77, 20);
            this.guardarToolStripMenuItem.Text = "Guardar";
            // 
            // cargarToolStripMenuItem
            // 
            this.cargarToolStripMenuItem.Image = ((System.Drawing.Image)(resources.GetObject("cargarToolStripMenuItem.Image")));
            this.cargarToolStripMenuItem.Name = "cargarToolStripMenuItem";
            this.cargarToolStripMenuItem.Size = new System.Drawing.Size(70, 20);
            this.cargarToolStripMenuItem.Text = "Cargar";
            // 
            // entrenarToolStripMenuItem
            // 
            this.entrenarToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.funciónDeTransferenciaToolStripMenuItem,
            this.comprobarToolStripMenuItem});
            this.entrenarToolStripMenuItem.Image = ((System.Drawing.Image)(resources.GetObject("entrenarToolStripMenuItem.Image")));
            this.entrenarToolStripMenuItem.Name = "entrenarToolStripMenuItem";
            this.entrenarToolStripMenuItem.Size = new System.Drawing.Size(79, 20);
            this.entrenarToolStripMenuItem.Text = "Entrenar";
            // 
            // funciónDeTransferenciaToolStripMenuItem
            // 
            this.funciónDeTransferenciaToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.purelineToolStripMenuItem,
            this.sigmoidalToolStripMenuItem});
            this.funciónDeTransferenciaToolStripMenuItem.Name = "funciónDeTransferenciaToolStripMenuItem";
            this.funciónDeTransferenciaToolStripMenuItem.Size = new System.Drawing.Size(207, 22);
            this.funciónDeTransferenciaToolStripMenuItem.Text = "Función de Transferencia";
            // 
            // purelineToolStripMenuItem
            // 
            this.purelineToolStripMenuItem.Name = "purelineToolStripMenuItem";
            this.purelineToolStripMenuItem.Size = new System.Drawing.Size(127, 22);
            this.purelineToolStripMenuItem.Text = "Pureline";
            // 
            // sigmoidalToolStripMenuItem
            // 
            this.sigmoidalToolStripMenuItem.Name = "sigmoidalToolStripMenuItem";
            this.sigmoidalToolStripMenuItem.Size = new System.Drawing.Size(127, 22);
            this.sigmoidalToolStripMenuItem.Text = "Sigmoidal";
            // 
            // comprobarToolStripMenuItem
            // 
            this.comprobarToolStripMenuItem.Name = "comprobarToolStripMenuItem";
            this.comprobarToolStripMenuItem.Size = new System.Drawing.Size(207, 22);
            this.comprobarToolStripMenuItem.Text = "Comprobar";
            // 
            // probarToolStripMenuItem
            // 
            this.probarToolStripMenuItem.Image = ((System.Drawing.Image)(resources.GetObject("probarToolStripMenuItem.Image")));
            this.probarToolStripMenuItem.Name = "probarToolStripMenuItem";
            this.probarToolStripMenuItem.RightToLeftAutoMirrorImage = true;
            this.probarToolStripMenuItem.Size = new System.Drawing.Size(97, 20);
            this.probarToolStripMenuItem.Text = "Probar RNA";
            this.probarToolStripMenuItem.Click += new System.EventHandler(this.probarToolStripMenuItem_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.Control;
            this.ClientSize = new System.Drawing.Size(599, 327);
            this.Controls.Add(this.menuStrip1);
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "Form1";
            this.Text = "Iris";
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem abrirToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem guardarToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem cargarToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem entrenarToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem funciónDeTransferenciaToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem purelineToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem sigmoidalToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem comprobarToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem probarToolStripMenuItem;
    }
}

