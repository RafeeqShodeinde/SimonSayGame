import java.util.Random;
import java.util.*;
import java.io.*;


public class simonModel
{
   protected Player player = new Player();
   public int patternMax;
   
   public Player[] easyHighPlayers = new Player[10];
   public Player[] hardHighPlayers = new Player[10];
   
   public Vector<Integer> pattern = new Vector<Integer>();
   public int turn;
   public Boolean display = false;

   //Save each player to an OutputStream
   public void saveToFile()
   {
      try
      {
         FileOutputStream file = new FileOutputStream("simon.dat");
         ObjectOutputStream out = new ObjectOutputStream(file);
         for (int i = 0; i < 10; i++)
         {
            out.writeObject(easyHighPlayers[i]);
         }
         for (int j = 0; j < 10; j++)
         {
            out.writeObject(hardHighPlayers[j]);
         }
         out.close();
         file.close();
      }
      catch (IOException io)
      {
         System.out.println("Exception " + io.getMessage());
      }
   }
   
   // Load top 10 players names saved each time simonDriver is executed
   public void loadFromFile(String fileName) throws Exception
   {
      FileInputStream file = new FileInputStream(fileName);
      ObjectInputStream in = new ObjectInputStream(file);
      for (int k = 0; k < 10; k++)
      {
         easyHighPlayers[k] = (Player)in.readObject();
      }
      for (int l = 0; l < 10; l++)
      {
         hardHighPlayers[l] = (Player)in.readObject();
      }
   }

   public Player[] getEasyHighPlayers()
   {
      return easyHighPlayers;
   }

   public Player[] getHardHighPlayers()
   {
      return hardHighPlayers;
   }
   
   public void saveName(String name)
   {
      player.setPlayerName(name);
   }
   
   public String getName()
   {
      return player.getPlayerName();
   }
   
   // Sets the state of the game
   public void startGame(int difficulty)
   {
      player.setPlayerScore(0);
      pattern.clear();
      
      if (difficulty == 0)
      {
         patternMax = 4;
         extendPattern();
      }
      else
      {
         patternMax = 9;
         extendPattern();
      }
   }
   
   public int getPatternMax()
   {
      return patternMax;
   }
   
   // increases the pattern after each turn
   public void extendPattern()
   {
      Random rand = new Random();
      int x = rand.nextInt(patternMax);
      pattern.add(x);
      turn = 0;
      player.setPlayerScore(player.getPlayerScore()+1);
      display = true;
   }
    
   public Boolean getDisplay()
   {
      return display;
   }
   
   public Vector<Integer> getPattern()
   {
      return pattern;
   }
   
   //Checks if player input is correct
   public Boolean check(int playerInput)
   {
      display = false;
      
      if(playerInput == pattern.elementAt(turn))
      {
         turn++;
         if (turn < pattern.size())
         {
            return false;
         }
         else
         {
            extendPattern();
            return false;
         }
      }
      else
      {
         player.setPlayerScore(player.getPlayerScore()-1);
         return true;
      }
   }
   
   // game state which kills the game if player inputs wrong pattern
   public Boolean endGame()
   {
      Boolean newHighScore = false;
   
      for (int i=0; i<10; i++)
      {
         if (patternMax == 4)
         {
            if(player.getPlayerScore()>easyHighPlayers[i].getPlayerScore())
            {
               update(i, easyHighPlayers);
               newHighScore = true;
               return newHighScore;
            }
         }
         
         else
         {
            if(player.getPlayerScore()>hardHighPlayers[i].getPlayerScore())
            {
               update(i, hardHighPlayers);
               newHighScore = true;
               return newHighScore;
            }
         }
      }
         
      newHighScore = false;
      return newHighScore; 
      }
    
   // Updates the Leaderboard table
   public void update(int scorePlace, Player[] players)
   {
      String tempName = players[scorePlace+1].getPlayerName();
      players[scorePlace+1].setPlayerName(players[scorePlace].getPlayerName());
      
      int tempScore = players[scorePlace+1].getPlayerScore();
      players[scorePlace+1].setPlayerScore(players[scorePlace].getPlayerScore());
      
      for (int i = scorePlace+1; i<9; i++)
      {
         int tempScore2 = players[i+1].getPlayerScore();
         String tempName2 = players[i+1].getPlayerName();
         
         players[i+1].setPlayerScore(tempScore);
         players[i+1].setPlayerName(tempName);
         
         tempScore = tempScore2;
         tempName = tempName2;
      }
      players[scorePlace].setPlayerName(player.getPlayerName());
      players[scorePlace].setPlayerScore(player.getPlayerScore());
   }
   
   public int getTurn()
   {
      return turn;
   }
} 
