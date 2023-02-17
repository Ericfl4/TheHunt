package com.example.thehunt;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Abejas extends ObjetoJuego {

    public Abejas(int x, int y, String nombreImagen) {
        super(x, y, nombreImagen);
        this.velocidad=15;
        this.ancho=50;
        this.alto=50;
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
        return new Rectangle(x,y,ancho,alto);
    }

}
