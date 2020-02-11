/**
 * RecordFormatException.java --- This class creates an exception, RecordFormatException, that accepts a single argument.
 * @author Ziqing Zhang
 * @version 1.0
 * @since 2019-10-01
*/

package dna;

public class RecordFormatException extends Exception
{
	// Creates exception that accepts a string.
	public RecordFormatException(String message)
	{
		super(message);
	}

}
