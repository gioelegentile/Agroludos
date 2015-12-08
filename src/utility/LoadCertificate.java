/*
 * 
 */
package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.NoSuchElementException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

// TODO: Auto-generated Javadoc
/**
 * The Class LoadCertificate.
 */
public class LoadCertificate {
	
	/** The username. */
	private String username;
	
	/** The f. */
	private File f;
	
	/**
	 * Instantiates a new load certificate.
	 *
	 * @param username the username
	 */
	public LoadCertificate(String username) {
		this.username = username;
	}

	/**
	 * Gets the path.
	 *
	 * @return the path
	 */
	public String getPath() {
		return f.getPath();
	}
	
	/**
	 * Load.
	 *
	 * @return the array list
	 * @throws URISyntaxException the URI syntax exception
	 */
	public int selectFile() throws URISyntaxException {

		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"*.txt", "txt");
		fileChooser.setFileFilter(filter);
		int n = fileChooser.showOpenDialog(null);
		
		if (n == JFileChooser.APPROVE_OPTION)
			try {
				f = fileChooser.getSelectedFile();
				BufferedReader br = null;
				
				if (f == null) {
					return 0;
				} else {
					
					try {
						br = new BufferedReader(new FileReader(f.getPath()));
						
						if (br.readLine() == null) {
						    return 0;
						} else {
							return 1;
						}
						
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				} 
				
			} catch (NoSuchElementException e) {
				return 0;
			}
		
		return -1;
		
	}
	
	/**
	 * Load.
	 *
	 * @return true, if successful
	 */
	public boolean load() {
		
		String server = "ftp.agroludositps.altervista.org";
		int port = 21;
        String user = "agroludositps";
        String pass = "agroludos";
        FTPClient ftpClient = new FTPClient();
        
        try {
 
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
 
            InputStream inputStream = new FileInputStream(f);
            ftpClient.storeFile("certificati/" + username + ".txt", inputStream);
            inputStream.close();
            return true;
 
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                return false;
            }
        }
	}

}
