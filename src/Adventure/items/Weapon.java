package Adventure.items;

public abstract class Weapon extends Item {
  private int damage;

  public Weapon(String name, String description, String type, int damage){
    super(type, name, description);
    this.damage = damage;
  }

  public int getDamage() {
    return damage;
  }

  public abstract boolean isUseAble();
}
