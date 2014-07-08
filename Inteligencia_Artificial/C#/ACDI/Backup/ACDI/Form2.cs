using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using NeuronDotNet.Core.Backpropagation;
using NeuronDotNet.Core;
using System.IO;

namespace ACDI
{
    public partial class Form2 : Form
    {
        int n = 0, top = 5;
        double[] numeros = new double[4];
        BackpropagationNetwork red;
        TrainingSet datos;
        int[] clase = { 1, 2, 3, 4};
        public Form2()
        {
            InitializeComponent();
            LinearLayer entrada = new LinearLayer(34);
            SigmoidLayer oculta = new SigmoidLayer(3);
            SigmoidLayer salida = new SigmoidLayer(4);
            new BackpropagationConnector(entrada, oculta);
            new BackpropagationConnector(oculta, salida);
            red = new BackpropagationNetwork(entrada, salida);
            red.SetLearningRate(0.3);
            datos = new TrainingSet(34,4);

            cargardatos();
        }
        public void cargardatos()
        {
            String fileName = "C:/ARCHIVOSARFF/SE/se-datos-entrenamiento.txt";
            string[] subcadena = new string[3];
            string sub = "";
            //string lin = "";
            int con = 0;
            FileStream stream = new FileStream(fileName, FileMode.Open, FileAccess.Read);
            StreamReader reader = new StreamReader(stream);
            while (reader.Peek() > -1)
            {
                //int tamanio = (reader.ReadLine().ToString()).TrimEnd().Length;
                string micadena = (reader.ReadLine().ToString()).TrimEnd();
                int tamanio = micadena.Length;
                sub = " ";
                double[] nums = new double[34];
                //DataBase.Items.Add(micadena.ToString().Length);
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
                        if (con == 34)
                        {
                            DataBase.Items.Add(elem + " = " + micadena[68].ToString());
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
                        }
                        sub = "";
                    }
                }
            }
            reader.Close();
            //cargardepruebas();
        }
        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            //Aprendizaje de la red
            red.Learn(datos, 1000);
        }

        private void Form2_Load(object sender, EventArgs e)
        {

        }
    }
}
