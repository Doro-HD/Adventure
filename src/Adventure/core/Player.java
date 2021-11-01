package Adventure.core;

import Adventure.items.Food;
import Adventure.items.Item;
import Adventure.items.Weapon;
import Adventure.util.Status;

import java.util.ArrayList;

public class Player {
    private String name;
    private int hp;
    private int maxHp;
    private Weapon equippedWeapon;
    private ArrayList<Item> inventory;
    private Room currentRoom;

    public Player(String name, Room startPosition) {
        this.setName(name);
        this.setCurrentRoom(startPosition);
        this.inventory = new ArrayList<>();
        this.setMaxHp(200);
        this.hp = 100;
    }

    public String inventoryToString() {
        String itemsString = "";
        for (Item item : this.inventory) {
            itemsString += "\t" + item.toString() + "\n";
        }
        return itemsString;
    }


    //Returns a boolean to Command that represents if the item was found
    public boolean takeItem(String itemName) {
        Item newItem = this.currentRoom.givePlayerItem(itemName);
        if (newItem != null) {
            this.inventory.add(newItem);
            return true;
        } else {
            return false;
        }
    }

    //Returns a boolean to Command that represents if the item was found
    public boolean dropItem(String itemName) {
        boolean itemWasDropped;
        Item item = findItem(itemName);

        if (item != null) {
            this.currentRoom.recievePlayerItem(item);
            this.inventory.remove(item);
            itemWasDropped = true;
        } else {
            itemWasDropped = false;
        }
        return itemWasDropped;
    }

    private Item findItem(String itemName) {
        for (Item item : this.inventory) {
            if (item.isSameType(itemName)) {
                return item;
            }
        }
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Sets the players current position to be a new room unless that room is null
    //The argument given in the client code is a reference to another room
    public boolean setCurrentRoom(Room newPlayerPosition) {
        if (newPlayerPosition != null) {
            this.currentRoom = newPlayerPosition;
            return true;
        } else
            return false;
    }

    public boolean inventoryIsEmpty() {
        if (this.inventory.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public Status consumeFood(String name) {
        //Finds a food item in the players inventory
        Item item = findItem(name);
        if (item == null) {
            return Status.itemNotFound;
        } else if (!(item instanceof Food)) {
            return Status.notUsable;
        } else {
            return Status.usable;
        }
    }

    public boolean equipWeapon(String weaponType) {
        Item foundWeapon = findItem(weaponType);
        if (foundWeapon instanceof Weapon) {
            this.equippedWeapon = (Weapon) foundWeapon;
            return true;
        }
        return false;
    }


    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public void setHp(int hp) {
        this.hp = Math.min(hp,maxHp);
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getHp() {
        return hp;
    }

    private boolean takeDamage(int damage){
        int health = Math.max(this.hp,damage)-Math.min(this.hp,damage);
        this.setHp(health);
        return this.hp <= 0;
    }

    public Status checkAttack() {
        Enemy enemy = this.currentRoom.getEnemy();
        if (enemy == null) {
            return Status.enemyNotFound;
        } else if (this.equippedWeapon == null) {
            return Status.itemNotFound;
        } else if (this.equippedWeapon.isUseAble()) {
            return this.attackSequence(enemy);
        } else {
            return Status.notUsable;
        }
    }

    private Status attackSequence(Enemy enemy){
        boolean enemyIsDead = this.attackEnemy(enemy);
        if (enemyIsDead) {
            return Status.enemyIsDead;
        }
        boolean playerIsDead = this.enemyAttack(enemy);
        if (playerIsDead) {
            return Status.playerIsDead;
        } else {
            return Status.enemyIsStillAlive;
        }
    }

    private boolean attackEnemy(Enemy enemy) {
        enemy.takeDamage(this.equippedWeapon.getDamage());
        boolean enemyIsDead = enemy.isDead();
        if (enemyIsDead) {
            return true;
        } else {
            return false;
        }
    }

    private boolean enemyAttack(Enemy enemy) {
        boolean playerIsDead = takeDamage(enemy.getDamage());
        if (playerIsDead) {
            return true;
        } else {
            return false;
        }
    }
}
