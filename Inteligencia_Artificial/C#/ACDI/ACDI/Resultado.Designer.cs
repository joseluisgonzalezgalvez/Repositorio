namespace ACDI
{
    partial class Resultado
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
            this.label1 = new System.Windows.Forms.Label();
            this.txtresult = new System.Windows.Forms.TextBox();
            this.txtcarrera = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(130, 24);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(148, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "TU PERFIL ACADEMICO ES:";
            // 
            // txtresult
            // 
            this.txtresult.Location = new System.Drawing.Point(52, 49);
            this.txtresult.Name = "txtresult";
            this.txtresult.Size = new System.Drawing.Size(555, 20);
            this.txtresult.TabIndex = 1;
            // 
            // txtcarrera
            // 
            this.txtcarrera.Location = new System.Drawing.Point(52, 85);
            this.txtcarrera.Name = "txtcarrera";
            this.txtcarrera.Size = new System.Drawing.Size(184, 20);
            this.txtcarrera.TabIndex = 2;
            // 
            // Resultado
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(669, 289);
            this.Controls.Add(this.txtcarrera);
            this.Controls.Add(this.txtresult);
            this.Controls.Add(this.label1);
            this.Name = "Resultado";
            this.Text = "Resultado";
            this.Load += new System.EventHandler(this.Resultado_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txtresult;
        private System.Windows.Forms.TextBox txtcarrera;
    }
}