import images.*;
import java.util.Scanner;
public class Filter
{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an image file name:");
        String filename = input.nextLine();
        APImage image = new APImage(filename);

        System.out.println("Enter an RBG value separated by spaces, like this [red grn blu]");
        int r = input.nextInt();
        int g = input.nextInt();
        int b = input.nextInt();


        //this loop iterates though every pixel in the image
        for(int i = 0; i < image.getImageWidth(); i++)
        {
            for (int j = 0; j < image.getImageHeight(); j++)
            {
                //create override pixel
                Pixel p = image.getPixel(i, j);

                //modifies red
                p.setRed(r + p.getRed());
                if(r + p.getRed() > 255){
                    p.setRed(255);
                }
                if(r + p.getRed() < 0){
                    p.setRed(0);
                }

                //modifies green
                p.setGreen(g + p.getGreen());
                if(g + p.getGreen() > 255){
                    p.setGreen(255);
                }
                if(g + p.getGreen() < 0){
                    p.setGreen(0);
                }

                //modifies blue
                p.setBlue(b + p.getBlue());
                if(b + p.getBlue() > 255){
                    p.setBlue(255);
                }
                if(b + p.getBlue() < 0){
                    p.setBlue(0);
                }

                image.setPixel(i, j, p);
            }
        }

        image.draw();
    }
}
