

import controller.consoleController;

public class SwingyConsole {

    public static void main(String[] args)
    {
        consoleController controller = new consoleController();

        System.out.print("\033[H\033[2J");
        System.out.flush();
        controller.ChooseHero();
        controller.ModelInitMap();
        controller.UpdateStats();
        controller.UpdateLocation();
        while (controller.gameStillRunning()){
            controller.getInputAndUpdateModel();}
    }
}
