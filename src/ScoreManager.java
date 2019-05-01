public class ScoreManager implements IScoreObserver {

    int redLettuceCounter = 0;

    private ActorManager actorManager;

    public ScoreManager(ActorManager actorManager) {
        this.actorManager = actorManager;
    }

    @Override
    public void scoreAction(int score) {
        int diff = score - (redLettuceCounter * WorldConfig.getInstance()
        .RED_LETTUCE_CREATION_ON_SCORE);
        System.out.println("diff:"+diff);
        if (diff >= WorldConfig.getInstance().RED_LETTUCE_CREATION_ON_SCORE) {
            actorManager.createRedLettuce();
            redLettuceCounter++;
        }
    }
}
