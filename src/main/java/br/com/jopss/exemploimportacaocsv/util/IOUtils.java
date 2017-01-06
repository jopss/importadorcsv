package br.com.jopss.exemploimportacaocsv.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public class IOUtils {

        private static final int DEFAULT_BUFFER_SIZE = 1024 * 4;

        public static String toString(InputStream input, String encoding) throws IOException {
                StringWriter sw = new StringWriter();
                InputStreamReader in = new InputStreamReader(input, encoding);
                copiar(in, sw);
                return sw.toString();
        }

        private static long copiar(Reader input, Writer output) throws IOException {
                char[] buffer = new char[DEFAULT_BUFFER_SIZE];
                long count = 0;
                int n = 0;
                while (-1 != (n = input.read(buffer))) {
                        output.write(buffer, 0, n);
                        count += n;
                }
                return count;

        }

}
