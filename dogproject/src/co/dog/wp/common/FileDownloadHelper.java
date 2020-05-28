/**
 * 파일명 : FileDownloadHelper.java
 * 작성자 : 김유미
 * 파일설명 :
 */
package co.dog.wp.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author user
 *
 */
public class FileDownloadHelper {
	public static void copy(String filePath, OutputStream os) throws IOException {
		FileInputStream is = null;
		try {
			is = new FileInputStream(filePath);
			byte[] data = new byte[8096];
			int len = -1;
			while ((len = is.read(data)) != -1) {
				os.write(data, 0, len);
			}
		} finally {
			if (is != null)
				try {
					is.close();
				} catch (IOException e) {
				}
		}
	}
}
