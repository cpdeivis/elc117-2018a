public class Point {
   private double x;
   private double y;
   public Point() {
     x = y = 0.0;
   }
   public Point(double x1, double y1){
     x = x1;
     y = y1;
   }
   public void setX(double x1){
     x = x1;
   }
   public void setY(double y1){
     y = y1;
   }
   public double Pitagoras(Point p){
     double dx = p.x - x;
     double dy = p.y - y;
     double distancia = Math.sqrt(dx*dx + dy*dy);
     return distancia;
   }
}
