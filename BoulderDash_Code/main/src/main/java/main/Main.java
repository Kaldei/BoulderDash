/**
 * @author Laetitia, Arthur, Anthony
 * @version 1.0.8
 */
package main;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import contract.IBoulderDashController;
import contract.IModel;
import controller.Controller;
import model.BoulderDashModel;
import model.DAO.DAOMap;
import view.View;

import javax.swing.*;

/**
 * The Class Main.
 *
 * @author Laetitia, Arthur, Anthony
 */
public abstract class Main {


    private static String[] filenames = new String[] {"map.txt", "sprites/background.png", "sprites/boulder.png", "sprites/diamond.png", "sprites/door.png", "sprites/greenMonster.png", "sprites/ground.png", "sprites/pDead.png", "sprites/pDown.png", "sprites/pLeft.png", "sprites/pNope.png", "sprites/pRight.png", "sprites/pUp.png", "sprites/pWin.png", "sprites/redMonster.png", "sprites/wall.png"};

    private static View view;
    private static IModel model;
    private static  IBoulderDashController controller;

    /**
     * The main method.
     *
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(final String[] args) {
        checkFiles();
        menu();
        game();

        System.exit(0);
    }



    static void checkFiles() {
        File file;
        for (String filename : filenames) {
            file = new File(filename);
            if (!file.exists()){
                JOptionPane.showMessageDialog(null, "File \"" + filename + "\" is missing.\nPlease put the file back in its place and then restart.", "BoulderDash - Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
                return;
            }
        }
    }

    static void menu() {

        int choice = JOptionPane.showInternalConfirmDialog(null, "Do you want to load a map from database?", "BloulderDash - Menu",JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        DAOMap databaseConnection = null;
        Object[] maps = null;

        if (choice == 0) {
            try {
                databaseConnection = new DAOMap();
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Can't connect to database!\nLaunching game without loading a new map.", "BoulderDash - Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                maps = databaseConnection.getLevels();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Can't retrieve map from database!\nLaunching game without loading a new map.", "BoulderDash - Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String map = (String)JOptionPane.showInputDialog(null, "Which map do you want to load?", "BoulderDash - Load map", JOptionPane.PLAIN_MESSAGE, null, maps, maps[0]);

            if (map != null) {
                try {
                    databaseConnection.loadlevel(filenames[0], map);
                } catch ( SQLException | IOException e) {
                    JOptionPane.showMessageDialog(null, "Can't load map into map file!\nLaunching game without loading a new map.", "BoulderDash - Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            return;
        }
    }

    static void game() {
        do {
            model = new BoulderDashModel(filenames[0], 1, 1);

            if (model.getMap().isCorrect()) {
                view = new View(model.getMap(), model.getMyPlayer());
                controller = new Controller(view, model);
                view.setOrderPerformer(controller.getOrderPerformer());

                controller.play();

            } else {
                JOptionPane.showMessageDialog(null, "The map isn't in the right format!\nCheck your map file (map.txt).", "BoulderDash - Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        while(true);
    }
}
