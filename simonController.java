import java.util.concurrent.TimeUnit;
import java.util.*;

public class simonController
{
   simonView view;
   simonModel model;
   
   
   public void addView(simonView view)
   {
      this.view = view;
   }

   public void addModel(simonModel model)
   {
      this.model = model;
   }
   
   public void nameSubmit(String name)
   {
      model.saveName(name);
      view.showMainMenu(this);
   }
   
   
   public void mainMenuStartEasy()
   {
      model.startGame(0);
      view.showGame(0, this);
      
   }
   
   public void mainMenuStartHard()
   {
      model.startGame(1);
      view.showGame(1, this);
      
   }
   
   public void mainMenuHowToPlay()
   {
      view.showInstruction(this);
   }
   
   public void closeButton()
   {
      view.showMainMenu(this);
   }
   
   public void playAgain(Boolean highScore)
   {
      view.showPlayAgain(this, highScore);
   }
   
   public void playAgainMainMenu()
   {
      view.showMainMenu(this);
   }

   
   public void playAgainPlayEasy()
   {
      model.startGame(0);
      view.showGame(0, this);
   }
   
   public void playAgainPlayHard()
   {
      model.startGame(1);
      view.showGame(1, this);
   }

   public String getEasyHighName(int a)
   {
      return model.easyHighPlayers[a].getPlayerName();
   }

   public int getEasyHighScore(int b)
   {
      return model.easyHighPlayers[b].getPlayerScore();
   }

   public String getHardHighName(int c)
   {
      return model.hardHighPlayers[c].getPlayerName();
   }

   public int getHardHighScore(int d)
   {
      return model.hardHighPlayers[d].getPlayerScore();
   }

   public int getPlayerScore()
   {
      return model.player.getPlayerScore();
   }

   public String getPlayerName()
   {
      return model.player.getPlayerName();
   }
   
   public boolean check(int x)
   {
      Boolean wrong = model.check(x);
      if (model.display == true)
      {
         view.displayPattern(model.getPattern());
         return wrong;
      }
      else
      {
         return wrong;
      }
   }

   public Vector<Integer> getPattern()
   {
      return model.getPattern();
   }
   
   public Boolean checkHighScore()
   {
      Boolean bool = model.endGame();
      model.saveToFile();
      return bool;
   }
}
