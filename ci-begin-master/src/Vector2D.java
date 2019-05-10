import tklibs.Mathx;

public class Vector2D {
    public double x;
    public double y;
    public double rate;

    public Vector2D() {
        this(0, 0);
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void add(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void subtract(double x, double y) {
        this.x -= x;
        this.y -= y;
    }

    public void scale(double rate) {
        this.x *= rate; // this.x = this.x * rate
        this.y *= rate;
    }

    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public  void set(Vector2D other){
        this.set(other.x, other.y);
    }

    public Vector2D clone() {
        return new Vector2D(this.x, this.y);
    }

    public double getLength() {
        return Math.sqrt(x * x + y * y);
    }

    public void setLength(double length) {
        double oldLength = this.getLength();
        if(oldLength != 0) {
            this.x = this.x * length / oldLength;
            this.y = this.y * length / oldLength;
        }
    }

    public double getAngle() {
        return Math.atan(y/x);
    }

    public void setAngle(double angle) {
        double length = this.getLength();
        if(length != 0){
            this.x = length * Math.cos(angle);
            this.y = length * Math.sin(angle);
        }
    }
}
