package chapter7_2;

import java.util.ArrayList;

public class CallHandler {
	static final int LEVELS = 3;
	static final int NUM_FRESHES = 5;
	ArrayList<Employee>[] empolyeeLevels = new ArrayList[LEVELS];
	
	//queues for each call's rank
	Queue<Call>[] callQueues = new LinkedList[LEVELS];
	
	public CallHandler() {...}
	
	Employee getCallHandler(Call call){
		for (int level = call.rank; level < LEVELS - 1; level++){
			ArrayList<Employee> employeeLevel = employeeLevels[level];
			for (Employee emp: employeeLevel){
				if (emp.free){
					return emp;
				}
			}
		}
		return null;
	}
	
	// routes the call to an available employee, or adds to a queue
	void dispatchCall(Call call){
		// try to route the call to an employee with minimal rank
		Employee emp = getCallhandler(call);
		if (emp != null){
			emp.ReceiveCall(call);
		} else {
			// place the call into queue according to its rank
			callQueues[call.rank].add(call);
		}
	}
	void getNextCall(Employee e) {...}
}
