package Adventure.items;

public class Food extends Item {
private int healingHp;

public Food(String name, String type, String description, int healingHp){
  super(type,name,description);
  this.healingHp = healingHp;
}

  public int getHealingHp() {
    return healingHp;
  }

}
