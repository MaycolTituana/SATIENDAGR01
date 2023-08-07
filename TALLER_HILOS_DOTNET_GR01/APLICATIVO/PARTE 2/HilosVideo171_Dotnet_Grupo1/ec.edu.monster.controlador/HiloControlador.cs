using HilosVideo171_Dotnet_Grupo1.ec.edu.monster.modelo;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HilosVideo171_Dotnet_Grupo1.ec.edu.monster.controlador
{
    internal class HiloControlador
    {
        private Hilo hilo1;
        private Hilo hilo2;
        public HiloControlador(Hilo hilo1, Hilo hilo2)
        {
            this.hilo1 = hilo1;
            this.hilo2 = hilo2;
        }
        public void MostrarHiloEjecucion1()
        {
            for (int i = 0; i < 15; i++)
            {
                Console.WriteLine("Ejecutando Hilo Thread ==> 0");
                hilo1 = new Hilo();
                Thread.Sleep(500);
            }
        }

        public void MostrarHiloEjecucion2()
        {
            for (int i = 0; i < 10; i++)
            {
                Console.WriteLine("Escribiendo Hilo Thread ==> 1");
                hilo2 = new Hilo();
                Thread.Sleep(500);
            }
        }
    }
}
