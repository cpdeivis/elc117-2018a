public class Principal{
    public static void main(String[] args) {
        Point[] vetor = new Point[5];
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = new Point();
        }
        for (int i = 0; i < (vetor.length - 1); i++) {
            for (int j = i+1; j < vetor.length; j++) {
              System.out.println("Distância P"+ i + " to P"+ j +": " + vetor[i].Pitagoras(vetor[j]));
            }
        }
    }
}
