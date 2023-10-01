package de.ibci.rottmann.WFC.View;

import de.ibci.rottmann.WFC.Control.SingletonAllController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.geom.Dimension2D;
import java.util.Objects;

public final class SingletonAllView extends AnchorPane {
    private BorderPane mainBorderPane;
    private StackPane mainCenterPane;
    private MenuBarView menuBarView;
    private final GridPaneView mainGridPaneView;
    private static SingletonAllView singletonAllViewInstance = null;
    private static SingletonAllController singletonAllControllerInstance;

    private SingletonAllView(Stage aStage, Dimension2D aScreenDimension) {
        //BorderPane
        this.mainBorderPane = new BorderPane();
        SingletonAllView.setBottomAnchor(this.mainBorderPane, 0.0);
        SingletonAllView.setTopAnchor(this.mainBorderPane, 0.0);
        SingletonAllView.setLeftAnchor(this.mainBorderPane, 0.0);
        SingletonAllView.setRightAnchor(this.mainBorderPane, 0.0);
        HBox.setHgrow(this.mainBorderPane, Priority.ALWAYS);
        VBox.setVgrow(this.mainBorderPane, Priority.ALWAYS);
        //mainCenterPane
        this.mainCenterPane = new StackPane();
        this.mainCenterPane.setAlignment(Pos.CENTER);
        this.mainCenterPane.setStyle("-fx-background-color: WHITE");
        //menubar
        this.menuBarView = new MenuBarView();
        VBox tmpMenuVBox = this.menuBarView.getMenuBarVBox();
        this.mainBorderPane.setTop(tmpMenuVBox);
        //gridView
        this.mainGridPaneView = new GridPaneView(Pos.CENTER);
        this.mainCenterPane.getChildren().add(this.mainGridPaneView.getGridVBox());
        this.mainBorderPane.setCenter(this.mainCenterPane);
        Scene tmpEditorScene = new Scene(this.mainBorderPane);
        aStage.setScene(tmpEditorScene);
        aStage.setMinHeight(aScreenDimension.getHeight() / 2);
        aStage.setMinWidth(aScreenDimension.getWidth() / 2);
        aStage.setTitle("Wave Function Collapser");
        //aStage.setMaximized(true);
        aStage.setResizable(true);
        aStage.getIcons().add(new Image(Objects.requireNonNull(SingletonAllView.class.getResourceAsStream("/WFC_Icon.jpg"))));
        aStage.show();
    }
    public void setUpdatedGridSize(Dimension2D anUpdatedGridSize) {
        this.mainGridPaneView.setUpdatedGridSize(anUpdatedGridSize);
    }
    public static SingletonAllView getInitInstance(Stage aStage, Dimension2D aScreenSize) {
        if (singletonAllViewInstance == null) {
            singletonAllViewInstance = new SingletonAllView(aStage, aScreenSize);
        }
        return singletonAllViewInstance;
    }
    public static SingletonAllView getInstance() {
        singletonAllControllerInstance = SingletonAllController.getInstance();
        if (singletonAllViewInstance == null) {
            Stage tmpStage = singletonAllControllerInstance.getStage();
            Dimension2D tmpDim = singletonAllControllerInstance.getScreenDimension();
            singletonAllViewInstance = getInitInstance(tmpStage, tmpDim);
        }
        return singletonAllViewInstance;
    }
}
