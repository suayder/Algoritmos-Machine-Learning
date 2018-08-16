import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Read training dataset
        Scanner scan;
        File file = new File("dataset1.txt");
        ArrayList<ArrayList<Double>> trainingData = new ArrayList<ArrayList<Double>> ();
        ArrayList<Integer> classes = new ArrayList<Integer>();
        try{
            scan = new Scanner(file);
            while (scan.hasNextLine()){
                String line = scan.nextLine();
                String[] resul = line.split(" ");
                ArrayList<Double> temp = new ArrayList<Double>();
                int i;
                for (i = 0; i<resul.length-i;i++) {
                    temp.add(Double.parseDouble(resul[i]));
                }
                trainingData.add(temp);
                classes.add(Integer.parseInt(resul[i]));
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }

        //Read testing dataset

        Scanner tests;
        File testfile = new File("testingDataset1.txt");
        ArrayList<ArrayList<Double>> testingData = new ArrayList<ArrayList<Double>> ();
        try{
            scan = new Scanner(testfile);
            while (scan.hasNextLine()){
                String line = scan.nextLine();
                String[] resul = line.split(" ");
                ArrayList<Double> temp = new ArrayList<Double>();
                for (int i = 0; i<resul.length;i++) {
                    temp.add(Double.parseDouble(resul[i]));
                }
                testingData.add(temp);
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }

        for(int i = 0; i<trainingData.size();i++){
            for (int j = 0; j<trainingData.get(i).size();j++){
                System.out.print(trainingData.get(i).get(j)+" ");
            }
            System.out.println(classes.get(i));
        }

        //KNN

        System.out.print("\nK: ");
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        for(ArrayList<Double> ar:testingData){
            ArrayList<Double> result = new ArrayList<Double>();

            for(int  l = 0; l<trainingData.size();l++){
                Double sum = 0.0;
                for (Double j : ar) {
                    sum += Math.pow((j-trainingData.get(l).get(ar.indexOf(j))),2);
                }
                result.add(Math.sqrt(sum));
            }
            ArrayList<Double> copy_result = new ArrayList<Double>(result);
            Collections.sort(copy_result);

            Map<Integer, Integer> count_neighbors = new HashMap<Integer, Integer>();
            for (Integer it:classes){
                count_neighbors.put(it,0);
            }

            for (int i = 0; i<k;i++){
                Integer classe = classes.get(result.indexOf(copy_result.get(i)));
                count_neighbors.put(classe, count_neighbors.get(classe)+1);
            }
            Integer larger = 0;
            for (Map.Entry<Integer, Integer> pair : count_neighbors.entrySet()) {
                if(pair.getValue() > count_neighbors.get(larger)){
                    larger = pair.getKey();
                }
            }
            System.out.println("Classe: "+larger);
            System.out.println(count_neighbors);
        }

    }
}
