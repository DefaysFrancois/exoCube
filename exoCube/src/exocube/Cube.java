/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exocube;

import java.text.DecimalFormat;

/**
 *
 * @author Def
 */
public class Cube {

    double lenght;
    String name;
    String color;

    public void setLenght(double lenght) throws NotPositiveException {
        if (lenght < 0) {
            throw new NotPositiveException();
        } else {
            this.lenght = lenght;
        }
    }

    public void setName(String name) throws  StringToLongOrShortException{
        if (name.length() < 3 || name.length() > 15) {
            throw new StringToLongOrShortException();
        } else {
            this.name = name;
        }
    }

    public void setColor(Integer r, Integer g, Integer b) throws NotAColorException {
        /* en hexa RGB */
        if ((r < 0 || r > 255)
                || (g < 0 || g > 255)
                || (b < 0 || b > 255)) {
            throw new NotAColorException();

        } else {
            DecimalFormat intForm = new DecimalFormat("00");
            r = Integer.parseInt(intForm.format((double)r));
            this.color = ("#" 
                    + String.format("%02X",r))  
                    + String.format("%02X",g)
                    + String.format("%02X",b);
        }
    }

    public double getLenght() {
        return lenght;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
    
    @Override
    public String toString(){
        return(name + " : lenght = " + lenght + " color : " + color);
    }
}
