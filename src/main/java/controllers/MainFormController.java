package controllers;

public class MainFormController extends BasicController{

    public void goEasy() {
        stage.setScene(scenes.get("easy"));
        stage.show();
    }

    public void goHard() {
        stage.setScene(scenes.get("hard"));
        stage.show();
    }
}
