package Application;

import javafx.scene.paint.Color;

import java.util.*;

public class Neighborhood
{
    public static Color calculate_vonNeumann( Cell[][] cells, int i, int j,String boundary_conditions)
    {
        switch (boundary_conditions) {
            case ("Periodic"):
                if (cells[i][j].getColor().equals(Color.WHITE)) {
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

                    Color color1 = cells[a][j].getColor();
                    Color color2 = cells[i][c].getColor();
                    Color color3 = cells[i][d].getColor();
                    Color color4 = cells[b][j].getColor();
                    ArrayList<Color> colortab = new ArrayList<>(5);

                    if (!color1.equals(Color.WHITE)) {
                        colortab.add(color1);
                    }
                    if (!color2.equals(Color.WHITE)) {
                        colortab.add(color2);
                    }
                    if (!color3.equals(Color.WHITE)) {
                        colortab.add(color3);
                    }
                    if (!color4.equals(Color.WHITE)) {
                        colortab.add(color4);
                    }


                    if (!colortab.isEmpty()) {
                        return chooseWhichColorToPaint(colortab);
                    }
                }

            case ("Absorbent"):
                if (cells[i][j].getColor().equals(Color.WHITE)) {
                    int a1 = i - 1;
                    int b1 = i + 1;
                    int c1 = j - 1;
                    int d1 = j + 1;
                    Color colora1;
                    if (a1 < 0) {
                        colora1 = Color.WHITE;
                    } else {
                        colora1 = cells[a1][j].getColor();
                    }
                    Color colorb1;
                    if (b1 > cells.length - 1) {
                        colorb1 = Color.WHITE;
                    } else {
                        colorb1 = cells[b1][j].getColor();
                    }
                    Color colorc1;
                    if (c1 < 0) {
                        colorc1 = Color.WHITE;
                    } else {
                        colorc1 = cells[i][c1].getColor();
                    }
                    Color colord1;
                    if (d1 > cells[0].length - 1) {
                        colord1 = Color.WHITE;
                    } else {
                        colord1 = cells[i][d1].getColor();
                    }


                    ArrayList<Color> colortab1 = new ArrayList<>(5);

                    if (!colora1.equals(Color.WHITE)) {
                        colortab1.add(colora1);
                    }
                    if (!colorb1.equals(Color.WHITE)) {
                        colortab1.add(colorb1);
                    }
                    if (!colorc1.equals(Color.WHITE)) {
                        colortab1.add(colorc1);
                    }
                    if (!colord1.equals(Color.WHITE)) {
                        colortab1.add(colord1);
                    }

                    if (!colortab1.isEmpty()) {
                        return chooseWhichColorToPaint(colortab1);
                    }
                }
        }
        return cells[i][j].getColor();
    }

    public static Color calculate_Moore(Cell[][] cells, int i, int j, String boundary_conditions)
    {
        switch (boundary_conditions) {
        case ("Periodic"):
            if (cells[i][j].getColor().equals(Color.WHITE)) {
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
                Color color1 = cells[a][c].getColor();
                Color color2 = cells[a][j].getColor();
                Color color3 = cells[a][d].getColor();
                Color color4 = cells[i][c].getColor();
                Color color5 = cells[i][d].getColor();
                Color color6 = cells[b][c].getColor();
                Color color7 = cells[b][j].getColor();
                Color color8 = cells[b][d].getColor();
                ArrayList<Color> colortab = new ArrayList<>(5);

                if (!color1.equals(Color.WHITE)) {
                    colortab.add(color1);
                }
                if (!color2.equals(Color.WHITE)) {
                    colortab.add(color2);
                }
                if (!color3.equals(Color.WHITE)) {
                    colortab.add(color3);
                }
                if (!color4.equals(Color.WHITE)) {
                    colortab.add(color4);
                }
                if (!color5.equals(Color.WHITE)) {
                    colortab.add(color5);
                }
                if (!color6.equals(Color.WHITE)) {
                    colortab.add(color6);
                }
                if (!color7.equals(Color.WHITE)) {
                    colortab.add(color7);
                }
                if (!color8.equals(Color.WHITE)) {
                    colortab.add(color8);
                }

                if (!colortab.isEmpty()) {
                    return chooseWhichColorToPaint(colortab);
                }
            }

        case ("Absorbent"):
            if (cells[i][j].getColor().equals(Color.WHITE)) {
                int a1 = i - 1;
                int b1 = i + 1;
                int c1 = j - 1;
                int d1 = j + 1;
                Color colora1;
                if (a1 < 0) {
                    colora1 = Color.WHITE;
                } else {
                    colora1 = cells[a1][j].getColor();
                }
                Color colorb1;
                if (b1 > cells.length - 1) {
                    colorb1 = Color.WHITE;
                } else {
                    colorb1 = cells[b1][j].getColor();
                }
                Color colorc1;
                if (c1 < 0) {
                    colorc1 = Color.WHITE;
                } else {
                    colorc1 = cells[i][c1].getColor();
                }
                Color colord1;
                if (d1 > cells[0].length - 1) {
                    colord1 = Color.WHITE;
                } else {
                    colord1 = cells[i][d1].getColor();
                }
                Color colore1;
                if(a1<0 ||c1<0)
                {
                    colore1 = Color.WHITE;
                }
                else
                {
                    colore1 = cells[a1][c1].getColor();
                }
                Color colorf1;
                if(a1<0 || d1> cells[0].length -1)
                {
                    colorf1 =Color.WHITE;
                }
                else
                {
                    colorf1 = cells[a1][d1].getColor();
                }
                Color colorg1;
                if(b1> cells.length-1 || c1<0)
                {
                    colorg1 = Color.WHITE;
                }
                else
                {
                    colorg1 = cells[b1][c1].getColor();
                }
                Color colorh1;
                if(b1> cells.length-1 || d1>cells[0].length-1)
                {
                    colorh1 = Color.WHITE;
                }
                else
                {
                    colorh1 = cells[b1][d1].getColor();
                }

                ArrayList<Color> colortab1 = new ArrayList<>(5);

                if (!colora1.equals(Color.WHITE)) {
                    colortab1.add(colora1);
                }
                if (!colorb1.equals(Color.WHITE)) {
                    colortab1.add(colorb1);
                }
                if (!colorc1.equals(Color.WHITE)) {
                    colortab1.add(colorc1);
                }
                if (!colord1.equals(Color.WHITE)) {
                    colortab1.add(colord1);
                }
                if (!colore1.equals(Color.WHITE)) {
                    colortab1.add(colore1);
                }
                if (!colorf1.equals(Color.WHITE)) {
                    colortab1.add(colorf1);
                }
                if (!colorg1.equals(Color.WHITE)) {
                    colortab1.add(colorg1);
                }
                if (!colorh1.equals(Color.WHITE)) {
                    colortab1.add(colorh1);
                }

                if (!colortab1.isEmpty()) {
                    return chooseWhichColorToPaint(colortab1);
                }
            }
    }
        return cells[i][j].getColor();
    }

    public static Color calculate_Hexagonal_random(Cell[][] cells, int i, int j, String boundary_conditions)
    {
        Random random = new Random();
        int factor = random.nextInt(2);
        Color color = null;
        if(factor ==0)
        {
            color = calculate_Hexagonal_left(cells, i,j, boundary_conditions);
        }
        else if(factor ==1)
        {
            color =  calculate_Hexagonal_right(cells, i,j ,boundary_conditions);
        }
        return color;
    }
    public static Color calculate_Pentagonal_random(Cell[][] cells, int i, int j, String boundary_conditions)
    {
        Random random = new Random();
        int f = random.nextInt(4);
        //Option top
        if(f == 0) {
            switch (boundary_conditions) {
                case ("Periodic"):
                    if (cells[i][j].getColor().equals(Color.WHITE)) {
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
                        Color color1 = cells[a][c].getColor();
                        Color color2 = cells[a][j].getColor();
                        Color color3 = cells[a][d].getColor();
                        Color color4 = cells[i][c].getColor();
                        Color color5 = cells[i][d].getColor();
                        ArrayList<Color> colortab = new ArrayList<>(5);

                        if (!color1.equals(Color.WHITE)) {
                            colortab.add(color1);
                        }
                        if (!color2.equals(Color.WHITE)) {
                            colortab.add(color2);
                        }
                        if (!color3.equals(Color.WHITE)) {
                            colortab.add(color3);
                        }
                        if (!color4.equals(Color.WHITE)) {
                            colortab.add(color4);
                        }
                        if (!color5.equals(Color.WHITE)) {
                            colortab.add(color5);
                        }

                        if (!colortab.isEmpty()) {
                            return chooseWhichColorToPaint(colortab);
                        }
                    }

                case ("Absorbent"):
                    if (cells[i][j].getColor().equals(Color.WHITE)) {
                        int a1 = i - 1;
                        int b1 = i + 1;
                        int c1 = j - 1;
                        int d1 = j + 1;
                        Color colora1;
                        if (a1 < 0) {
                            colora1 = Color.WHITE;
                        } else {
                            colora1 = cells[a1][j].getColor();
                        }
                        Color colorc1;
                        if (c1 < 0) {
                            colorc1 = Color.WHITE;
                        } else {
                            colorc1 = cells[i][c1].getColor();
                        }
                        Color colord1;
                        if (d1 > cells[0].length - 1) {
                            colord1 = Color.WHITE;
                        } else {
                            colord1 = cells[i][d1].getColor();
                        }
                        Color colore1;
                        if (a1 < 0 || c1 < 0) {
                            colore1 = Color.WHITE;
                        } else {
                            colore1 = cells[a1][c1].getColor();
                        }
                        Color colorf1;
                        if (a1 < 0 || d1 > cells[0].length - 1) {
                            colorf1 = Color.WHITE;
                        } else {
                            colorf1 = cells[a1][d1].getColor();
                        }

                        ArrayList<Color> colortab1 = new ArrayList<>(5);

                        if (!colora1.equals(Color.WHITE)) {
                            colortab1.add(colora1);
                        }

                        if (!colorc1.equals(Color.WHITE)) {
                            colortab1.add(colorc1);
                        }
                        if (!colord1.equals(Color.WHITE)) {
                            colortab1.add(colord1);
                        }
                        if (!colore1.equals(Color.WHITE)) {
                            colortab1.add(colore1);
                        }
                        if (!colorf1.equals(Color.WHITE)) {
                            colortab1.add(colorf1);
                        }

                        if (!colortab1.isEmpty()) {
                            return chooseWhichColorToPaint(colortab1);
                        }
                    }
            }
        }
        //Option left
        else if(f ==1)
        {
            {
                switch (boundary_conditions) {
                    case ("Periodic"):
                        if (cells[i][j].getColor().equals(Color.WHITE)) {
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
                            Color color1 = cells[a][c].getColor();
                            Color color2 = cells[a][j].getColor();
                            Color color4 = cells[i][c].getColor();
                            Color color6 = cells[b][c].getColor();
                            Color color7 = cells[b][j].getColor();
                            ArrayList<Color> colortab = new ArrayList<>(5);

                            if (!color1.equals(Color.WHITE)) {
                                colortab.add(color1);
                            }
                            if (!color2.equals(Color.WHITE)) {
                                colortab.add(color2);
                            }
                            if (!color4.equals(Color.WHITE)) {
                                colortab.add(color4);
                            }
                            if (!color6.equals(Color.WHITE)) {
                                colortab.add(color6);
                            }
                            if (!color7.equals(Color.WHITE)) {
                                colortab.add(color7);
                            }
                            if (!colortab.isEmpty()) {
                                return chooseWhichColorToPaint(colortab);
                            }
                        }

                    case ("Absorbent"):
                        if (cells[i][j].getColor().equals(Color.WHITE)) {
                            int a1 = i - 1;
                            int b1 = i + 1;
                            int c1 = j - 1;
                            int d1 = j + 1;
                            Color colora1;
                            if (a1 < 0) {
                                colora1 = Color.WHITE;
                            } else {
                                colora1 = cells[a1][j].getColor();
                            }
                            Color colorb1;
                            if (b1 > cells.length - 1) {
                                colorb1 = Color.WHITE;
                            } else {
                                colorb1 = cells[b1][j].getColor();
                            }
                            Color colorc1;
                            if (c1 < 0) {
                                colorc1 = Color.WHITE;
                            } else {
                                colorc1 = cells[i][c1].getColor();
                            }
                            Color colore1;
                            if(a1<0 ||c1<0)
                            {
                                colore1 = Color.WHITE;
                            }
                            else
                            {
                                colore1 = cells[a1][c1].getColor();
                            }
                            Color colorg1;
                            if(b1> cells.length-1 || c1<0)
                            {
                                colorg1 = Color.WHITE;
                            }
                            else
                            {
                                colorg1 = cells[b1][c1].getColor();
                            }

                            ArrayList<Color> colortab1 = new ArrayList<>(5);

                            if (!colora1.equals(Color.WHITE)) {
                                colortab1.add(colora1);
                            }
                            if (!colorb1.equals(Color.WHITE)) {
                                colortab1.add(colorb1);
                            }
                            if (!colorc1.equals(Color.WHITE)) {
                                colortab1.add(colorc1);
                            }
                            if (!colore1.equals(Color.WHITE)) {
                                colortab1.add(colore1);
                            }
                            if (!colorg1.equals(Color.WHITE)) {
                                colortab1.add(colorg1);
                            }

                            if (!colortab1.isEmpty()) {
                                return chooseWhichColorToPaint(colortab1);
                            }
                        }
                }
            }
        }
        //Option right
        else if(f ==2)
        {
            {
                switch (boundary_conditions) {
                    case ("Periodic"):
                        if (cells[i][j].getColor().equals(Color.WHITE)) {
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
                            Color color2 = cells[a][j].getColor();
                            Color color3 = cells[a][d].getColor();
                            Color color5 = cells[i][d].getColor();
                            Color color7 = cells[b][j].getColor();
                            Color color8 = cells[b][d].getColor();
                            ArrayList<Color> colortab = new ArrayList<>(5);

                            if (!color2.equals(Color.WHITE)) {
                                colortab.add(color2);
                            }
                            if (!color3.equals(Color.WHITE)) {
                                colortab.add(color3);
                            }
                            if (!color5.equals(Color.WHITE)) {
                                colortab.add(color5);
                            }
                            if (!color7.equals(Color.WHITE)) {
                                colortab.add(color7);
                            }
                            if (!color8.equals(Color.WHITE)) {
                                colortab.add(color8);
                            }

                            if (!colortab.isEmpty()) {
                                return chooseWhichColorToPaint(colortab);
                            }
                        }

                    case ("Absorbent"):
                        if (cells[i][j].getColor().equals(Color.WHITE)) {
                            int a1 = i - 1;
                            int b1 = i + 1;
                            int c1 = j - 1;
                            int d1 = j + 1;
                            Color colora1;
                            if (a1 < 0) {
                                colora1 = Color.WHITE;
                            } else {
                                colora1 = cells[a1][j].getColor();
                            }
                            Color colorb1;
                            if (b1 > cells.length - 1) {
                                colorb1 = Color.WHITE;
                            } else {
                                colorb1 = cells[b1][j].getColor();
                            }
                            Color colord1;
                            if (d1 > cells[0].length - 1) {
                                colord1 = Color.WHITE;
                            } else {
                                colord1 = cells[i][d1].getColor();
                            }
                            Color colorf1;
                            if(a1<0 || d1> cells[0].length -1)
                            {
                                colorf1 =Color.WHITE;
                            }
                            else
                            {
                                colorf1 = cells[a1][d1].getColor();
                            }
                            Color colorh1;
                            if(b1> cells.length-1 || d1>cells[0].length-1)
                            {
                                colorh1 = Color.WHITE;
                            }
                            else
                            {
                                colorh1 = cells[b1][d1].getColor();
                            }

                            ArrayList<Color> colortab1 = new ArrayList<>(5);

                            if (!colora1.equals(Color.WHITE)) {
                                colortab1.add(colora1);
                            }
                            if (!colorb1.equals(Color.WHITE)) {
                                colortab1.add(colorb1);
                            }
                            if (!colord1.equals(Color.WHITE)) {
                                colortab1.add(colord1);
                            }
                            if (!colorf1.equals(Color.WHITE)) {
                                colortab1.add(colorf1);
                            }
                            if (!colorh1.equals(Color.WHITE)) {
                                colortab1.add(colorh1);
                            }

                            if (!colortab1.isEmpty()) {
                                return chooseWhichColorToPaint(colortab1);
                            }
                        }
                }
            }
        }
        //Option top
        else if(f ==3)
        {
            {
                switch (boundary_conditions) {
                    case ("Periodic"):
                        if (cells[i][j].getColor().equals(Color.WHITE)) {
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
                            Color color4 = cells[i][c].getColor();
                            Color color5 = cells[i][d].getColor();
                            Color color6 = cells[b][c].getColor();
                            Color color7 = cells[b][j].getColor();
                            Color color8 = cells[b][d].getColor();
                            ArrayList<Color> colortab = new ArrayList<>(5);

                            if (!color4.equals(Color.WHITE)) {
                                colortab.add(color4);
                            }
                            if (!color5.equals(Color.WHITE)) {
                                colortab.add(color5);
                            }
                            if (!color6.equals(Color.WHITE)) {
                                colortab.add(color6);
                            }
                            if (!color7.equals(Color.WHITE)) {
                                colortab.add(color7);
                            }
                            if (!color8.equals(Color.WHITE)) {
                                colortab.add(color8);
                            }

                            if (!colortab.isEmpty()) {
                                return chooseWhichColorToPaint(colortab);
                            }
                        }

                    case ("Absorbent"):
                        if (cells[i][j].getColor().equals(Color.WHITE)) {
                            int a1 = i - 1;
                            int b1 = i + 1;
                            int c1 = j - 1;
                            int d1 = j + 1;
                            Color colorb1;
                            if (b1 > cells.length - 1) {
                                colorb1 = Color.WHITE;
                            } else {
                                colorb1 = cells[b1][j].getColor();
                            }
                            Color colorc1;
                            if (c1 < 0) {
                                colorc1 = Color.WHITE;
                            } else {
                                colorc1 = cells[i][c1].getColor();
                            }
                            Color colord1;
                            if (d1 > cells[0].length - 1) {
                                colord1 = Color.WHITE;
                            } else {
                                colord1 = cells[i][d1].getColor();
                            }
                            Color colorg1;
                            if(b1> cells.length-1 || c1<0)
                            {
                                colorg1 = Color.WHITE;
                            }
                            else
                            {
                                colorg1 = cells[b1][c1].getColor();
                            }
                            Color colorh1;
                            if(b1> cells.length-1 || d1>cells[0].length-1)
                            {
                                colorh1 = Color.WHITE;
                            }
                            else
                            {
                                colorh1 = cells[b1][d1].getColor();
                            }

                            ArrayList<Color> colortab1 = new ArrayList<>(5);

                            if (!colorb1.equals(Color.WHITE)) {
                                colortab1.add(colorb1);
                            }
                            if (!colorc1.equals(Color.WHITE)) {
                                colortab1.add(colorc1);
                            }
                            if (!colord1.equals(Color.WHITE)) {
                                colortab1.add(colord1);
                            }
                            if (!colorg1.equals(Color.WHITE)) {
                                colortab1.add(colorg1);
                            }
                            if (!colorh1.equals(Color.WHITE)) {
                                colortab1.add(colorh1);
                            }

                            if (!colortab1.isEmpty()) {
                                return chooseWhichColorToPaint(colortab1);
                            }
                        }
                }
            }
        }
            return cells[i][j].getColor();

    }
    public static Color calculate_Hexagonal_left(Cell[][] cells, int i, int j, String boundary_conditions) {
        switch (boundary_conditions) {
            case ("Periodic"):
                if (cells[i][j].getColor().equals(Color.WHITE)) {
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
                    Color color2 = cells[a][j].getColor();
                    Color color3 = cells[a][d].getColor();
                    Color color4 = cells[i][c].getColor();
                    Color color5 = cells[i][d].getColor();
                    Color color6 = cells[b][c].getColor();
                    Color color7 = cells[b][j].getColor();

                    ArrayList<Color> colortab = new ArrayList<>(5);

                    if (!color2.equals(Color.WHITE)) {
                        colortab.add(color2);
                    }
                    if (!color3.equals(Color.WHITE)) {
                        colortab.add(color3);
                    }
                    if (!color4.equals(Color.WHITE)) {
                        colortab.add(color4);
                    }
                    if (!color5.equals(Color.WHITE)) {
                        colortab.add(color5);
                    }
                    if (!color6.equals(Color.WHITE)) {
                        colortab.add(color6);
                    }
                    if (!color7.equals(Color.WHITE)) {
                        colortab.add(color7);
                    }

                    if (!colortab.isEmpty()) {
                        return chooseWhichColorToPaint(colortab);
                    }
                }

            case ("Absorbent"):
                if (cells[i][j].getColor().equals(Color.WHITE)) {
                    int a1 = i - 1;
                    int b1 = i + 1;
                    int c1 = j - 1;
                    int d1 = j + 1;
                    Color colora1;
                    if (a1 < 0) {
                        colora1 = Color.WHITE;
                    } else {
                        colora1 = cells[a1][j].getColor();
                    }
                    Color colorb1;
                    if (b1 > cells.length - 1) {
                        colorb1 = Color.WHITE;
                    } else {
                        colorb1 = cells[b1][j].getColor();
                    }
                    Color colorc1;
                    if (c1 < 0) {
                        colorc1 = Color.WHITE;
                    } else {
                        colorc1 = cells[i][c1].getColor();
                    }
                    Color colord1;
                    if (d1 > cells[0].length - 1) {
                        colord1 = Color.WHITE;
                    } else {
                        colord1 = cells[i][d1].getColor();
                    }

                    Color colorf1;
                    if (a1 < 0 || d1 > cells[0].length - 1) {
                        colorf1 = Color.WHITE;
                    } else {
                        colorf1 = cells[a1][d1].getColor();
                    }
                    Color colorg1;
                    if (b1 > cells.length - 1 || c1 < 0) {
                        colorg1 = Color.WHITE;
                    } else {
                        colorg1 = cells[b1][c1].getColor();
                    }


                    ArrayList<Color> colortab1 = new ArrayList<>(5);

                    if (!colora1.equals(Color.WHITE)) {
                        colortab1.add(colora1);
                    }
                    if (!colorb1.equals(Color.WHITE)) {
                        colortab1.add(colorb1);
                    }
                    if (!colorc1.equals(Color.WHITE)) {
                        colortab1.add(colorc1);
                    }
                    if (!colord1.equals(Color.WHITE)) {
                        colortab1.add(colord1);
                    }
                    if (!colorf1.equals(Color.WHITE)) {
                        colortab1.add(colorf1);
                    }
                    if (!colorg1.equals(Color.WHITE)) {
                        colortab1.add(colorg1);
                    }

                    if (!colortab1.isEmpty()) {
                        return chooseWhichColorToPaint(colortab1);
                    }
                }
        }

        return cells[i][j].getColor();

    }
    public static Color calculate_Hexagonal_right(Cell[][] cells, int i,int j, String boundary_conditions)
    {
        switch (boundary_conditions) {
            case ("Periodic"):
                if (cells[i][j].getColor().equals(Color.WHITE)) {
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
                    Color color1 = cells[a][c].getColor();
                    Color color2 = cells[a][j].getColor();
                    Color color4 = cells[i][c].getColor();
                    Color color5 = cells[i][d].getColor();
                    Color color7 = cells[b][j].getColor();
                    Color color8 = cells[b][d].getColor();
                    ArrayList<Color> colortab = new ArrayList<>(5);

                    if (!color1.equals(Color.WHITE)) {
                        colortab.add(color1);
                    }
                    if (!color2.equals(Color.WHITE)) {
                        colortab.add(color2);
                    }
                    if (!color4.equals(Color.WHITE)) {
                        colortab.add(color4);
                    }
                    if (!color5.equals(Color.WHITE)) {
                        colortab.add(color5);
                    }
                    if (!color7.equals(Color.WHITE)) {
                        colortab.add(color7);
                    }
                    if (!color8.equals(Color.WHITE)) {
                        colortab.add(color8);
                    }

                    if (!colortab.isEmpty()) {
                        return chooseWhichColorToPaint(colortab);
                    }
                }

            case ("Absorbent"):
                if (cells[i][j].getColor().equals(Color.WHITE)) {
                    int a1 = i - 1;
                    int b1 = i + 1;
                    int c1 = j - 1;
                    int d1 = j + 1;
                    Color colora1;
                    if (a1 < 0) {
                        colora1 = Color.WHITE;
                    } else {
                        colora1 = cells[a1][j].getColor();
                    }
                    Color colorb1;
                    if (b1 > cells.length - 1) {
                        colorb1 = Color.WHITE;
                    } else {
                        colorb1 = cells[b1][j].getColor();
                    }
                    Color colorc1;
                    if (c1 < 0) {
                        colorc1 = Color.WHITE;
                    } else {
                        colorc1 = cells[i][c1].getColor();
                    }
                    Color colord1;
                    if (d1 > cells[0].length - 1) {
                        colord1 = Color.WHITE;
                    } else {
                        colord1 = cells[i][d1].getColor();
                    }
                    Color colore1;
                    if(a1<0 ||c1<0)
                    {
                        colore1 = Color.WHITE;
                    }
                    else
                    {
                        colore1 = cells[a1][c1].getColor();
                    }
                    Color colorh1;
                    if(b1> cells.length-1 || d1>cells[0].length-1)
                    {
                        colorh1 = Color.WHITE;
                    }
                    else
                    {
                        colorh1 = cells[b1][d1].getColor();
                    }

                    ArrayList<Color> colortab1 = new ArrayList<>(5);

                    if (!colora1.equals(Color.WHITE)) {
                        colortab1.add(colora1);
                    }
                    if (!colorb1.equals(Color.WHITE)) {
                        colortab1.add(colorb1);
                    }
                    if (!colorc1.equals(Color.WHITE)) {
                        colortab1.add(colorc1);
                    }
                    if (!colord1.equals(Color.WHITE)) {
                        colortab1.add(colord1);
                    }
                    if (!colore1.equals(Color.WHITE)) {
                        colortab1.add(colore1);
                    }
                    if (!colorh1.equals(Color.WHITE)) {
                        colortab1.add(colorh1);
                    }

                    if (!colortab1.isEmpty()) {
                        return chooseWhichColorToPaint(colortab1);
                    }
                }
        }
        return cells[i][j].getColor();
    }

    private static Color chooseWhichColorToPaint(List<Color> list) {
        int max = 0;
        int curr = 0;
        Color currKey = null;
        Set<Color> unique = new HashSet<>(list);
        for (Color key : unique) {
            curr = Collections.frequency(list, key);
            if (max < curr) {
                max = curr;
                currKey = key;
            }
        }
        return currKey;
    }
}




