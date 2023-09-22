package de.ibci.rottmann.WFC.View;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Cell;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class AllView {
    public AllView(Stage aStage, Dimension2D aScreenDimension) {
        GridPane tmpGrid = new GridPane();
        //do not use addColumn/Row with getColumn/RowConstraints().add(new Column/RowConstraints(...))
        int tmpInt = 9;
        for (int i = 0; i < tmpInt; i++) {
            String tmpString = String.valueOf(i + 1);
            tmpGrid.getColumnConstraints().add(new ColumnConstraints(50));
        }
        for (int i = 0; i < tmpInt; i++) {
            String tmpString = String.valueOf(i + 1);
            tmpGrid.getRowConstraints().add(new RowConstraints(50));
        }
        tmpGrid.setGridLinesVisible(true);

        VBox tmpAllVBox = new VBox();
        MenuBarView tmpMenuBarView = new MenuBarView();
        //ToDo: margins
        tmpAllVBox.getChildren().addAll(tmpMenuBarView.getAllVBox(), tmpGrid);

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
