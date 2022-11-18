package data.pass.colors.modes;

import data.pass.colors.ColorsEnum;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class ColorTemplate {

    public static void darkMode(){

    }

    public static void deepBlueMode_JTabbedPanel(JTabbedPane jT){
        Component[] components = jT.getComponents();
        Arrays.stream(components).forEach(item->{

            item.setForeground(Color.WHITE);
            item.setBackground(ColorsEnum.NAVY_BLACK.getColor());
        });
    }

    public static void deepBlueMode_JPanel(JPanel jT){
        Component[] components = jT.getComponents();
        Arrays.stream(components).forEach(item->{

            if(item instanceof JToolBar){
                deepBlueMode_JToolBar((JToolBar) item);
            }

            if(item instanceof JPanel){
                deepBlueMode_JPanel((JPanel) item);
            }

            if(item instanceof JScrollPane){
                deepBlueMode_JScrollPane((JScrollPane) item);
            }

            item.setBackground(ColorsEnum.NAVY_BLACK.getColor());
            item.setForeground(Color.WHITE);
        });
    }

    //System.out.println(item.getClass().toString());

    public static void deepBlueMode_JTable(JTable jT){
        jT.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
        jT.setGridColor(ColorsEnum.BLUE_TARO.getColor());
        jT.getTableHeader().setBackground(ColorsEnum.BLACK_DARK.getColor());
        jT.getTableHeader().setForeground(Color.WHITE);
        jT.setSelectionBackground(ColorsEnum.NAVY_EXLIGHT.getColor());
        jT.setSelectionForeground(Color.WHITE);
        jT.setBackground(ColorsEnum.NAVY_BLACK.getColor());
        jT.setForeground(Color.WHITE);
    }

    public static void deepBlueMode_JToolBar(JToolBar jT){
        Component[] components = jT.getComponents();
        Arrays.stream(components).forEach(item->{

            System.out.println("TOOLBAR: "+item.getClass().toString());

            if(item instanceof JComboBox){
                deepBlueMode_JList((JComboBox) item);
            }

            if(item instanceof JButton){
                deepBlueMode_JButton((JButton) item);
            }

            item.setForeground(Color.WHITE);
            item.setBackground(ColorsEnum.NAVY_BLACK.getColor());
        });
    }

    public static void deepBlueMode_JButton(JButton jP){
        jP.setBackground(ColorsEnum.BLACK_DARK.getColor());
        jP.setForeground(Color.WHITE);
    }

    public static void deepBlueMode_JList(JComboBox jC){
        jC.setBackground(ColorsEnum.NAVY_BLACK.getColor());
        jC.setForeground(Color.WHITE);
        jC.setFont(new Font("Tahoma", Font.BOLD, 12));
    }

    public static void deepBlueMode_JScrollPane(JScrollPane jC){
        Component[] components = jC.getComponents();

        Arrays.stream(components).forEach(item-> {
            System.out.println("SCROLL: "+item.getClass().toString());


            if(item instanceof JViewport){
                deepBlueMode_JViewPort((JViewport) item);
            }

                });

        jC.setBackground(ColorsEnum.NAVY_BLACK.getColor());
        jC.setForeground(Color.WHITE);
        jC.setFont(new Font("Tahoma", Font.BOLD, 12));
    }

    public static void deepBlueMode_JViewPort(JViewport jV){
        Component[] components = jV.getComponents();

        Arrays.stream(components).forEach(item-> {
            System.out.println("JVIEWPORT: "+item.getClass().toString());
            if (item instanceof JTable) {
                deepBlueMode_JTable((JTable) item);
            }
        });
    }

}
