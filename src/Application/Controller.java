package Application;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {


    public Button StartButton;
    public Button ResetButton;
    public Button RescaleButton;
    public TextField RescaleX;
    public TextField RescaleY;
    public  Canvas canvas;
    public ComboBox Zarodkowanie;
    public ComboBox Neighborhood;
    public ComboBox BoundaryConditions;
    public TextField numberofincrements;
    public TextField numberofelements;
    public TextField seedsize;
    public TextField radius;
    public Button nucleationwithradius;
    public Button homogenousnucleation;
    public TextField elementsinrow;
    public TextField numberofrows;
    public ComboBox MCneighborhood;
    public ComboBox MCboundaryconditions;
    public Button startMC;
    public TextField kt;
    public TextField MCiterations;
    public Button showenergy;
    public Button DRXbutton;
    public Button dislocationbutton;
    Cell[][] celltab;
    public void initialize()
    {
        Operations.initialize(canvas, canvas.getGraphicsContext2D());
    }
    public void Nucleation (javafx.event.ActionEvent actionEvent)
    {
        String value = (String) Zarodkowanie.getValue();

        int elements = Integer.parseInt(String.valueOf(numberofelements.getText()));
        if (elements <0)
        {
            throw new IllegalArgumentException("Number of elements cannot be negative");
        }
        int size = Integer.parseInt(String.valueOf(seedsize.getText()));
        if (size <0)
        {
            throw new IllegalArgumentException("size cannot be negative");
        }

        switch(value)
        {
            case "Random"-> Nucleation.Random(canvas, canvas.getGraphicsContext2D(), elements, size);
            case "Own Choice" ->Nucleation.choice(canvas, canvas.getGraphicsContext2D(),size);
        }
    }
    public void RescalePressed(javafx.event.ActionEvent actionEvent)
    {
        int height = Integer.parseInt(String.valueOf( RescaleY.getText()));
        int width = Integer.parseInt(String.valueOf(RescaleX.getText()));
        if(height <1 || width <1) {
                throw new IllegalArgumentException("height or width cannot be negative");

        }
        else
        Operations.rescale(canvas, canvas.getGraphicsContext2D(),width, height);
    }
    public void StartPressed(javafx.event.ActionEvent actionEvent)
    {

        String neighborhood = (String) Neighborhood.getValue();
        String boundaryconditions = (String) BoundaryConditions.getValue();
        Operations.perform_CA(canvas, canvas.getGraphicsContext2D(),neighborhood, boundaryconditions);

    }
    public void ResetPressed(javafx.event.ActionEvent actionEvent)
    {
        Operations.initialize(canvas, canvas.getGraphicsContext2D());
        Zarodkowanie.getSelectionModel().clearSelection();
    }
    public void nucleationwithradius(javafx.event.ActionEvent actionEvent)
    {
        int elements = Integer.parseInt(String.valueOf(numberofelements.getText()));
        if(elements <0)
        {
            throw new IllegalArgumentException("Number of elements cannot be negative");
        }
        int size = Integer.parseInt(String.valueOf(seedsize.getText()));
        if (size <0)
        {
            throw new IllegalArgumentException("size cannot be negative");
        }
        int radiuss = Integer.parseInt(String.valueOf(radius.getText()));
        if (radiuss <0)
        {
            throw new IllegalArgumentException("radius cannot be negative");
        }
    Nucleation.Circle(canvas, canvas.getGraphicsContext2D(),elements,radiuss,size);
        
    }
    public void homogenous_nucleation(javafx.event.ActionEvent actionEvent)
    {
        int rows = Integer.parseInt(String.valueOf(numberofrows.getText()));
        if (rows <0)
        {
            throw new IllegalArgumentException("rows cannot be negative");
        }
        int inrow = Integer.parseInt(String.valueOf(elementsinrow.getText()));
        if (inrow <0)
        {
            throw new IllegalArgumentException("Number of elements in row cannot be negative");
        }
        int size = Integer.parseInt(String.valueOf(seedsize.getText()));
        if (size <0)
        {
            throw new IllegalArgumentException("size cannot be negative");
        }
       Nucleation.homogenous(canvas, canvas.getGraphicsContext2D(), inrow, rows,size);

    }
    public void Monte_Carlo(javafx.event.ActionEvent actionEvent)
    {
        String BC = (String) MCboundaryconditions.getValue();
        String NG = (String) MCneighborhood.getValue();
        double stala = Double.parseDouble(kt.getText());
        if (stala <0.1)
        {
            throw new IllegalArgumentException("kt cannot be less than 0.1");
        }
        else if(stala >6)
        {
            throw new IllegalArgumentException("kt cannot be more than 6");
        }
        int it = Integer.parseInt(MCiterations.getText());
        if (it <0)
        {
            throw new IllegalArgumentException("Number of operations cannot be negative");
        }
        System.out.println(it);
        celltab = Operations.perform_Monte_Carlo(canvas, canvas.getGraphicsContext2D(),BC,NG,it, stala);
    }
    public void showenergy(javafx.event.ActionEvent actionEvent)
    {
        Operations.visualizeenergy(celltab, canvas, canvas.getGraphicsContext2D());
    }
    public void DRXpressed(javafx.event.ActionEvent actionEvent)
    {
        Operations.performDRX(celltab, canvas, canvas.getGraphicsContext2D());
    }
    public void dislocationpressed( javafx.event.ActionEvent actionEvent)
    {
        Operations.visualizerecrystalization(celltab,canvas, canvas.getGraphicsContext2D());
    }

}