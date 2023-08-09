using DOTNET169_GR01.ec.edu.monster.modelo;
using DOTNET169_GR01.ec.edu.monster.vista;



namespace DOTNET169_GR01.ec.edu.monster.controlador
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
                    Thread.Sleep(10);
                    view.recargarMarco();
                }
                Console.WriteLine("the hilo has been stopped");
            }
            catch (ThreadInterruptedException)
            {
                Console.WriteLine("hilo detenido!!!");
            }
        }

        public static void Stop()
        {
            try
            {
                foreach (var thread in listaHilos.ToList())
                {
                    thread.Interrupt();
                    listaHilos.Remove(thread);
                }
            }
            catch (ThreadInterruptedException)
            {
                Console.WriteLine("hilo detenido!!!");
            }
        }
    }
}
