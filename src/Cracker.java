import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;



public class Cracker {

     String[] potentialPasswords = new String[1024];

    public Cracker(){


        for(int i = 0; i < 1024; i++){

            potentialPasswords[i] = (RandomPassGen.CreatePass());


        }
        System.out.println(potentialPasswords.length);

    }



    public void crack (String path) throws IOException {

        String zipFilePath = "/path/to/zip/file.zip";
        // potentialPasswords = List.of("password1", "password2", "password3");

        File file = new File(zipFilePath);
        InputStream is = new FileInputStream(file);
        ZipArchiveInputStream zis = new ZipArchiveInputStream(is);

        for (String password : potentialPasswords) {
            try {
                ZipArchiveEntry entry = zis.getNextZipEntry();
                while (entry != null) {
                    // read the contents of the entry
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        // do something with the contents of the entry
                    }
                    entry = zis.getNextZipEntry();
                }
                System.out.println("Password found: " + password);
                break;
            } catch (IOException e) {
                // incorrect password, continue to next password
            } finally {
                // reset the stream to the beginning of the archive
                zis.close();
                is = new FileInputStream(file);
                zis = new ZipArchiveInputStream(is, password, true);
            }
        }

        zis.close();
    }

}
