package com.example.thehunt;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Lobo extends ObjetoJuego {
    private int hambre;
    private int vidas;
    public Lobo(int x, int y, String nombreImagen) {
        super(x, y, nombreImagen);
        this.velocidad=5;
        this.hambre = 40;
        this.ancho=225;
        this.alto=100;
        this.vidas=4;
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

    public int getHambre() {
        return hambre;
    }

    public void setHambre(int hambre) {
        this.hambre = hambre;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }
    @Override
    public void pintar(GraphicsContext graphicsContext){
        graphicsContext.drawImage(MainApp.imagenes.get(nombreImagen),x,y);
    }

    @Override
    public void mover(){
        if (MainApp.derecha && x<=850){
            x+=velocidad;
        }
        if (MainApp.izquierda && x>=20){
            x-=(velocidad*6);
        }
        if (MainApp.abajo && y<=460){
            y+=(velocidad*2);
        }
        if (MainApp.arriba && y>=30){
            y-=(velocidad*2);
        }
    }

    public Rectangle obtenerRectangle(){
        return new Rectangle(x+30,y+20,ancho-30,alto-50);
    }

    public void verificarColisionesCiervo(Ciervo ciervo){
        if(this.obtenerRectangle().getBoundsInLocal().intersects(ciervo.obtenerRectangle().getBoundsInLocal())){
            hambre--;
            ciervo.setX(-200);
            if (hambre<1){
                MainApp.bVictory=true;
            }

        }

    }

    public void verificarColisionesAbejas(Abejas abejas){
        if(this.obtenerRectangle().getBoundsInLocal().intersects(abejas.obtenerRectangle().getBoundsInLocal())){
            vidas--;
            abejas.setX(-200);
            if (vidas<1){
                MainApp.bLose=true;
            }

        }

    }
}
