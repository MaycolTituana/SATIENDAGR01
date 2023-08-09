using DOTNET169_GR01.ec.edu.monster.modelo;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DOTNET169_GR01.ec.edu.monster.controlador
{
    internal class PelotaControlador
    {
        public static void GenerarPelota(Graphics p, PelotaModelo pelota, Color color)
        {
            SolidBrush relleno = new SolidBrush(color);
            p.FillEllipse(relleno, pelota.X, pelota.Y, PelotaModelo.TAMX, PelotaModelo.TAMY);
        }

        public static void MoverPelota(Panel limites, PelotaModelo pelota)
        {
            pelota.X += pelota.Dx;
            pelota.Y += pelota.Dy;

            if (pelota.X < 0)
            {
                pelota.X = 0;
                pelota.Dx = -pelota.Dx;
            }

            if (pelota.X + PelotaModelo.TAMX >= limites.Width)
            {
                pelota.X = limites.Width - PelotaModelo.TAMX;
                pelota.Dx = -pelota.Dx;
            }

            if (pelota.Y < 0)
            {
                pelota.Y = 0;
                pelota.Dy = -pelota.Dy;
            }

            if (pelota.Y + PelotaModelo.TAMY >= limites.Height)
            {
                pelota.Y = limites.Height - PelotaModelo.TAMY;
                pelota.Dy = -pelota.Dy;
            }
        }
    }
}
