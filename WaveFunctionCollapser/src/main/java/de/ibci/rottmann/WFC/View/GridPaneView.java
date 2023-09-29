package de.ibci.rottmann.WFC.View;

import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

public class GridPaneView{
    private VBox gridVBox;
    private final HBox gridHBox = new HBox();
    private GridPane gridPane;
    private Pos alignmentPos;

    public GridPaneView(Pos aPos) {
        this.gridPane = new GridPane();
        this.gridPane.setAlignment(aPos);
        //do not use addColumn/Row with getColumn/RowConstraints().add(new Column/RowConstraints(...))
        int tmpInt = 9;
        for (int i = 0; i < tmpInt; i++) {
            String tmpString = String.valueOf(i + 1);
            this.gridPane.getColumnConstraints().add(new ColumnConstraints(50));
        }
        for (int i = 0; i < tmpInt; i++) {
            String tmpString = String.valueOf(i + 1);
            this.gridPane.getRowConstraints().add(new RowConstraints(50));
        }
        this.gridPane.setGridLinesVisible(true);
        this.gridVBox = new VBox();
        this.gridVBox.setAlignment(aPos);
        this.gridVBox.getChildren().add(this.gridPane);
        System.out.println("GridPaneView successful");
    }

    public VBox getGridVBox() {
        return gridVBox;
    }
}
