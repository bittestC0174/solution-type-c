package problem03;

public class MyStack {
	
	
	private String[] buffer;
	private int top=-1;

	public MyStack( int size ) {
		buffer = new String[3];
	}
	
	public void push(String item) {
		
		if(top+1>=buffer.length) resize();
		buffer[++top] = item;
	}
	private void resize() {
		String temp [] = new String[buffer.length+1];
		for (int i = 0; i < buffer.length; i++) {
            temp[i] = buffer[i];
        }
		buffer=temp;
	}

	public String pop() {
		if(top<0) return null;
		return buffer[top--];
	}

	public boolean isEmpty() {
		return top==-1;
	}
	
	public int size() {
		return top+1;
	}
}