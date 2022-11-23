package view.display.custom.components;

import javax.swing.*;
import javax.swing.plaf.TabbedPaneUI;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;

public class ExTabbedPane extends BasicTabbedPaneUI implements IComponents {
    private static ColorUI colorUI;
    private Font fuente;

    public ExTabbedPane(Font fuente) {
        this.fuente = fuente;
    }
    
    public ExTabbedPane(ColorUI colorUI){
        ExTabbedPane.colorUI = colorUI;
    }
    
    public static ColorUI getColorUI() {
        return colorUI;
    }

    public static void setColorUI(ColorUI aColorUI) {
        colorUI = aColorUI;
    }
    
    
    public static TabbedPaneUI createUI(JComponent c){
        return new ExTabbedPane(colorUI);
    }
    
    @Override
    public void crearDisenio(){
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
        UIManager.put("TabbedPane.font", this.fuente);
        UIManager.put("TabbedPane.background", colorUI.getColorTerciario());
        UIManager.put("TabbedPane.foreground", colorUI.getColorForeground());
        //UIManager.put("TabbedPane.tabsOverlapBorder", false);
        //UIManager.put("TabbedPane.tabsOpaque", true);
    }

    public Font getFuente() {
        return fuente;
    }

    public void setFuente(Font fuente) {
        this.fuente = fuente;
    }
    
    @Override
    public void modificarUI(JComponent c){
        if(c instanceof JTabbedPane){
            JTabbedPane tp = (JTabbedPane)c;
            tp.setUI(this);
        }
        
    }
    
    public void modificarUI(JTabbedPane... tps) throws IllegalArgumentException{
        if(tps.length == 0){
            throw new IllegalArgumentException("Debe haber por lo menos un argumento de entrada en la funci�n");
        }
        
        for(int i = 0 ; i < tps.length; i++){
            tps[i].setUI(this);
        }
    }
    
    
}