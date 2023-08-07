using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HilosVideo171_Dotnet_Grupo1.ec.edu.monster.modelo
{
    internal class Hilo
    {
        private Thread hilo1;
        private Thread hilo2;

        public Hilo()
        { }

        public Thread getHilo1()
        {
            return hilo1;
        }

        public Thread getHilo2()
        {
            return hilo2;
        }

        public void setHilo1(Thread hilo)
        {
            this.hilo1 = hilo;
        }

        public void setHilo2(Thread hilo)
        {
            this.hilo2 = hilo;
        }
    }
}
