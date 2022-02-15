package Week7.TemplateMethodPattern;

abstract class TemplateHouse {

    // final so subclasses can't override the template method
    public final void buildHouse(){
        buildFoundation();
        buildWalls();
        addInsulation();
        buildRoof();
        buildWindows();
        System.out.println(this.getClass().getSimpleName() + " is built.");
    }

    // can't change this as it's private
    private void buildFoundation(){
        System.out.println("Pouring concrete for the foundation.");
    }

    // default, but can change
    void buildWindows(){
        System.out.println("Installing double glazed windows.");
    }

    void buildRoof(){
        System.out.println("Adding slate tiles to roof.");
    }

    // methods to be implemented by subclasses
    abstract void addInsulation();
    abstract void buildWalls();
}

class WoodenHouse extends TemplateHouse{
    void buildWalls(){
        System.out.println("Building wooden walls.");
    }

    void addInsulation(){
        System.out.println("Using sawdust insulation.");
    }
}

class GlassHouse extends TemplateHouse{

    void addInsulation() {
        System.out.println("No insulation in glass house.");
    }

    void buildWalls() {
        System.out.println("Using steel supports and quadruple layered glass as walls,");
    }

    void buildRoof(){
        System.out.println("Using triple layered glass on the roof.");
    }

    void buildWindows(){
        System.out.println("Don't need windows when the walls are glass.");
    }
}
