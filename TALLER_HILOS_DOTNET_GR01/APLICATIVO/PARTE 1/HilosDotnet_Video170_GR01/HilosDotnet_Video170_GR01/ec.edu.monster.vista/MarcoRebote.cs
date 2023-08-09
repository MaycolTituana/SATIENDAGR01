using System;
using System.Windows.Forms;

namespace HilosDotnet_Video170_GR01.ec.edu.monster.vista
{
    public partial class MarcoRebote : Form
    {

        public MarcoRebote()
        {
            InitializeComponent();
        }

        public Panel GetLamina()
        {
            return this.panel1;
        }
        public Control GetButton(String name)
        {
            return this.Controls[name];
        }

        public void run()
        {
            this.Show();
        }

        private void MarcoRebote_Load(object sender, EventArgs e)
        {
            CheckForIllegalCrossThreadCalls = false;
        }

        private void BtnSalir_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
