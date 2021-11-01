package Adventure.core;
import Adventure.items.Item;
import Adventure.items.Weapon;

public class Enemy {
    private String name;
    private int hp;
    private Room currentRoom;
    private Weapon equippedWeapon;


    public Enemy(String name, int hp, Weapon equippedWeapon){
        this.name = name;
        this.hp = hp;
        this.equippedWeapon = equippedWeapon;
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

    public int getDamage(){
        if (this.equippedWeapon == null) {
            return 0;
        } else {
            return this.equippedWeapon.getDamage();
        }
    }
}
