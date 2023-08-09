using DOTNET168_GR01.ec.edu.monster.modelo;
using DOTNET168_GR01.ec.edu.monster.vista;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;


namespace DOTNET168_GR01.ec.edu.monster.controlador
{
    internal class HiloControlador
    {
        private static readonly List<Thread> listaHilos = new List<Thread>();

        public static void MovimientoPelota(PelotaVista view, Panel marco, PelotaModelo model)
        {
            try
            {
                for (int i = 0; i < 3000; i++)
                {
                    int hilo = Thread.CurrentThread.ManagedThreadId;
                    listaHilos.Add(Thread.CurrentThread);
                    PelotaControlador.MoverPelota(marco, model);
                    Thread.Sleep(2);
                    view.recargarMarco();
                }
            }
            catch (Exception)
            {
                Console.WriteLine("Thread '{0}' interrumpido.", Thread.CurrentThread.Name);
            }
        }
    }
}
