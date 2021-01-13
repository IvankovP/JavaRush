package level_16.task_1_FactoryPattern;

import level_16.task_1_FactoryPattern.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageType) {
        if (imageType == ImageTypes.BMP) return new BmpReader();
        else if (imageType == ImageTypes.JPG) return new JpgReader();
        else if (imageType == ImageTypes.PNG) return new PngReader();
        else throw new IllegalArgumentException();
    }
}
