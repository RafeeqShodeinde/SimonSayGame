import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;

import java.util.concurrent.TimeUnit;
import java.util.*;

public class simonView
{
   protected JFrame mainFrame;
   protected JPanel mainPanel;
   
   protected JPanel nameMainPanel;
   protected JLabel nameLabel;
   protected JTextField nameField;
   protected JButton nameSubmit;
   
   protected JButton mainMenuStartEasy;
   protected JButton mainMenuStartHard;
   protected JButton mainMenuHowToPlay;
   protected JButton closeButton;
   protected JPanel mainMenuMainPanel;
   protected JPanel mainMenuControlPanel;
   protected JPanel mainMenuEasyScoreBoard;
   protected JPanel mainMenuHardScoreBoard;
   
   protected JPanel instructionPanel;
   protected JLabel instructionLabel;
   protected JPanel wordPanel;
   
   protected JPanel playAgainMainPanel;
   protected JPanel playAgainScoreBoard;
   protected JPanel playAgainControlPanel;   
   protected JButton playAgainPlayEasy;
   protected JButton playAgainPlayHard;
   protected JButton playAgainMainMenu;
   
   protected JPanel mainGamePanel;
   protected JPanel board;
   protected JPanel gameStatus;
   protected JLabel boardName;
   protected JLabel boardDifficulty;
   protected JLabel boardScore;
   protected simonButton gameButton;
   protected Color[] hardColors;
   protected Color[] easyColors;
   protected simonButton[] Buttons;
   int x=0;
   
   public simonView()
   {
      //saving-name GUI: First command executed when Driver is run.
      mainFrame = new JFrame();
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mainFrame.setSize(new Dimension(300, 100));
      mainPanel = new JPanel();
      mainPanel.setLayout(new BorderLayout());
      mainPanel.setPreferredSize(new Dimension(300, 300));
      mainFrame.add(mainPanel);

      nameSubmit = new JButton("Submit");
      mainMenuStartEasy = new JButton("Play Easy");
      mainMenuStartHard = new JButton("Play Hard");
      mainMenuHowToPlay = new JButton("How To Play");
      closeButton = new JButton("Close");
      playAgainPlayEasy = new JButton("Play Easy");
      playAgainPlayHard = new JButton("Play Hard");
      playAgainMainMenu = new JButton("Main Menu");

      nameMainPanel = new JPanel();
      nameMainPanel.setLayout(new BorderLayout());
      nameLabel = new JLabel("Enter your name: ", JLabel.CENTER);

      nameField = new JTextField(20);
      nameMainPanel.add(nameLabel, BorderLayout.NORTH);
      nameMainPanel.add(nameField, BorderLayout.CENTER);
      nameMainPanel.add(nameSubmit, BorderLayout.SOUTH);
      
      mainPanel.add(nameMainPanel);
      mainFrame.setVisible(true);
    }  

      
   // Adding all actionListeners
   public void addListeners(simonController controller)
   {
      nameSubmit.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            controller.nameSubmit(nameField.getText());
         }
      });
      
      mainMenuStartEasy.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e2)
         {
            controller.mainMenuStartEasy();
         }
      });
      
      mainMenuStartHard.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e3)
         {
            controller.mainMenuStartHard();
         }
      });
      
      mainMenuHowToPlay.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e4)
         {
            controller.mainMenuHowToPlay();
         }
      });
      
      closeButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e5)
         {
            controller.closeButton();
         }
      });
      
      playAgainMainMenu.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e6)
         {
            controller.playAgainMainMenu();
         }
      });
      
      playAgainPlayEasy.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e7)
         {
            controller.playAgainPlayEasy();
         }
      });
      
      playAgainPlayHard.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e8)
         {
            controller.playAgainPlayHard();
         }
      });   
   }
   
   // Main Menu GUI
   public void showMainMenu(simonController controller)
   {
      mainPanel.removeAll();
      mainFrame.setSize(new Dimension(300, 300));
      mainMenuMainPanel = new JPanel();
      mainMenuMainPanel.setLayout(new BorderLayout());    
      mainMenuControlPanel = new JPanel();
      mainMenuControlPanel.setLayout(new BorderLayout()); 
      mainMenuEasyScoreBoard = new JPanel();
      mainMenuEasyScoreBoard.setLayout(new BorderLayout());
      mainMenuHardScoreBoard = new JPanel();
      mainMenuHardScoreBoard.setLayout(new BorderLayout());
      
      JLabel mainMenuAnnouncement = new JLabel("High Scores");
      mainMenuAnnouncement.setHorizontalAlignment(JLabel.CENTER);
      
      //Leaderboard Table GUI
      JLabel mainMenuEasyScores = new JLabel("<html>1. " + controller.getEasyHighName(0) + " " + controller.getEasyHighScore(0) + "<br/> 2. " + controller.getEasyHighName(1) + " " + controller.getEasyHighScore(1) + "<br/> 3. " + controller.getEasyHighName(2) + " " + controller.getEasyHighScore(2) + "<br/> 4. " + controller.getEasyHighName(3) + " " + controller.getEasyHighScore(3) + "<br/> 5. " + controller.getEasyHighName(4) + " " + controller.getEasyHighScore(4) + "<br/> 6. " + controller.getEasyHighName(5) + " " + controller.getEasyHighScore(5) + "<br/> 7. " + controller.getEasyHighName(6) + " " + controller.getEasyHighScore(6) + "<br/> 8. " + controller.getEasyHighName(7) + " " + controller.getEasyHighScore(7) + "<br/> 9. " + controller.getEasyHighName(8) + " " + controller.getEasyHighScore(8) + "<br/> 10. " + controller.getEasyHighName(9) + " " + controller.getEasyHighScore(9) + "</html>");
      mainMenuEasyScoreBoard.add(mainMenuEasyScores, BorderLayout.CENTER);
      JLabel mainMenuEasy = new JLabel("Easy");
      mainMenuEasy.setHorizontalAlignment(JLabel.CENTER);
      mainMenuEasyScoreBoard.add(mainMenuEasy, BorderLayout.NORTH);
      JLabel mainMenuHard = new JLabel("Hard");
      mainMenuHard.setHorizontalAlignment(JLabel.CENTER);
      mainMenuHardScoreBoard.add(mainMenuHard, BorderLayout.NORTH);
      JLabel mainMenuHardScore = new JLabel("<html>1. " + controller.getHardHighName(0) + " " + controller.getHardHighScore(0) + "<br/> 2. " + controller.getHardHighName(1) + " " + controller.getHardHighScore(1) + "<br/> 3. " + controller.getHardHighName(2) + " " + controller.getHardHighScore(2) + "<br/> 4. " + controller.getHardHighName(3) + " " + controller.getHardHighScore(3) + "<br/> 5. " + controller.getHardHighName(4) + " " + controller.getHardHighScore(4) + "<br/> 6. " + controller.getHardHighName(5) + " " + controller.getHardHighScore(5) + "<br/>7. " + controller.getHardHighName(6) + " " + controller.getHardHighScore(6) + "<br/> 8. " + controller.getHardHighName(7) + " " + controller.getHardHighScore(7) + "<br/> 9. " + controller.getHardHighName(8) + " " + controller.getHardHighScore(8) + "<br/> 10. " + controller.getHardHighName(9) + " " + controller.getHardHighScore(9) + "</html>");
      mainMenuHardScoreBoard.add(mainMenuHardScore, BorderLayout.CENTER);
      
      mainMenuMainPanel.add(mainMenuAnnouncement, BorderLayout.PAGE_START);
      mainMenuMainPanel.add(mainMenuControlPanel, BorderLayout.SOUTH);
      mainMenuMainPanel.add(mainMenuEasyScoreBoard, BorderLayout.WEST);
      mainMenuMainPanel.add(mainMenuHardScoreBoard, BorderLayout.EAST);
      mainMenuControlPanel.add(mainMenuStartEasy, BorderLayout.WEST);
      mainMenuControlPanel.add(mainMenuStartHard, BorderLayout.EAST);
      mainMenuControlPanel.add(mainMenuHowToPlay, BorderLayout.SOUTH);
      
      mainPanel.add(mainMenuMainPanel);
      mainPanel.repaint();
      mainPanel.revalidate();
   }
	
   //(EASY/HARD)-GAME GUI
   public void showGame(int diff, simonController controller)
   {
	  
      mainPanel.removeAll();
      
      JPanel mainGamePanel = new JPanel();
      mainGamePanel.setLayout(new BorderLayout());
      board = new JPanel();
      board.setPreferredSize(new Dimension(300, 300));
      gameStatus = new JPanel(new BorderLayout());
      
      
      JLabel boardName = new JLabel(controller.getPlayerName());
      JLabel boardDifficulty = new JLabel();
      
      gameStatus.add(boardName, BorderLayout.PAGE_START);
      gameStatus.add(boardDifficulty, BorderLayout.CENTER);

      Color[] hardColors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.MAGENTA, Color.CYAN, Color.ORANGE, Color.PINK, Color.GRAY};
      Color[] easyColors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
      
      mainGamePanel.add(gameStatus, BorderLayout.PAGE_START);
      mainGamePanel.add(board, BorderLayout.CENTER);
      if (diff == 0)
      {
         x = 0;
         board.setLayout(new GridLayout(2,2));
         boardDifficulty.setText("Difficulty: Easy");
         Buttons = new simonButton[4];
        
         for (int i = 0; i < 4; i++)
         {
             gameButton = new simonButton(x, controller);
             Buttons[i] = gameButton;
             Buttons[i].setColor(easyColors[x]);
             board.add(Buttons[i], i%2, i/2);
             x++;
            }
      }
      else
      {
         x = 0;
         board.setLayout(new GridLayout(3,3));
         boardDifficulty.setText("Difficulty: Hard");
         Buttons = new simonButton[9];
         for (int i = 0; i < 9; i++)
         {
             gameButton = new simonButton(x, controller);
             Buttons[i] = gameButton;
             Buttons[i].setColor(hardColors[x]);
             board.add(Buttons[i], i%3, i/3);
             x++;
         }
      }
      
      mainPanel.add(mainGamePanel);
      mainPanel.repaint();
      mainPanel.revalidate();
      this.displayPattern(controller.getPattern());
   }
   
   // HOW TO PLAY GUI   
   public void showInstruction(simonController controller)
   {
      mainFrame.setSize(new Dimension(1000, 150));
      mainPanel.removeAll();
      
      instructionPanel = new JPanel();
      wordPanel = new JPanel();
      wordPanel.setLayout(new BorderLayout());
      instructionPanel.setLayout(new BorderLayout());

      instructionLabel = new JLabel("HOW TO PLAY: ", JLabel.CENTER);
      JLabel label1 = new JLabel("Select level of difficulty: Easy/Hard. Wait for colored tiles to highlight the desired random patterns", JLabel.CENTER);
      JLabel label2 = new JLabel("Click tiles in the same pattern which they were highlighted to win round. Patterns in consecutive rounds are longer and harder.", JLabel.CENTER);

      
      instructionPanel.add(instructionLabel, BorderLayout.NORTH);
      instructionPanel.add(label1, BorderLayout.CENTER);
      instructionPanel.add(label2, BorderLayout.SOUTH);
      
      wordPanel.add(instructionPanel, BorderLayout.NORTH);
      wordPanel.add(closeButton, BorderLayout.SOUTH);
      
      mainPanel.add(wordPanel);
      mainPanel.revalidate();
      mainPanel.repaint();
      
   }  
   
   // Play Again main menu GUI -> screen that pops up after round if lost.
   public void showPlayAgain(simonController controller, Boolean highScore)
   {
      mainPanel.removeAll();
	   
      playAgainMainPanel = new JPanel();
      playAgainMainPanel.setLayout(new BorderLayout());
      playAgainScoreBoard = new JPanel();
      playAgainScoreBoard.setLayout(new BorderLayout());
      playAgainControlPanel = new JPanel();
      playAgainControlPanel.setLayout(new BorderLayout());
      JLabel playAgainAnnouncement = new JLabel("Wrong!");
      playAgainAnnouncement.setHorizontalAlignment(JLabel.CENTER);
      playAgainScoreBoard.add(playAgainAnnouncement, BorderLayout.NORTH);
      int playAgainPlayerScore = controller.getPlayerScore();
      JLabel playAgainScore = new JLabel("Final Score: " + playAgainPlayerScore);
      JLabel playAgainNewHighScore = new JLabel("New High Score!");
      playAgainNewHighScore.setHorizontalAlignment(JLabel.CENTER);
      if (highScore == true)
      {
         playAgainScoreBoard.add(playAgainNewHighScore, BorderLayout.CENTER);
      }
      playAgainScore.setHorizontalAlignment(JLabel.CENTER);
      playAgainScoreBoard.add(playAgainScore, BorderLayout.SOUTH);
      
      JLabel playAgain = new JLabel("Play Again?");
      playAgain.setHorizontalAlignment(JLabel.CENTER);
      playAgainControlPanel.add(playAgainPlayEasy, BorderLayout.WEST);
      playAgainControlPanel.add(playAgainPlayHard, BorderLayout.EAST);
      playAgainControlPanel.add(playAgainMainMenu, BorderLayout.SOUTH);
      
      playAgainMainPanel.add(playAgainScoreBoard, BorderLayout.NORTH);
      playAgainMainPanel.add(playAgain, BorderLayout.CENTER);
      playAgainMainPanel.add(playAgainControlPanel, BorderLayout.SOUTH);
      
      mainPanel.add(playAgainMainPanel);
      mainPanel.repaint();
      mainPanel.revalidate();
   }
   
   // GUI which displays the pattern to be followed by user
   public void displayPattern(Vector<Integer> pattern)
   {
      for (int i=0; i<pattern.size(); i++)
      {
         int number = pattern.get(i);
         Timer timer = new Timer((i)*1500, new ActionListener() 
         {
            public void actionPerformed(ActionEvent evt) 
            {
               Buttons[number].displayButton();
            }
         });
      timer.start();
      timer.setRepeats(false);
      }
   }
}
