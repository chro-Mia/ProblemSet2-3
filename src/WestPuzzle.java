import images.*;
public class WestPuzzle
{
    public static void main(String[] args){
        APImage image = new APImage("west-puzzle.png");

        //for-each pixel in the image...
        for(Pixel p : image){

                //remove all red and green
                p.setRed(0);
                p.setGreen(0);

                //ignore blue values greater than 16
                if(p.getBlue() > 16){
                    p.setBlue(0);
                }
                //multiply blue values less than 16 by 16
                else{
                    p.setBlue(p.getBlue() * 16);
                }

                //change blue to red
                p.setRed(p.getBlue());
                p.setBlue(0);
        }
        image.draw();
    }
}
