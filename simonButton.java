import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;


public class simonButton extends JButton implements ActionListener
{
   private int number;
   private Color color;
   private simonController controller;

   public simonButton(int n, simonController con)
   {
      number = n;
      controller = con;
      addActionListener(this);
   }

   public void actionPerformed(ActionEvent e)
   {
      Boolean right = controller.check(number);
      if (right == true)
      {
         controller.playAgain(controller.checkHighScore());
      }
   }
   
   public void displayButton()
   {
      this.setBackground(Color.WHITE);
      Timer timer = new Timer(1000, new ActionListener() 
      {
         public void actionPerformed(ActionEvent evt) 
         {
            setColor(color);
         }
      });
      timer.start();
      timer.setRepeats(false);
      Timer timer2 = new Timer(500, new ActionListener() 
      {
         public void actionPerformed(ActionEvent evt) 
         {
            return;
         }
      });
      timer2.start();
      timer2.setRepeats(false);
   }
   
   public int getNumber()
   {
      return number;
   }
   
   public void setColor(Color c)
   {
      this.setBackground(c);
      this.color = c;
   }


}
