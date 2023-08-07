using HilosVideo172_Dotnet_Grupo1.ec.edu.monster.controlador;
using HilosVideo172_Dotnet_Grupo1.ec.edu.monster.modelo;
using System.Threading;
// See https://aka.ms/new-console-template for more information

Hilo hiloEjecucion1 = new Hilo();
Hilo hiloEjecucion2 = new Hilo();

HiloControlador hiloControlador = new HiloControlador();

hiloControlador.IniciarEjecucion();

