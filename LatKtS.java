// Maggie Xia
// APCS2 pd1
// HW23--Stack: What Is It Good For?               well, this. 
// 2017-03-23

/*****************************************************
 * class LatKtS (LatKeysToSuccess)
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 * SKELETON
 *****************************************************/

public class LatKtS 
{

    /**********************************************************
     * precondition:  input string has length > 0
     * postcondition: returns reversed string s
     *                flip("desserts") -> "stressed"
     **********************************************************/
    public static String flip( String s ) 
    {        
	//empty or one-character strings are the same when flipped
	if ( s.length() == 0  || s.length() == 1 ) {
	    return s;
	}

	//create a stack to flip
	Latkes flipper = new Latkes( s.length() );
	//FILO
	for ( int i = 0; i < s.length(); i++ ) {
	    String pusher = s.substring( i, i );
	    flipper.push( pusher );
	}

	String flipped = "";
	//pop s back out reversed
	int x = s.length();
	while ( x != 0 ) {
	    flipped += flipper.pop();
	    x -= 1;
	}

	return flipped;

    }//end flip()


    /**********************************************************
     * precondition:  s contains only the characters {,},(,),[,]
     * postcondition: allMatched( "({}[()])" )    -> true
     *                allMatched( "([)]" )        -> false
     *                allMatched( "" )            -> true
     **********************************************************/
    public static boolean allMatched( String s ) 
    {
	//empty or invalid string
	if ( s.length() <= 0 ) {
	    return true;
	}
	//pairs--> even length()
	else if ( s.length() % 2 != 0 ) {
	    return false;
	}

	//create a stack to check for pairs of brackets/parens...
	Latkes matcher = new Latkes( s.length() );
	String compare;

	//traverse the string
	for ( int i = 0; i < s.length(); i++ ) {
	    compare = s.substring( i, i );//checking each character

	    //push each opening grouper to the stack
	    if ( compare.equals("{") || compare.equals("[") || compare.equals("(") ) {
		matcher.push( compare );
	    }

	    //upon encountering a closing grouper
	    if( compare.equals("}") || compare.equals("]") || compare.equals(")") ) {
		//check previous character
		if ( compare.equals("}") ) {
		    if ( !matcher.pop().equals( "{" ) ) {
			return false;
		    }
		}
		else if ( compare.equals("]") ) {
		    if ( !matcher.pop().equals( "[" ) ) {
			return false;
		    }
		}
	        else if ( compare.equals(")") ) {
		    if ( !matcher.pop().equals( "(" ) ) {
			return false;
		    }
		}
	    }	    
	}
	
	//no other cases that would return false
	    return true;
	    
    }//end allMatched()


    //main method to test
    public static void main( String[] args ) { 

	System.out.println(flip("stressed"));
        System.out.println(allMatched( "({}[()])" )); //true
        System.out.println(allMatched( "([)]" ) ); //false
        System.out.println(allMatched( "(){([])}" ) ); //true
        System.out.println(allMatched( "](){([])}" ) ); //false
        System.out.println(allMatched( "(){([])}(" ) ); //false
        System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
          ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
    }

}//end class LatKtS
