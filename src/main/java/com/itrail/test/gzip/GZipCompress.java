
package com.itrail.test.gzip;

import java.io.IOException;
import java.io.RandomAccessFile;
import org.jboss.resteasy.annotations.GZIP;
/**
 *
 * @author barysevich_k
 */
public class GZipCompress {

    @GZIP
    public static void main( String[] args) throws IOException{
        System.out.println("GZIP FILE>>>>>>>>>>>>>>>>" );
        RandomAccessFile f = new RandomAccessFile("primer", "rw");
        f.setLength(1024 * 1024 * 10);
    }
}
