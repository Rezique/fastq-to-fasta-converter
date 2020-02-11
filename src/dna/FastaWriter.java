/**
 * FastaWriter.java --- This class writes lines of string into a file.
 * @author Ziqing Zhang
 * @version 1.0
 * @since 2019-10-01
*/

package dna;

import java.io.*;


//
// Writes a fasta record to a print writer.
//

public class FastaWriter 
{
	public PrintWriter thePrintWriter;
	
	// Instantiates the PrintWriter.
	
	public FastaWriter(PrintWriter thePrintWriter)
	{
		this.thePrintWriter = thePrintWriter;
	}
	
	// 2 PrintWriters called to write two different lines, throws exception.

	public void writeRecord(FastaRecord rec) throws IOException
	{
		thePrintWriter.println(rec.getDefline());
		thePrintWriter.println(rec.getSequence());
	}
}
