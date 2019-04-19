public class ScoreManager implements IScoreObserver {

  // chain of responsibility pattern for other guys, game level up and game over. maybe
  int redLettuceCounter = 0;

  private ActorManager actorManager;

  public ScoreManager(ActorManager actorManager) {
    this.actorManager = actorManager;
  }

  @Override
  public void scoreAction(int score) {
    int diff = score - (redLettuceCounter * WorldConfig.RED_LETTUCE_CREATION_ON_SCORE);
    System.out.println("diff:"+diff);
    if (diff >= WorldConfig.RED_LETTUCE_CREATION_ON_SCORE) {
      System.out.println("creating red lettuce");
      actorManager.createRedLettuce();
      redLettuceCounter++;
    }
  }
}
