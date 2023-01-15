package view.display.main;

import startup.init.start.InitStartup;
import startup.init.vault.loader.utils.SysSettingsLoader;
import view.display.main.form.SearcherForm;

import javax.swing.*;
import java.io.IOException;

public class GUIRunner {

    public static void main(String[] args) throws IOException{
        InitStartup ptL = new InitStartup();

        SwingUtilities.invokeLater(() -> {
                    JFrame j = new JFrame("Permits Documents Downloader Manager - Ver. 2.1.0.2022");
                    j.setContentPane(new SearcherForm().getContentPane());
                    j.setSize((int)Math.round(SysSettingsLoader.getScreenHeight()*.963),(int)Math.round(SysSettingsLoader.getScreenWidth()*.6712));
                    j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    j.setVisible(true);
                    j.pack();
                });
    }
}
