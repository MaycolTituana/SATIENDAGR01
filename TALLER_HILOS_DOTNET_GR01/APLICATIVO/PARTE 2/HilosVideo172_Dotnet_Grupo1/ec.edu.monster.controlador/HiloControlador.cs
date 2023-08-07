using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HilosVideo172_Dotnet_Grupo1.ec.edu.monster.controlador
{
    internal class HiloControlador
    {
        private Thread hilo1;
        private Thread hilo2;

        public void IniciarEjecucion()
        {
            Thread t1 = new Thread(MostrarHiloEjecucion1);

            ThreadStart threadSt = new ThreadStart(MostrarHiloEjecucion2);

            Thread t2 = new Thread(threadSt);

            this.hilo1 = t1;
            this.hilo2 = t2;

            this.hilo1.Start();

            this.hilo2.Start();

            Console.WriteLine("TAREAS COMPLETADAS");
        }
        public HiloControlador()
        {
        }
        public void MostrarHiloEjecucion1()
        {
            hilo2.Join();
            for (int i = 0; i < 15; i++)
            {
                Console.WriteLine("Ejecutando Hilo Thread ==> 1");
                Thread.Sleep(500);
            }
        }

        public void MostrarHiloEjecucion2()
        {
            for (int i = 0; i < 15; i++)
            {
                Console.WriteLine("Escribiendo Hilo Thread ==> 0");
                Thread.Sleep(500);
            }
        }
    }
}
