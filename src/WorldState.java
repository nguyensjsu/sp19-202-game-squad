public interface WorldState  
{
    void setEndGameState();
    void setPlayGameState();
    void setLevelUpState();
    void setInitState();
    void prepare();
}
