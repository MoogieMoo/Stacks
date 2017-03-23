// Maggie Xia
// APCS2 pd1
// HW22--Stacks on Stacks on Stacks on Stacks...
// 2017-03-22

/***
 * class Latkes
 * SKELETON
 * (actually: a class to implement a stack of Strings)
 * uses an array as underlying data structure
 ***/

public class Latkes 
{

    private String [] _stack;
    private int _stackSize;

    //constructor
    public Latkes( int size ) 
    {
        _stack = new String[ size ];
	_stackSize = 0;
    }

    //means of insertion
    public void push( String s ) 
    {
	//no items
        if( _stack[0] == null ) {
	    _stack[0] = s;
	    _stackSize += 1;
	}
	//shift down
	else if( _stack[ _stack.length - 1 ] == null ) {
	    int shove = _stack.length-1;
	    while( shove > 0 ) {
		_stack[ shove ] = _stack[ x - 1 ];
		shove -= 1;
	    }
	    _stack[0] = s;
	    _stackSize += 1;
	}
	else {
	    System.out.println( "Error" );
	    return;
	}
    }

    //means of removal
    public String pop( ) 
    {
	//first item gets removed
	String pup = _stack[0];
	//shift up
	int pip = 0;
	while ( pip < _stack.length - 1 ){
	    _stack[pip] = _stack[ pip + 1 ];
	    pip += 1;
	}
	_stack[ _stack.length - 1 ] = null;
	_stackSize -= 1;
	//returns removed item
	return pup;
    }

    //chk for emptiness
    public boolean isEmpty() 
    {
	if( _stackSize == 0 ) {
	    return true;
	}
	else {
	    return false;
	}
    }

    //chk for fullness
    public boolean isFull() 
    {
	if( _stackSize == _stack.length ) {
	    return true;
	}
	else {
	    return false;
	}
    }

    public String toString(){
	String print = "[";
	for( int i = 0; i < _stack.length; i++ ) {
	    print += _stack[x];
	    print += " ";
	}
	print  += "]";
	return print;
    }

    //tests
    public static void main(String[] args){

	//instantiate stack with a 20 pancake capacity
	Latkes flapjacks = new Latkes(20);
	System.out.println(flapjacks.isEmpty());//should return true
	System.out.println(flapjacks.isFull());//should return false b/c it is empty
	//should print empty stack
	System.out.println(flapjacks.toString());

	//keep adding pancakes until full
	while ( flapjacks._stackSize < 20 ){
	    flapjacks.push( "pancake" );
	}

	//should print stack of 20 pancakes
	System.out.println(flapjacks.toString());


}//end class Latkes

