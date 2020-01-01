import java.io.Serializable;

public class Player implements Serializable
{
   private String playerName;
   private int playerScore;
   
   public Player()
   {
      this.playerName = "None";
      this.playerScore = 0;
   }
   
   public void setPlayerName(String name)
   {
      this.playerName = name;
   }
   
   public void setPlayerScore(int score)
   {
      this.playerScore = score;
   }
   
   public String getPlayerName()
   {
      return this.playerName;
   }
   
   public int getPlayerScore()
   {
      return this.playerScore;
   }
 

}
