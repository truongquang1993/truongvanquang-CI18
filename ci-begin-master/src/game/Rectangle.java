package game;

public class Rectangle {
    Vector2D rectanglePosition;
    double x, y;
    int height, width;

    public Rectangle(){
        this(new Vector2D(0,0), 0, 0);
    }

    public Rectangle (double x, double y, int width, int height){
        this(new Vector2D(x, y), width, height);
    }

    public Rectangle (Vector2D rectanglePosition, int width, int height){
        this.rectanglePosition = rectanglePosition;
        this.width = width;
        this.height = height;
    }

    double top(){
        return this.rectanglePosition.y;
    }

    double bottom(){
        return this.top() + this.height;
    }

    double left(){
        return this.rectanglePosition.x;
    }

    double right(){
        return this.left()+ this.width;
    }


    public boolean intersects (Rectangle other){
        return this.right() >= other.left()
                && this.left() <= other.right()
                && this.bottom() >= other.top()
                && this.top() <= other.bottom();
    }
//    public game.Rectangle(double x, double y, int width, int height) {
//        this.rectanglePosition = new game.Vector2D(x, y);
//        this.width = width;
//        this.height = height;
//    }
//
//    public game.Rectangle(game.Vector2D rectanglePosition, int width, int height) {
//        this.rectanglePosition = rectanglePosition;
//        this.width = width;
//        this.height = height;
//    }
//
//    public boolean intersects (game.Rectangle other) {
//
//        game.Rectangle rec = new game.Rectangle(rectanglePosition,width,height);
//
//        if (rec.rectanglePosition.x <= other.rectanglePosition.x && other.rectanglePosition.x <= rec.rectanglePosition.x+ rec.width &&
//                rec.rectanglePosition.y <= other.rectanglePosition.y && other.rectanglePosition.y <= rec.rectanglePosition.y + rec.height) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public static void main(String[] args) {
//        game.Rectangle rec1 = new game.Rectangle(30,35,20,20);
//        game.Rectangle rec2 = new game.Rectangle(40,40,5,5);
//        game.Rectangle rec3 = new game.Rectangle(10,10,5,5);
//
//        System.out.println(rec1.intersects(rec2));
//        System.out.println(rec1.intersects(rec3));
//        System.out.println(rec2.intersects(rec3));
//    }
}
