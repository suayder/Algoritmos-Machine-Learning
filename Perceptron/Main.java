public class Main {

    public static void main(String[] args) {
        //Porta AND
        int X[][] = {{1,0,0,0},
                    {1,0,1,0},
                    {1,1,0,0},
                    {1,1,1,1}};

        double W[] = {0.0,0.0,0.0};

        Perceptron perceptron = new Perceptron(X,W);
        System.out.println("Para os pesos: [0.0,0.0,0.0]");
        perceptron.classifyDataSet();

        W[0] = -1.0;
        W[1] = 1.0;
        W[2] = 0.5;

        System.out.println("\n\nPara os pesos: [-1, 1, 0.5]");
        perceptron.classifyDataSet(W);

        W[0] = 1.0;
        W[1] = -1.0;
        W[2] = 0.5;

        System.out.println("\n\nPara os pesos: [1,-1,0.5]");
        perceptron.classifyDataSet();

    }
}
