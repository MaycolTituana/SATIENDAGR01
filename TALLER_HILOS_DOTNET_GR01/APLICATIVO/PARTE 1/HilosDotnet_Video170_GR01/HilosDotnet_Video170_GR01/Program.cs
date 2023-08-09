using HilosDotnet_Video170_GR01.ec.edu.monster.controlador;
using HilosDotnet_Video170_GR01.ec.edu.monster.vista;
using System;
using System.Windows.Forms;

namespace HilosDotnet_Video170_GR01
{
    static class Program
    {
        /// <summary>
        /// Punto de entrada principal para la aplicación.
        /// </summary>
        [STAThread]
        static void Main()
        {
            try
            {
                MarcoRebote vista = new MarcoRebote();
                PelotaHilos controlador = new PelotaHilos(vista);
                controlador.IniciarVista();
                Application.Run();
            }
            catch (Exception ex)
            {
                System.Diagnostics.Debug.WriteLine(ex.Message);
            }
        }
    }
}
