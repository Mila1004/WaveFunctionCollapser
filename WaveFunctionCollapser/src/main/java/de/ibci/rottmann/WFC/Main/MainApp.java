package de.ibci.rottmann.WFC.Main;

import de.ibci.rottmann.WFC.Control.AllController;
import javafx.application.Application;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.util.Locale;

public class MainApp extends Application {
    private AllController AllController;

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
            Dimension2D tmpScreenDimension = Toolkit.getDefaultToolkit().getScreenSize();
            System.out.println("Debug: " + tmpScreenDimension);
            this.AllController = new AllController(primaryStage, tmpScreenDimension);
        } catch (RuntimeException anException) {
            System.out.println(anException);
        }
    }
}
