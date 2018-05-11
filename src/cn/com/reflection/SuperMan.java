package cn.com.reflection;

public class SuperMan extends Person implements ActionInterface{

    private boolean buleBriefs;

    @Override
    public void walk(int meter) {
        System.out.println("Super can walk, and walked "+meter+" meters then stop.");
    }

    public boolean isBuleBriefs() {
        return buleBriefs;
    }

    public void setBuleBriefs(boolean buleBriefs) {
        this.buleBriefs = buleBriefs;
    }

    public void fly(){
        System.out.println("SuperMan can fly");
    }
}
