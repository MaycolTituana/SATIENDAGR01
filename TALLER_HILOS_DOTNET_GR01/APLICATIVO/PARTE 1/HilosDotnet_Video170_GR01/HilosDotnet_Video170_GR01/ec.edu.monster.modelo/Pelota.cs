using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace HilosDotnet_Video170_GR01.ec.edu.monster.modelo
{
    class Pelota : PictureBox
    {
        //tamaño de mi panel 747; 356
        private int TAMX = 647;
        private int TAMY = 293;
        private int dx = 1;
        private int dy = 1;
        private int x, y = 0;
        private bool paused = false;
        private bool end = false;
        private Thread thread;
        private Graphics p;
        public Pelota(string name, int x, int y)
        {
            //this.CreateGraphics = System.Drawing.Graphics;
            this.BackColor = System.Drawing.Color.Transparent;
            this.Location = new System.Drawing.Point(x, y);
            this.Name = name;
            this.Size = new System.Drawing.Size(20, 20);
            this.ResizeRedraw = true;
            this.p = this.CreateGraphics();
            this.thread = new Thread(this.mueve_pelota);
        }
        public void DibujarPelota(Brush color)
        {
            Image bmp = new Bitmap(20, 20);
            using (Graphics g = Graphics.FromImage(bmp))
            {
                g.FillEllipse(color, 0, 0, 20, 20);
            }
            this.Image = bmp;
        }
        public void Pause()
        {
            lock (this)
            {
                this.paused = true;
            }
        }

        public void Play()
        {
            if (this.thread.ThreadState == ThreadState.Unstarted)
            {
                this.thread.IsBackground = true;
                this.thread.Start();
            }
            else
            {
                lock (this)
                {
                    this.paused = false;
                    Monitor.PulseAll(this);
                }
            }

        }

        public void End()
        {
            lock (this)
            {
                this.end = true;
                Monitor.PulseAll(this);
            }
        }
        public void mueve_pelota()
        {
            int cont = 0;

            while (true)
            {
                cont++;
                if (cont % 5 == 0) {
                    Thread.Sleep(1);
                }
                x = this.Location.X + dx;
                y = this.Location.Y + dy;
                this.Location = new System.Drawing.Point(x, y);
                
                lock (this)
                {
                    if (this.paused) Monitor.Wait(this);
                }
                if (this.Location.X > this.TAMX - 10)
                {
                    dx = -dx;
                }
                else if (this.Location.X < 10)
                {
                    dx = -dx;
                }

                if (this.Location.Y > this.TAMY - 10)
                {
                    dy = -dy;
                }
                else if (this.Location.Y < 10)
                {
                    dy = -dy;
                }
                
            }
        }

    }
}
