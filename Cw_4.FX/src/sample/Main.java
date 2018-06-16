package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.time.LocalTime;
import java.util.Collections;


public class Main extends Application {
    private Canvas canvas = new Canvas(600, 600);
    private GraphicsContext gc = canvas.getGraphicsContext2D();
    private Stage stage;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        stage.setTitle("Clock");
        Group root = new Group();
        root.getChildren().add(canvas);
        stage.setScene(new Scene(root));
        stage.show();

        new AnimationTimer() {
            @Override
            public void handle(long n) {
                drawClock();
            }
        }.start();
    }

    private void drawClock() {
        canvas.setWidth(stage.getWidth());
        canvas.setHeight(stage.getHeight());
        gc.clearRect(0, 0, 10000, 10000);
        gc.setStroke(Color.WHITE);
        gc.setFill(Color.GREY);
        gc.setLineWidth(1);
        double width=stage.getWidth();
        double height=stage.getHeight();
        double marginX= width/10;
        double marginY=height/10;
        double numberHeight = (height-2*marginY)/5;
        double plyWidth = (width-2*marginX)/5;
        double plyheiht = plyWidth/5;
        LocalTime time = LocalTime.now();
        checkTime(time.getHour()/10,marginX,marginY,plyWidth,plyheiht,numberHeight);
        checkTime(time.getHour()%10,marginX+marginX/10+plyWidth,marginY,plyWidth,plyheiht,numberHeight);
        gc.fillRect(2*plyWidth+marginX+marginX/5,numberHeight+marginY-marginY/5,marginX/5,marginY/5);
        gc.fillRect(2*plyWidth+marginX+marginX/5,numberHeight+marginY+marginY/5,marginX/5,marginY/5);
        checkTime(time.getMinute()/10,marginX+marginX/2+2*plyWidth,marginY,plyWidth,plyheiht,numberHeight);
        checkTime(time.getMinute()%10,marginX+marginX/2+3*plyWidth+marginX/10,marginY,plyWidth,plyheiht,numberHeight);
        checkTime(time.getSecond()/10,marginX+marginX/2+4*plyWidth+marginX/5,marginY+numberHeight,plyWidth/2,plyheiht/2,numberHeight/2);
        checkTime(time.getSecond()%10,marginX+marginX/2+4*plyWidth+marginX/4+plyWidth/2,marginY+numberHeight,plyWidth/2,plyheiht/2,numberHeight/2);
    }
    private void draw0(double marginX,double marginY, double plyWidth,double plyHeight, double numberHeight ) {
        double[] pxCenter = {
                marginX,
                marginX + plyWidth,
                marginX + plyWidth - plyHeight / 2,
                marginX + plyHeight / 2


        };
        double[] pxLeft = {
                marginX,
                marginX,
                marginX + plyHeight,
                marginX + plyHeight


        };
        double[] pxRight = {
                marginX + plyWidth,
                marginX + plyWidth,
                marginX + plyWidth - plyHeight,
                marginX + plyWidth - plyHeight
        };
        double[] pyCenter = {
                marginY,
                marginY,
                marginY + plyHeight,
                marginY + plyHeight

        };
        double[] pySide = {
                marginY,
                marginY + numberHeight,
                marginY + numberHeight - plyHeight / 2,
                marginY + plyHeight / 2

        };
        gc.setFill(Color.BLACK);
        gc.fillPolygon(pxCenter, pyCenter, 4);
        gc.fillPolygon(pxLeft, pySide, 4);
        gc.fillPolygon(pxRight, pySide, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);
        for (int i = 0; i < 4; i++) {
            pyCenter[i] += numberHeight;
            pySide[i] += numberHeight;
        }

        gc.fillPolygon(pxLeft, pySide, 4);
        gc.fillPolygon(pxRight, pySide, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);
        gc.setFill(Color.LIGHTGREY);
        gc.fillPolygon(pxCenter, pyCenter, 4);
        for (int i = 2; i < 4; i++) {
            pyCenter[i] -= 2 * plyHeight;
        }
        gc.fillPolygon(pxCenter, pyCenter, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);
        for (int i = 0; i < 4; i++) {
            pyCenter[i] += numberHeight;
        }
        gc.setFill(Color.BLACK);
        gc.fillPolygon(pxCenter, pyCenter, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);

    }
    private void draw1(double marginX,double marginY, double plyWidth,double plyHeight, double numberHeight ) {
        double[] pxCenter = {
                marginX,
                marginX + plyWidth,
                marginX + plyWidth - plyHeight / 2,
                marginX + plyHeight / 2


        };
        double[] pxLeft = {
                marginX,
                marginX,
                marginX + plyHeight,
                marginX + plyHeight


        };
        double[] pxRight = {
                marginX + plyWidth,
                marginX + plyWidth,
                marginX + plyWidth - plyHeight,
                marginX + plyWidth - plyHeight
        };
        double[] pyCenter = {
                marginY,
                marginY,
                marginY + plyHeight,
                marginY + plyHeight

        };
        double[] pySide = {
                marginY,
                marginY + numberHeight,
                marginY + numberHeight - plyHeight / 2,
                marginY + plyHeight / 2

        };
        gc.setFill(Color.LIGHTGREY);
        gc.fillPolygon(pxCenter, pyCenter, 4);
        gc.fillPolygon(pxLeft, pySide, 4);
        gc.setFill(Color.BLACK);
        gc.fillPolygon(pxRight, pySide, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);
        for (int i = 0; i < 4; i++) {
            pyCenter[i] += numberHeight;
            pySide[i] += numberHeight;
        }
        gc.setFill(Color.LIGHTGREY);
        gc.fillPolygon(pxLeft, pySide, 4);
        gc.setFill(Color.BLACK);
        gc.fillPolygon(pxRight, pySide, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);
        gc.setFill(Color.LIGHTGREY);
        gc.fillPolygon(pxCenter, pyCenter, 4);
        for (int i = 2; i < 4; i++) {
            pyCenter[i] -= 2 * plyHeight;
        }
        gc.fillPolygon(pxCenter, pyCenter, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);
        for (int i = 0; i < 4; i++) {
            pyCenter[i] += numberHeight;
        }
        //gc.setFill(Color.BLACK);
        gc.fillPolygon(pxCenter, pyCenter, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);

    }
    private void draw2(double marginX,double marginY, double plyWidth,double plyHeight, double numberHeight ) {
        double[] pxCenter = {
                marginX,
                marginX + plyWidth,
                marginX + plyWidth - plyHeight / 2,
                marginX + plyHeight / 2


        };
        double[] pxLeft = {
                marginX,
                marginX,
                marginX + plyHeight,
                marginX + plyHeight


        };
        double[] pxRight = {
                marginX + plyWidth,
                marginX + plyWidth,
                marginX + plyWidth - plyHeight,
                marginX + plyWidth - plyHeight
        };
        double[] pyCenter = {
                marginY,
                marginY,
                marginY + plyHeight,
                marginY + plyHeight

        };
        double[] pySide = {
                marginY,
                marginY + numberHeight,
                marginY + numberHeight - plyHeight / 2,
                marginY + plyHeight / 2

        };

        gc.fillPolygon(pxCenter, pyCenter, 4);
        gc.setFill(Color.LIGHTGREY);
        gc.fillPolygon(pxLeft, pySide, 4);
        gc.setFill(Color.BLACK);
        gc.fillPolygon(pxRight, pySide, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);
        for (int i = 0; i < 4; i++) {
            pyCenter[i] += numberHeight;
            pySide[i] += numberHeight;
        }

        gc.fillPolygon(pxLeft, pySide, 4);
        gc.setFill(Color.LIGHTGREY);
        gc.fillPolygon(pxRight, pySide, 4);
        gc.setFill(Color.BLACK);
        gc.strokePolygon(pxCenter, pyCenter, 4);
        gc.fillPolygon(pxCenter, pyCenter, 4);
        for (int i = 2; i < 4; i++) {
            pyCenter[i] -= 2 * plyHeight;
        }
        gc.fillPolygon(pxCenter, pyCenter, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);
        for (int i = 0; i < 4; i++) {
            pyCenter[i] += numberHeight;
        }
        //gc.setFill(Color.BLACK);
        gc.fillPolygon(pxCenter, pyCenter, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);

    }
    private void draw3(double marginX,double marginY, double plyWidth,double plyHeight, double numberHeight ) {
        double[] pxCenter = {
                marginX,
                marginX + plyWidth,
                marginX + plyWidth - plyHeight / 2,
                marginX + plyHeight / 2


        };
        double[] pxLeft = {
                marginX,
                marginX,
                marginX + plyHeight,
                marginX + plyHeight


        };
        double[] pxRight = {
                marginX + plyWidth,
                marginX + plyWidth,
                marginX + plyWidth - plyHeight,
                marginX + plyWidth - plyHeight
        };
        double[] pyCenter = {
                marginY,
                marginY,
                marginY + plyHeight,
                marginY + plyHeight

        };
        double[] pySide = {
                marginY,
                marginY + numberHeight,
                marginY + numberHeight - plyHeight / 2,
                marginY + plyHeight / 2

        };
        gc.setFill(Color.BLACK);
        gc.fillPolygon(pxCenter, pyCenter, 4);
        gc.setFill(Color.LIGHTGREY);
        gc.fillPolygon(pxLeft, pySide, 4);
        gc.setFill(Color.BLACK);
        gc.fillPolygon(pxRight, pySide, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);
        for (int i = 0; i < 4; i++) {
            pyCenter[i] += numberHeight;
            pySide[i] += numberHeight;
        }
        gc.setFill(Color.LIGHTGREY);
        gc.fillPolygon(pxLeft, pySide, 4);
        gc.setFill(Color.BLACK);
        gc.fillPolygon(pxRight, pySide, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);
        gc.fillPolygon(pxCenter, pyCenter, 4);
        for (int i = 2; i < 4; i++) {
            pyCenter[i] -= 2 * plyHeight;
        }
        gc.fillPolygon(pxCenter, pyCenter, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);
        for (int i = 0; i < 4; i++) {
            pyCenter[i] += numberHeight;
        }
        gc.setFill(Color.BLACK);
        gc.fillPolygon(pxCenter, pyCenter, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);

    }
    private void draw4(double marginX,double marginY, double plyWidth,double plyHeight, double numberHeight ) {
        double[] pxCenter = {
                marginX,
                marginX + plyWidth,
                marginX + plyWidth - plyHeight / 2,
                marginX + plyHeight / 2


        };
        double[] pxLeft = {
                marginX,
                marginX,
                marginX + plyHeight,
                marginX + plyHeight


        };
        double[] pxRight = {
                marginX + plyWidth,
                marginX + plyWidth,
                marginX + plyWidth - plyHeight,
                marginX + plyWidth - plyHeight
        };
        double[] pyCenter = {
                marginY,
                marginY,
                marginY + plyHeight,
                marginY + plyHeight

        };
        double[] pySide = {
                marginY,
                marginY + numberHeight,
                marginY + numberHeight - plyHeight / 2,
                marginY + plyHeight / 2

        };
        gc.setFill(Color.LIGHTGREY);
        gc.fillPolygon(pxCenter, pyCenter, 4);
        gc.setFill(Color.BLACK);
        gc.fillPolygon(pxLeft, pySide, 4);
        gc.fillPolygon(pxRight, pySide, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);
        for (int i = 0; i < 4; i++) {
            pyCenter[i] += numberHeight;
            pySide[i] += numberHeight;
        }
        gc.setFill(Color.LIGHTGREY);
        gc.fillPolygon(pxLeft, pySide, 4);
        gc.setFill(Color.BLACK);
        gc.fillPolygon(pxRight, pySide, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);
        gc.fillPolygon(pxCenter, pyCenter, 4);
        for (int i = 2; i < 4; i++) {
            pyCenter[i] -= 2 * plyHeight;
        }
        gc.fillPolygon(pxCenter, pyCenter, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);
        for (int i = 0; i < 4; i++) {
            pyCenter[i] += numberHeight;
        }
        gc.setFill(Color.LIGHTGREY);
        gc.fillPolygon(pxCenter, pyCenter, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);

    }
    private void draw5(double marginX,double marginY, double plyWidth,double plyHeight, double numberHeight ) {
        gc.setFill(Color.BLACK);
        double[] pxCenter = {
                marginX,
                marginX + plyWidth,
                marginX + plyWidth - plyHeight / 2,
                marginX + plyHeight / 2


        };
        double[] pxLeft = {
                marginX,
                marginX,
                marginX + plyHeight,
                marginX + plyHeight


        };
        double[] pxRight = {
                marginX + plyWidth,
                marginX + plyWidth,
                marginX + plyWidth - plyHeight,
                marginX + plyWidth - plyHeight
        };
        double[] pyCenter = {
                marginY,
                marginY,
                marginY + plyHeight,
                marginY + plyHeight

        };
        double[] pySide = {
                marginY,
                marginY + numberHeight,
                marginY + numberHeight - plyHeight / 2,
                marginY + plyHeight / 2

        };
        gc.fillPolygon(pxCenter, pyCenter, 4);
        gc.fillPolygon(pxLeft, pySide, 4);
        gc.setFill(Color.LIGHTGREY);
        gc.fillPolygon(pxRight, pySide, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);
        for (int i = 0; i < 4; i++) {
            pyCenter[i] += numberHeight;
            pySide[i] += numberHeight;
        }
        gc.fillPolygon(pxLeft, pySide, 4);
        gc.setFill(Color.BLACK);
        gc.fillPolygon(pxRight, pySide, 4);
        gc.fillPolygon(pxCenter, pyCenter, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);

        for (int i = 2; i < 4; i++) {
            pyCenter[i] -= 2 * plyHeight;
        }
        gc.fillPolygon(pxCenter, pyCenter, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);
        for (int i = 0; i < 4; i++) {
            pyCenter[i] += numberHeight;
        }
        gc.fillPolygon(pxCenter, pyCenter, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);

    }
    private void draw6(double marginX,double marginY, double plyWidth,double plyHeight, double numberHeight ) {
        gc.setFill(Color.BLACK);
        double[] pxCenter = {
                marginX,
                marginX + plyWidth,
                marginX + plyWidth - plyHeight / 2,
                marginX + plyHeight / 2


        };
        double[] pxLeft = {
                marginX,
                marginX,
                marginX + plyHeight,
                marginX + plyHeight


        };
        double[] pxRight = {
                marginX + plyWidth,
                marginX + plyWidth,
                marginX + plyWidth - plyHeight,
                marginX + plyWidth - plyHeight
        };
        double[] pyCenter = {
                marginY,
                marginY,
                marginY + plyHeight,
                marginY + plyHeight

        };
        double[] pySide = {
                marginY,
                marginY + numberHeight,
                marginY + numberHeight - plyHeight / 2,
                marginY + plyHeight / 2

        };
        gc.fillPolygon(pxCenter, pyCenter, 4);
        gc.fillPolygon(pxLeft, pySide, 4);
        gc.setFill(Color.LIGHTGREY);
        gc.fillPolygon(pxRight, pySide, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);
        for (int i = 0; i < 4; i++) {
            pyCenter[i] += numberHeight;
            pySide[i] += numberHeight;
        }
        gc.setFill(Color.BLACK);
        gc.fillPolygon(pxLeft, pySide, 4);
        gc.fillPolygon(pxRight, pySide, 4);
        gc.fillPolygon(pxCenter, pyCenter, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);

        for (int i = 2; i < 4; i++) {
            pyCenter[i] -= 2 * plyHeight;
        }
        gc.fillPolygon(pxCenter, pyCenter, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);
        for (int i = 0; i < 4; i++) {
            pyCenter[i] += numberHeight;
        }
        gc.fillPolygon(pxCenter, pyCenter, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);

    }
    private void draw7(double marginX,double marginY, double plyWidth,double plyHeight, double numberHeight ) {
        double[] pxCenter = {
                marginX,
                marginX + plyWidth,
                marginX + plyWidth - plyHeight / 2,
                marginX + plyHeight / 2


        };
        double[] pxLeft = {
                marginX,
                marginX,
                marginX + plyHeight,
                marginX + plyHeight


        };
        double[] pxRight = {
                marginX + plyWidth,
                marginX + plyWidth,
                marginX + plyWidth - plyHeight,
                marginX + plyWidth - plyHeight
        };
        double[] pyCenter = {
                marginY,
                marginY,
                marginY + plyHeight,
                marginY + plyHeight

        };
        double[] pySide = {
                marginY,
                marginY + numberHeight,
                marginY + numberHeight - plyHeight / 2,
                marginY + plyHeight / 2

        };
        gc.setFill(Color.BLACK);
        gc.fillPolygon(pxCenter, pyCenter, 4);
        gc.fillPolygon(pxLeft, pySide, 4);
        gc.fillPolygon(pxRight, pySide, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);
        for (int i = 0; i < 4; i++) {
            pyCenter[i] += numberHeight;
            pySide[i] += numberHeight;
        }
        gc.setFill(Color.LIGHTGREY);
        gc.fillPolygon(pxLeft, pySide, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);
        gc.fillPolygon(pxCenter, pyCenter, 4);
        for (int i = 2; i < 4; i++) {
            pyCenter[i] -= 2 * plyHeight;
        }

        gc.fillPolygon(pxCenter, pyCenter, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);
        for (int i = 0; i < 4; i++) {
            pyCenter[i] += numberHeight;
        }
        gc.fillPolygon(pxCenter, pyCenter, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);
        gc.setFill(Color.BLACK);
        gc.fillPolygon(pxRight, pySide, 4);

    }
    private void draw8(double marginX,double marginY, double plyWidth,double plyHeight, double numberHeight ) {
       gc.setFill(Color.BLACK);
        double[] pxCenter = {
                marginX,
                marginX + plyWidth,
                marginX + plyWidth - plyHeight / 2,
                marginX + plyHeight / 2


        };
        double[] pxLeft = {
                marginX,
                marginX,
                marginX + plyHeight,
                marginX + plyHeight


        };
        double[] pxRight = {
                marginX + plyWidth,
                marginX + plyWidth,
                marginX + plyWidth - plyHeight,
                marginX + plyWidth - plyHeight
        };
        double[] pyCenter = {
                marginY,
                marginY,
                marginY + plyHeight,
                marginY + plyHeight

        };
        double[] pySide = {
                marginY,
                marginY + numberHeight,
                marginY + numberHeight - plyHeight / 2,
                marginY + plyHeight / 2

        };
        gc.fillPolygon(pxCenter, pyCenter, 4);
        gc.fillPolygon(pxLeft, pySide, 4);
        gc.fillPolygon(pxRight, pySide, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);
        for (int i = 0; i < 4; i++) {
            pyCenter[i] += numberHeight;
            pySide[i] += numberHeight;
        }
        gc.fillPolygon(pxCenter, pyCenter, 4);
        gc.fillPolygon(pxLeft, pySide, 4);
        gc.fillPolygon(pxRight, pySide, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);

        for (int i = 2; i < 4; i++) {
            pyCenter[i] -= 2 * plyHeight;
        }
        gc.fillPolygon(pxCenter, pyCenter, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);
        for (int i = 0; i < 4; i++) {
            pyCenter[i] += numberHeight;
        }
        gc.fillPolygon(pxCenter, pyCenter, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);

    }
    private void draw9(double marginX,double marginY, double plyWidth,double plyHeight, double numberHeight ) {
        double[] pxCenter = {
                marginX,
                marginX + plyWidth,
                marginX + plyWidth - plyHeight / 2,
                marginX + plyHeight / 2


        };
        double[] pxLeft = {
                marginX,
                marginX,
                marginX + plyHeight,
                marginX + plyHeight


        };
        double[] pxRight = {
                marginX + plyWidth,
                marginX + plyWidth,
                marginX + plyWidth - plyHeight,
                marginX + plyWidth - plyHeight
        };
        double[] pyCenter = {
                marginY,
                marginY,
                marginY + plyHeight,
                marginY + plyHeight

        };
        double[] pySide = {
                marginY,
                marginY + numberHeight,
                marginY + numberHeight - plyHeight / 2,
                marginY + plyHeight / 2

        };
        gc.setFill(Color.BLACK);
        gc.fillPolygon(pxCenter, pyCenter, 4);
        gc.fillPolygon(pxLeft, pySide, 4);
        gc.fillPolygon(pxRight, pySide, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);
        for (int i = 0; i < 4; i++) {
            pyCenter[i] += numberHeight;
            pySide[i] += numberHeight;
        }
        gc.setFill(Color.LIGHTGREY);
        gc.fillPolygon(pxLeft, pySide, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);
        gc.setFill(Color.BLACK);
        gc.fillPolygon(pxCenter, pyCenter, 4);
        for (int i = 2; i < 4; i++) {
            pyCenter[i] -= 2 * plyHeight;
        }
        gc.fillPolygon(pxCenter, pyCenter, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);
        for (int i = 0; i < 4; i++) {
            pyCenter[i] += numberHeight;
        }

        gc.fillPolygon(pxRight, pySide, 4);
        gc.fillPolygon(pxCenter, pyCenter, 4);
        gc.strokePolygon(pxCenter, pyCenter, 4);

    }
    private void checkTime(int time,double marginX,double marginY,double plyWidth,double plyHeight,double numberHeight) {
        switch (time) {
            case 1:
                draw1(marginX, marginY, plyWidth, plyHeight, numberHeight);
                break;
            case 2:
                draw2(marginX, marginY, plyWidth, plyHeight, numberHeight);
                break;
            case 3:
                draw3(marginX, marginY, plyWidth, plyHeight, numberHeight);
                break;
            case 4:
                draw4(marginX, marginY, plyWidth, plyHeight, numberHeight);
                break;
            case 5:
                draw5(marginX, marginY, plyWidth, plyHeight, numberHeight);
                break;
            case 6:
                draw6(marginX, marginY, plyWidth, plyHeight, numberHeight);
                break;
            case 7:
                draw7(marginX, marginY, plyWidth, plyHeight, numberHeight);
                break;
            case 8:
                draw8(marginX, marginY, plyWidth, plyHeight, numberHeight);
                break;
            case 9:
                draw9(marginX, marginY, plyWidth, plyHeight, numberHeight);
                break;
            case 0:
                draw0(marginX, marginY, plyWidth, plyHeight, numberHeight);
                break;
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}