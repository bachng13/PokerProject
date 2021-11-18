/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PokerProject;

/**
 *
 * @author User 1
 */

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Dimension;
import java.util.ArrayList;

public class imagesHandler extends javax.swing.JPanel {
    private Image cardImage1;
    private Image cardImage2;
    
    public imagesHandler(){
        
    }
    
    public Image getImages1(){
        return cardImage1;           
    }
    
    public Image getImages2(){
        return cardImage2;
    }
    
    public void setImage(Image image){
        this.cardImage1 = image;
        Dimension size = new Dimension(this.getWidth(),this.getHeight());
        this.setPreferredSize(size);
        this.setMinimumSize(size);
        this.setMaximumSize(size);
        this.setSize(size);
        this.setOpaque(true);
    }
    
    public void paintComponent(Graphics g){
        if(this.cardImage1!=null){
            g.drawImage(cardImage1, 0,0,this.getWidth() , this.getHeight(), null);
        }
    }

    void setSize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}