package view.display.custom.components;

import view.display.colors.ColorsEnum;

import javax.swing.*;
import java.awt.*;

public class ExCustomPane extends JTabbedPane implements IComponents {
    private static ColorUI colorUI;
    public ExCustomPane(ColorUI colorUI){
        ExCustomPane.colorUI = colorUI;
    }


    public static void createUIComponents(){

    }

    public static ColorUI getColorUI() {
        return colorUI;
    }

    @Override
    public void modificarUI(JComponent c) {

        colorUI.setColorForeground(ColorsEnum.NAVY_EXLIGHT.getColor());
        colorUI.setColorFondo(ColorsEnum.BLACK_DARK.getColor());

        UIManager.put("TabbedPane.focus", colorUI.getColorTerciario());
        UIManager.put("TabbedPane.selected", colorUI.getColorTerciario());
        UIManager.put("TabbedPane.contentBorderInsets", new Insets(0,0,0,0));
        UIManager.put("TabbedPane.contentAreaColor", colorUI.getColorTerciario());
        UIManager.put("TabbedPane.tabsOverlapBorder", false);
        UIManager.put("TabbedPane.tabAreaInsets", new Insets(0,0,0,0));
        UIManager.put("TabbedPane.highlight", colorUI.getColorTerciario());
        UIManager.put("TabbedPane.light", colorUI.getColorTerciario());
        UIManager.put("TabbedPane.tabAreaBackground", colorUI.getColorTerciario());
        UIManager.put("TabbedPane.tabsOverlapBorder", false);
        UIManager.put("TabbedPane.darkShadow", colorUI.getColorTerciario());
        UIManager.put("TabbedPane.selectHighlight", colorUI.getColorTerciario());
        UIManager.put("TabbedPane.selectionFollowsFocus", false);
        UIManager.put("TabbedPane.selectedTabPadInsets", new Insets(0,0,0,0));
        UIManager.put("TabbedPane.shadow", colorUI.getColorTerciario());
        //UIManager.put("TabbedPane.font", this.fuente);
        UIManager.put("TabbedPane.background", colorUI.getColorTerciario());
        UIManager.put("TabbedPane.foreground", colorUI.getColorForeground());
    }

    @Override
    public void crearDisenio() {

    }
}
