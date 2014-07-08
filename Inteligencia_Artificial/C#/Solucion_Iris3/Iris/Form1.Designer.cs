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
            this.probarToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.btnprobar = new System.Windows.Forms.Button();
            this.basededatos = new System.Windows.Forms.ListBox();
            this.elepruebas = new System.Windows.Forms.ListBox();
            this.txtclases = new System.Windows.Forms.TextBox();
            this.txtclase = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.panel1 = new System.Windows.Forms.Panel();
            this.panel2 = new System.Windows.Forms.Panel();
            this.button1 = new System.Windows.Forms.Button();
            this.numericUpDown4 = new System.Windows.Forms.NumericUpDown();
            this.numericUpDown3 = new System.Windows.Forms.NumericUpDown();
            this.numericUpDown2 = new System.Windows.Forms.NumericUpDown();
            this.numericUpDown1 = new System.Windows.Forms.NumericUpDown();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.menuStrip1.SuspendLayout();
            this.panel1.SuspendLayout();
            this.panel2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown4)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown3)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown2)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
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
            this.menuStrip1.Size = new System.Drawing.Size(492, 24);
            this.menuStrip1.TabIndex = 0;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // abrirToolStripMenuItem
            // 
            this.abrirToolStripMenuItem.BackColor = System.Drawing.SystemColors.Window;
            this.abrirToolStripMenuItem.Image = ((System.Drawing.Image)(resources.GetObject("abrirToolStripMenuItem.Image")));
            this.abrirToolStripMenuItem.Name = "abrirToolStripMenuItem";
            this.abrirToolStripMenuItem.Size = new System.Drawing.Size(61, 20);
            this.abrirToolStripMenuItem.Text = "Abrir";
            this.abrirToolStripMenuItem.Click += new System.EventHandler(this.abrirToolStripMenuItem_Click);
            // 
            // guardarToolStripMenuItem
            // 
            this.guardarToolStripMenuItem.Image = ((System.Drawing.Image)(resources.GetObject("guardarToolStripMenuItem.Image")));
            this.guardarToolStripMenuItem.Name = "guardarToolStripMenuItem";
            this.guardarToolStripMenuItem.Size = new System.Drawing.Size(77, 20);
            this.guardarToolStripMenuItem.Text = "Guardar";
            this.guardarToolStripMenuItem.Click += new System.EventHandler(this.guardarToolStripMenuItem_Click);
            // 
            // cargarToolStripMenuItem
            // 
            this.cargarToolStripMenuItem.Image = ((System.Drawing.Image)(resources.GetObject("cargarToolStripMenuItem.Image")));
            this.cargarToolStripMenuItem.Name = "cargarToolStripMenuItem";
            this.cargarToolStripMenuItem.Size = new System.Drawing.Size(70, 20);
            this.cargarToolStripMenuItem.Text = "Cargar";
            this.cargarToolStripMenuItem.Click += new System.EventHandler(this.cargarToolStripMenuItem_Click);
            // 
            // entrenarToolStripMenuItem
            // 
            this.entrenarToolStripMenuItem.Image = ((System.Drawing.Image)(resources.GetObject("entrenarToolStripMenuItem.Image")));
            this.entrenarToolStripMenuItem.Name = "entrenarToolStripMenuItem";
            this.entrenarToolStripMenuItem.Size = new System.Drawing.Size(79, 20);
            this.entrenarToolStripMenuItem.Text = "Entrenar";
            this.entrenarToolStripMenuItem.Click += new System.EventHandler(this.entrenarToolStripMenuItem_Click);
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
            // btnprobar
            // 
            this.btnprobar.Location = new System.Drawing.Point(6, 318);
            this.btnprobar.Name = "btnprobar";
            this.btnprobar.Size = new System.Drawing.Size(114, 23);
            this.btnprobar.TabIndex = 4;
            this.btnprobar.Text = "Probar Elemento";
            this.btnprobar.UseVisualStyleBackColor = true;
            this.btnprobar.Click += new System.EventHandler(this.btnprobar_Click);
            // 
            // basededatos
            // 
            this.basededatos.FormattingEnabled = true;
            this.basededatos.Location = new System.Drawing.Point(6, 7);
            this.basededatos.Name = "basededatos";
            this.basededatos.Size = new System.Drawing.Size(218, 277);
            this.basededatos.TabIndex = 1;
            // 
            // elepruebas
            // 
            this.elepruebas.BackColor = System.Drawing.SystemColors.Window;
            this.elepruebas.ForeColor = System.Drawing.SystemColors.Info;
            this.elepruebas.FormattingEnabled = true;
            this.elepruebas.Location = new System.Drawing.Point(254, 7);
            this.elepruebas.Name = "elepruebas";
            this.elepruebas.Size = new System.Drawing.Size(218, 277);
            this.elepruebas.TabIndex = 2;
            this.elepruebas.DrawItem += new System.Windows.Forms.DrawItemEventHandler(this.elepruebas_DrawItem);
            this.elepruebas.SelectedIndexChanged += new System.EventHandler(this.elepruebas_SelectedIndexChanged);
            // 
            // txtclases
            // 
            this.txtclases.Enabled = false;
            this.txtclases.Location = new System.Drawing.Point(6, 291);
            this.txtclases.Name = "txtclases";
            this.txtclases.Size = new System.Drawing.Size(466, 20);
            this.txtclases.TabIndex = 3;
            // 
            // txtclase
            // 
            this.txtclase.Enabled = false;
            this.txtclase.Location = new System.Drawing.Point(303, 318);
            this.txtclase.Name = "txtclase";
            this.txtclase.Size = new System.Drawing.Size(169, 20);
            this.txtclase.TabIndex = 5;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(251, 318);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(39, 13);
            this.label1.TabIndex = 6;
            this.label1.Text = "Clase: ";
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.label1);
            this.panel1.Controls.Add(this.txtclase);
            this.panel1.Controls.Add(this.btnprobar);
            this.panel1.Controls.Add(this.txtclases);
            this.panel1.Controls.Add(this.elepruebas);
            this.panel1.Controls.Add(this.basededatos);
            this.panel1.Location = new System.Drawing.Point(7, 31);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(484, 354);
            this.panel1.TabIndex = 7;
            // 
            // panel2
            // 
            this.panel2.Controls.Add(this.button1);
            this.panel2.Controls.Add(this.numericUpDown4);
            this.panel2.Controls.Add(this.numericUpDown3);
            this.panel2.Controls.Add(this.numericUpDown2);
            this.panel2.Controls.Add(this.numericUpDown1);
            this.panel2.Controls.Add(this.label3);
            this.panel2.Controls.Add(this.label4);
            this.panel2.Controls.Add(this.label2);
            this.panel2.Controls.Add(this.label5);
            this.panel2.Controls.Add(this.pictureBox1);
            this.panel2.Location = new System.Drawing.Point(7, 31);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(484, 354);
            this.panel2.TabIndex = 8;
            this.panel2.Paint += new System.Windows.Forms.PaintEventHandler(this.panel2_Paint);
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(303, 289);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 23);
            this.button1.TabIndex = 16;
            this.button1.Text = "Probar";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // numericUpDown4
            // 
            this.numericUpDown4.DecimalPlaces = 1;
            this.numericUpDown4.Increment = new decimal(new int[] {
            1,
            0,
            0,
            65536});
            this.numericUpDown4.Location = new System.Drawing.Point(186, 294);
            this.numericUpDown4.Name = "numericUpDown4";
            this.numericUpDown4.Size = new System.Drawing.Size(61, 20);
            this.numericUpDown4.TabIndex = 15;
            this.numericUpDown4.Value = new decimal(new int[] {
            3,
            0,
            0,
            65536});
            // 
            // numericUpDown3
            // 
            this.numericUpDown3.DecimalPlaces = 1;
            this.numericUpDown3.Increment = new decimal(new int[] {
            1,
            0,
            0,
            65536});
            this.numericUpDown3.Location = new System.Drawing.Point(186, 266);
            this.numericUpDown3.Name = "numericUpDown3";
            this.numericUpDown3.Size = new System.Drawing.Size(61, 20);
            this.numericUpDown3.TabIndex = 14;
            this.numericUpDown3.Value = new decimal(new int[] {
            19,
            0,
            0,
            65536});
            // 
            // numericUpDown2
            // 
            this.numericUpDown2.DecimalPlaces = 1;
            this.numericUpDown2.Increment = new decimal(new int[] {
            1,
            0,
            0,
            65536});
            this.numericUpDown2.Location = new System.Drawing.Point(186, 238);
            this.numericUpDown2.Name = "numericUpDown2";
            this.numericUpDown2.Size = new System.Drawing.Size(61, 20);
            this.numericUpDown2.TabIndex = 13;
            this.numericUpDown2.Value = new decimal(new int[] {
            28,
            0,
            0,
            65536});
            // 
            // numericUpDown1
            // 
            this.numericUpDown1.DecimalPlaces = 1;
            this.numericUpDown1.Increment = new decimal(new int[] {
            1,
            0,
            0,
            65536});
            this.numericUpDown1.Location = new System.Drawing.Point(186, 211);
            this.numericUpDown1.Name = "numericUpDown1";
            this.numericUpDown1.Size = new System.Drawing.Size(61, 20);
            this.numericUpDown1.TabIndex = 12;
            this.numericUpDown1.Value = new decimal(new int[] {
            59,
            0,
            0,
            65536});
            this.numericUpDown1.ValueChanged += new System.EventHandler(this.numericUpDown1_ValueChanged);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(73, 301);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(87, 13);
            this.label3.TabIndex = 11;
            this.label3.Text = "Ancho del pétalo";
            this.label3.UseWaitCursor = true;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(73, 273);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(97, 13);
            this.label4.TabIndex = 10;
            this.label4.Text = "Longitud del pétalo";
            this.label4.UseWaitCursor = true;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(73, 245);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(89, 13);
            this.label2.TabIndex = 9;
            this.label2.Text = "Ancho del sépalo";
            this.label2.UseWaitCursor = true;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Cursor = System.Windows.Forms.Cursors.WaitCursor;
            this.label5.Location = new System.Drawing.Point(73, 213);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(99, 13);
            this.label5.TabIndex = 8;
            this.label5.Text = "Longitud del sépalo";
            this.label5.UseWaitCursor = true;
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox1.Image")));
            this.pictureBox1.Location = new System.Drawing.Point(142, 19);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(209, 145);
            this.pictureBox1.TabIndex = 0;
            this.pictureBox1.TabStop = false;
            this.pictureBox1.Click += new System.EventHandler(this.pictureBox1_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.Control;
            this.ClientSize = new System.Drawing.Size(492, 409);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.menuStrip1);
            this.Controls.Add(this.panel2);
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "Form1";
            this.Text = "Iris";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.panel2.ResumeLayout(false);
            this.panel2.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown4)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown3)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown2)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem abrirToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem guardarToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem cargarToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem entrenarToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem probarToolStripMenuItem;
        private System.Windows.Forms.Button btnprobar;
        private System.Windows.Forms.ListBox basededatos;
        private System.Windows.Forms.ListBox elepruebas;
        private System.Windows.Forms.TextBox txtclases;
        private System.Windows.Forms.TextBox txtclase;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Panel panel2;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.NumericUpDown numericUpDown1;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.NumericUpDown numericUpDown4;
        private System.Windows.Forms.NumericUpDown numericUpDown3;
        private System.Windows.Forms.NumericUpDown numericUpDown2;
    }
}

