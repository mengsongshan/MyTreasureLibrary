package com.water.music.office.ppt;

import org.apache.poi.hslf.usermodel.*;
import org.apache.poi.sl.usermodel.PictureData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public
class PptParser {
    private static String HEADER_PIC_PATH = " ";
    public static final String CONTENT_PIC_PATH = "";

    public static
    void main(String[] args) {


    }

    public
    void changeBackground(String path) {
        try {
            // build PPT instance from ppt file stream
            HSLFSlideShow ppt = new HSLFSlideShow(new HSLFSlideShowImpl(path));
            HSLFPictureData pd = ppt.addPicture(new File("c:\\train\\ppt\\earierMaster.jpg"), PictureData.PictureType.JPEG);

            // get all slide
            Iterator<HSLFSlide> iterator = ppt.getSlides().iterator();
            while (iterator.hasNext()) {
                HSLFSlide slide = iterator.next();
                HSLFFill fill = slide.getBackground().getFill();
                fill.setFillType(HSLFFill.FILL_PICTURE);
                fill.setPictureData(pd);
            }
            ppt.write(new FileOutputStream(new File("c:\\temp.ppt")));
        } catch (IOException e1) {
            e1.printStackTrace();
        }


    }

    private static
    void chagePageSize(String path) {
        HSLFSlideShow ppt = null;
        try {
            ppt = new HSLFSlideShow(new HSLFSlideShowImpl(path));
            //retrieve page size. Coordinates are expressed in points (72 dpi)
            java.awt.Dimension pgsize = ppt.getPageSize();
            int pgx = pgsize.width; //slide width
            int pgy = pgsize.height; //slide height

            //set new page size
            ppt.setPageSize(new java.awt.Dimension(124, 68));
            //save changes
            FileOutputStream out = new FileOutputStream("slideshow.ppt");
            ppt.write(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static
    void createPptSlide() throws IOException {
        //create order new empty slide show
        HSLFSlideShow ppt = new HSLFSlideShow();
        HSLFPictureData pd = ppt.addPicture(new File(HEADER_PIC_PATH), PictureData.PictureType.JPEG);

        //add first slide
        HSLFSlide s1 = ppt.createSlide();
        HSLFFill fill = s1.getBackground().getFill();
        fill.setFillType(HSLFFill.FILL_PICTURE);
        fill.setPictureData(pd);
        //add second slide
        HSLFSlide s2 = ppt.createSlide();

        //save changes in order file
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("c:\\slideshow.ppt");
            ppt.write(out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * operate slide master
     * @param path
     */
    public  void operateMaster(String path){
        try {
            // build PPT instance from ppt file stream
            HSLFSlideShow ppt = new HSLFSlideShow(new HSLFSlideShowImpl(path));
//            HSLFPictureData pd = ppt.addPicture(new File(HEADER_PIC_PATH), PictureData.PictureType.JPEG);

            // get PPT all slide template
            List<HSLFSlideMaster> slideMasters = ppt.getSlideMasters();
            Iterator<HSLFSlideMaster> iterator = slideMasters.iterator();
            int picIndex = 0;
            while (iterator.hasNext()) {
                HSLFSlideMaster slideMaster = iterator.next();
                HSLFFill masterFill = slideMaster.getBackground().getFill();
                HSLFPictureData hslfPictureData = masterFill.getPictureData();
                if(hslfPictureData == null){
                    continue;
                }
                byte[] picContent =  hslfPictureData.getData();
                String pic_ext =  hslfPictureData.getType().extension;
                FileOutputStream fos = new FileOutputStream(new File("c:\\pptPic\\easier_" + picIndex +"_"+ pic_ext));
                picIndex++;
                fos.write(picContent);
                fos.close();
            }

        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    /**
     * operate slide master
     * @param path
     */
    public  void operateSlide(String path){
        try {
            // build PPT instance from ppt file stream
            HSLFSlideShow ppt = new HSLFSlideShow(new HSLFSlideShowImpl(path));

            // get PPT all slide template
            List<HSLFSlide> slides = ppt.getSlides();
            Iterator<HSLFSlide> iterator = slides.iterator();
            int picIndex = 0;
            while (iterator.hasNext()) {
                HSLFSlide slide = iterator.next();
                HSLFFill fill = slide.getBackground().getFill();
                HSLFPictureData hslfPictureData = fill.getPictureData();
                if(hslfPictureData == null){
                    continue;
                }
                byte[] picContent =  hslfPictureData.getData();
                String pic_ext =  hslfPictureData.getType().extension;
                FileOutputStream fos = new FileOutputStream(new File("c:\\pptPic\\easier_" + picIndex +"_"+ pic_ext));
                picIndex++;
                fos.write(picContent);
                fos.close();
            }

        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }
}
