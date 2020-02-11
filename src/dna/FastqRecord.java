/**
 * FastqRecord.java --- This class checks for the quality of the DNA sequences.
 * @author Ziqing Zhang
 * @version 1.0
 * @since 2019-10-01
*/

package dna;

//
// FastqRecord contains the defline, sequence, and quality string
// from a record in a fastq file.
//


public class FastqRecord implements DNARecord 
{
	public String defline;
	public String sequence;
	public String quality;
	
	// Method instantiates 3 variables
	// Checks defline for the correct first character, else throws an exception
	
	public FastqRecord(String defline, String sequence, String quality) throws RecordFormatException
	{
		if(defline.charAt(0) != '@')
			throw new RecordFormatException("Bad 1st char in defline in fastq record: saw " + defline.charAt(0) + ", expected @");
		this.defline = defline;
		this.sequence = sequence;
		this.quality = quality;
	}
	
	
	// 
	// 2 methods that satisfy DNARecord interface.
	//
	public String getDefline()
	{
		return defline;
	}
	
	public String getSequence()
	{
		return sequence;
	}
	

	// Deep equals() method that checks the three variables.
	// Returns a boolean.
	
	public boolean equals(Object x)
	{
		FastqRecord that = (FastqRecord) x;
		if(!this.defline.equals(that.defline))
			return false;
		if(!this.sequence.equals(that.sequence))
			return false;
		if(!this.quality.equals(that.quality))
			return false;
		return true;
	}
	
	// Checks the quality string for the expected characters, and returns a boolean.
	
	public boolean qualityIsLow()
	{
		
		if(this.quality.contains("$") && this.quality.contains("#"))
			return true;
		return false; 
	}
	
	
	// Returns the sum of hashCodes for all three variables.
	
	public int hashCode()
	{
		return this.defline.hashCode() + this.sequence.hashCode() + this.quality.hashCode();
	}
	
}
