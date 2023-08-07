using HilosVideo171_Dotnet_Grupo1.ec.edu.monster.controlador;
using HilosVideo171_Dotnet_Grupo1.ec.edu.monster.modelo;
using System.Threading;
// See https://aka.ms/new-console-template for more information


Hilo hiloEjecucion1 = new Hilo();
Hilo hiloEjecucion2 = new Hilo();

HiloControlador hiloControlador = new HiloControlador(hiloEjecucion1, hiloEjecucion2);

var hilo1 = new Thread(new ThreadStart(hiloControlador.MostrarHiloEjecucion1));
var hilo2 = new Thread(new ThreadStart(hiloControlador.MostrarHiloEjecucion2));

hilo1.Start();
hilo1.Join();

hilo2.Start();
hilo2.Join();

Console.WriteLine("Terminadas las tareas");
