/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.modelo;

import java.awt.Color;

/**
 *
 * @author JOHAO MORALES, MAYCOL TITUAÑA, ALEX VELASTEGUI
 */
public class Pelota {
    public static final int TAMX = 15;
    public static final int TAMY = 15;
    public double x;
    public double y;
    public double dx;
    public double dy;
    private Color color;

    public Pelota() {
        this.x = 0;
        this.y = 0;
        this.dx = 1;
        this.dy = 1;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
