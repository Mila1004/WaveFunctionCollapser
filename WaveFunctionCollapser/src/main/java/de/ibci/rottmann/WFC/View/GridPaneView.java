package de.ibci.rottmann.WFC.View;

import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

import java.awt.geom.Dimension2D;

public class GridPaneView{
    private VBox gridVBox;
    private final HBox gridHBox = new HBox();
    private GridPane gridPane;
    private Pos alignmentPos;
    private final int defaultGridSize = 6;
    private int updatedGridWidth = 0;
    private int updatedGridHeight = 0;

    public GridPaneView(Pos aPos) {
        this.gridPane = new GridPane();
        this.gridPane.setAlignment(aPos);
        //do not use addColumn/Row with getColumn/RowConstraints().add(new Column/RowConstraints(...))
        this.drawGrid(this.defaultGridSize);
        this.gridVBox = new VBox();
        this.gridVBox.setAlignment(aPos);
        this.gridVBox.getChildren().add(this.gridPane);
        System.out.println("GridPaneView successful");
    }

    private void drawGrid(int aGridSize) {
        for (int i = 0; i < aGridSize; i++) {
            this.gridPane.getColumnConstraints().add(new ColumnConstraints(50));
        }
        for (int i = 0; i < aGridSize; i++) {
            this.gridPane.getRowConstraints().add(new RowConstraints(50));
        }
        this.gridPane.setGridLinesVisible(true);
    }

    public void setUpdatedGridSize(Dimension2D anUpdatedGridSize) {
        this.updateGrid(anUpdatedGridSize);
    }

    private void updateGrid(Dimension2D anUpdatedGridSize) {
        int tmpGridWidth = (int) anUpdatedGridSize.getWidth();
        int tmpGridHeight = (int) anUpdatedGridSize.getHeight();
        for (int i = 1; i < tmpGridHeight; i++) {
            this.gridPane.addRow(this.gridPane.getRowCount() + i);
        }
        for (int i = 1; i < tmpGridWidth; i++) {
            this.gridPane.addColumn(this.gridPane.getColumnCount() + i);
        }
    }

    public VBox getGridVBox() {
        return this.gridVBox;
    }
}
