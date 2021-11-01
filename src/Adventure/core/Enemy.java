package Adventure.core;
import Adventure.items.Item;
import Adventure.items.Weapon;

public class Enemy {
    private String name;
    private int hp;
    private int attack;
    private Room currentRoom;


    public Enemy(String name, int hp, int attack){
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }

    public Boolean isDead(){
       return this.hp <= 0;
    }

    public int showEnemyHp(){
        return this.hp;
    }

    public void takeDamage(int damage){
        this.hp = - damage;
    }
}
