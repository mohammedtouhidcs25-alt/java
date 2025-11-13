abstract class Shape{
    int a,b;
    abstract void printArea();
}
class Rectangle extends Shape{
    Rectangle (int x, int y){
        a = x;
        b = y;
    }
        void printArea(){
            System.out.println("Area of rectangle:"+(a*b));
        }
}
class Triangle extends Shape{
    Triangle(int x,int y){
        a = x;
        b = y;
    }
    void printArea(){
        System.out.println("Area of Triangle:"+(0.5*a*b));
    }
}
class Circle extends Shape{
    Circle(int r){
        a = r;
    }
    void printArea(){
        System.out.println("Area of Circle:"+(3.14*a*a));
    }
}
public class ShapeDemo{                        
    public static void main(String args[]){
        Rectangle r = new Rectangle(10, 5);
        Triangle t = new Triangle(6, 4);
        Circle c = new Circle(3);

        r.printArea();
        t.printArea();
        c.printArea();
    }
}
    

