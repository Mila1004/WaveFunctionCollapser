package de.ibci.rottmann.WFC.Control;

import de.ibci.rottmann.WFC.Main.MainApp;
import de.ibci.rottmann.WFC.View.SingletonAllView;
import javafx.stage.Stage;

import java.awt.geom.Dimension2D;

public class SingletonAllController {
    private static SingletonAllController singletonAllControllerInstance;
    private static SingletonAllView singletonAllView;
    private static Stage stage;
    private static Dimension2D screenDimension;

    private SingletonAllController() {}

    public void initAllView() {
        singletonAllView = SingletonAllView.getInstance();
    }

    public static SingletonAllController getInitInstance(Stage aStage, Dimension2D aScreenDimension) {
        if (singletonAllControllerInstance == null) {
            System.out.println("allC init");
            stage = aStage;
            screenDimension = aScreenDimension;
            singletonAllControllerInstance = new SingletonAllController();
        }
        return singletonAllControllerInstance;
    }
    public static SingletonAllController getInstance() {
        if (singletonAllControllerInstance == null) {
            System.out.println("allC inst");
            singletonAllControllerInstance = getInitInstance(MainApp.getPrimaryStage(), MainApp.getScreenDimension());
        }
        return singletonAllControllerInstance;
    }
    public Stage getStage() {
        return stage;
    }
    public Dimension2D getScreenDimension() {
        return screenDimension;
    }
}
