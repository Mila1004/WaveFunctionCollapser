package de.ibci.rottmann.WFC.View;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;

public class MenuBarView {
    private final VBox MenuBarVbox = new VBox();
    private final Menu menuBarFileItem = new Menu("File");
    private final Menu menuBarEditItem = new Menu("Edit");
    private final Menu menuBarViewItem = new Menu("View");
    private final Menu menuBarHelpItem = new Menu("Help");
    public MenuBarView() {
        MenuBar tmpMenuBar = new MenuBar();
        tmpMenuBar.getMenus().addAll(this.menuBarFileItem, this.menuBarEditItem,
                this.menuBarViewItem, this.menuBarHelpItem);
        MenuBarVbox.getChildren().addAll(tmpMenuBar);
    }
    public VBox getAllVBox() {
        return this.MenuBarVbox;
    }
}
