package chapter3;

public class threeStacks {
	private int stackSize = 300;
	private int indexUsed = 0;
	private int[] stackPointer = {-1, -1, -1};
	private StackNode[] buffer = new StackNode[stackSize * 3];
	
	public void push(int stackNum, int value){
		int lastIndex = stackPointer[stackNum];
		stackPointer[stackNum] = indexUsed;
		indexUsed++;
		buffer[stackPointer[stackNum]] = new StackNode(lastIndex, value);
	}
	
	public int pop(int stackNum){
		int value = buffer[stackPointer[stackNum]].value;
		int lastIndex = stackPointer[stackNum];
		stackPointer[stackNum] = buffer[stackPointer[stackNum]].previous;
		buffer[lastIndex] = null;
		indexUsed--;
		return value;
	}
	
	public int peek(int stack){
		return buffer[stackPointer[stack]].value;
	}
	
	public boolean isEmpty(int stackNum){
		return stackPointer[stackNum] == -1;
	}
	
	private class StackNode{
		public int previous;
		public int value;
		public StackNode(int p, int v){
			value = v;
			previous = p;
		}
	}
}
