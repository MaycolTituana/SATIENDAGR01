using HilosDotnet_Video170_GR01.ec.edu.monster.modelo;
using HilosDotnet_Video170_GR01.ec.edu.monster.vista;
using System;
using System.Drawing;

namespace HilosDotnet_Video170_GR01.ec.edu.monster.controlador
{
    class PelotaHilos
    {
        private Pelota pelota1 = new Pelota("1", 50, 15);
        private Pelota pelota2 = new Pelota("2", 50, 115);
        private Pelota pelota3 = new Pelota("3", 50, 215);
        private MarcoRebote vista;

        public PelotaHilos(MarcoRebote vista)
        {
            this.vista = vista;
            this.vista.GetLamina().Controls.Add(this.pelota1);
            this.vista.GetLamina().Controls.Add(this.pelota2);
            this.vista.GetLamina().Controls.Add(this.pelota3);
            this.pelota1.DibujarPelota(Brushes.Green);
            this.pelota2.DibujarPelota(Brushes.Blue);
            this.pelota3.DibujarPelota(Brushes.Orange);

            // Set colors for the buttons
            this.vista.GetButton("btnHilo1").BackColor = Color.Green;
            this.vista.GetButton("btnHilo1").ForeColor = Color.White;

            this.vista.GetButton("btnHilo2").BackColor = Color.Blue;
            this.vista.GetButton("btnHilo2").ForeColor = Color.White;

            this.vista.GetButton("btnHilo3").BackColor = Color.Orange;
            this.vista.GetButton("btnHilo3").ForeColor = Color.White;

            this.vista.GetButton("btnDetener1").BackColor = Color.Green;
            this.vista.GetButton("btnDetener1").ForeColor = Color.White;

            this.vista.GetButton("btnDetener2").BackColor = Color.Blue;
            this.vista.GetButton("btnDetener2").ForeColor = Color.White;

            this.vista.GetButton("btnDetener3").BackColor = Color.Orange;
            this.vista.GetButton("btnDetener3").ForeColor = Color.White;

            this.vista.GetButton("btnHilo1").Click += delegate (object sender, EventArgs e)
            {
                this.pelota1.Play();
            };
            this.vista.GetButton("btnHilo2").Click += delegate (object sender, EventArgs e)
            {
                this.pelota2.Play();

            };
            this.vista.GetButton("btnHilo3").Click += delegate (object sender, EventArgs e)
            {
                this.pelota3.Play();
            };
            this.vista.GetButton("btnDetener1").Click += delegate (object sender, EventArgs e)
            {
                this.pelota1.Pause();
            };
            this.vista.GetButton("btnDetener2").Click += delegate (object sender, EventArgs e)
            {
                this.pelota2.Pause();

            };
            this.vista.GetButton("btnDetener3").Click += delegate (object sender, EventArgs e)
            {
                this.pelota3.Pause();
            };
        }
        public void IniciarVista()
        {
            this.vista.run();
        }

    }
}
