public class Perceptron {

    private int X[][];
    private double W[];

    public Perceptron(int[][] X, double[] W){
        this.X = X;
        this.W = W;
    }

    private double f(int[] X, double []W){
        double sum = 0;
        for (int i = 0; i<X.length-1;i++){
            sum += X[i]*W[i];
        }
        return sum;
    }

    public void classifyDataSet(){
        for (int i = 0; i < this.X.length;i++){
            double ans;
            int classe;
            ans = this.f(this.X[i], this.W);

            classe = (ans>0)?1:0;

            System.out.println("Resposta função f: "+ans+" classe: "+classe+" -> "+((classe==this.X[i][this.X.length-1])?"Acertou a classificação":"Errou a classificação"));
        }
    }
    public void classifyDataSet(double[] W){
        for (int i = 0; i < this.X.length;i++){
            double ans;
            int classe;
            ans = this.f(this.X[i], W);

            classe = (ans>0)?1:0;

            System.out.println("Resposta função f: "+ans+" classe: "+classe+" -> "+((classe==this.X[i][this.X.length-1])?"Acertou a classificação":"Errou a classificação"));
        }
    }
}
