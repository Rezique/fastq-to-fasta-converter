/**
 * FileConverter.java --- Creates readers and writers, then creates a file with the results.
 * @author Ziqing Zhang
 * @version 1.0
 * @since 2019-10-01
*/

package dna;

import java.io.*;
import java.util.*;


public class FileConverter 
{
	public File fastq;
	public File fasta;
	
	public FileConverter(File fastq, File fasta)
	{
		this.fastq = fastq;
		this.fasta = fasta;
	}
	
	// Converts the read lines to format wanted, then writes to a file.
	
	public void convert() throws IOException
	{
		// Readers to read fastq file.
		
		FileReader fr = new FileReader(fastq);
		BufferedReader br = new BufferedReader(fr);
		FastqReader fqr = new FastqReader(br);

		// Writers to write to the fasta file.
		
		FileWriter fw = new FileWriter(fasta);
		PrintWriter pw = new PrintWriter(fw);
		FastaWriter faw = new FastaWriter(pw);
		
		// Try-Catch block, checks for quality, before deciding whether or not
		// record has reached condition to be passed into the writer.
		
		boolean flag = false;
		while(!flag)
		{
			try
			{
				FastqRecord aRecord = fqr.readRecord();
				
				// Checks if EOF
				
				if(aRecord == null)
				{
					flag = true;
				}
				
				// Checks quality of records, then creates new record.
				
				else if(!aRecord.qualityIsLow())
				{
					faw.writeRecord(new FastaRecord(aRecord));
				}
			}
			
		catch (RecordFormatException x) {}
		catch (NullPointerException x) {}
		}
		
		// Close the writers.
		
		pw.close();
		fw.close();
		
		// Close the readers.
		
		br.close();
		fr.close();

	}
	
	// Main method.	
	
	public static void main(String[] args)
	{
		System.out.println("Starting");
		try
		{
			File fastq = new File("data/HW4.fastq");
			if (!fastq.exists())
			{
				System.out.println("Can't find input file " + fastq.getAbsolutePath());
				System.exit(1);
			}
			File fasta = new File("data/HW4.fasta");
			FileConverter converter = new FileConverter(fastq, fasta);
			converter.convert();
		}
		catch (IOException x)
		{
			System.out.println(x.getMessage());
		}
		System.out.println("Done");
	}
}
