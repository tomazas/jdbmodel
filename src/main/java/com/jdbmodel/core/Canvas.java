package com.jdbmodel.core;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

public class Canvas extends JPanel {
    
    final static Color TOP_HEADER = new Color(221, 231, 248);
    final int HEADER_HEIGHT = 30;
    final int CORNER_SIZE = 20;
    final int TAB_SIZE = 20;
    
    private void drawTable(Graphics2D g2, String title, int x, int y, int w, int h) {
        
        // header
        GradientPaint grad = new GradientPaint(x, y, TOP_HEADER, x, y+HEADER_HEIGHT/2, Color.WHITE, true);
        g2.setPaint(grad);
        g2.fill(new RoundRectangle2D.Float(x, y, w, h, CORNER_SIZE, CORNER_SIZE));
        
        // title
        int size = g2.getFontMetrics().stringWidth(title);;
        g2.setColor(Color.BLACK);
        g2.drawString(title, x+size/2, y+HEADER_HEIGHT/1.5f);
        
        g2.setColor(Color.WHITE);
        g2.fill(new Rectangle.Float(x,y+HEADER_HEIGHT,x+w,y+h-CORNER_SIZE));
        
        // frame/border
        g2.setColor(Color.GRAY);
        g2.drawRoundRect(x, y, w, h, CORNER_SIZE, CORNER_SIZE);
        g2.drawLine(x, y+HEADER_HEIGHT, x+w, y+HEADER_HEIGHT);
        g2.drawLine(x+TAB_SIZE, y+HEADER_HEIGHT, x+TAB_SIZE, y+h);
        
        // fields
        g2.setColor(Color.BLACK);
        g2.drawString("ADDRESS varchar(10)", x+10, y+50);//TODO: fix
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        drawTable(g2, "RUNTIME_INFO", 10, 10, 200, 300);
    }
}
