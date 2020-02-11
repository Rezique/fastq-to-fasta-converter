/**
 * FastqReader.java --- This class reads lines in a file, and strings them together.
 * @author Ziqing Zhang
 * @version 1.0
 * @since 2019-10-01
*/

package dna;

import java.io.*;

// Reads lines from a BufferedReader and builds a FastqRecord.

public class FastqReader 
{
	public BufferedReader theBufferedReader;
	
	// Instantiates the BufferedReader.
	
	public FastqReader(BufferedReader theBufferedReader)
	{
		this.theBufferedReader = theBufferedReader;
	}
	
	// Reads records until EOF and then returns null.
	
	public FastqRecord readRecord() throws IOException, RecordFormatException
	{
		String defline = theBufferedReader.readLine();
		if (defline == null)
			return null;
		
		String sequence = theBufferedReader.readLine();
		theBufferedReader.readLine();
		String quality = theBufferedReader.readLine();
		
		// Returns a new record with the three lines read by the BufferedReader.
		
		FastqRecord record = new FastqRecord(defline, sequence, quality);
		return record;

	}
}
