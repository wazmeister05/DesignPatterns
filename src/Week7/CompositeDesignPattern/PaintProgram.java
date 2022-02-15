package Week7.CompositeDesignPattern;

import java.util.List;

// Component class
abstract class Shape{
    int x = 0, y = 0;

    int getX(){
        return this.x;
    }
    int getY(){
        return this.y;
    }

    void move(int x, int y){
        this.x += x;
        this.y += y;
    }

    abstract int width();
    abstract int height();
    abstract void draw();
}

// Leaf class
class Rectangle extends Shape{
    public int width;
    public int height;

    public Rectangle(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int width(){
        return width;
    }

    public int height(){
        return height;
    }

    public void draw(){
        System.out.println("Drawing rectangle at: " + this.x + ", " + this.y +
                "; width : " + width() + "; height : " + height());
    }
}

// Leaf class
class Circle extends Shape{
    public int radius;

    public Circle(int x, int y, int radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    int width() {
        return radius * 2;
    }

    int height() {
        return radius * 2;
    }

    void draw() {
        System.out.println("Drawing circle at: " + this.x + ", " + this.y +
                "; width : " + width() + "; height : " + height());
    }
}

// Composite
class GroupShapes extends Shape{
    private List<Shape> children;

    public GroupShapes(List<Shape> children){
        this.children = children;
    }

    public int getX(){
        if(children.size() == 0){
            return 0;
        }
        int x = children.get(0).getX();
        for(Shape child : children){
            if(child.getX() < x){
                x = child.getX();
            }
        }
        return x;
    }

    public int getY(){
        if(children.size() == 0){
            return 0;
        }
        int y = children.get(0).getY();
        for(Shape child : children){
            if(child.getY() < y){
                y = child.getY();
            }
        }
        return y;
    }

    int width(){
        int maxWidth = 0;
        int x = getX();
        for(Shape child : children){
            int relativeX = child.getX() - x;
            int childWidth = relativeX + child.width();
            if(childWidth > maxWidth){
                maxWidth = childWidth;
            }
        }
        return maxWidth;
    }

    int height() {
        int maxHeight = 0;
        int y = getY();
        for(Shape child : children){
            int relativeY = child.getY() - y;
            int childHeight = relativeY + child.height();
            if(childHeight > maxHeight){
                maxHeight = childHeight;
            }
        }
        return maxHeight;
    }

    void move(int x, int y){
        for(Shape s : children){
            s.move(x, y);
        }
    }

    void draw() {
        System.out.println("Drawing composite............");
        for(Shape s : children){
            s.draw();
        }
    }
}