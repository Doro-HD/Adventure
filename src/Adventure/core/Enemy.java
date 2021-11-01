package Adventure.core;
import Adventure.items.Item;
import Adventure.items.Weapon;

public class Enemy {
    private String name;
    private int hp;
    private Room currentRoom;
    private Weapon equippedWeapon;

    public Enemy(String name, int hp, Room currentRoom, Weapon equippedWeapon){
        this.name = name;
        this.hp = hp;
        this.currentRoom = currentRoom;
        this.equippedWeapon = equippedWeapon;
    }

    public Boolean isDead(){
       boolean isDead = this.hp <= 0;

       if (isDead) {
           this.currentRoom.recievePlayerItem(this.equippedWeapon);
           this.currentRoom.setEnemy(null);
       }
       return isDead;
    }

    public int showEnemyHp(){
        return this.hp;
    }

    public void takeDamage(int damage){
        this.hp -= damage;
        System.out.println("The enemy has " + this.hp + " hp left");
    }

    public int getDamage(){
        if (this.equippedWeapon == null) {
            return 0;
        } else {
            return this.equippedWeapon.getDamage();
        }
    }
}
