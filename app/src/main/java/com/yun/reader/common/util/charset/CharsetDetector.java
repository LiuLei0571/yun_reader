package com.yun.reader.common.util.charset;

import org.mozilla.universalchardet.UniversalDetector;

import java.io.FileInputStream;
import java.nio.charset.Charset;

public class CharsetDetector {

    public static Charset getCodingType(String str) {
        Charset forName;
        Exception e;
        Charset forName2 = Charset.forName("UTF-8");
        try {
            byte[] bArr = new byte[4096];
            FileInputStream fileInputStream = new FileInputStream(str);
            UniversalDetector universalDetector = new UniversalDetector(null);
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0 || universalDetector.isDone()) {
                    break;
                }
                universalDetector.handleData(bArr, 0, read);
            }
            universalDetector.dataEnd();
            String detectedCharset = universalDetector.getDetectedCharset();
            if (detectedCharset != null) {
                forName = Charset.forName(detectedCharset);
            } else {
                forName = forName2;
            }
            try {
                universalDetector.reset();
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return forName;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            forName = forName2;
            e = exception;
            e.printStackTrace();
            return forName;
        }
        return forName;
    }
}
