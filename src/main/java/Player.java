public class Player {
    protected int id;
    protected int strength;
    protected String name;//id, name, strength

    public Player(int id, int strength, String name) {
        this.id = id;
        this.strength = strength;
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public String getName() {
        return name;
    }
}
