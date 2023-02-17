package com.example.thehunt;

import javafx.scene.canvas.GraphicsContext;

public class Fondo extends ObjetoJuego{
    private String nombreImagen2;
    private int x2;
    public Fondo(int x, int y, String nombreImagen, String nombreImagen2, int velocidad) {
        super(x, y, nombreImagen);
        this.nombreImagen2=nombreImagen2;
        this.ancho= (int) MainApp.imagenes.get("fondo").getWidth();
        this.alto= (int) MainApp.imagenes.get("fondo").getHeight();
        this.x2=this.ancho+this.x;
        this.velocidad=20;
    }

    @Override
    public void pintar(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(MainApp.imagenes.get(nombreImagen),this.x,this.y);
        graphicsContext.drawImage(MainApp.imagenes.get(nombreImagen),this.x2,this.y);
    }

    @Override
    public void mover() {
        if (x<=-1*ancho){
            x=ancho;
        }
        if (x2<=-1*ancho){
            x2=ancho;
        }
        x-=velocidad;
        x2-=velocidad;
    }
}
