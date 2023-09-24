package de.ibci.rottmann.WFC.View;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class MenuBarView {
    private final VBox menuBarVbox = new VBox();
    private final Menu menuBarFile = new Menu("File");
    private final Menu menuBarEdit = new Menu("Edit");
    private final Menu menuBarView = new Menu("View");
    private final Menu menuBarHelp = new Menu("Help");
    public MenuBarView() {
        MenuBar tmpMenuBar = new MenuBar();
        List<MenuItem> tmpMenuItemList = this.menuBarFileItems();
        for (MenuItem tmpMenuItem :
                tmpMenuItemList) {
            this.menuBarFile.getItems().add(tmpMenuItem);
            this.menuBarFile.getItems().add(new SeparatorMenuItem());
        }
        tmpMenuItemList = this.menuBarEditItems();
        for (MenuItem tmpMenuItem :
                tmpMenuItemList) {
            this.menuBarEdit.getItems().add(tmpMenuItem);
            this.menuBarEdit.getItems().add(new SeparatorMenuItem());
        }
        tmpMenuItemList = this.menuBarViewItems();
        for (MenuItem tmpMenuItem :
                tmpMenuItemList) {
            this.menuBarView.getItems().add(tmpMenuItem);
            this.menuBarView.getItems().add(new SeparatorMenuItem());
        }
        tmpMenuItemList = this.menuBarHelpItems();
        for (MenuItem tmpMenuItem :
                tmpMenuItemList) {
            this.menuBarHelp.getItems().add(tmpMenuItem);
            this.menuBarHelp.getItems().add(new SeparatorMenuItem());
        }
        tmpMenuBar.getMenus().addAll(this.menuBarFile, this.menuBarEdit,
                this.menuBarView, this.menuBarHelp);
        menuBarVbox.getChildren().addAll(tmpMenuBar);
    }
    public VBox getMenuBarVBox() {
        return this.menuBarVbox;
    }
    private List<MenuItem> menuBarFileItems() {
        MenuItem tmpNewFileItem = new MenuItem("New File");
        MenuItem tmpOpenFileItem = new MenuItem("Open File");
        MenuItem tmpSaveFileItem = new MenuItem("Save File");
        List<MenuItem> tmpMenuItemList = new ArrayList<>();
        tmpMenuItemList.add(tmpNewFileItem);
        tmpMenuItemList.add(tmpOpenFileItem);
        tmpMenuItemList.add(tmpSaveFileItem);
        return tmpMenuItemList;
    }
    private List<MenuItem> menuBarEditItems() {
        MenuItem tmpEditItem = new MenuItem("Edit");
        MenuItem tmpSettingsItem = new MenuItem("Settings");
        List<MenuItem> tmpMenuItemList = new ArrayList<>();
        tmpMenuItemList.add(tmpEditItem);
        tmpMenuItemList.add(tmpSettingsItem);
        return tmpMenuItemList;
    }
    private List<MenuItem> menuBarViewItems() {
        List<MenuItem> tmpMenuItemList = new ArrayList<>();
        return tmpMenuItemList;
    }
    private List<MenuItem> menuBarHelpItems() {
        MenuItem tmpAboutItem = new MenuItem("About");
        MenuItem tmpTutorialItem = new MenuItem("Tutorial");
        List<MenuItem> tmpMenuItemList = new ArrayList<>();
        tmpMenuItemList.add(tmpAboutItem);
        tmpMenuItemList.add(tmpTutorialItem);
        return tmpMenuItemList;
    }
}
