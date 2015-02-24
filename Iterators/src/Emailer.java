import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Emailer {
	
	/**
	 * Standard input reader to read file input for email data.
	 */
	private BufferedReader input;
	
	/**
	 * The data received from reading the file input.
	 */
	private Queue<String> dataQueue;
	
	/**
	 * Inbox folder.
	 * Newly received emails are initially placed here.
	 */
	private Folder inbox;
	
	/**
	 * Trash folder (deleted items)
	 */
	private Folder trash;
	
	/**
	 * Read folder (read items)
	 */
	private Folder read;

	/**
	 * A Folder containing individual Emails for the Emailer class.
	 * @author bednarzt
	 * @version 1.0
	 */
	public class Folder {
		public String name;
		
		public Queue<Email> contents;
		
		public Folder(String name) {
			this.name = name;
			this.contents = new LinkedList<Email>();
		}
		
		public Folder() {
			this("New Folder");
		}
		
		public String toString() {
			String ret = this.name + ": ";
			
			for(Email e : contents) {
				ret += e.toString() + ", ";
			}
			
			return ret;
		}
		
		public void addItem(Email e) {
			this.contents.offer(e);
		}
		
		public Email removeNext() {
			return this.contents.poll();
		}
		
		public int getCount() {
			return this.contents.size();
		}
	}
	
	/**
	 * An individual Email containing the retrieved email data.
	 * Currently only stores the name of the sender.
	 * @author bednarzt
	 * @version 1.0
	 */
	public class Email {
		public String sender;
		
		public Email(String sender) {
			this.sender = sender;
		}
		
		public Email() {
			this("NO SENDER");
		}
		
		public String toString() {
			return "Email[" + this.sender + "]";
		}
	}
	
	/**
	 * Creates the new default Emailer object
	 */
	public Emailer() {
		inbox = new Folder("Inbox");
		trash = new Folder("Trash");
		read = new Folder("Read");
		dataQueue = new LinkedList<String>();
	}
	
	@Override
	/**
	 * @return a String representation of the Emailer class
	 */
	public String toString() {
		String ret = "Emailer: (Inbox: " + inbox.getCount() + ") (Read: " + read.getCount() + ") (Trash: " + trash.getCount() + ")\n";
		
		ret += inbox.toString() + "\n";
		ret += trash.toString() + "\n";
		ret += read.toString() + "\n";
		
		return ret;
	}
	
	/**
	 * Updates Emailer's data with the file data from the specified filename.
	 * @param filename
	 */
	public void update(String filename) {
		dataQueue.clear();
		readData(filename);
		processQueue();
	}
	
	/**
	 * Reads and places email data into the data queue
	 * @param filename the name of the file to be read
	 */
	private void readData(String filename) {
		try {
			this.input = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
		} catch (FileNotFoundException e) {
			System.err.println("Emailer: everything is burning (file not found)");
			e.printStackTrace();
		}
		
		try {
			while(input.ready()) {
				String data = input.readLine();
				dataQueue.offer(data);
			}
		} catch (IOException e) {
			System.err.println("Emailer: what am i even reading (io exception)");
			e.printStackTrace();
		}
	}
	
	/**
	 * Processes the data queue. If the the data queue is empty, does nothing.
	 */
	private void processQueue() {
		if(dataQueue == null || dataQueue.size() <= 0) {
			System.err.println("Emailer: No data queue to process.");
			return;
		}
		
		for(String data : dataQueue) {
			if(data.equals("READ")) {
				readNext();
			}
			
			else if(data.equals("DELETE")) {
				deleteNext();
			}
			
			else {
				inbox.addItem(new Email(data));
			}
		}
	}
	
	/**
	 * Moves the next item in the inbox to the Read folder.
	 */
	private void readNext() {
		read.addItem(inbox.removeNext());
	}
	
	/**
	 * Moves the next item in the inbox to the Trash folder.
	 */
	private void deleteNext() {
		trash.addItem(inbox.removeNext());
	}
	
	/*
	 * Main
	 */
	public static void main(String[] args) {
		Emailer gmail = new Emailer();
		gmail.update("email.txt");
		
		System.out.println(gmail);
	}
}
