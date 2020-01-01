public class simonDriver
{
   public static void main(String []args)
   {
      simonController controller = new simonController();
      simonView view = new simonView();
      simonModel model = new simonModel();
      controller.addView(view);
      controller.addModel(model);
      view.addListeners(controller);
      
      try
      {
         model.loadFromFile("simon.dat");      
      }
      catch (Exception e)
      {
         for (int i=0; i<10; i++)
         {
            Player player = new Player();
            model.easyHighPlayers[i] = player;
         }
         for (int i=0; i<10; i++)
         {
            Player player = new Player();
            model.hardHighPlayers[i] = player;
         }
      }
   }
}
