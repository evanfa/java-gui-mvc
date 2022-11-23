package view.display.colors.modes;

import view.display.colors.ColorsEnum;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class ColorTemplate {

    public static void darkMode(){

    }

    public static void deepBlueMode_JTabbedPanel(JTabbedPane jT) /*throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException*/ {
        Component[] components = jT.getComponents();

        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        //SwingUtilities.updateComponentTreeUI(java.awt.Component);

        //System.out.println("Tabs count: "+jT.getTabCount());
        //jT.getSelectedComponent().setBackground(ColorsEnum.DARK_GRAYBLUE.getColor());
        //jT.getSelectedComponent().setBackground(ColorsEnum.ARENA.getColor());
        //jT.getSelectedComponent().setForeground(ColorsEnum.GRAY_LIGHT.getColor());

        //UIManager.put("TabbedPane.selected", Color.red);
        //tabContainerPanel.getSelectedComponent().setFocusable(false);

        //System.out.println("Selected Component: "+jT.getSelectedComponent().getName());

        for (int i = 0; i < jT.getTabCount(); i++) {
            jT.setBackgroundAt(i, ColorsEnum.BLACK_ONE.getColor());
            jT.setForegroundAt(i,Color.WHITE);
        }
        //jT.setBackgroundAt();

        Arrays.stream(components).forEach(item->{
            System.out.println("TABBED PANEL: "+item.getClass().toString()+"Item Name: "+item.getName());

            item.setForeground(Color.WHITE);
            item.setBackground(ColorsEnum.NAVY_BLACK.getColor());

            //UIManager.put("TabbedPane.unselectedBackground", ColorsEnum.BLUE_FOLDER.getColor());
            //jtp.setBackgroundAt(index, original);

        });
    }

    public static void deepBlueMode_JPanel(JPanel jT){
        Component[] components = jT.getComponents();
        Arrays.stream(components).forEach(item->{

            //System.out.println("JPANEL: "+item.getClass().toString()+"Item Name: "+item.getName());

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
        jT.setBackground(ColorsEnum.DARK_GRAYBLUE.getColor());
        jT.setForeground(Color.WHITE);
    }

    public static void deepBlueMode_JToolBar(JToolBar jT){
        jT.setFloatable(false);

        Component[] components = jT.getComponents();

        Arrays.stream(components).forEach(item->{
            //System.out.println("TOOLBAR: "+item.getClass().toString()+"Item Name: "+item.getName());

            if(item instanceof JComboBox){
                deepBlueMode_JList((JComboBox) item);
            }

            if(item instanceof JButton){
                deepBlueMode_JButton((JButton) item);
            }

            if(item instanceof JTextField){
                deepBlueMode_JTextField((JTextField) item);
            }

            if(item instanceof JToggleButton){
                deepBlueMode_JToggleButton((JToggleButton) item);
            }

            if(item instanceof JLabel){
                deepBlueMode_JLabel((JLabel) item);
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
        jC.setLightWeightPopupEnabled(true);
    }

    public static void deepBlueMode_JScrollPane(JScrollPane jC){
        Component[] components = jC.getComponents();

        Arrays.stream(components).forEach(item-> {
            //System.out.println("JCROLLPANE: " + item.getClass().toString() + "Item Name: " + item.getName());

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
            //System.out.println("JVIEWPORT: "+item.getClass().toString()+"Item Name: "+item.getName());

            if (item instanceof JTable) {
                deepBlueMode_JTable((JTable) item);
            }
        });
    }

     public static void deepBlueMode_JTextField(JTextField jV){
         Component[] components = jV.getComponents();
         Arrays.stream(components).forEach(item-> {
             item.setBackground(ColorsEnum.PURPLE_LIGHT.getColor());
             item.setForeground(ColorsEnum.NAVY_LIGHT.getColor());
             jV.setFont(new Font("Tahoma", Font.BOLD, 11));
        });
     }

    public static void deepBlueMode_JToggleButton(JToggleButton jV){
        Component[] components = jV.getComponents();
        Arrays.stream(components).forEach(item-> {

            System.out.println("JTOGGLEBUTTON: "+item.getClass().toString()+"Item Name: "+item.getName());
            item.setBackground(ColorsEnum.BLACK_ONE.getColor());
            item.setForeground(ColorsEnum.BLACK_ONE.getColor());
            jV.setFont(new Font("Tahoma", Font.BOLD, 11));
        });
    }

    public static void deepBlueMode_JLabel(JLabel jC){
        Component[] components = jC.getComponents();
        Arrays.stream(components).forEach(item-> {
            jC.setForeground(Color.WHITE);
        });
    }

}
