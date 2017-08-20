package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

/**
 * Created by tolik on 18.08.2017.
 */
public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes iTypes) throws IllegalArgumentException {


        if (iTypes == ImageTypes.JPG)
            return new JpgReader();

        if (iTypes == ImageTypes.BMP)
            return new BmpReader();

        if (iTypes == ImageTypes.PNG)
            return new PngReader();

        throw new IllegalArgumentException("Неподходящий тип картинки");

//        try {
//            ImageReader type = null;
//            switch (iTypes){
//                case BMP: type = new BmpReader();
//                break;
//                case JPG: type = new JpgReader();
//                break;
//                case PNG: type = new PngReader();
//                break;
//                default: throw new IllegalArgumentException("Неподходящий тип картинки");
//            }
//            return type;
//        } catch (IllegalArgumentException e) {
//            throw new IllegalArgumentException("Неподходящий тип картинки");
//        }
    }
}
