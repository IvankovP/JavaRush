package level_16.task_1_FactoryPattern;

import level_16.task_1_FactoryPattern.common.*;

public class Solution {
    public static void main(String[] args) {
        ImageReader reader = ImageReaderFactory.getImageReader(ImageTypes.JPG);
    }
}