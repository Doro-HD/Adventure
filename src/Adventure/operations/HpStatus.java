package Adventure.operations;

import Adventure.core.Player;

public class HpStatus extends Operation{

  public boolean execute(Player player) {
    evaluateHp(player);
    return true;
  }

  private void evaluateHp(Player player){
    int startHp = player.getMaxHp();
    int hp = player.getHp();
    this.operationExecution += "Your hp is: "+hp+" right now\n";
    if(hp > startHp * 0.75){
      this.operationExecution += "You are in good health!";
    }else if(hp > startHp * 0.5){
      this.operationExecution += "You are still in good health, but please be careful!";
    }else if(hp > startHp * 0.25){
      this.operationExecution +="You could be worse of, but you could also be better";
    }else{
      this.operationExecution += "you are about to die my guy";
    }
  }


}
