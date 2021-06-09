package Application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.*;
import java.util.stream.Collectors;


public class Operations {
    public static void initialize(Canvas canvas, GraphicsContext graphicsContext)
    {
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillRect(0, 0, canvas.getHeight(), canvas.getWidth());
    }

    public static void perform_CA(Canvas canvas,GraphicsContext graphicsContext, String neighborhood, String boundaryconditions)
    {
        Cell[][] current_table = initialize_Cells(canvas, graphicsContext);
        Cell[][] next_step = initialize_Cells(canvas, graphicsContext);
        switch (neighborhood) {
            case ("von Neumann"):
                while (isanywhite(current_table)) {
                    for (int i = 0; i < current_table.length; i++) {
                        for (int j = 0; j < current_table[0].length; j++) {
                            Color fillcolor = current_table[i][j].getColor();
                            graphicsContext.setFill(fillcolor);
                            graphicsContext.fillRect(i, j, 1, 1);
                            next_step[i][j].setColor(Neighborhood.calculate_vonNeumann(current_table, i, j, boundaryconditions));

                        }
                    }
                    Image writableImage = canvas.snapshot(null, null);
                    graphicsContext.drawImage( writableImage,0,0, canvas.getHeight(), canvas.getWidth() );
                    System.out.println("iteration");
                    copyarray(current_table, next_step);

                }
            case("Moore"):
                while (isanywhite(current_table))  {
                    for (int i = 0; i < current_table.length; i++) {
                        for (int j = 0; j < current_table[0].length; j++) {
                            Color fillcolor = current_table[i][j].getColor();
                            graphicsContext.setFill(fillcolor);
                            graphicsContext.fillRect(i, j, 1, 1);
                            next_step[i][j].setColor(Neighborhood.calculate_Moore(current_table, i, j, boundaryconditions));

                        }
                    }
                    Image writableImage = canvas.snapshot(null, null);
                    graphicsContext.drawImage( writableImage,0,0, canvas.getHeight(), canvas.getWidth() );
                    System.out.println("iteration");
                    copyarray(current_table, next_step);
                }
            case("Hexagonal left"):
                while (isanywhite(current_table))  {
                    for (int i = 0; i < current_table.length; i++) {
                        for (int j = 0; j < current_table[0].length; j++) {
                            Color fillcolor = current_table[i][j].getColor();
                            graphicsContext.setFill(fillcolor);
                            graphicsContext.fillRect(i, j, 1, 1);
                            next_step[i][j].setColor(Neighborhood.calculate_Hexagonal_left(current_table, i, j, boundaryconditions));

                        }
                    }
                    Image writableImage = canvas.snapshot(null, null);
                    graphicsContext.drawImage( writableImage,0,0, canvas.getHeight(), canvas.getWidth() );
                    System.out.println("iteration");
                    copyarray(current_table, next_step);
                }
            case("Hexagonal right"):
                while (isanywhite(current_table))  {
                    for (int i = 0; i < current_table.length; i++) {
                        for (int j = 0; j < current_table[0].length; j++) {
                            Color fillcolor = current_table[i][j].getColor();
                            graphicsContext.setFill(fillcolor);
                            graphicsContext.fillRect(i, j, 1, 1);
                            next_step[i][j].setColor(Neighborhood.calculate_Hexagonal_right(current_table, i, j, boundaryconditions));

                        }
                    }
                    Image writableImage = canvas.snapshot(null, null);
                    graphicsContext.drawImage( writableImage,0,0, canvas.getHeight(), canvas.getWidth() );
                    System.out.println("iteration");
                    copyarray(current_table, next_step);
                }
            case("Hexagonal Random"):
                while (isanywhite(current_table))  {
                    for (int i = 0; i < current_table.length; i++) {
                        for (int j = 0; j < current_table[0].length; j++) {
                            Color fillcolor = current_table[i][j].getColor();
                            graphicsContext.setFill(fillcolor);
                            graphicsContext.fillRect(i, j, 1, 1);
                            next_step[i][j].setColor(Neighborhood.calculate_Hexagonal_random(current_table, i, j, boundaryconditions));

                        }
                    }
                    Image writableImage = canvas.snapshot(null, null);
                    graphicsContext.drawImage( writableImage,0,0, canvas.getHeight(), canvas.getWidth() );
                    System.out.println("iteration");
                    copyarray(current_table, next_step);
                }
            case("Pentagonal Random"):
                while (isanywhite(current_table))  {
                    for (int i = 0; i < current_table.length; i++) {
                        for (int j = 0; j < current_table[0].length; j++) {
                            Color fillcolor = current_table[i][j].getColor();
                            graphicsContext.setFill(fillcolor);
                            graphicsContext.fillRect(i, j, 1, 1);
                            next_step[i][j].setColor(Neighborhood.calculate_Pentagonal_random(current_table, i, j, boundaryconditions));

                        }
                    }
                    Image writableImage = canvas.snapshot(null, null);
                    graphicsContext.drawImage( writableImage,0,0, canvas.getHeight(), canvas.getWidth() );
                    System.out.println("iteration");
                    copyarray(current_table, next_step);
                }
    }}
    public static Cell[][] initialize_Cells(Canvas canvas, GraphicsContext graphicsContext)
    {
        Cell[][] cells = new Cell[(int) canvas.getHeight()][(int) canvas.getWidth()];
        Image writableImage = canvas.snapshot(null, null);
        graphicsContext.drawImage( writableImage,0,0, canvas.getHeight(), canvas.getWidth() );
        PixelReader pixelReader = writableImage.getPixelReader();
        int id =0;
        int energy =0;
        double ro = 0;
        String state = "nocrystal";
        for(int i = 0; i<cells.length; i++)
        {
            for(int j = 0; j<cells[0].length; j++)
            {
                Color color = pixelReader.getColor(i,j);
                cells[i][j] = new Cell(id, color, energy,j,i, ro, state);
                cells[i][j].setId(id);
                cells[i][j].setColor(color);
                cells[i][j].setEnergy(0);
                cells[i][j].setX(j);
                cells[i][j].setY(i);
                cells[i][j].setRo(ro);
                cells[i][j].setState(state);
                id++;
            }
        }
        return cells;
    }
    public static void rescale(Canvas canvas, GraphicsContext graphicsContext, int x, int y)
    {
        canvas.setHeight(y);
        canvas.setWidth(x);
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillRect(0,0,x,y);
    }
    public static void copyarray(Cell[][] oldarray, Cell[][] newarray) {
        for (int i = 0; i < oldarray.length; i++) {
            for (int j = 0; j < oldarray[0].length; j++)
            {
                oldarray[i][j].setColor(newarray[i][j].getColor());
            }
        }
    }
    public static boolean isanywhite(Cell[][] oldarray)
    {
        int numberofwhites =0;
        for (Cell[] cells : oldarray) {
            for (int j = 0; j < oldarray[0].length; j++) {
                if (cells[j].getColor().equals(Color.WHITE)) {
                    numberofwhites++;
                }
            }
        }
        return numberofwhites != 0;
    }
    public static Cell[][] perform_Monte_Carlo(Canvas canvas, GraphicsContext graphicsContext, String boundary_conditions, String neighborhood , int iterations, double kt)
    {
        Cell[][] cells = initialize_Cells(canvas, graphicsContext);
        List<Cell> cellArrayList = Arrays.stream(cells)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        Collections.shuffle(cellArrayList);
        switch(neighborhood){
            case("vonNeumann"):
                for(int i = 0; i<iterations; i++)
                {
                    for(int j = 0; j<cellArrayList.size(); j++)
                    {
                        int x = cellArrayList.get(j).getX();
                        int y = cellArrayList.get(j).getY();
                        Color fillcolor = Montecarlo_neighborhood.MCvonNeumann(cells,y, x,boundary_conditions, kt);
                        cells[y][x].setColor(fillcolor);
                        graphicsContext.setFill(fillcolor);
                        graphicsContext.fillRect(y, x, 1, 1);
                    }
                    Image writableImage = canvas.snapshot(null, null);
                    graphicsContext.drawImage( writableImage,0,0, canvas.getHeight(), canvas.getWidth() );
                    System.out.println("MC");
                    Collections.shuffle(cellArrayList);
                }
            case("Moore"):
                for(int i = 0; i<iterations; i++)
                {
                    for(int j = 0; j<cellArrayList.size(); j++)
                    {
                        int x = cellArrayList.get(j).getX();
                        int y = cellArrayList.get(j).getY();
                        Color fillcolor = Montecarlo_neighborhood.calculate_MC_Moore(cells,y, x,boundary_conditions, kt);
                        cells[y][x].setColor(fillcolor);
                        graphicsContext.setFill(fillcolor);
                        graphicsContext.fillRect(y, x, 1, 1);
                    }
                    Image writableImage = canvas.snapshot(null, null);
                    graphicsContext.drawImage( writableImage,0,0, canvas.getHeight(), canvas.getWidth() );
                    System.out.println("MC");
                    Collections.shuffle(cellArrayList);
                }
            case("Pentagonal random"):
                for(int i = 0; i<iterations; i++)
                {
                    for(int j = 0; j<cellArrayList.size(); j++)
                    {
                        int x = cellArrayList.get(j).getX();
                        int y = cellArrayList.get(j).getY();
                        Color fillcolor = Montecarlo_neighborhood.MCPentrandom(cells,y, x,boundary_conditions, kt);
                        cells[y][x].setColor(fillcolor);
                        graphicsContext.setFill(fillcolor);
                        graphicsContext.fillRect(y, x, 1, 1);
                    }
                    Image writableImage = canvas.snapshot(null, null);
                    graphicsContext.drawImage( writableImage,0,0, canvas.getHeight(), canvas.getWidth() );
                    System.out.println("MC");
                    Collections.shuffle(cellArrayList);
                }
            case("Hexagonal Left"):
                for(int i = 0; i<iterations; i++)
                {
                    for(int j = 0; j<cellArrayList.size(); j++)
                    {
                        int x = cellArrayList.get(j).getX();
                        int y = cellArrayList.get(j).getY();
                        Color fillcolor = Montecarlo_neighborhood.MCHEXleft(cells,y, x,boundary_conditions, kt);
                        cells[y][x].setColor(fillcolor);
                        graphicsContext.setFill(fillcolor);
                        graphicsContext.fillRect(y, x, 1, 1);
                    }
                    Image writableImage = canvas.snapshot(null, null);
                    graphicsContext.drawImage( writableImage,0,0, canvas.getHeight(), canvas.getWidth() );
                    System.out.println("MC");
                    Collections.shuffle(cellArrayList);
                }
            case("Hexagonal Right"):
                for(int i = 0; i<iterations; i++)
                {
                    for(int j = 0; j<cellArrayList.size(); j++)
                    {
                        int x = cellArrayList.get(j).getX();
                        int y = cellArrayList.get(j).getY();
                        Color fillcolor = Montecarlo_neighborhood.MCHexright(cells,y, x,boundary_conditions, kt);
                        cells[y][x].setColor(fillcolor);
                        graphicsContext.setFill(fillcolor);
                        graphicsContext.fillRect(y, x, 1, 1);
                    }
                    Image writableImage = canvas.snapshot(null, null);
                    graphicsContext.drawImage( writableImage,0,0, canvas.getHeight(), canvas.getWidth() );
                    System.out.println("MC");
                    Collections.shuffle(cellArrayList);
                }
            case("Hexagonal Random"):
                for(int i = 0; i<iterations; i++)
                {
                    for(int j = 0; j<cellArrayList.size(); j++)
                    {
                        int x = cellArrayList.get(j).getX();
                        int y = cellArrayList.get(j).getY();
                        Color fillcolor = Montecarlo_neighborhood.MCHexrandom(cells,y, x,boundary_conditions, kt);
                        cells[y][x].setColor(fillcolor);
                        graphicsContext.setFill(fillcolor);
                        graphicsContext.fillRect(y, x, 1, 1);
                    }
                    Image writableImage = canvas.snapshot(null, null);
                    graphicsContext.drawImage( writableImage,0,0, canvas.getHeight(), canvas.getWidth() );
                    System.out.println("MC");
                    Collections.shuffle(cellArrayList);
                }
        }
        return cells;
    }
public static void visualizeenergy(Cell[][] cells, Canvas canvas, GraphicsContext graphicsContext)
{
    Group root = new Group();
    Stage stage = new Stage();
    stage.setTitle("Energy");
    Canvas canva = new Canvas();
    stage.setWidth(canvas.getWidth());
    stage.setHeight(canvas.getHeight());
    root.getChildren().add(canva);
    stage.setScene(new Scene(root));
    stage.show();

    canva.setWidth(canvas.getWidth());
    canva.setHeight(canvas.getHeight());
    for(int i = 0; i< cells.length-1; i++)
    {
        for(int j =0; j<cells[0].length-1;j++)
        {
            if(cells[i][j].getEnergy() ==0)
            {
                canva.getGraphicsContext2D().setFill(Color.BLACK);
                canva.getGraphicsContext2D().fillRect(i,j,1,1);
            }
            else
                canva.getGraphicsContext2D().setFill(Color.RED);
                canva.getGraphicsContext2D().fillRect(i,j,1,1);
        }
    }

}
    public static void performDRX(Cell[][] cells, Canvas canvas, GraphicsContext graphicsContext)
    {
        Cell[][] celltab = new Cell[cells.length][cells[0].length];
        for(int i = 0; i< cells.length; i++)
        {
            for(int j=0; j<cells[0].length; j++)
            {
                celltab[i][j] = new Cell(cells[i][j].getId(), cells[i][j].getColor(),cells[i][j].getEnergy(), cells[i][j].getX(), cells[i][j].getY(), cells[i][j].getRo(), cells[i][j].getState());
            }
        }

        int xSize = (int)canvas.getWidth();
        int ySize = (int)canvas.getWidth();
         double A =86710969050178.5;
        double B =9.41268203527779;
        double t = 0;
        double RO ;
        double newRo;
        double criticaldislocation =( A/B +(1-A/B)*Math.exp(-B*0.65))/(xSize*ySize);
        while(t<1)
        {
            if (t == 0)
            {
                RO = A/B +(1-A/B)*Math.exp(-B*t);
            }
            else
            {
                RO = A/B +(1-A/B)*Math.exp(-B*(t-0.1));
            }
            newRo = A/B +(1-A/B)*Math.exp(-B*t);
            double deltaro = newRo -RO;
            double averagedislocation = deltaro/(xSize*ySize);
            double bigpack = 0.3 *averagedislocation;
            double smallpack = 0.001 *averagedislocation;
            for(int i = 0; i< cells.length; i++)
            {
                for(int j=0; j<cells[0].length; j++)
                {
                    cells[i][j].setRo(bigpack);
                    deltaro = deltaro -bigpack;
                }
            }
            while(deltaro >0)
            {
                Random random = new Random();
                int x = random.nextInt(cells[0].length);
                int y = random.nextInt(cells.length);

                if(cells[y][x].getEnergy() != 0)
                {
                    //System.out.println(cells[y][x].getEnergy());

                    if(Math.random() <0.8)
                    {
                        double currentro = cells[y][x].getRo();
                        cells[y][x].setRo(currentro+smallpack);
                        deltaro = deltaro -smallpack;

                    }
                }
                else {
                    if (Math.random() < 0.2) {
                        double currentro = cells[y][x].getRo();
                        cells[y][x].setRo(currentro + smallpack);
                        deltaro = deltaro-smallpack;
                    }
                }
            }for(int i = 0; i< cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                if(cells[i][j].getRo() > criticaldislocation && cells[i][j].getEnergy() != 0)
                {
                    cells[i][j].setRo(0);
                    cells[i][j].setState("Crystal");
                    cells[i][j].setColor(Color.RED);
                    graphicsContext.setFill(Color.RED);
                    graphicsContext.fillRect(i,j,1,1);

                }

            }
        }

            for(int i = 0; i< cells.length; i++)
            {
                for(int j=0; j<cells[0].length; j++)
                {
                        int a = i - 1;
                        int b = i + 1;
                        int c = j - 1;
                        int d = j + 1;
                        if (a < 0) {
                            a = cells.length - 1;
                        }
                        if (b > cells.length - 1) {
                            b = 0;
                        }
                        if (c < 0) {
                            c = cells[0].length - 1;
                        }
                        if (d > cells[0].length - 1) {
                            d = 0;
                        }
                    String state1 = celltab[a][c].getState();
                    String state2 = celltab[a][j].getState();
                    String state3 = celltab[a][d].getState();
                    String state4 = celltab[i][c].getState();
                    String state5 = celltab[i][d].getState();
                    String state6 = celltab[b][c].getState();
                    String state7 = celltab[b][j].getState();
                    String state8 = celltab[b][d].getState();
                    ArrayList<String> statetab = new ArrayList<String>(8);
                    statetab.add(state1);
                    statetab.add(state2);
                    statetab.add(state3);
                    statetab.add(state4);
                    statetab.add(state5);
                    statetab.add(state6);
                    statetab.add(state7);
                    statetab.add(state8);
                    if(statetab.contains("Crystal")) {

                        double RO1 = cells[a][c].getRo();
                        double RO2 = cells[a][j].getRo();
                        double RO3 = cells[a][d].getRo();
                        double RO4 = cells[i][c].getRo();
                        double RO5 = cells[i][d].getRo();
                        double RO6 = cells[b][c].getRo();
                        double RO7 = cells[b][j].getRo();
                        double RO8 = cells[b][d].getRo();
                        ArrayList<Double> rotab = new ArrayList<Double>(8);
                        rotab.add(RO1);
                        rotab.add(RO2);
                        rotab.add(RO3);
                        rotab.add(RO4);
                        rotab.add(RO5);
                        rotab.add(RO6);
                        rotab.add(RO7);
                        rotab.add(RO8);

                        double max = Collections.max(rotab);
                        if(max< cells[i][j].getRo())
                        {
                            cells[i][j].setColor(Color.RED);
                            cells[i][j].setRo(0);
                            cells[i][j].setState("Crystal");
                            graphicsContext.setFill(Color.RED);
                            graphicsContext.fillRect(i,j,1,1);

                        }
                        else
                            celltab[i][j].setEnergy(cells[i][j].getEnergy());
                            celltab[i][j].setRo(cells[i][j].getRo());
                            celltab[i][j].setState(cells[i][j].getState());
                    }
                }
            }
            Image writableImage = canvas.snapshot(null, null);
            graphicsContext.drawImage( writableImage,0,0, canvas.getHeight(), canvas.getWidth() );
            System.out.println("DRX");
            t = t+0.1;
        }
    }
    public static void visualizerecrystalization(Cell[][] cells, Canvas canvas, GraphicsContext graphicsContext)
    {
        Group root = new Group();
        Stage stage = new Stage();
        stage.setTitle("RO");
        Canvas canva = new Canvas();
        stage.setWidth(canvas.getWidth());
        stage.setHeight(canvas.getHeight());
        root.getChildren().add(canva);
        stage.setScene(new Scene(root));
        stage.show();

        canva.setWidth(canvas.getWidth());
        canva.setHeight(canvas.getHeight());
        for(int i = 0; i< cells.length-1; i++)
        {
            for(int j =0; j<cells[0].length-1;j++)
            {
                if(cells[i][j].getState().equals("nocrystal"))
                {
                    canva.getGraphicsContext2D().setFill(Color.BLACK);
                    canva.getGraphicsContext2D().fillRect(i,j,1,1);
                }
                else
                    canva.getGraphicsContext2D().setFill(Color.GREEN);
                canva.getGraphicsContext2D().fillRect(i,j,1,1);
            }
        }

    }
}
