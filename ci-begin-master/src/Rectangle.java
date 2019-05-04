public class Rectangle {
    Vector2D rectanglePosition;
    double x, y;
    int height, width;
    
    public Rectangle(double x, double y, int width, int height) {
        this(new Vector2D(x, y), width, height);
    }

    public Rectangle(Vector2D rectanglePosition, int width, int height) {
        this.rectanglePosition = rectanglePosition;
        this.width = width;
        this.height = height;
    }

    public boolean intersects (Rectangle other) {

        Rectangle rec = new Rectangle(rectanglePosition,width,height);

        if (rec.rectanglePosition.x <= other.rectanglePosition.x && other.rectanglePosition.x <= rec.rectanglePosition.x+ rec.width &&
                rec.rectanglePosition.y <= other.rectanglePosition.y && other.rectanglePosition.y <= rec.rectanglePosition.y + rec.height) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Rectangle rec1 = new Rectangle(30,35,20,20);
        Rectangle rec2 = new Rectangle(40,40,5,5);
        Rectangle rec3 = new Rectangle(10,10,5,5);

        System.out.println(rec1.intersects(rec2));
        System.out.println(rec1.intersects(rec3));
        System.out.println(rec2.intersects(rec3));
    }
}
