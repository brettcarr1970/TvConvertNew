/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvconvertstartup;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author bcarr
 */
public class TvConvertSetUp {
      protected static File destFile = null;
    /**
     * Checks and copies the file to the convertedFiles folder.
     * @param newFile
     * @throws IOException 
     */
    public static void checkFile(File newFile) throws IOException{
        String newFilePath = "C:\\Users\\brett\\Documents\\ConvertedTvFiles\\";
        destFile = new File(newFilePath+newFile.getName());
        Files.copy(newFile.toPath(), destFile.toPath(),StandardCopyOption.REPLACE_EXISTING);
    }
}
