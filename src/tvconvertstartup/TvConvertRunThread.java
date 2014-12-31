/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvconvertstartup;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author brett
 */
public class TvConvertRunThread {

    /**
     * creates a process variable
     */
    protected static Process process = null;

    /**
     * Creates a thread variable
     */
    protected volatile static Thread t = null;

    /**
     * Creates a process using ProcessBuilder the starts a thread so output is
     * available. The run method passes the progress to the progress bar on the
     * Main form.
     *
     * @param tvConvertMainForm
     * @throws IOException
     */
    public static void startThread(final TvConvertMainForm tvConvertMainForm) throws IOException {
        char sep = File.separatorChar;
        String spew = System.getProperty("user.home"), doc = "Documents",wrkdir = "ConvertedTvFiles";
        //System.out.print(TvConvertSetUp.fileToBeConverted);
        ProcessBuilder pb = new ProcessBuilder("ffmpeg", "-i", TvConvertSetUp.destFile.toString(),"-map","0:a:0", spew+sep+doc+sep+wrkdir+sep+TvConvertSetUp.fileToBeConverted+".mp3");
        final Process p = pb.start();
        TvConvertRunThread.process = p;
        t = new Thread() {
            @Override
            public void run() {
                Scanner sc = new Scanner(p.getErrorStream());
                // Find duration  
                Pattern durPattern = Pattern.compile("(?<=Duration: )[^,]*");
                String dur = sc.findWithinHorizon(durPattern, 0);
                if (dur == null) {
                    throw new RuntimeException("Could not parse duration.");
                }
                String[] hms = dur.split(":");
                double totalSecs = Integer.parseInt(hms[0]) * 3600 + Integer.parseInt(hms[1]) * 60 + Double.parseDouble(hms[2]);
                System.out.println("Total duration: " + totalSecs + " seconds.");
                // Find time as long as possible.  
                Pattern timePattern = Pattern.compile("(?<=time=)[\\d:.]*");
                String match;
                String[] matchSplit;
                //MashForm pgbar = new MashForm();
                while (null != (match = sc.findWithinHorizon(timePattern, 0))) {
                    matchSplit = match.split(":");
                    double progress = (Integer.parseInt(matchSplit[0]) * 3600 + Integer.parseInt(matchSplit[1]) * 60 + Double.parseDouble(matchSplit[2])) / totalSecs;
                    int prog = (int) (progress * 100);
                    tvConvertMainForm.setbar(prog);
                }
            }
        };
        t.start();
        // return p;
    }

    /**
     * Cancels the process if the cancel button is clicked
     *
     * @throws IOException
     */
    public synchronized static void stopMe() throws IOException {
        TvConvertRunThread.t.interrupt();
        if (TvConvertRunThread.process != null) {
            TvConvertRunThread.process.destroyForcibly();//   destroy();
        }
    }





}
/**
 * Calls the stopMe method and is called from the mashFormCunts form
 *
 * @author brett
 */
class killMash extends TvConvertRunThread {

    public static void Kfpeg() throws IOException {
        TvConvertRunThread.stopMe();
    }
}