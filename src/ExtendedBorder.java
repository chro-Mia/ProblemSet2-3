import images.*;
import java.util.Scanner;
public class ExtendedBorder
{
    public static void main(String[] args)
    {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter an image file name:");
        String filename = input.nextLine();
        APImage image = new APImage(filename);
        APImage canvas = new APImage(image.getImageWidth() + 40, image.getImageHeight() + 40);

        System.out.println("Enter a RBG value separated by spaces, like this [red grn blu]:");
        int r = input.nextInt();
        int g = input.nextInt();
        int b = input.nextInt();
        Pixel p = new Pixel(r, g, b);

        //north to south
        //this loop iterates through all the pixels of one column once per column
        //it does this exactly 20 times for the first and last 20 pixels of the east and west border
        for (int i = 0; i < 20; i++){
            for (int j = 0; j < canvas.getImageHeight(); j++){
                canvas.setPixel(i, j, p);
                canvas.setPixel(canvas.getImageWidth() - i - 1, canvas.getImageHeight() - j - 1, p);
            }
        }

        //east to west
        //this loop iterates through all the pixels of one row once per row
        //it does this exactly 20 times for the first and last 20 pixels of the north and south border
        for (int i = 0; i < 20; i++){
            for (int j = 0; j < canvas.getImageWidth(); j++){
                canvas.setPixel(j, i, p);
                canvas.setPixel(canvas.getImageWidth() - j - 1, canvas.getImageHeight() - i - 1, p);
            }
        }

        //this essentially moves the chosen image to the center of the border
        for(int i = 0; i < image.getImageHeight(); i++){
            for(int j = 0; j < image.getImageWidth(); j++){
                canvas.setPixel(j + 20, i + 20, image.getPixel(j, i));
            }
        }

        /*
        //north check
        p = canvas.getPixel(canvas.getImageWidth() / 2, 19);
        if(p.getRed() == r && p.getGreen() == g && p.getBlue() == b){
            System.out.println("North check PASSED!");
        }
        else{
            System.out.println("North check FAILED!");
        }

        //south check
        p = canvas.getPixel(canvas.getImageWidth() / 2, canvas.getImageHeight() - 19);
        if(p.getRed() == r && p.getGreen() == g && p.getBlue() == b){
            System.out.println("South check PASSED!");
        }
        else{
            System.out.println("South check FAILED!");
        }

        //east check
        p = canvas.getPixel(canvas.getImageWidth() - 19, canvas.getImageHeight() / 2);
        if(p.getRed() == r && p.getGreen() == g && p.getBlue() == b){
            System.out.println("East check PASSED!");
        }
        else{
            System.out.println("East check FAILED!");
        }

        //west check
        p = canvas.getPixel(19, canvas.getImageHeight() / 2);
        if(p.getRed() == r && p.getGreen() == g && p.getBlue() == b){
            System.out.println("West check PASSED!");
        }
        else{
            System.out.println("West check FAILED!");
        }

         */

        canvas.draw();
    }
}