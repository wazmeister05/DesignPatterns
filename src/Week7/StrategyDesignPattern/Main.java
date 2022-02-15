package Week7.StrategyDesignPattern;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Application app = new Application();

        String text = "Some text data";
        // choosing save as text.
        app.saveAs(new ZipCompression());
        app.save(text);

        Random rnd = new Random();
        double[] music = new double[1000];
        for(int i = 0; i < 1000; i++){
            music[i] = rnd.nextDouble();
        }
        // choosing save as flac
        app.saveAs(new FlacCompression());
        app.save(music);

        int[][] image = new int[800][600];
        for(int i = 0; i < 800; i++){
            for(int j = 0; j < 600; j++){
                image[i][j] = rnd.nextInt();
            }
        }
        // choosing save as png
        app.saveAs(new PngCompression());
        app.save(image);

        // nothing to stop us saving ordinary text as an image...
        app.save(text);
    }
}
