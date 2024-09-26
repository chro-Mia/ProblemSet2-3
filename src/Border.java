import images.*;
import java.util.Scanner;
public class Border
{
    public static void main(String[] args)
    {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter an image file name:");
        String filename = input.nextLine();
        APImage image = new APImage(filename);

        System.out.println("Enter a RBG value separated by spaces, like this [red grn blu]:");
        int r = input.nextInt();
        int g = input.nextInt();
        int b = input.nextInt();
        Pixel p = new Pixel(r, g ,b);

        //north to south
        //this loop iterates through all the pixels of one column once per column
        //it does this exactly 20 times for the first and last 20 pixels of the east and west border
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < image.getImageHeight(); j++){
                image.setPixel(i, j, p);
                image.setPixel(image.getImageWidth() - i - 1, image.getImageHeight() - j - 1, p);
            }
        }

        //east to west
        //this loop iterates through all the pixels of one row once per row
        //it does this exactly 20 times for the first and last 20 pixels of the north and south border
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < image.getImageWidth(); j++){
                image.setPixel(j, i, p);
                image.setPixel(image.getImageWidth() - j - 1, image.getImageHeight() - i - 1, p);
            }
        }


        //verification test
        //there are ways to fool this test, but it would only happen under ultra-specific circumstances so this check
        //is generally trustworthy

        //north check
        p = image.getPixel(image.getImageWidth() / 2, 19);
        if(p.getRed() == r && p.getGreen() == g && p.getBlue() == b){
            System.out.println("North check PASSED!");
        }
        else{
            System.out.println("North check FAILED!");
        }

        //south check
        p = image.getPixel(image.getImageWidth() / 2, image.getImageHeight() - 19);
        if(p.getRed() == r && p.getGreen() == g && p.getBlue() == b){
            System.out.println("South check PASSED!");
        }
        else{
            System.out.println("South check FAILED!");
        }

        //east check
        p = image.getPixel(image.getImageWidth() - 19, image.getImageHeight() / 2);
        if(p.getRed() == r && p.getGreen() == g && p.getBlue() == b){
            System.out.println("East check PASSED!");
        }
        else{
            System.out.println("East check FAILED!");
        }

        //west check
        p = image.getPixel(19, image.getImageHeight() / 2);
        if(p.getRed() == r && p.getGreen() == g && p.getBlue() == b){
            System.out.println("West check PASSED!");
        }
        else{
            System.out.println("West check FAILED!");
        }

        image.draw();
    }
}
