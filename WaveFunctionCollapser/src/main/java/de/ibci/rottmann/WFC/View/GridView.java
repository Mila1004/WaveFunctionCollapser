package de.ibci.rottmann.WFC.View;

import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

public class GridView {
    private final VBox gridVBox = new VBox();
    private final HBox gridHBox = new HBox();

    public GridView() {
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
        this.gridVBox.getChildren().add(tmpGrid);
        this.gridVBox.setAlignment(Pos.CENTER);
        this.gridHBox.getChildren().add(gridVBox);
        this.gridHBox.setAlignment(Pos.CENTER);
    }
    public HBox getGridHBox() {
        return this.gridHBox;
    }
}
