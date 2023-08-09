using DOTNET169_GR01.ec.edu.monster.modelo;
using DOTNET169_GR01.ec.edu.monster.controlador;
using System.Collections;
using System;


namespace DOTNET169_GR01.ec.edu.monster.vista
{
    public partial class PelotaVista : Form
    {
        private PelotaModelo model = new PelotaModelo();
        public ArrayList arregloPelotas = new ArrayList();
        private Random random = new Random();

        public void AgregarPelota(PelotaModelo pelota)
        {
            Color randomColor = Color.FromArgb(random.Next(256), random.Next(256), random.Next(256));
            arregloPelotas.Add(new Tuple<PelotaModelo, Color>(pelota, randomColor));
        }
        public PelotaVista()
        {
            InitializeComponent();
        }

        private void Dibujar_Marco(object sender, PaintEventArgs e)
        {
            foreach (Tuple<PelotaModelo, Color> tuple in arregloPelotas)
            {
                PelotaModelo p = tuple.Item1;
                Color color = tuple.Item2;
                PelotaControlador.GenerarPelota(e.Graphics, p, color);
            }
        }

        private void btnComenzar_Clic(object sender, EventArgs e)
        {
            model = new PelotaModelo();
            AgregarPelota(model);
            Task tarea = Task.Run(
                () => HiloControlador.MovimientoPelota(this, Marco, model));
        }

        private void btnDetener_Clic(object sender, EventArgs e)
        {
            HiloControlador.Stop();
        }

        private void btnCerrar_Clic(object sender, EventArgs e)
        {
            Environment.Exit(exitCode: 0);
        }

        public void recargarMarco()
        {
            if (Marco.InvokeRequired)
            {
                try
                {
                    Marco.Invoke(new Action(recargarMarco));
                }
                catch (ThreadInterruptedException)
                {
                    Console.WriteLine("Thread '{0}' awoken.", Thread.CurrentThread.Name);
                }
                return;
            }

            Marco.Refresh();
        }
    }
}
