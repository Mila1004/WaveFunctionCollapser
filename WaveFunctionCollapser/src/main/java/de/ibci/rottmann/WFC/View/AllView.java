package de.ibci.rottmann.WFC.View;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.geom.Dimension2D;
import java.util.Objects;

public class AllView {
    public AllView(Stage aStage, Dimension2D aScreenDimension) {
        VBox tmpAllVBox = new VBox();
        MenuBarView tmpMenuBarView = new MenuBarView();
        GridView tmpGridView = new GridView();
        //ToDo: margins
        VBox tmpMenuVBox = tmpMenuBarView.getMenuBarVBox();
        VBox tmpGridVBox = new VBox(tmpGridView.getGridHBox());
        tmpGridVBox.setAlignment(Pos.CENTER);
        tmpAllVBox.getChildren().addAll(tmpMenuVBox, tmpGridVBox);

        Scene tmpScene = new Scene(tmpAllVBox);
        aStage.setScene(tmpScene);
        aStage.setMinHeight(aScreenDimension.getHeight() / 2);
        aStage.setMinWidth(aScreenDimension.getWidth() / 2);
        aStage.setTitle("Wave Function Collapser");
        aStage.setMaximized(true);
        aStage.setResizable(true);
        aStage.getIcons().add(new Image(Objects.requireNonNull(AllView.class.getResourceAsStream("/WFC_Icon.jpg"))));
        aStage.show();
    }
}
