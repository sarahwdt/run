package controllers;

/**
 * Контроллер окна главного меню
 */
public class MainFormController extends BasicController {

    /**
     * Обработка события нажатия на кнопку мышью
     * Переход в окно игры
     */
    public void goEasy() {
        stage.setScene(scenes.get("easy"));
        stage.show();
    }

    /**
     * Обработка события нажатия на кнопку мышью
     * Переход в окно игры повышенной сложности
     */
    public void goHard() {
        stage.setScene(scenes.get("hard"));
        stage.show();
    }
}
