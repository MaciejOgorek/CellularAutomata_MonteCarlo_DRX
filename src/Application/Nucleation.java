package Application;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.sqrt;


public class Nucleation {
    public static void homogenous(Canvas canvas, GraphicsContext graphicsContext, int elementsinrow, int rows, int seedsize)
    {
        int x = (int) canvas.getWidth();
        int y = (int) canvas.getHeight();
        ArrayList<Color> colorlist = new ArrayList<>();
        int xdist = x/(elementsinrow);
        int ydist = y/rows;
        int halfsize = seedsize/2;
        int xposition = xdist/2;
        int yposition = ydist/2;

        for(int i = 0; i<rows; i++)
        {
            for(int j=0; j<elementsinrow; j++)
            {
                Random rand = new Random();
                double r = rand.nextInt(256);
                double g = rand.nextInt(256);
                double b = rand.nextInt(256);
                r = r / 255;
                g = g / 255;
                b = b / 255;
                Color color = new Color(r, g, b, 1);

                if(colorlist.contains(color))
                {
                    j--;
                    xposition = xposition -xdist;
                }
                else {
                    colorlist.add(color);
                    graphicsContext.setFill(color);
                    graphicsContext.fillRect(xposition -halfsize, yposition -halfsize, seedsize, seedsize);
                }
                xposition += xdist;
            }
            yposition += ydist;
            xposition = xdist/2;
        }
    }
    public static void Random(Canvas canvas, GraphicsContext graphicsContext, int numberofelements,int seedsize){
        int x = (int) canvas.getWidth();
        int y = (int) canvas.getHeight();
        int halfsize = seedsize/2;
        ArrayList<Color> colorlist = new ArrayList<>();
        for(int i = 0; i<numberofelements; i++) {
            Random rand = new Random();
            int k = rand.nextInt(y);
            int j = rand.nextInt(x);
            {
                double r = rand.nextInt(256);
                double g = rand.nextInt(256);
                double b = rand.nextInt(256);
                r = r / 255;
                g = g / 255;
                b = b / 255;
                Color color = new Color(r, g, b, 1);
                if(colorlist.contains(color))
                {
                    i--;
                }
                else {
                    colorlist.add(color);
                    graphicsContext.setFill(color);
                    graphicsContext.fillRect(k -halfsize, j -halfsize, seedsize, seedsize);
                }
            }
        }

    }
    public static void choice(Canvas canvas, GraphicsContext graphicsContext, int seedsize)
    {
        int x = (int) canvas.getWidth();
        int y = (int) canvas.getHeight();
        int halfsize = seedsize/2;
        canvas.setOnMouseClicked(event -> {
            double m = event.getX();
            double n = event.getY();
            Random rand = new Random();
            double r = rand.nextInt(256);
            double g = rand.nextInt(256);
            double b = rand.nextInt(256);
            r = r / 255;
            g = g / 255;
            b = b / 255;
            Color color = new Color(r, g, b, 1);
            graphicsContext.setFill(color);
            graphicsContext.fillRect(m-halfsize, n-halfsize, seedsize, seedsize);
        });
    }
public static void Circle(Canvas canvas, GraphicsContext graphicsContext, int numberofelements, int radius,int seedsize)
{
    int x = (int) canvas.getWidth();
    int y = (int) canvas.getHeight();
    int halfsize = seedsize/2;
    ArrayList<Color> colorlist = new ArrayList<>();
    for(int i = 0; i<numberofelements; i++)
    {
                Random rand = new Random();
                double r = rand.nextInt( 256);
                double g = rand.nextInt(256);
                double b = rand.nextInt(256);
                int cordx = rand.nextInt(x);
                int cordy = rand.nextInt(y);
                r = r/255;
                g = g/255;
                b = b/255;
                Color color = new Color(r, g, b, 1);

        Image writableImage = canvas.snapshot(null, null);
        graphicsContext.drawImage( writableImage,0,0, canvas.getHeight(), canvas.getWidth() );
        PixelReader pixelReader = writableImage.getPixelReader();
        int iterator =0;
        for(int z = 0; z<y; z++)
        {
            for(int j = 0; j<x; j++) {
                Color checkcolor = pixelReader.getColor(z, j);
                double distance =sqrt((j-cordx)^2+(z-cordy)^2);
                //System.out.println(distance);
                if(distance <radius)
                {
                    if(!checkcolor.equals(Color.WHITE))
                    {
                        iterator++;
                    }

                }

            }}
        System.out.println(iterator);
        if(iterator ==0)
        {
            if(colorlist.contains(color))
            {
                i--;
            }
            else {
                colorlist.add(color);
                graphicsContext.setFill(color);
                graphicsContext.fillRect(cordx-halfsize, cordy-halfsize, seedsize,seedsize);
            }

        }
        else
        {
            i--;
        }


    }
}


}



