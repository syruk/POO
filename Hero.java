import java.util.Random;

public class Hero {
    //VARIABLES
    private String name;
    private int level;
    private int health;
    private int maxHealth;
    private int experience;
    private int attack;
    private int defense;
    public static final int minimumLevel = 1;
    public static final int minimumExperience = 0;
    public static final int potion = 10;
    public static final int restHealth = 50;
    public static final int starterHealth = 100;
    public static final int addedHealthPerLevel = 5;
    public static final int xpPerAttack = 10;
    public static final int xpPerLevel = 50;

    //GETTERS
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    //SETTERS
    //CONSTRUCTORES
    public Hero(String name, int attack, int defense){
        this.name = name;
        this.level = minimumLevel;
        this.health = starterHealth;
        this.maxHealth = starterHealth;
        this.experience = minimumExperience;
        this.attack = attack;
        this.defense = defense;
    }

    //METODOS
    public void drinkPotion() {
        health += potion;
        if (health > maxHealth) {
            health = maxHealth;
        }
    }
    public void rest() {
        health += restHealth;
        if (health > maxHealth) {
            health = maxHealth;
        }
    }
    public String toString() {
        return "Nombre: " + name + "\nNivel: " + level + "\nVida actual: " + health + "/" + maxHealth +
                "\nExperiencia: " + experience + "\nAtaque: " + attack + "\nDefensa: " + defense;
    }
    public void attack(Hero enemy) {
        Random random = new Random();
        int damage = Math.max(attack - enemy.defense, 10);
        enemy.health -= damage;
        experience += xpPerAttack;

        if (experience >= xpPerLevel) {
            levelUp();
        }
    }
    public void levelUp() {
        level++;
        health += addedHealthPerLevel;
        maxHealth += addedHealthPerLevel;
        attack++;
        defense++;
        experience = 0;
    }
}