package Adventure.items;

public class MeleeWeapon extends Weapon{
  public MeleeWeapon(String type, String name, String description, int damage){
    super(name, description, type, damage);
  }

  public boolean useAble() {
    return true;
  }
}
