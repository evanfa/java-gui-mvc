package view.display.main.form;

import data.pass.colors.ColorsEnum;
import model.functions.StreamSearch;
import startup.init.start.InitStartup;
import startup.init.vault.loader.utils.SysSettingsLoader;
import view.display.main.imgs.ImgsLoader;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;

public class SearcherForm extends JFrame{
    private JPanel mainContainerPanel;
    private JTabbedPane tabContainerPanel;
    private JPanel fastSearchForm;
    private JPanel configPanelForm;
    private JTextField inputSearch;
    private JButton btnSearch;
    private JLabel lblInputSearch;
    private JLabel lblSelectPath;
    private JComboBox selectPathCombobox;
    private JTable searchResult;
    private JPanel resultContanierPanel;
    private JToolBar footerToolBar;
    private JLabel lblResultInfo;
    private JButton addButton;
    private JButton clearButton;
    private JButton downloadButton;
    private JToggleButton btnCSVSearch;
    private JToggleButton btnDBSearch;



    public SearcherForm() {
        setContentPane(mainContainerPanel);
        createUIComponents();
        updateSelectableItems();
    }

    public void createUIComponents(){
        /*System Vars*/
        SysSettingsLoader.setMainPanel(mainContainerPanel);

        /*Tabs Settings*/
        tabContainerPanel.addTab("Fast Search", ImgsLoader.getSearchIcon(), fastSearchForm, null);
        tabContainerPanel.addTab("Config", ImgsLoader.getConfgIcon(), configPanelForm, null);

        /*Update Buttons*/
        updateAddButton(false);
        updateClearButton(false);
        updateProccessButton(false);

        /*ToggleButton Setting*/
        btnDBSearch.setIcon(ImgsLoader.getServerDbIcon());
        btnDBSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("BD Search");

            }
        });

        btnCSVSearch.setIcon(ImgsLoader.getCsvIcon());
        btnCSVSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("CSV Search");

            }
        });

        btnSearch.setIcon(ImgsLoader.getExecIcon());
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ArrayList<String> resultSearch = StreamSearch.execSearchInCSV(inputSearch.getText());
                if(!resultSearch.isEmpty() && resultSearch.size()>0){
                    System.out.println("Records Found: "+resultSearch.size());

                    resultSearch.stream().forEach(System.out::println);
                }else{
                    JOptionPane.showMessageDialog(null, "Non Match Found ", "Error - No coincidences found", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        addButton.setIcon(ImgsLoader.getAddIcon());
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        clearButton.setIcon(ImgsLoader.getBdIcon());
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        downloadButton.setIcon(ImgsLoader.getDownLoadIcon());
        downloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        selectPathCombobox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    InitStartup.loadTotalRecordsFromCSVFile(selectPathCombobox.getSelectedItem().toString());
                    lblResultInfo.setText("Loaded "+InitStartup.getCsvTotalRows()+" records.");
                    lblResultInfo.setForeground(ColorsEnum.BLUE_TEMPER.getColor());
                }
            }
        });
    }
    
    public void updateSelectableItems(){
        for (int i = 1; i < InitStartup.getPathsList().size(); i++) {
            selectPathCombobox.addItem(InitStartup.getPathsList().get(i));
        }
    }

    public void updateAddButton(boolean flag)
    {
        if(flag){
            addButton.setBorderPainted(true);
            addButton.setEnabled(true);
        }else{
            addButton.setBorderPainted(false);
            addButton.setEnabled(false);
        }
    }

    public void updateClearButton(boolean flag)
    {
        if(flag){
            clearButton.setBorderPainted(true);
            clearButton.setEnabled(true);
        }else{
            clearButton.setBorderPainted(false);
            clearButton.setEnabled(false);
        }
    }

    public void updateProccessButton(boolean flag){
        if(flag){
            downloadButton.setBorderPainted(true);
            downloadButton.setEnabled(true);
        }else{
            downloadButton.setBorderPainted(false);
            downloadButton.setEnabled(false);
        }
    }


    public static void main(String[] args) throws IOException {

        InitStartup initSart = new InitStartup();

        SwingUtilities.invokeLater(() -> {
            JFrame j = new JFrame("Permits Documents Downloader Manager - Ver. 2.1.0.2022");
            j.setContentPane(new SearcherForm().mainContainerPanel);
            j.setSize((int)Math.round(SysSettingsLoader.getScreenHeight()*.963),(int)Math.round(SysSettingsLoader.getScreenWidth()*.6712));
            j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            j.setVisible(true);
            j.pack();
                }
        );

    }

}
