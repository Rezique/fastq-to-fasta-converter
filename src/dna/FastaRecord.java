/**
 * FastaRecord.java --- This class checks the file formatting, and records the data.
 * @author Ziqing Zhang
 * @version 1.0
 * @since 2019-10-01
*/

package dna;


public class FastaRecord implements DNARecord 
{	
	
	public String defline;
	public String sequence;
 
	// Instantiates two variables.
	// Creates a precondition for the first character of defline, if precondition is not fulfilled, exception thrown
	
	public FastaRecord(String defline, String sequence) throws RecordFormatException
	{
		if(defline.charAt(0) != '>')
			throw new RecordFormatException("Bad 1st char in defline in fastq record saw: " + defline.charAt(0) + ", expected >");
		this.defline = defline;
		this.sequence = sequence;
	}
	
	
	// Initialize defline and sequence from the input record.
	// defline's first character is replaced with another character.
 
	public FastaRecord(FastqRecord fastqRec)
	{
		this.defline = ">" + fastqRec.getDefline().substring(1);
		this.sequence = fastqRec.getSequence();
	}
	
	// 2 Methods that satisfy the DNARecords interface.
	
	public String getDefline()
	{
		return defline;
	}
	
	public String getSequence()
	{
		return sequence;
	}
	
	// Provide an equals() method for the two variables defline and sequence.
	
	public boolean equals(Object x)
	{
		FastaRecord that = (FastaRecord) x;
		if(!this.defline.equals(that.defline))
			return false;
		if(!this.sequence.equals(that.sequence))
			return false;
		return true;
	}

	// Returns a the sum of hasCode of both variables.
	
	public int hashCode()
	{
		return this.defline.hashCode() + this.sequence.hashCode();
	}
}
