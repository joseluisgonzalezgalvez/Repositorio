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
        double x=0;
        public string parametros="";
        int contadortotal = 0;
        int contadoraceptados = 0;
        int n = 0, top = 5;
        double[] numeros = new double[34];
        int numclase = 0;
        BackpropagationNetwork red;
        TrainingSet datos;
        int[] clase = { 1, 2, 3, 4 };
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
            declaraciones(1);
            panel1.Visible = false;
            panel2.Visible = false;
            barra();
            cargar();
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
            LinearLayer entrada = new LinearLayer(34);
            LogarithmLayer oculta = new LogarithmLayer(15);
            //NeuronDotNet.Core.Backpropagation. 
            LogarithmLayer salida = new LogarithmLayer(4);
            new BackpropagationConnector(entrada, oculta);
            new BackpropagationConnector(oculta, salida);
            red = new BackpropagationNetwork(entrada, salida);
            red.SetLearningRate(0.3);
            datos = new TrainingSet(34, 4);
        }
        public void Sine()
        {
            LinearLayer entrada = new LinearLayer(34);
            SineLayer oculta = new SineLayer(18);
            //NeuronDotNet.Core.Backpropagation. 
            SineLayer salida = new SineLayer(4);
            new BackpropagationConnector(entrada, oculta);
            new BackpropagationConnector(oculta, salida);
            red = new BackpropagationNetwork(entrada, salida);
            red.SetLearningRate(0.3);
            datos = new TrainingSet(34, 4);
        }
        public void Sigmoidal() {
            LinearLayer entrada = new LinearLayer(34);
            SigmoidLayer oculta = new SigmoidLayer(15);
            //NeuronDotNet.Core.Backpropagation. 
            SigmoidLayer salida = new SigmoidLayer(4);
            new BackpropagationConnector(entrada, oculta);
            new BackpropagationConnector(oculta, salida);
            red = new BackpropagationNetwork(entrada, salida);
            red.SetLearningRate(0.3);
            datos = new TrainingSet(34, 4);                               
        }
        public void Tangensial()
        {
            LinearLayer entrada = new LinearLayer(34);
            TanhLayer oculta = new TanhLayer(24);            
            TanhLayer salida = new TanhLayer(4);
            new BackpropagationConnector(entrada, oculta);
            new BackpropagationConnector(oculta, salida);
            red = new BackpropagationNetwork(entrada, salida);
            red.SetLearningRate(0.3);
            datos = new TrainingSet(34, 4);
        }
        public void Lineal()
        {
            LinearLayer entrada = new LinearLayer(34);
            LinearLayer oculta = new LinearLayer(20);
            LinearLayer salida = new LinearLayer(4);
            new BackpropagationConnector(entrada, oculta);
            new BackpropagationConnector(oculta, salida);
            red = new BackpropagationNetwork(entrada, salida);
            red.SetLearningRate(0.3);
            datos = new TrainingSet(34, 4);
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
        }
        private void abrirToolStripMenuItem_Click(object sender, EventArgs e)
        {
            panel1.Visible = true;
            panel2.Visible = false;
            visualizar();
            elepruebas.Items.Clear();
            //contadoraceptados = 0;
            //contadortotal = 0;
            abrirarchivo();
            //x = contadoraceptados * 100 / contadortotal;
            //MessageBox.Show("Porcentaje de efectividad de la red es de: " + x + "% Sigmoidal");
        }
        public void cargarpruebas()
        {
            String fileName = "C:/ACDI/test.txt";            
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
                    //micadena = (reader.ReadLine().ToString()).TrimEnd();

                    //MessageBox.Show("Mi cadena leida: "+micadena);
                    int tamanio = micadena.Length;
                    sub = " ";
                    double[] nums = new double[34];
                    string elem = "";
                    for (int i = 0; i < micadena.Length; i++)
                    {
                        if (micadena[i] != ',')
                        {
                            sub = sub + micadena[i].ToString();
                        }
                        if (micadena[i] == ',')
                        {
                            nums[con] = Double.Parse(sub.ToString());
                            //txtclase.Text = clase[ind].ToString();
                            //elem = elem + nums[con].ToString();
                            con++;
                        }
                        if (con == 34)
                        {
                            double[] resp = red.Run(numeros);
                            txtclases.Text = "C1=" + resp[0].ToString() + "   C2=" + resp[1].ToString() + "   C3=" + resp[2].ToString() + "   C4=" + resp[3].ToString();

                            double max = 0;
                            int ind = 0;
                            for (int m = 0; m < 3; m++)
                                if (resp[m] > max)
                                {
                                    max = resp[m];
                                    ind = m;
                                }
                            //MessageBox.Show("Clase definida: " + max);
                            if (clase[ind].ToString() == micadena[68].ToString())
                            {
                                contadoraceptados++;
                            }
                            contadortotal++;
                            con = 0;
                        }
                    }
                    //MessageBox.Show("Total de pruebas: " + contadortotal + " Total de aceptados correctos!!: " + contadoraceptados);                  
                }
                reader.Close();
                micadena = "";
            }
            catch {
                MessageBox.Show("Base de pruebas no encontrada!");
            }
                        
        }
        public void abrirarchivo() {
            String fileName = "C:/DIABETES/basededatos.txt";
            string[] subcadena = new string[6];
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
                    micadena = (reader.ReadLine().ToString()).TrimEnd();
                    int tamanio = micadena.Length;
                    MessageBox.Show("dentro del archivo: "+micadena);
                    sub = " ";
                    double[] nums = new double[8];
                    string elem = "";
                    for (int i = 0; i < micadena.Length; i++)
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
                            /*if (con == 8)
                            {
                                basededatos.Items.Add(elem + " = " + micadena[68].ToString());
                                //string nm = micadena[68].ToString();
                                 // Esto estaba con con dirección 16 bueno ubicación de la cadena
                                //string otro = micadena[68].ToString();
                                if (Int16.Parse(micadena[68].ToString()) == 1)
                                    datos.Add(new TrainingSample(nums, new double[] { 1d, 0d, 0d, 0d }));
                                if (Int16.Parse(micadena[68].ToString()) == 2)
                                    datos.Add(new TrainingSample(nums, new double[] { 0d, 1d, 0d, 0d }));
                                if (Int16.Parse(micadena[68].ToString()) == 3)
                                    datos.Add(new TrainingSample(nums, new double[] { 0d, 0d, 1d, 0d }));
                                if (Int16.Parse(micadena[68].ToString()) == 4)
                                    datos.Add(new TrainingSample(nums, new double[] { 0d, 0d, 0d, 1d }));
                                con = 0;
                                break;
                            }*/
                            sub = "";
                        }
                    }
                }
                reader.Close();
                //cargarpruebas();
            }
            catch {
                MessageBox.Show("Base de datos no encontrada!");
            }
        }
        private void sigmoidalToolStripMenuItem_Click(object sender, EventArgs e)
        {
            declaraciones(1);
           
        }
        public void numerodeclase()
        {
            double[] resp = red.Run(numeros);
            txtclases.Text = "C1=" + resp[0].ToString() + "   C2=" + resp[1].ToString() + "   C3=" + resp[2].ToString() + "   C4=" + resp[3].ToString();
            contadortotal++;
            double max = 0;
            int ind = 0;
            for (int m = 0; m < 3; m++)
                if (resp[m] > max)
                {
                    max = resp[m];
                    ind = m;
                }

            if (numclase == Int16.Parse(txtclase.Text.ToString()))
            {
                MessageBox.Show("Tipo de clase es correcta: " + numclase);
                contadoraceptados++;
            }
            else
            {
                MessageBox.Show("Tipo de clase no es correcta: " + numclase);
            }
        }
        private void btnprobar_Click(object sender, EventArgs e)
        {
            pBar.Value = 0;            
             
            double[] resp = red.Run(numeros);
            txtclases.Text = "C1=" + resp[0].ToString() + "   C2=" + resp[1].ToString() + "   C3=" + resp[2].ToString() + "   C4=" + resp[3].ToString();

            double max = 0;
            int ind = 0;
            for (int m = 0; m < 3; m++)
                if (resp[m] > max)
                {
                    max = resp[m];
                    ind = m;
                }
            txtclase.Text = clase[ind].ToString();
            //MessageBox.Show("Tamaño de la cadena de los datos leidos: " + (micadena.ToString()).Length);
            //MessageBox.Show("La cadena para probar es: " + micadena.ToString());
            for (int i = 1; i <= 100; i++)
            {
                pBar.Value = i;
            }

            if (numclase == Int16.Parse(txtclase.Text.ToString()))
            {
                MessageBox.Show("Tipo de clase es correcta: " + numclase);
                //agregararchivo(parametros);
                //agregarbasededatos(parametros);
                //basededatos.Items.Clear();
                //abrirarchivo();
                //elepruebas.Items.Clear();
                //cargarpruebas();
            }
            else
            {
                MessageBox.Show("Tipo de clase no es correcta: " + numclase);
            }
            //agregararchivo(parametros);
        }
        public void resultadoentrenamiento(string micadena)
        {
            string sub = "";
            string elem = "";
            //double[] nums = new double[4];
            try
            {
                numclase = Int16.Parse(micadena[68].ToString());
                elem = "";
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
            }
            catch { }
            txtclases.Text = elem;
        }
        private void elepruebas_SelectedIndexChanged(object sender, EventArgs e)
        {
            parametros = elepruebas.SelectedItem.ToString();
            txtclases.Text = elepruebas.SelectedItem.ToString();
            resultadoentrenamiento(parametros);
            txtclase.Text = "";
        }
        public void agregararchivo(string parametros)
        {
            FileStream stream = new FileStream(@"C:/ACDI/temp.txt", FileMode.Append, FileAccess.Write);
            using (StreamWriter fileWrite = new StreamWriter(stream))
            {
                FileStream streamread = new FileStream(@"C:/ACDI/test.txt", FileMode.Open, FileAccess.Read);
                using (StreamReader fielRead = new StreamReader(streamread)) 
                {
                    String line;
        
                    while ((line = fielRead.ReadLine()) != null) 
                    {                        
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
            File.Delete(@"C:/ACDI/test.txt");
            File.Move(@"C:/ACDI/temp.txt", "C:/ACDI/test.txt");
        }
        public void agregarbasededatos(string parametros)
        {
            FileStream stream = new FileStream(@"C:/ACDI/train.txt", FileMode.Append, FileAccess.Write);
            using (StreamWriter fileWrite = new StreamWriter(stream))
            {
                //FileStream streamread = new FileStream(@"C:/ARCHIVOSARFF/SE-ORDINARIO/prueba.txt", FileMode.Open, FileAccess.Read);
                //using (StreamReader fielRead = new StreamReader(streamread))
                //{
                    //String line;

                    //while ((line = fielRead.ReadLine()) != null)
                    //{
                        //string[] datos = line.Split(new char[] {'\n'});
                        //if (line != parametros.ToString())
                        //{
                            fileWrite.WriteLine(parametros.ToString());
                        //}

                    //}
                    //fielRead.Close();
               //}
                fileWrite.Close();
            }
            //aqui se renombrea el archivo temporal 
            //File.Delete(@"C:/ARCHIVOSARFF/SE-ORDINARIO/pruebas.txt");
            //File.Move(@"C:/ARCHIVOSARFF/SE-ORDINARIO/temp.txt", "C:/ARCHIVOSARFF/SE-ORDINARIO/pruebas.txt");
        }
        private void entrenarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            pBar.Value = 0;
            for (int i = 1; i <= 30; i++)
            {
                pBar.Value = i;
            }
            red.Learn(datos, 30000);
            for (int i = 31; i <= 100; i++)
            {
                pBar.Value = i;
            }
            MessageBox.Show("Red entrenada!");

        }
        public void cargar() 
        {
            try
            {
                Stream stream = File.Open(@"C:\ARCHIVOSARFF\SE\red.ndn", FileMode.Open);
                IFormatter formatter = new BinaryFormatter();
                red = (NeuronDotNet.Core.Backpropagation.BackpropagationNetwork)formatter.Deserialize(stream);
                stream = File.Open(@"C:\ARCHIVOSARFF\SE\data.ndn", FileMode.Open);
                formatter = new BinaryFormatter();
                datos = (TrainingSet)formatter.Deserialize(stream);
            }
            catch (Exception)
            {
                MessageBox.Show("Error al cargar la red neuronal", "Error Crítico", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }
        private void cargarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            cargar();
        }
        private void guardarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            try
            {
                Stream stream = File.Open(@"C:\ARCHIVOSARFF\SE\red.ndn", FileMode.Create);
                IFormatter formatter = new BinaryFormatter();
                formatter.Serialize(stream, red);
                stream = File.Open(@"C:\ARCHIVOSARFF\SE\data.ndn", FileMode.Create);
                formatter = new BinaryFormatter();
                formatter.Serialize(stream, datos);
            }
            catch (Exception)
            {
                MessageBox.Show("Error al guardar la red", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }
        private void panel2_Paint(object sender, PaintEventArgs e)
        {

        }
        private void button1_Click(object sender, EventArgs e)
        {
            MessageBox.Show("La longitud del pétalo es: "+numericUpDown1.Value);

            /*logsep = (Double)numericUpDown1.Value;
            anchsep = (Double)numericUpDown2.Value;
            logpet = (Double)numericUpDown3.Value;
            ancpet = (Double)numericUpDown4.Value;
            //MessageBox.Show("" + txtlogsep.Text + "," + txtanchsep.Text + "," + txtlogpet.Text + "," + txtancpet.Text + "");
            numeros[0] = logsep;
            numeros[1] = anchsep;
            numeros[2] = logpet;
            numeros[3] = ancpet;*/
            

            pBar.Value = 0;

            identicarclases();
            for (int i = 1; i <= 100; i++)
            {
                pBar.Value = i;
            }

            //MessageBox.Show("Red entrenada!");
        }
        public void identicarclases()
        {
            MessageBox.Show("" + numeros[0] + "," + numeros[1] + "," + numeros[2] + "," + numeros[3] + "");
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
        private void txtclase_TextChanged(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }
      
    }
}
