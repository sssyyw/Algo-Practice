package chapter7_2;

public class Employee {
	CallHandler callHandler;
	int rank;
	boolean free;
	Employee (int rank) {this.rank = rank;}
	void ReceiveCall(Call call){...}
	void CallHandled(Call call){...}
	void Cannothandle(Call call){
		call.rank = rank + 1;
		callHandler.dispatchCall(call);
		free = true;
		CallHandler.getNextCall(this);
	}
}
