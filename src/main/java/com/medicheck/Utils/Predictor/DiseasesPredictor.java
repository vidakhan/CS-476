package com.medicheck.Utils.Predictor;

import weka.classifiers.trees.J48;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.CSVLoader;

import java.io.InputStream;
import java.util.*;

public class DiseasesPredictor {

    private static J48 tree;
    private static Instance instance;

    private static Instances trainData;


    public static List<String> symptomsList = new LinkedList<>();

    public static void initialize()
    {
        if(tree==null)
        {
            InputStream inputStream = DiseasesPredictor.class.getClassLoader().getResourceAsStream("assets/Training.csv");
            if (inputStream == null) {
                System.out.println("Training.csv not found in assets directory!");
                return;
            }

            try {
                // Load dataset
                CSVLoader loader = new CSVLoader();
                loader.setSource(inputStream);
                trainData = loader.getDataSet();

                // Get the number of attributes (columns)
                int numAttributes = trainData.numAttributes();

                // Iterate and print column names
                for (int i = 0; i < numAttributes-1; i++) {
                    symptomsList.add(trainData.attribute(i).name().trim());
                }

                // Remove unnecessary column (if any)
                if (trainData.attribute("Unnamed: 133") != null) {
                    trainData.deleteAttributeAt(trainData.attribute("Unnamed: 133").index());
                }

                // Set class index (last column is the target)
                trainData.setClassIndex(trainData.numAttributes() - 1);

                // Train Decision Tree model
                tree = new J48();
                tree.buildClassifier(trainData);

//                instance = new DenseInstance(data.numAttributes());
//                instance.setDataset(data);
//
//                Enumeration<Attribute> dataAttributes = data.enumerateAttributes();
////                for(Attribute i:dataAttributes)
//                dataAttributes.


            }catch (Exception es)
            {
                es.printStackTrace();
            }
        }

    }



    public static PredictionResultModel predict(HashSet<String> symptoms)
    {
        if (tree == null || trainData == null) {
            System.out.println("Model not initialized!");
            return null;
        }

        try {
            Instance instance = new DenseInstance(trainData.numAttributes());
            instance.setDataset(trainData);

            for (int i = 0; i < trainData.numAttributes() - 1; i++) {
                instance.setValue(i, symptoms.contains(trainData.attribute(i).name().trim()) ? 1 : 0);
            }

            double resultIndex = tree.classifyInstance(instance);
            String predictedDisease = trainData.classAttribute().value((int) resultIndex);

            double[] distribution = tree.distributionForInstance(instance);
            double confidence = distribution[(int) resultIndex] * 100;

            return new PredictionResultModel(predictedDisease, confidence);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    public static void main(String[] args)
    {
        DiseasesPredictor.initialize();
        PredictionResultModel res = DiseasesPredictor.predict(new HashSet<>(List.of("chills", "high_fever", "muscle_pain")));
        System.out.println(res);
        System.out.println(getMedication(res));
    }


    public static String getMedication(PredictionResultModel result) {

        InputStream inputStream = DiseasesPredictor.class.getClassLoader().getResourceAsStream("assets/medical data.csv");
        if (inputStream == null) {
            System.out.println("mdedical data.csv not found in assets directory!");
            return null;
        }

        try {

            // Load dataset
            CSVLoader loader = new CSVLoader();
            loader.setSource(inputStream);


            // Get dataset
            Instances data = loader.getDataSet();

            // Identify column indexes
            int diseaseIndex = data.attribute("Disease").index();
            int medicationIndex = data.attribute("Medicine").index();
            int causesIndex = data.attribute("Causes").index();

            HashSet<String> causes = new HashSet<>();
            HashSet<String> medications = new HashSet<>();

            // Iterate over instances
            for (int i = 0; i < data.numInstances(); i++) {
                Instance instance = data.instance(i);
                String disease = instance.stringValue(diseaseIndex);
                if(disease.toLowerCase().contains(result.getDisease().toLowerCase().trim()))
                {
                    String cause = instance.stringValue(causesIndex);
                    String medication = instance.stringValue(medicationIndex);

                    causes.add(cause);
                    medications.add(medication);
                } /*else
                    System.out.println(disease +" doesnt contain "+result.getDisease());*/

            }

//            String[] causesArray = causes.toArray(new String[0]);

            // Convert HashSet to Array
            String[] causesArray = causes.toArray(new String[0]);
            String[] medicationsArray = medications.toArray(new String[0]);

//            StringBuilder causesTxt = new StringBuilder();
//            for(int m=0;m<causes.size();m++)
//                causesTxt.append(causesArray[m]).append(m + 1 >= causes.size() ? "" : (m == causes.size() - 2 ? " and " : ","));


            // Construct output strings
            String causesTxt = formatList(causesArray);
            String medicationsTxt = formatList(medicationsArray);

            return "Precautions : "+getPrecaution(result)+" \nCaused By : "+causesTxt+". \n Treated by : "+medicationsTxt;
        }catch (Exception es)
        {
            es.printStackTrace();
        }

        return "Seek Medical Attention";
    }


    public static String getPrecaution(PredictionResultModel result) {

        InputStream inputStream = DiseasesPredictor.class.getClassLoader().getResourceAsStream("assets/Disease precaution.csv");
        if (inputStream == null) {
            System.out.println("Disease precaution.csv not found in assets directory!");
            return null;
        }

        try {

            // Load dataset
            CSVLoader loader = new CSVLoader();
            loader.setSource(inputStream);


            // Get dataset
            Instances data = loader.getDataSet();


            HashSet<String> causes = new HashSet<>();
            HashSet<String> medications = new HashSet<>();

            // Iterate over instances
            for (int i = 0; i < data.numInstances(); i++) {
                Instance instance = data.instance(i);
                if (instance.stringValue(0).toLowerCase().contains(result.getDisease().toLowerCase().trim())) {
                    return instance.stringValue(1) + "," + instance.stringValue(2) + "," + instance.stringValue(3) + " and " + instance.stringValue(4) + ".";
                }
            }
        }catch (Exception es)
        {
            es.printStackTrace();
        }

        return "Seek Medical Attention";
    }


    // Helper method to format lists with commas and "and"
    private static String formatList(String[] array) {
        StringBuilder formattedTxt = new StringBuilder();
        for (int m = 0; m < array.length; m++) {
            formattedTxt.append(array[m]);
            if (m < array.length - 2) {
                formattedTxt.append(", "); // Comma for multiple items
            } else if (m == array.length - 2) {
                formattedTxt.append(" and "); // "and" before the last item
            }
        }
        return formattedTxt.toString();
    }
}
