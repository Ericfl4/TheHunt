package com.example.thehunt;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

public class MainApp extends Application {
    public static boolean bVictory;
    public static boolean bLose;
    private GraphicsContext graphicsContext;
    private Group root;
    private Scene scene;
    private Canvas canvas;
    private Lobo lobo;
    private Ciervo ciervo, ciervo2, ciervo3;
    private Abejas abejas, abejas2;
    private Fondo fondo;
    public static boolean arriba;
    public static boolean abajo;
    public static boolean izquierda;
    public static boolean derecha;
    public static HashMap<String, Image> imagenes;
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws IOException {
        iniciarComponentes();
        gestionEventos();
        stage.setScene(scene);
        stage.setTitle("The Hunt");
        stage.show();
        cicloJuego();
    }

    public void cicloJuego(){

        long tiempoInicial = System.nanoTime();
        AnimationTimer animationTimer = new AnimationTimer() {
            //Este metodo se ejecuta unas 60 veces por segundo
            Media juego = new Media(getClass().getResource("audio/musica.mp3").toExternalForm());
            MediaPlayer mediaJuego = new MediaPlayer(juego);
            Media derrota = new Media(getClass().getResource("audio/derrota.mp3").toExternalForm());
            MediaPlayer mediaDerrota = new MediaPlayer(derrota);

            Media victoria = new Media(getClass().getResource("audio/victoria.mp3").toExternalForm());
            MediaPlayer mediaVictoria = new MediaPlayer(victoria);

            @Override
            public void handle(long tiempoActual) {
                if (!bVictory && !bLose){
                double t = (tiempoActual - tiempoInicial) / 1000000000.0;
                System.out.println(t);
                System.out.println(bVictory);
                actualizarEstado();
                pintar();
                    mediaJuego.play();
                } else if (bVictory) {
                    mediaJuego.pause();
                    mediaVictoria.play();
                    graphicsContext.drawImage(MainApp.imagenes.get("fondovictoria"),0,0);
                } else if (bLose) {
                    mediaJuego.pause();
                    mediaDerrota.play();
                    graphicsContext.drawImage(MainApp.imagenes.get("fondoderrota"),0,0);
                }

            }
        };
        animationTimer.start();//Empieza el ciclo de juego

    }
    private void actualizarEstado() {
        if (lobo.getNombreImagen()=="lobo1"){
            lobo.setNombreImagen("lobo2");
        } else if (lobo.getNombreImagen()=="lobo2") {
            lobo.setNombreImagen("lobo3");
        } else if (lobo.getNombreImagen()=="lobo3") {
            lobo.setNombreImagen("lobo4");
        } else if (lobo.getNombreImagen()=="lobo4") {
            lobo.setNombreImagen("lobo5");
        } else if (lobo.getNombreImagen()=="lobo5") {
            lobo.setNombreImagen("lobo6");
        } else if (lobo.getNombreImagen()=="lobo6") {
            lobo.setNombreImagen("lobo7");
        } else if (lobo.getNombreImagen()=="lobo7") {
            lobo.setNombreImagen("lobo8");
        } else if (lobo.getNombreImagen()=="lobo8") {
            lobo.setNombreImagen("lobo1");
        }

        if (ciervo.getNombreImagen()=="ciervo1"){
            ciervo.setNombreImagen("ciervo2");
        } else if (ciervo.getNombreImagen()=="ciervo2") {
            ciervo.setNombreImagen("ciervo3");
        } else if (ciervo.getNombreImagen()=="ciervo3") {
            ciervo.setNombreImagen("ciervo4");
        } else if (ciervo.getNombreImagen()=="ciervo4") {
            ciervo.setNombreImagen("ciervo5");
        } else if (ciervo.getNombreImagen()=="ciervo5") {
            ciervo.setNombreImagen("ciervo6");
        } else if (ciervo.getNombreImagen()=="ciervo6") {
            ciervo.setNombreImagen("ciervo7");
        } else if (ciervo.getNombreImagen()=="ciervo7") {
            ciervo.setNombreImagen("ciervo8");
        } else if (ciervo.getNombreImagen()=="ciervo8") {
            ciervo.setNombreImagen("ciervo9");
        } else if (ciervo.getNombreImagen()=="ciervo9") {
            ciervo.setNombreImagen("ciervo10");
        } else if (ciervo.getNombreImagen()=="ciervo10") {
            ciervo.setNombreImagen("ciervo1");
        }

        if (ciervo2.getNombreImagen()=="ciervo1"){
            ciervo2.setNombreImagen("ciervo2");
        } else if (ciervo2.getNombreImagen()=="ciervo2") {
            ciervo2.setNombreImagen("ciervo3");
        } else if (ciervo2.getNombreImagen()=="ciervo3") {
            ciervo2.setNombreImagen("ciervo4");
        } else if (ciervo2.getNombreImagen()=="ciervo4") {
            ciervo2.setNombreImagen("ciervo5");
        } else if (ciervo2.getNombreImagen()=="ciervo5") {
            ciervo2.setNombreImagen("ciervo6");
        } else if (ciervo2.getNombreImagen()=="ciervo6") {
            ciervo2.setNombreImagen("ciervo7");
        } else if (ciervo2.getNombreImagen()=="ciervo7") {
            ciervo2.setNombreImagen("ciervo8");
        } else if (ciervo2.getNombreImagen()=="ciervo8") {
            ciervo2.setNombreImagen("ciervo9");
        } else if (ciervo2.getNombreImagen()=="ciervo9") {
            ciervo2.setNombreImagen("ciervo10");
        } else if (ciervo2.getNombreImagen()=="ciervo10") {
            ciervo2.setNombreImagen("ciervo1");
        }

        if (ciervo3.getNombreImagen()=="ciervo1"){
            ciervo3.setNombreImagen("ciervo2");
        } else if (ciervo3.getNombreImagen()=="ciervo2") {
            ciervo3.setNombreImagen("ciervo3");
        } else if (ciervo3.getNombreImagen()=="ciervo3") {
            ciervo3.setNombreImagen("ciervo4");
        } else if (ciervo3.getNombreImagen()=="ciervo4") {
            ciervo3.setNombreImagen("ciervo5");
        } else if (ciervo3.getNombreImagen()=="ciervo5") {
            ciervo3.setNombreImagen("ciervo6");
        } else if (ciervo3.getNombreImagen()=="ciervo6") {
            ciervo3.setNombreImagen("ciervo7");
        } else if (ciervo3.getNombreImagen()=="ciervo7") {
            ciervo3.setNombreImagen("ciervo8");
        } else if (ciervo3.getNombreImagen()=="ciervo8") {
            ciervo3.setNombreImagen("ciervo9");
        } else if (ciervo3.getNombreImagen()=="ciervo9") {
            ciervo3.setNombreImagen("ciervo10");
        } else if (ciervo3.getNombreImagen()=="ciervo10") {
            ciervo3.setNombreImagen("ciervo1");
        }


        lobo.mover();
        ciervo.mover();
        ciervo2.mover();
        ciervo3.mover();
        abejas.mover();
        abejas2.mover();
        fondo.mover();
        lobo.verificarColisionesCiervo(ciervo);
        lobo.verificarColisionesCiervo(ciervo2);
        lobo.verificarColisionesCiervo(ciervo3);
        lobo.verificarColisionesAbejas(abejas);
        lobo.verificarColisionesAbejas(abejas2);


    }
    public void iniciarComponentes(){
        imagenes = new HashMap<String, Image>();
        cargarImagenes();
        lobo = new Lobo(20,300,"lobo1");
        ciervo = new Ciervo(2000,320,"ciervo1");
        ciervo2 = new Ciervo(2200,000,"ciervo1");
        ciervo3 = new Ciervo(2400,100,"ciervo1");
        abejas = new Abejas(2300,200,"abeja1");
        abejas2 = new Abejas(2600,400,"abeja1");
        fondo = new Fondo(0,0,"fondo","fondo2",20);
        root = new Group();
        scene = new Scene(root,1100,600);
        canvas = new Canvas(1100,600);
        root.getChildren().add(canvas);
        graphicsContext = canvas.getGraphicsContext2D();
    }
    public void cargarImagenes(){
        imagenes.put("lobo1", new Image(MainApp.class.getResource("images/lobo1.png").toExternalForm()));
        imagenes.put("lobo2", new Image(MainApp.class.getResource("images/lobo2.png").toExternalForm()));
        imagenes.put("lobo3", new Image(MainApp.class.getResource("images/lobo3.png").toExternalForm()));
        imagenes.put("lobo4", new Image(MainApp.class.getResource("images/lobo4.png").toExternalForm()));
        imagenes.put("lobo5", new Image(MainApp.class.getResource("images/lobo5.png").toExternalForm()));
        imagenes.put("lobo6", new Image(MainApp.class.getResource("images/lobo6.png").toExternalForm()));
        imagenes.put("lobo7", new Image(MainApp.class.getResource("images/lobo7.png").toExternalForm()));
        imagenes.put("lobo8", new Image(MainApp.class.getResource("images/lobo8.png").toExternalForm()));
        imagenes.put("ciervo1", new Image(MainApp.class.getResource("images/ciervo1.png").toExternalForm()));
        imagenes.put("ciervo2", new Image(MainApp.class.getResource("images/ciervo2.png").toExternalForm()));
        imagenes.put("ciervo3", new Image(MainApp.class.getResource("images/ciervo3.png").toExternalForm()));
        imagenes.put("ciervo4", new Image(MainApp.class.getResource("images/ciervo4.png").toExternalForm()));
        imagenes.put("ciervo5", new Image(MainApp.class.getResource("images/ciervo5.png").toExternalForm()));
        imagenes.put("ciervo6", new Image(MainApp.class.getResource("images/ciervo6.png").toExternalForm()));
        imagenes.put("ciervo7", new Image(MainApp.class.getResource("images/ciervo7.png").toExternalForm()));
        imagenes.put("ciervo8", new Image(MainApp.class.getResource("images/ciervo8.png").toExternalForm()));
        imagenes.put("ciervo9", new Image(MainApp.class.getResource("images/ciervo9.png").toExternalForm()));
        imagenes.put("ciervo10", new Image(MainApp.class.getResource("images/ciervo10.png").toExternalForm()));
        imagenes.put("abeja1", new Image(MainApp.class.getResource("images/abeja1.png").toExternalForm()));
        imagenes.put("fondo", new Image(MainApp.class.getResource("images/fondo.png").toExternalForm()));
        imagenes.put("fondo2", new Image(MainApp.class.getResource("images/fondo2.png").toExternalForm()));
        imagenes.put("fondovictoria", new Image(MainApp.class.getResource("images/fondovictoria.png").toExternalForm()));
        imagenes.put("fondoderrota", new Image(MainApp.class.getResource("images/fondoderrota.png").toExternalForm()));
    }
    public void pintar(){
        fondo.pintar(graphicsContext);
        lobo.pintar(graphicsContext);
        ciervo.pintar(graphicsContext);
        ciervo2.pintar(graphicsContext);
        ciervo3.pintar(graphicsContext);
        abejas.pintar(graphicsContext);
        abejas2.pintar(graphicsContext);
        graphicsContext.fillText("Hambre "+lobo.getHambre(),20,20);
        graphicsContext.fillText("Vidas "+lobo.getVidas(),1000,20);
    }
    public void gestionEventos(){
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode().toString()){
                    case "RIGHT":
                        derecha=true;
                        break;
                    case "LEFT":
                        izquierda=true;
                        break;
                    case "UP":
                        arriba=true;
                        break;
                    case "DOWN":
                        abajo=true;
                        break;
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode().toString()){
                    case "RIGHT":
                        derecha=false;
                        break;
                    case "LEFT":
                        izquierda=false;
                        break;
                    case "UP":
                        arriba=false;
                        break;
                    case "DOWN":
                        abajo=false;
                        break;
                }
            }
        });
    }
}