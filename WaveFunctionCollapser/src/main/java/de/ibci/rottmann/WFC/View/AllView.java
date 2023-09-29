package de.ibci.rottmann.WFC.View;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.geom.Dimension2D;
import java.util.Objects;

public class AllView extends AnchorPane {
    private BorderPane mainBorderPane;
    private StackPane mainCenterPane;
    private MenuBarView menuBarView;
    private GridPaneView mainGridPaneView;

    public AllView(Stage aStage, Dimension2D aScreenDimension) {
        //BorderPane
        this.mainBorderPane = new BorderPane();
        AllView.setBottomAnchor(this.mainBorderPane, 0.0);
        AllView.setTopAnchor(this.mainBorderPane, 0.0);
        AllView.setLeftAnchor(this.mainBorderPane, 0.0);
        AllView.setRightAnchor(this.mainBorderPane, 0.0);
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
        aStage.setMaximized(true);
        aStage.setResizable(true);
        aStage.getIcons().add(new Image(Objects.requireNonNull(AllView.class.getResourceAsStream("/WFC_Icon.jpg"))));
        aStage.show();
    }
}
