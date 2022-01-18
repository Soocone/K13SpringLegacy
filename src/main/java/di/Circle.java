package di;

public class Circle {
   Point point;
   int radian;
   
   public Point getPoint() {
      return point;
   }
   
   public void setPoint(Point point) {
      this.point = point;
   }
   
   public int getRadian() {
      return radian;
   }
   
   public void setRadian(int radian) {
      this.radian = radian;
   }
   
   @Override
   public String toString() {
      return point + "반지름:" + radian;
   }
}