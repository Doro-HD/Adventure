package Adventure.items;

public class RangedWeapon extends Weapon {

  private int ammunition;

  public RangedWeapon(String type, String name, String description, int damage,int ammunition){
    super(name, description, type, damage);
    this.ammunition = ammunition;
  }

  public boolean isUseAble() {
    return this.ammunition > 0;
  }
}
