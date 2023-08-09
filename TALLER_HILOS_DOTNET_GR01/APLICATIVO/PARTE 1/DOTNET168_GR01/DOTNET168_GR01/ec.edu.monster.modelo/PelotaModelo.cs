using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DOTNET168_GR01.ec.edu.monster.modelo
{
    public class PelotaModelo
    {
        private int x = 0;
        private int y = 0;
        private int dx = 1;
        private int dy = 1;
        public const int TAMX = 15;
        public const int TAMY = 15;

        public int X
        {
            get => x;
            set => x = value;
        }
        public int Y
        {
            get => y;
            set => y = value;
        }
        public int Dx
        {
            get => dx;
            set => dx = value;
        }
        public int Dy
        {
            get => dy;
            set => dy = value;
        }
    }
}
