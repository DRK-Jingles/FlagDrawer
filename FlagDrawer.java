// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for Assignment 2  COMP102
 * Name: Adam Hearps
 * Usercode:hearpsadam
 * ID:300357488
 */

import ecs100.*;
import java.awt.Color;

/**
 * Draws flags of various countries.
 * The correct dimensions of the official flags varies from country to country,
 * But you may assume that they are 2/3 as high as they are wide.
 * The exact colours of the flags will also be difficult to match;
 * It is fine to use the standard colours: red, green, blue, orange, etc
 * You can find lots of flag details (including the correct dimensions and colours)
 * from   http://www.crwflags.com/fotw/flags/    
 */
public class FlagDrawer{

    public static final double top = 100;
    public static final double left = 50;


    /** Constructor, sets up the user interface */
    public FlagDrawer(){
        UI.initialise();
        UI.addButton("Clear", UI::clearGraphics);

        UI.addButton("Core: Denmark", this::denmarkFlag);
        UI.addButton("Core: Greece", this::greeceFlag);
        UI.addButton("Core: Mauritania", this::simplifiedMauritaniaFlag);

        //COMPLETION
        UI.addButton("Completion: Star", this::starFlag);
        UI.addButton("Completion: Pacman", this::pacmanFlag);
        UI.addButton("Challenge: Israel", this::israelFlag);

        //CHALLENGE
        UI.addButton("Challenge: Seychelles", this::seychellesFlag);
        UI.addButton("Quit", UI::quit);
    }


    /**
     * The flag for Denmark is a red rectangle with
     * a white cross over it.
     * (alternatively, it is four red rectangles on a white background!)
     */
    public void denmarkFlag() {
        
        
        double width = UI.askDouble("Width");         //asks user for width of flag
        double height = (width)*2/3;                  //sets height of flag
        
        double vertxside = (left)+(width*12/37);      //sets start side of vertical cross
        double vertxwidth = (width)*4/37;             //sets width of vertical cross
        double horzxtop = (top)+(height)*3/7;         //sets top of horizontal stripe
        double horzxheight = (height)*1/7;            //sets height of horizontal stripe

        UI.clearGraphics();                             //clears graphics
        UI.setColor(Color.red);                         //set color to red
        UI.fillRect(left,top,width,height);             //draw filled rectangle for flag
        UI.setColor(Color.white);                       //set color to white
        UI.fillRect(vertxside,top,vertxwidth,height);   //draw vertical white stripe for cross
        UI.fillRect(left,horzxtop,width,horzxheight);   //draw horizontal white strip for cross
        UI.setColor(Color.black);                       //set color to black
        UI.drawRect(left,top,width,height);             //draw black outline on flag
        

    }

    /**
     * The flag for Greece has blue and white strips, and
     * a white cross on a blue background in the top left corner.
     * The blue is a dark blue. 
     */
    public void greeceFlag() {
        
        double width = UI.askDouble("Width");         //asks user for width of flag
        double height = (width)*2/3;                  //sets height of flag
        
        double stripeheight = (height)*1/9;           //sets height/depth of stripes
        double stripe1top = (top)+(height)*1/9;         //sets start height of stripe 1
        double stripe2top = (top)+(height)*3/9;         //'''''''''''''''''stripe 2
        double stripe3top = (top)+(height)*5/9;         //'''''''''''''''''stripe 3
        double stripe4top = (top)+(height)*7/9;         //'''''''''''''''''stripe 4
        double horzxtop = (top)+(height)*2/9;           //sets start height of horizontal cross stripe
        double vertxside = (left)+(height)*2/9;         //sets start side of vertical cross stripe
        double box = (height)*5/9;                      //sets size of cross's box
        
        UI.clearGraphics();                                 //clear graphics
        UI.setColor(Color.blue.darker());                   //set color dark blue
        UI.fillRect(left,top,width,height);                 //draw blue flag
        UI.setColor(Color.white);                           //set color white
        UI.fillRect(left,stripe1top,width,stripeheight);    //draw stripe 1
        UI.fillRect(left,stripe2top,width,stripeheight);    //draw stripe 2
        UI.fillRect(left,stripe3top,width,stripeheight);    //draw stripe 3
        UI.fillRect(left,stripe4top,width,stripeheight);    //draw stripe 4
        UI.setColor(Color.blue.darker());                   //set color dark blue
        UI.fillRect(left,top,box,box);                      //draw cross's box
        UI.setColor(Color.white);                           //set color white
        UI.fillRect(left,horzxtop,box,stripeheight);        //draw horizontal cross stripe
        UI.fillRect(vertxside,top,stripeheight,box);        //draw vertical cross stripe
        UI.setColor(Color.black);                           //set color black
        UI.drawRect(left,top,width,height);                 //draw black outline on flag

    }

    /**
     * The Mauritania flag (simplified)  is a green background with
     * a yellow crescent moon and a yellow circle.
     * (The real flag has a 5 pointed star in place of the circle
     */
    public void simplifiedMauritaniaFlag() {
        
        double width = UI.askDouble("Width");         //asks user for width of flag
        double height = (width)*2/3;                  //sets height of flag
        
        double star = (width)*1/6;                    //set size of 'star'
        double circ1w = (width)*15/36;                //set width inner oval
        double circ2w = (width)*31/72;                  //set width outer oval
        double circ1h = (width)*7/18;                   //set height inner oval
        double starleft = (left)+(width)*15/36;         //set 'star' left start point
        double startop = (top)+(height)*1/6;            //set 'star' top start point
        double circ1left = (left)+(width)*21/72;        //set inner oval left start point
        double circ1top = (top);                        //set inner oval top start point
        double circ2left = (left)+(width)*20.5/72;       //set outer oval start point
        double circ2top = (top)+(height)*2.5/48;         //set outer oval top start point
        
        UI.clearGraphics();                             //clear graphics
        UI.setColor(Color.green);                       //set color green
        UI.fillRect(left,top,width,height);             //draw green flag
        UI.setColor(Color.yellow);                      //set color yellow
        UI.fillOval(circ2left,circ2top,circ2w,circ2w);  //draw yellow outer oval
        UI.setColor(Color.green);                       //set color green
        UI.fillOval(circ1left,circ1top,circ1w,circ1h);  //draw green inner oval
        UI.setColor(Color.yellow);                      //set color yellow
        UI.fillOval(starleft,startop,star,star);        //draw yellow 'star'
        UI.setColor(Color.black);                       //set color black
        UI.drawRect(left,top,width,height);             //draw black outline on flag
        

    }

    /**
     * Completion: Six pointed Star on a white background.
     * The lines should be several pixels thick.
     */
    public  void starFlag() {
        
        double width = UI.askDouble("Width");           //Ask user for width
        double height = (width)*(2/(Math.sqrt(3)));     //Set height
        
        double ax = (left+width*1/2);                   //calculate x co-ordinate for point a
        double ay = (top);                              //calculate y co-ordinate for point a
        double bx = (left);                             //calculate x co-ordinate for point b
        double by = (top+height*1/4);                   //calculate y co-ordinate for point b
        double cx = (left+width);                       //calculate x co-ordinate for point c
        double cy = (top+height*1/4);                   //calculate y co-ordinate for point c
        double dx = (left);                             //calculate x co-ordinate for point d
        double dy = (top+height*3/4);                   //calculate y co-ordinate for point d
        double ex = (left+width);                       //calculate x co-ordinate for point e
        double ey = (top+height*3/4);                   //calculate y co-ordinate for point e
        double fx = (left+width*1/2);                   //calculate x co-ordinate for point f
        double fy = (top+height);                       //calculate y co-ordinate for point f
        
        UI.clearGraphics();                         //Clear graphics
        UI.setLineWidth(4);                         //set line width for flag outline
        UI.drawRect(left,top,width,height);         //draw flag outline
        UI.setColor(Color.blue);                    //set color to blue
        UI.drawLine(ax,ay,dx,dy);                   //draw line point a to point d
        UI.drawLine(dx,dy,ex,ey);                   //draw line point d to point e
        UI.drawLine(ex,ey,ax,ay);                   //draw line point e to point a
        UI.drawLine(bx,by,fx,fy);                   //draw line point b to point f
        UI.drawLine(fx,fy,cx,cy);                   //draw line point f to point c
        UI.drawLine(cx,cy,bx,by);                   //draw line point c to point b
        UI.setLineWidth(1);                         //reset line width
        UI.setColor(Color.black);                   //set color to black
        
    }

    /**
     * Completion: pacman
     * A yellow pacman on a black background chasing white, red, and green dots.
     */
    public  void pacmanFlag() {
        
        double width = UI.askDouble("width");           //ask user for width
        double height = (width)*2/3;                    //set flag height
        double dot = (width)*1/15;                      //set dot size
        double pacman = (width)*1/3;                    //set pacman size
        
        double dotT = (top)+(height)*9/20;              //set dot top height
        double dot1L = (left)+(width)*1/2;              //set left hand side of dot 1
        double dot2L = (left)+(width)*19/30;            //set left hand side of dot 2
        double dot3L = (left)+(width)*23/30;            //set left hand side of dot 3
        double pacmanT = (top)+(height)*1/4;            //set pacman top height
        double pacmanL = (left)+(width)*1/10;           //set left hand side of pacman
        double pacstartr = -(Math.asin(((dot)*3/2)/((pacman)/2)));      //calculate mouth arc start location in radians
        double pacstartdeg = Math.toDegrees(pacstartr);                 //convert radians to degrees
        double pacarc = (pacstartdeg)*-2;                               //calculate size of mouth arc
        
        
        UI.clearGraphics();                             //clear graphics
        UI.setColor(Color.black);                       //set colour black
        UI.fillRect(left,top,width,height);             //draw black flag
        UI.setColor(Color.white);                       //set color white
        UI.fillOval(dot1L,dotT,dot,dot);                //draw white dot
        UI.setColor(Color.red);                         //set color red
        UI.fillOval(dot2L,dotT,dot,dot);                //draw red dot
        UI.setColor(Color.green);                       //set color green
        UI.fillOval(dot3L,dotT,dot,dot);                //draw green dot
        UI.setColor(Color.yellow);                      //set color yellow
        UI.fillOval(pacmanL,pacmanT,pacman,pacman);     //draw pacman shape
        UI.setColor(Color.black);                       //set color black
        UI.fillArc(pacmanL,pacmanT,pacman,pacman,pacstartdeg,pacarc);   //draw arc for mouth
        
    }

    /**
     * Challenge: The flag of Israel
     * Two horizontal blue stripes and a 6 pointed star on a white background
     */
    public  void israelFlag() {
        
        double width = UI.askDouble("Width");               //ask user for width
        double height = (width)*2/3;                        //sets height of flag
        double barT = (height)*5/33;                        //sets thickness of bars
        double bar1top = (top)+(height)*1/11;               //sets top height of bar 1
        double bar2top = (top)+(height)*24/33;              //sets top height of bar 2
        
        double starboxT = (top)+(height)*10/33;             //sets top of 'starbox'
        double starboxH = (height)*12/33;                   //sets height of 'starbox'
        double starboxW = (starboxH)/(2/(Math.sqrt(3)));    //sets width of 'starbox'
        double starboxL = (left)+((width)-(starboxH))*1/2;  //sets start side of 'starbox'
        
        double ax = (starboxL+starboxW*1/2);                //calculate x co-ordinate for point a
        double ay = (starboxT);                         //calculate y co-ordinate for point a
        double bx = (starboxL);                             //calculate x co-ordinate for point b
        double by = (starboxT+starboxH*1/4);                   //calculate y co-ordinate for point b
        double cx = (starboxL+starboxW);                       //calculate x co-ordinate for point c
        double cy = (starboxT+starboxH*1/4);                   //calculate y co-ordinate for point c
        double dx = (starboxL);                             //calculate x co-ordinate for point d
        double dy = (starboxT+starboxH*3/4);                   //calculate y co-ordinate for point d
        double ex = (starboxL+starboxW);                       //calculate x co-ordinate for point e
        double ey = (starboxT+starboxH*3/4);                   //calculate y co-ordinate for point e
        double fx = (starboxL+starboxW*1/2);                   //calculate x co-ordinate for point f
        double fy = (starboxT+starboxH);                       //calculate y co-ordinate for point f
               
        
        UI.clearGraphics();                         //clear graphics
        UI.setColor(Color.black);                   //set color black
        UI.drawRect(left,top,width,height);         //draws flag outline
        UI.setColor(Color.blue);                    //sets color blue
        UI.fillRect(left,bar1top,width,barT);       //draws blue bar at top
        UI.fillRect(left,bar2top,width,barT);       //draws blue bar at bottom
        UI.setLineWidth(4);                         //sets line width for star
        UI.drawLine(ax,ay,dx,dy);                   //draw line point a to point d
        UI.drawLine(dx,dy,ex,ey);                   //draw line point d to point e
        UI.drawLine(ex,ey,ax,ay);                   //draw line point e to point a
        UI.drawLine(bx,by,fx,fy);                   //draw line point b to point f
        UI.drawLine(fx,fy,cx,cy);                   //draw line point f to point c
        UI.drawLine(cx,cy,bx,by);                   //draw line point c to point b
        UI.setLineWidth(1);                         //reset line width

    }

    /** 
     *  Challenge: the flag of the Seychelles
     *  Radiating triangles.
     */
    public  void seychellesFlag() {
        
        double width = UI.askDouble("Width");       //ask user for width
        double height = (width)*2/3;                //set height of flag
        
        double ax = (left);                         //set x co-ordinate for point a
        double ay = (top);                          //set y co-ordinate for point a
        double bx = (left)+(width)*1/3;             //set x co-ordinate for point b
        double by = (top);                          //set y co-ordinate for point b
        double cx = (left)+(width)*2/3;             //set x co-ordinate for point c
        double cy = (top);                          //set y co-ordinate for point c
        double dx = (left)+(width);                 //set x co-ordinate for point d
        double dy = (top);                          //set y co-ordinate for point d
        double ex = (left)+(width);                 //set x co-ordinate for point e
        double ey = (top)+(height)*1/3;             //set y co-ordinate for point e
        double fx = (left)+(width);                 //set x co-ordinate for point f
        double fy = (top)+(height)*2/3;             //set y co-ordinate for point f
        double gx = (left)+(width);                 //set x co-ordinate for point g
        double gy = (top)+(height);                 //set y co-ordinate for point g
        double hx = (left);                         //set x co-ordinate for point h
        double hy = (top)+(height);                 //set y co-ordinate for point h
        
        double []x1 = {ax,bx,hx};                   //Group x co-ordinates for polygon 1
        double []y1 = {ay,by,hy};                   //Group y co-ordinates for polygon 1
        double []x2 = {bx,cx,hx};                   //Group x co-ordinates for polygon 2
        double []y2 = {by,cy,hy};                   //Group y co-ordinates for polygon 2
        double []x3 = {cx,dx,ex,hx};                //Group x co-ordinates for polygon 3
        double []y3 = {cy,dy,ey,hy};                //Group y co-ordinates for polygon 3
        double []x4 = {fx,gx,hx};                   //Group x co-ordinates for polygon 4
        double []y4 = {fy,gy,hy};                   //Group y co-ordinates for polygon 4
        double []x5 = {ex,fx,hx};                   //Group x co-ordinates for polygon 5
        double []y5 = {ey,fy,hy};                   //Group y co-ordinates for polygon 5
        
        UI.clearGraphics();                         //clear graphics
        UI.drawRect(left,top,width,height);         //draw flag outline
        UI.setColor(Color.blue);                    //set color blue
        UI.fillPolygon(x1, y1,3);                   //draw polygon 1
        UI.setColor(Color.yellow);                  //set color yellow
        UI.fillPolygon(x2, y2,3);                   //draw polygon 2
        UI.setColor(Color.red);                     //set color red
        UI.fillPolygon(x3, y3,4);                   //draw polygon 3
        UI.setColor(Color.green);                   //set color green
        UI.fillPolygon(x4, y4,3);                   //draw polygon 4
        UI.setColor(Color.white);                   //set color white
        UI.fillPolygon(x5,y5,3);                    //draw polygon 5
        UI.setColor(Color.black);                   //set color black
        UI.drawRect(left,top,width,height);         //redraw flag outline
        
    }



}
