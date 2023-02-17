package com.example.thehunt;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;
import java.util.Random;

public class Ciervo extends ObjetoJuego {
    public Ciervo(int x, int y, String nombreImagen) {
        super(x, y, nombreImagen);
        this.velocidad=15;
        this.ancho=190;
        this.alto=160;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    @Override
    public void pintar(GraphicsContext graphicsContext){
        graphicsContext.drawImage(MainApp.imagenes.get(nombreImagen),x,y);
    }
    @Override
    public void mover(){
        if (x<=-200){
            setX(1300);
            setY((int) (Math.random()*460));
        }
        x-=velocidad;

    }
    public Rectangle obtenerRectangle(){
        return new Rectangle(x+30,y+50,ancho-30,alto-100);
    }

}
