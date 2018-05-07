public class Circle {
   //private double x;
   //private double y;
   private Point p;
   private double r;

   public Circle() {
      //x = y = r = 0.0;
      r = 0.0;
      p = new Point();
      System.out.println("New Circle");
   }
   public Circle(double x1, double y1, double r1){
      //x = x1;
      //y = y1;
      r = r1;
      p = new Point(x1, y1);
      System.out.println("New Circle");
   }

   public double area() {
      return Math.PI * r * r;
   }
   public void setRadius(double radius){
     r = radius;
   }

   public static void main(String[] args) {
      Circle c = new Circle(0, 0, 5);
      System.out.println("Area do circulo: " + c.area());
      Circle c2 = new Circle();
      c2.setRadius(5.0);
      System.out.println("Area do circulo: " + c2.area());
      System.out.println("Distância C1 to C2: " + c.p.Pitagoras(c2.p));
   }

}
