package com.AdrGeoLouis.DicoAlgo;

import java.io.File;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Main {
	
	static Database db = new Database();
	static String path = System.getProperty("user.dir")+"DBFile.db";
	
	// TODO Programme principal
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (ClassNotFoundException ex) {}
        catch (InstantiationException ex) {} 
        catch (IllegalAccessException ex) {} 
        catch (UnsupportedLookAndFeelException ex) {}

    	SwingUtilities.invokeLater(new Runnable() {			
	        @Override
	        public void run() {
	            // TODO Appel page connexion inscription	        	
	            new FormMain();   
	            File f = new File(path);
	    		if(f.exists() && !f.isDirectory())
	    		{
	    			System.out.println("La database existe ");
	    		}else {
	    			System.out.println("Working Directory = " + System.getProperty("user.dir"));
	    		    db.createNewDatabase("DBFile.db");
	    		}
	        }
        });	
    }
}
