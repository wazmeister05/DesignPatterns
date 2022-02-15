package Week2.VisitorPattern;

// all classes we want to use the Week2.VisitorPattern.Visitor should implement the
// Week2.VisitorPattern.Expression interface
// Object Structure
public interface Expression {
    <E> E accept(Visitor<E> v);
}

// The Week2.VisitorPattern.Visitor knows about all the classes we want to accept
interface Visitor<E>{
    E visit(Number c);
    E visit(Variable v);
    E visit(Add a);
}

// constants are ordinary numbers
class Number implements Expression{
    public final int value;
    public Number(int value) {
        this.value = value;
    }
    public<E> E accept(Visitor<E> v){
        return v.visit(this);
    }
}

// variables have yet to to receive a value
class Variable implements Expression{
    public final String name;
    public Variable(String name){
        this.name = name;
    }
    public<E> E accept(Visitor<E> v){
        return v.visit(this);
    }
}

// addition of two expressions
// makes a bigger expression
class Add implements Expression{
    public final Expression left;
    public final Expression right;

    public Add(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }

    public<E> E accept(Visitor<E> v){
        return v.visit(this);
    }
}
