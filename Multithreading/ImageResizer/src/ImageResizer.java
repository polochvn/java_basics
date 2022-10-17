import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;

public class ImageResizer implements Runnable {

    private File[] files;
    private int newWidth;
    private String dstFolder;

    public ImageResizer(File[] files, int newWidth, String dstFolder) {
        this.files = files;
        this.newWidth = newWidth;
        this.dstFolder = dstFolder;
    }

    public static BufferedImage resize(BufferedImage src, int targetWidth,
                                       int targetHeight, BufferedImageOp ops) {

        BufferedImage image = Scalr.resize(src,
                Scalr.Method.ULTRA_QUALITY,
                Scalr.Mode.FIT_EXACT,
                targetWidth, targetHeight, ops);

        return image;
    }

    @Override
    public void run(){

        try {
            for (File file : files) {

                BufferedImage image = ImageIO.read(file);
                if (image == null) {
                    continue;
                }

                int newHeight = (int) Math.round(
                        image.getHeight() / (image.getWidth() / (double) newWidth));

                AffineTransformOp op = new AffineTransformOp(
                        AffineTransform.getRotateInstance(0),
                        AffineTransformOp.TYPE_BILINEAR);

                BufferedImage newImage = resize(image, newWidth, newHeight, op);

                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(newImage, "jpg", newFile);
                image.flush();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
