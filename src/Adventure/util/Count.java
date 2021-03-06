package Adventure.util;

import java.util.Timer;
import java.util.TimerTask;

public class Count {
  static int secondsPassed = 0;
  Timer myTimer = new Timer();
  TimerTask task = new TimerTask() {

    public void run() {
      secondsPassed++;
    }
  };

  public void start() {
    myTimer.scheduleAtFixedRate(task, 1000, 1000);
  }

  public void stop() {
    myTimer.cancel();
  }

  public int getSecondsPassed() {
    return this.secondsPassed;
  }
}
