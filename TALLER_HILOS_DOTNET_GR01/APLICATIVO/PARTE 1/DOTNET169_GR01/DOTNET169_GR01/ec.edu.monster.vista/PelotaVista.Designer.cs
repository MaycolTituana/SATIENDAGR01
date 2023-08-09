namespace DOTNET169_GR01.ec.edu.monster.vista
{
    partial class PelotaVista
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code
        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        /// 
        private void InitializeComponent()
        {
            this.Marco = new System.Windows.Forms.Panel();
            this.btnComenzar = new System.Windows.Forms.Button();
            this.btnCerrar = new System.Windows.Forms.Button();
            this.btnDetener = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // Marco
            // 
            this.Marco.BackColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.Marco.Location = new System.Drawing.Point(12, 12);
            this.Marco.Name = "Marco";
            this.Marco.Size = new System.Drawing.Size(422, 275);
            this.Marco.TabIndex = 0;
            this.Marco.Paint += new System.Windows.Forms.PaintEventHandler(this.Dibujar_Marco);
            // 
            // btnComenzar
            // 
            this.btnComenzar.BackColor = System.Drawing.SystemColors.MenuHighlight;
            this.btnComenzar.Location = new System.Drawing.Point(456, 92);
            this.btnComenzar.Name = "btnComenzar";
            this.btnComenzar.Size = new System.Drawing.Size(91, 23);
            this.btnComenzar.TabIndex = 1;
            this.btnComenzar.Text = "Empezar";
            this.btnComenzar.UseVisualStyleBackColor = false;
            this.btnComenzar.Click += new System.EventHandler(this.btnComenzar_Clic);
            // 
            // btnCerrar
            // 
            this.btnCerrar.BackColor = System.Drawing.SystemColors.Info;
            this.btnCerrar.Location = new System.Drawing.Point(456, 187);
            this.btnCerrar.Name = "btnCerrar";
            this.btnCerrar.Size = new System.Drawing.Size(91, 23);
            this.btnCerrar.TabIndex = 2;
            this.btnCerrar.Text = "Cerrar";
            this.btnCerrar.UseVisualStyleBackColor = false;
            this.btnCerrar.Click += new System.EventHandler(this.btnCerrar_Clic);
            // 
            // btnDetener
            // 
            this.btnDetener.BackColor = System.Drawing.SystemColors.InactiveCaption;
            this.btnDetener.Location = new System.Drawing.Point(456, 138);
            this.btnDetener.Name = "btnDetener";
            this.btnDetener.Size = new System.Drawing.Size(91, 23);
            this.btnDetener.TabIndex = 3;
            this.btnDetener.Text = "Detener";
            this.btnDetener.UseVisualStyleBackColor = false;
            this.btnDetener.Click += new System.EventHandler(this.btnDetener_Clic);
            // 
            // PelotaView
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(566, 296);
            this.Controls.Add(this.btnDetener);
            this.Controls.Add(this.btnCerrar);
            this.Controls.Add(this.btnComenzar);
            this.Controls.Add(this.Marco);
            this.Name = "PelotaView";
            this.Text = "Hilos Video 169 - GRUPO 01";
            this.ResumeLayout(false);

        }

        #endregion
        private Panel Marco;
        private Button btnComenzar;
        private Button btnDetener;
        private Button btnCerrar;
    }
}