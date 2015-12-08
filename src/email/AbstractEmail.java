/*
 * 
 */
package email;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractEmail.
 */
public abstract class AbstractEmail extends Thread {
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		send();
	}
	
	/**
	 * Send.
	 */
	abstract void send();
	
}
