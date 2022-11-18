package view.display.main.form;

import data.pass.colors.ColorsEnum;
import data.pass.colors.modes.ColorTemplate;
import model.JTableTemplate_Download;
import model.TableModelTemplate;
import model.functions.StreamSearch;
import model.objects.Record;
import startup.init.start.InitStartup;
import startup.init.vault.loader.utils.SysSettingsLoader;
import view.display.main.imgs.ImgsLoader;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;
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
    private JLabel lblInputSearch;
    private JLabel lblSelectPath;
    private JComboBox selectPathCombobox;
    private JTable searchResult;
    private JPanel resultContanierPanel;
    private JToolBar footerToolBar;
    private JLabel lblResultInfo;
    private JButton btnSearch;
    private JButton addButton;
    private JButton clearButton;
    private JButton downloadButton;
    private JToggleButton btnCSVSearch;
    private JToggleButton btnDBSearch;
    private JToolBar actionsToolBar;
    private JToolBar searcherToolBar;
    private JToolBar pathToolBar;
    private JScrollPane scrollPanelContent;
    private JTable srchResult_JTable;
    private TableColumnModel columnModel;
    private TableModelTemplate tableModel;
    private JTableTemplate_Download tableDownloadModel;
    private ArrayList<Record> resultSearch;

    public SearcherForm() {
        setContentPane(mainContainerPanel);
        createUIComponents();
        updateSelectableItems();
    }

    public void createUIComponents(){
        /*System Vars*/
        SysSettingsLoader.setMainPanel(mainContainerPanel);

        //UIManager.put("TabbedPane.selected", Color.red);
        //tabContainerPanel = new JTabbedPane();

        /*Tabs Settings*/
        tabContainerPanel.addTab("Fast Search", ImgsLoader.getSearchIcon(), fastSearchForm, null);
        tabContainerPanel.addTab("Config", ImgsLoader.getConfgIcon(), configPanelForm, null);
        tabContainerPanel.setFocusable(false);

        /*Update Buttons*/
        updateAddButton(false);
        updateClearButton(false);
        updateProccessButton(false);

        pathToolBar.setFloatable(false);
        actionsToolBar.setFloatable(false);
        searcherToolBar.setFloatable(false);
        footerToolBar.setFloatable(false);

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
                //ArrayList<String> resultSearch = StreamSearch.execSearchInCSV(inputSearch.getText());
                String inputValue = inputSearch.getText();
                System.out.println("Input to Search: "+inputValue);
                if(inputValue != null|| inputValue.length()>2) {

                    resultSearch = StreamSearch.execSearchInCSVtoRecord(inputSearch.getText());
                    if (!resultSearch.isEmpty() && resultSearch.size() > 0) {
                        System.out.println("Records Found: " + resultSearch.size());

                        /*New table model for display result data set*/
                        /*------------------------------------------------*/
                        tableModel = new TableModelTemplate();
                        /*------------------------------------------------*/
                        /*New table model Created when exist a result in current execution*/
                        /*------------------------------------------------*/
                        tableDownloadModel = new JTableTemplate_Download();
                        /*------------------------------------------------*/
                        //resultSearch.stream().forEach(System.out::println);
                        tableModel.setListItemsFound(resultSearch);

                        /*-------------------SET COLORS-----------------------------*/

                        ColorTemplate.deepBlueMode_JPanel(mainContainerPanel);
                        ColorTemplate.deepBlueMode_JTabbedPanel(tabContainerPanel);
                        ColorTemplate.deepBlueMode_JPanel(fastSearchForm);
                        ColorTemplate.deepBlueMode_JPanel(resultContanierPanel);

                        //ColorTemplate.deepBlueMode_JScrollPanel(scrollPanelContent);

                        //UIManager.put("TabbedPane.selected", Color.red);
                        //tabContainerPanel.getSelectedComponent().setFocusable(false);

                        /*ColorTemplate.deepBlueMode_JTable(searchResult);
                        ColorTemplate.deepBlueMode_JToolBar(pathToolBar);

                        ColorTemplate.deepBlueMode_JToolBar(actionsToolBar);
                        ColorTemplate.deepBlueMode_JToolBar(searcherToolBar);
                        ColorTemplate.deepBlueMode_JToolBar(footerToolBar);

                        ColorTemplate.deepBlueMode_JPanel(mainContainerPanel);

                         */

                        /*ColorTemplate.deepBlueMode_JPanel(mainContainerPanel);
                        ColorTemplate.deepBlueMode_JButton(btnSearch);
                        ColorTemplate.deepBlueMode_JButton(addButton);
                        ColorTemplate.deepBlueMode_JButton(clearButton);
                        ColorTemplate.deepBlueMode_JButton(downloadButton);
                        ColorTemplate.deepBlueMode_JList(selectPathCombobox);*/
                        /*----------------------------------------------------------*/

                        searchResult.setModel(tableModel);

                        columnModel = searchResult.getColumnModel();
                        columnModel.getColumn(0).setPreferredWidth((int) Math.round(searchResult.getWidth() * .035));
                        columnModel.getColumn(1).setPreferredWidth((int) Math.round(searchResult.getWidth() * .185));
                        columnModel.getColumn(2).setPreferredWidth((int) Math.round(searchResult.getWidth() * .75));
                        columnModel.getColumn(3).setPreferredWidth((int) Math.round(searchResult.getWidth() * .047));

                        updateAddButton(true);
                        updateClearButton(true);
                        updateProccessButton(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Non Match Found ", "Error - No coincidences found", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                        updateAddButton(false);
                        updateClearButton(false);
                        updateProccessButton(false);

                        JOptionPane.showMessageDialog(null,"Empty Input Field", "Error",JOptionPane.ERROR_MESSAGE);
                        lblResultInfo.setText("Empty search field");
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
