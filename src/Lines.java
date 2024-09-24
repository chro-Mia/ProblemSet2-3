import images.*;
import java.util.Scanner;
public class Lines
{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an image file name:");
        String filename = input.nextLine();

        //creates a new image object with an existing image
        APImage image = new APImage(filename);

        //creates a red pixel object used to overwrite
        Pixel red = new Pixel(255, 0 ,0);

        //for each pixel in on the y-axis, replace the pixel halfway in the x-axis with red
        for(int i = 0; i < image.getImageHeight(); i++){
            image.setPixel(image.getImageWidth() / 2, i, red);
        }

        //for each pixel in on the x-axis, replace the pixel halfway in the y-axis with red
        for(int i = 0; i < image.getImageWidth(); i++){
            image.setPixel(i, image.getImageHeight() / 2, red);
        }

        image.draw();
    }
}
