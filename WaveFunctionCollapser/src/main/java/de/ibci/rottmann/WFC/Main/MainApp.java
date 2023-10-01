package de.ibci.rottmann.WFC.Main;

import de.ibci.rottmann.WFC.Control.SingletonAllController;
import javafx.application.Application;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.util.Locale;

public class MainApp extends Application {
    private static Dimension2D screenDimension;
    private static Stage startStage;
    private SingletonAllController singletonAllControllerInstance;
    public static void main(String[] args) {
        Application.launch(args);
    }
    //
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Locale.setDefault(new Locale("en", "GB"));
            //ToDo: check for java version
            String tmpJavaVersion = System.getProperty("java.version");
            System.out.println("Java Version: " + tmpJavaVersion);
            //ToDo: logging
            screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
            startStage = primaryStage;
            System.out.println("Debug: " + screenDimension);
            this.singletonAllControllerInstance = SingletonAllController.getInstance();
            this.singletonAllControllerInstance.initAllView();
        } catch (RuntimeException anException) {
            System.out.println(anException);
        }
    }

    public static Dimension2D getScreenDimension() {
        return screenDimension;
    }

    public static Stage getPrimaryStage() {
        return startStage;
    }
}
