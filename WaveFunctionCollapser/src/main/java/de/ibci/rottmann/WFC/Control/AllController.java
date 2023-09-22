package de.ibci.rottmann.WFC.Control;

import de.ibci.rottmann.WFC.View.AllView;
import javafx.stage.Stage;

import java.awt.geom.Dimension2D;

public class AllController {
    AllView allView;
    public AllController(Stage aStage, Dimension2D aScreenDimension) {
        this.allView = new AllView(aStage, aScreenDimension);
    }
}
