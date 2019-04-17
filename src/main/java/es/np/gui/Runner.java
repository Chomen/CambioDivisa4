package es.np.gui;

import es.np.gui.controller.AddClientDocController;
import es.np.gui.controller.MainMenuController;

public class Runner {



    public static void main(String[] args) {


        //AddClientDocController addClientController= new AddClientDocController();
        //addClientController.showFrame();

        MainMenuController controller = new MainMenuController();
        controller.showFrame();
    }
}
