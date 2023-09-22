package de.ibci.rottmann.WFC.Main;

import de.ibci.rottmann.WFC.Control.AllController;
import javafx.application.Application;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.geom.Dimension2D;

public class MainApp extends Application {
    private AllController AllController;

    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages.
     * @throws Exception if something goes wrong
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Dimension2D tmpScreenDimension = Toolkit.getDefaultToolkit().getScreenSize();
            System.out.println("Debug: " + tmpScreenDimension);
            this.AllController = new AllController(primaryStage, tmpScreenDimension);
        } catch (RuntimeException anException) {
            System.out.println(anException);
        }
    }
}
