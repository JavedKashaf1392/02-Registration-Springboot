package in.nit.util;

import java.util.Random;

public class PazzwordUtil {
	    private static final String[] ALPHA_NUMERIC_STRING = new String[] {
	            "abcdefghijklmnopqrstuvwxyz",
	            "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
	            "0123456789"
	    };

	    public static String generateTempPws(int length) {
	        StringBuilder password = new StringBuilder(length);
	        Random random = new Random(System.nanoTime());

	        for (int i = 0; i < length; i++) {
	            String charCategory =  ALPHA_NUMERIC_STRING[random.nextInt( ALPHA_NUMERIC_STRING.length)];
	            int position = random.nextInt(charCategory.length());
	            password.append(charCategory.charAt(position));
	        }

	        return new String(password);
	    }
	}

