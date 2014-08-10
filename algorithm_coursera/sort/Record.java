package com.yiwei.sort;

public class Record implements Comparable<Record>
{
	private final String name, grade;
	public Record(String name, String grade)
	{
		this.name = name;
		this.grade = grade;
	}
	
	public int compareTo(Record r)
	{
		return this.grade.compareTo(r.grade);
	}
	
	public String toString()
	{
		return this.name + " " + this.grade;
	}
}
