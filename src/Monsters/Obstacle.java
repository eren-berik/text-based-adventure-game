package Monsters;

public class Obstacle {
    private int id;
    private String name;
    private int damage;
    private int health;
    private int defaultHealth;
    private int moneyAward;
    private String itemAward;

    public Obstacle(int id, String name, int damage, int health, int moneyAward) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.defaultHealth = health;
        this.moneyAward = moneyAward;
    }

    public Obstacle(int id, String name, int damage, int health, String itemAward) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.defaultHealth = health;
        this.itemAward = itemAward;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }

    public int getMoneyAward() {
        return moneyAward;
    }

    public void setMoneyAward(int award) {
        this.moneyAward = award;
    }

    public String getItemAward() {
        return itemAward;
    }

    public void setItemAward(String itemAward) {
        this.itemAward = itemAward;
    }
}
