using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.IO;
using NeuronDotNet.Core;
using NeuronDotNet.Core.Backpropagation;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters.Binary;

namespace Iris
{
    public partial class Form1 : Form
    {
        ProgressBar pBar = new ProgressBar();   
        public string parametros="";
        int n = 0, top = 5;
        double[] numeros = new double[4];
        int numclase = 0;
        BackpropagationNetwork red;
        TrainingSet datos;
        int[] clase = { 1, 2, 3 };
        string micadena = "";

        

        double minimo = 4.3;
        double maximo = 7.9;
        public double logsep = 0.0;
        public double anchsep = 0.0;
        public double logpet = 0.0;
        public double ancpet = 0.0;

        public Form1()
        {
            InitializeComponent();
            ocultar();            
            declaraciones(0);
            panel1.Visible = false;
            panel2.Visible = false;
            barra();
            
        }
        public void barra() {
            pBar.Location = new System.Drawing.Point(20, 20);
            pBar.Name = "progressBar 1";
            pBar.Width = 200;
            pBar.Height = 30;
            pBar.Dock = DockStyle.Bottom;
            pBar.Minimum = 0;
            pBar.Maximum = 100;
            Controls.Add(pBar);

            pBar.Visible = true;
        }
        public void declaraciones(int f)
        {
            switch(f){
                case 0: Lineal(); break;
                case 1: Sigmoidal(); break;
                case 2: Tangensial(); break;
                case 3: Logaritmica(); break;
                case 4: Sine(); break;
                default: Lineal(); break;
            }
        }
        public void Logaritmica()
        {
            LinearLayer entrada = new LinearLayer(4);
            LogarithmLayer oculta = new LogarithmLayer(3);
            //NeuronDotNet.Core.Backpropagation. 
            LogarithmLayer salida = new LogarithmLayer(3);
            new BackpropagationConnector(entrada, oculta);
            new BackpropagationConnector(oculta, salida);
            red = new BackpropagationNetwork(entrada, salida);
            red.SetLearningRate(0.3);
            datos = new TrainingSet(4, 3);
        }
        public void Sine()
        {
            LinearLayer entrada = new LinearLayer(4);
            SineLayer oculta = new SineLayer(3);
            //NeuronDotNet.Core.Backpropagation. 
            SineLayer salida = new SineLayer(3);
            new BackpropagationConnector(entrada, oculta);
            new BackpropagationConnector(oculta, salida);
            red = new BackpropagationNetwork(entrada, salida);
            red.SetLearningRate(0.3);
            datos = new TrainingSet(4, 3);
        }
        public void Sigmoidal() {
            LinearLayer entrada = new LinearLayer(4);
            SigmoidLayer oculta = new SigmoidLayer(3);
            //NeuronDotNet.Core.Backpropagation. 
            SigmoidLayer salida = new SigmoidLayer(3);
            new BackpropagationConnector(entrada, oculta);
            new BackpropagationConnector(oculta, salida);
            red = new BackpropagationNetwork(entrada, salida);
            red.SetLearningRate(0.3);
            datos = new TrainingSet(4, 3);                                
        }
        public void Tangensial()
        {
            LinearLayer entrada = new LinearLayer(4);
            TanhLayer oculta = new TanhLayer(3);            
            TanhLayer salida = new TanhLayer(3);
            new BackpropagationConnector(entrada, oculta);
            new BackpropagationConnector(oculta, salida);
            red = new BackpropagationNetwork(entrada, salida);
            red.SetLearningRate(0.3);
            datos = new TrainingSet(4, 3);
        }
        public void Lineal()
        {
            LinearLayer entrada = new LinearLayer(4);
            LinearLayer oculta = new LinearLayer(3);
            LinearLayer salida = new LinearLayer(3);
            new BackpropagationConnector(entrada, oculta);
            new BackpropagationConnector(oculta, salida);
            red = new BackpropagationNetwork(entrada, salida);
            red.SetLearningRate(0.3);
            datos = new TrainingSet(4, 3);
        }
        public void ocultar() {
            basededatos.Visible = false;
            elepruebas.Visible = false;
        }
        public void visualizar()
        {
            basededatos.Visible = true;
            elepruebas.Visible = true;
        }
        private void probarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            //Form2 Probar = new Form2();
            //Probar.Show();
            panel1.Visible = false;
            panel2.Visible = true;
            entrenarToolStripMenuItem.Enabled = false;
        }
        private void abrirToolStripMenuItem_Click(object sender, EventArgs e)
        {
            basededatos.Items.Clear();
            elepruebas.Items.Clear();
            panel1.Visible = true;
            panel2.Visible = false;
            visualizar();//muestra las dos listas donde se cargan los datos de la base de datos y las pruebas
            abrirarchivo();//Se cargan en la lista la base de datos 
            cargarToolStripMenuItem.Enabled = true;
            entrenarToolStripMenuItem.Enabled = true;
        }
        public void cargarpruebas()
        {
            String fileName = "C:/SE-ORDINARIO/pruebas.txt";
            string[] subcadena = new string[3];
            string sub = "";
            string lin = "";
            int con = 0;
            FileStream stream = null;
            StreamReader reader = null;
            try
            {
                stream = new FileStream(fileName, FileMode.Open, FileAccess.Read);
                reader = new StreamReader(stream);
                while (reader.Peek() > -1)
                {
                    ////int tamanio = (reader.ReadLine().ToString()).TrimEnd().Length;
                    micadena = (reader.ReadLine().ToString()).TrimEnd();
                    elepruebas.Items.Add(micadena);
                    MessageBox.Show("Funcion cargar pruebas: "+ micadena);
                    //resultadoentrenamiento(micadena);
                }
                reader.Close();
            }
            catch {
                MessageBox.Show("Base de pruebas no encontrada!");
            }                        
        }
        public void abrirarchivo() {
            String fileName = "C:/SE-ORDINARIO/basedatos.txt";
            string[] subcadena = new string[3];
            string sub = "";
            //string lin = "";
            int con = 0;
            FileStream stream = null;
            StreamReader reader = null;
            try
            {
                stream = new FileStream(fileName, FileMode.Open, FileAccess.Read);
                reader = new StreamReader(stream);
                while (reader.Peek() > -1)
                {
                    //int tamanio = (reader.ReadLine().ToString()).TrimEnd().Length;
                    micadena = (reader.ReadLine().ToString()).TrimEnd();
                    int tamanio = micadena.Length;
                    sub = " ";
                    double[] nums = new double[4];
                    string elem = "";
                    for (int i = 0, j = 0; i < micadena.Length; i++)
                    {
                        if (micadena[i] != ',')
                        {
                            sub = sub + micadena[i].ToString();
                        }
                        if (micadena[i] == ',')
                        {
                            nums[con] = Double.Parse(sub.ToString());
                            elem = elem + nums[con].ToString();
                            con++;
                            if (con == 4)
                            {
                                basededatos.Items.Add(elem + " = " + micadena[16].ToString());
                                if (Int16.Parse(micadena[16].ToString()) == 1)
                                    datos.Add(new TrainingSample(nums, new double[] { 1d, 0d, 0d }));
                                if (Int16.Parse(micadena[16].ToString()) == 2)
                                    datos.Add(new TrainingSample(nums, new double[] { 0d, 1d, 0d }));
                                if (Int16.Parse(micadena[16].ToString()) == 3)
                                    datos.Add(new TrainingSample(nums, new double[] { 0d, 0d, 1d }));
                                con = 0;
                                break;
                            }
                            sub = "";
                        }
                    }
                }
                reader.Close();
                cargarpruebas();//Se cargan los archivos del archivo donde se encuentran las pruebas
            }
            catch {
                MessageBox.Show("Base de datos no encontrada!");
            }      
        }
        private void sigmoidalToolStripMenuItem_Click(object sender, EventArgs e)
        {
            declaraciones(1);
           
        }
        public void funcionprobar() {
            MessageBox.Show("Dentro de la funcion probar: "+numeros[0] + " " + numeros[1] + " " + numeros[2] + " " + numeros[3]);
            double[] resp = red.Run(numeros);
            txtclases.Text = "C1=" + resp[0].ToString() + "   C2=" + resp[1].ToString() + "   C3=" + resp[2].ToString();
            double max = 0;
            int ind = 0;
            for (int m = 0; m < 3; m++)
                if (resp[m] > max)
                {
                    max = resp[m];
                    ind = m;
                }
            txtclase.Text = clase[ind].ToString();
            MessageBox.Show("Antes de la comparacion entre clases: "+micadena);
            if (numclase == Int16.Parse(txtclase.Text.ToString()))
            {
                MessageBox.Show("La clase coincide. Elemento agregado!");
                //agregararchivo(micadena);
                //agregarbasededatos(micadena);
                basededatos.Items.Clear();
                abrirarchivo();
                elepruebas.Items.Clear();
                cargarpruebas();
                entrenarToolStripMenuItem.Enabled = true;
                guardarToolStripMenuItem.Enabled = true;
            }
            else
            {
                MessageBox.Show("Elemento no coincide: " + micadena);
                //agregararchivoseliminados(micadena);
                MessageBox.Show("La clase no coincide. El elemento no se agregará!");
                entrenarToolStripMenuItem.Enabled = false;
            }
        }
        private void btnprobar_Click(object sender, EventArgs e)
        {
            funcionprobar();
            //agregararchivo(parametros);
        }
        public void resultadoentrenamiento(string micadena)
        {
            string sub = "";
            //double[] nums = new double[4];
            //MessageBox.Show("Cadena leida de la lista: " + (micadena.ToString()));
            //MessageBox.Show("Tamaño de la cadena leida: " + (micadena.ToString().Length));
            //MessageBox.Show("Tamaño de la cadena leida: " + (micadena[16].ToString()));
            numclase = Int16.Parse(micadena[16].ToString());
            string elem = "";
            int con = 0;
            for (int i = 0, j = 0; i < micadena.Length; i++)
            {
                if (micadena[i] != ',')
                {
                    sub = sub + micadena[i].ToString();
                }
                if (micadena[i] == ',')
                {
                    numeros[con] = Double.Parse(sub.ToString());

                    elem = elem + numeros[con].ToString();
                    con++;
                    sub = "";
                }
            }
            MessageBox.Show(numeros[0] +" "+numeros[1]+" "+ numeros[2]+" "+numeros[3]);
            funcionprobar();
            txtclases.Text = elem;
        }
        private void elepruebas_SelectedIndexChanged(object sender, EventArgs e)
        {
            int sel = elepruebas.SelectedIndex;
            MessageBox.Show("numero de item seleccionado:  "+sel);
            elepruebas.Items[sel] = System.Drawing.Color.Pink;
            parametros = elepruebas.SelectedItem.ToString();
            txtclases.Text = elepruebas.SelectedItem.ToString();
            
            //resultadoentrenamiento(parametros);
            txtclase.Text = "";
        }
        public void agregararchivo(string parametros)
        {
            FileStream stream = new FileStream(@"C:/SE-ORDINARIO/temp.txt", FileMode.Append, FileAccess.Write);
            using (StreamWriter fileWrite = new StreamWriter(stream))
            {
                FileStream streamread = new FileStream(@"C:/SE-ORDINARIO/pruebas.txt", FileMode.Open, FileAccess.Read);
                using (StreamReader fielRead = new StreamReader(streamread)) 
                {
                    String line;
        
                    while ((line = fielRead.ReadLine()) != null) 
                    {
                        //string[] datos = line.Split(new char[] {'\n'});
                        if(line != parametros.ToString())
                        {
                            fileWrite.WriteLine(line.ToString());
                        }
                    }
                    fielRead.Close();
                }
                fileWrite.Close();
            }
            //aqui se renombrea el archivo temporal 
            File.Delete(@"C:/SE-ORDINARIO/pruebas.txt");
            File.Move(@"C:/SE-ORDINARIO/temp.txt", "C:/SE-ORDINARIO/pruebas.txt");
        }
        public void agregarbasededatos(string parametros)
        {
            FileStream stream = new FileStream(@"C:/SE-ORDINARIO/basedatos.txt", FileMode.Append, FileAccess.Write);
            using (StreamWriter fileWrite = new StreamWriter(stream))
            {
                fileWrite.WriteLine(parametros.ToString());
                fileWrite.Close();
            }
        }
        public void agregararchivoseliminados(string parametros)
        {
            FileStream stream = new FileStream(@"C:/SE-ORDINARIO/pruebasrechazadas.txt", FileMode.Append, FileAccess.Write);
            using (StreamWriter fileWrite = new StreamWriter(stream))
            {
                fileWrite.WriteLine(parametros.ToString());
                fileWrite.Close();
            }
        }
        private void entrenarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            pBar.Value = 0;

            red.Learn(datos, 10000);
            for (int i = 1; i <= 100; i++)
            {
                pBar.Value = i;
            }
            MessageBox.Show("Red entrenada!");
            guardarToolStripMenuItem.Enabled = true;
            cargarToolStripMenuItem.Enabled = false;
            entrenarToolStripMenuItem.Enabled = false;

        }
        public void cargarredneuronal()
        {
            try
            {
                pBar.Value = 0;

                //C:\ARCHIVOS ARFF
                Stream stream = File.Open(@"C:\ARCHIVOSARFF\red\red.ndn", FileMode.Open);
                //Stream stream = File.Open(@"C:\ARCHIVOS ARFF\iris-datos.txt", FileMode.Open);
                IFormatter formatter = new BinaryFormatter();
                red = (NeuronDotNet.Core.Backpropagation.BackpropagationNetwork)formatter.Deserialize(stream);
                stream = File.Open(@"C:\ARCHIVOSARFF\red\data.ndn", FileMode.Open);
                //stream = File.Open(@"C:\ARCHIVOS ARFF\iris-datos-n.txt", FileMode.Open);
                formatter = new BinaryFormatter();
                datos = (TrainingSet)formatter.Deserialize(stream);                
                
                for (int i = 1; i <= 100; i++)
                {
                    pBar.Value = i;
                }
                MessageBox.Show("La red se ha cargado!");
            }
            catch (Exception)
            {
                MessageBox.Show("Error al cargar la red neuronal", "Error Crítico", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }
        public void guardarredneuronal()
        {
            try
            {
                pBar.Value = 0;

                Stream stream = File.Open(@"C:\ARCHIVOSARFF\red\red.ndn", FileMode.Create);
                IFormatter formatter = new BinaryFormatter();
                formatter.Serialize(stream, red);

                stream = File.Open(@"C:\ARCHIVOSARFF\red\data.ndn", FileMode.Create);
                formatter = new BinaryFormatter();
                formatter.Serialize(stream, datos);


                for (int i = 1; i <= 100; i++)
                {
                    pBar.Value = i;
                }
                MessageBox.Show("La red se ha guardado!");
            }
            catch (Exception)
            {
                MessageBox.Show("Error al guardar la red", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }
        private void guardarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            guardarredneuronal();
            guardarToolStripMenuItem.Enabled = false;
            cargarToolStripMenuItem.Enabled = true;
            entrenarToolStripMenuItem.Enabled = false;
            probarToolStripMenuItem.Enabled = true;
        }
        private void cargarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            cargarredneuronal();

            guardarToolStripMenuItem.Enabled = true;
            cargarToolStripMenuItem.Enabled = false;
            entrenarToolStripMenuItem.Enabled = false;
            probarToolStripMenuItem.Enabled = true;
        }
        private void panel2_Paint(object sender, PaintEventArgs e)
        {

        }
        private void button1_Click(object sender, EventArgs e)
        {
            //MessageBox.Show("La longitud del pétalo es: "+numericUpDown1.Value);

            logsep = (Double)numericUpDown1.Value;
            anchsep = (Double)numericUpDown2.Value;
            logpet = (Double)numericUpDown3.Value;
            ancpet = (Double)numericUpDown4.Value;
            //MessageBox.Show("" + txtlogsep.Text + "," + txtanchsep.Text + "," + txtlogpet.Text + "," + txtancpet.Text + "");
            numeros[0] = logsep;
            numeros[1] = anchsep;
            numeros[2] = logpet;
            numeros[3] = ancpet;
            

            pBar.Value = 0;

            
            for (int i = 1; i <= 100; i++)
            {
                pBar.Value = i;
            }
            identicarclases();
            //MessageBox.Show("Red entrenada!");
        }
        public void identicarclases()
        {
            //MessageBox.Show("" + numeros[0] + "," + numeros[1] + "," + numeros[2] + "," + numeros[3] + "");
            double[] resp = red.Run(numeros);
            //txtclases.Text = "C1=" + resp[0].ToString() + "   C2=" + resp[1].ToString() + "   C3=" + resp[2].ToString();
            //MessageBox.Show("C1=" + resp[0].ToString() + "   C2=" + resp[1].ToString() + "   C3=" + resp[2].ToString());
            double max = 0;
            int ind = 0;
            for (int m = 0; m < 3; m++)
                if (resp[m] > max)
                {
                    max = resp[m];
                    ind = m;
                }
            //MessageBox.Show(clase[ind].ToString());
            switch (clase[ind]) {
                case 1: pictureBox1.ImageLocation = "C:/IA/iris-setosa.png"; break;
                case 2: pictureBox1.ImageLocation = "C:/IA/iris-versicolor.png"; break;
                case 3: pictureBox1.ImageLocation = "C:/IA/iris-virginica.png"; break;
                default: break;
            }
            //txtclase.Text = clase[ind].ToString();
        }
        private void numericUpDown1_ValueChanged(object sender, EventArgs e)
        {

        }
        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }
        private void Form1_Load(object sender, EventArgs e)
        {
            //MessageBox.Show("La funcion elegida es: " + form3.get_funcion());
            guardarToolStripMenuItem.Enabled = false;
            cargarToolStripMenuItem.Enabled = false;
            entrenarToolStripMenuItem.Enabled = false;
            probarToolStripMenuItem.Enabled = false;
        }
        private void elepruebas_DrawItem(object sender, DrawItemEventArgs e)
        {

        }
     }
}
