package com.jdp.model;

public class AllocationData {
	
	private int id;
    private String personFullName;
    private String missionName;
    private String missionType;
    private String activityName;
    private int year;
    private int month;
	private double workDays;
	
	public AllocationData() {
		personFullName = "";
		missionName = "";
		missionType = "";
		activityName = "";
		year = 0;
		month = 0;
		workDays = 0.00;
	}
	
	public AllocationData( String person, String mission, String type, String activity, int year, int month, Double workdays) {
		this.personFullName = person;
		this.missionName = mission;
		this.missionType = type;
		this.activityName = activity;
		this.year = year;
		this.month = month;
		this.workDays = workdays;
	};
	
    public int getAllocationId() {
        return id;
    }
    public void setAllocationId(int id) {
        this.id = id;
    }
	
	public String getPersonFullName() {
		return personFullName;
	}
    public void setPersonFullName(String personfullname) {
        this.personFullName = personfullname;
    }

    public String getMissionName() {
        return missionName;
    }
    public void setMissionName(String missionname) {
        this.missionName = missionname;
    }
    
    public String getMissionTypee() {
        return missionType;
    }
    public void setMissionType(String missiontype) {
        this.missionType = missiontype;
    }
    
    public String getActivityName() {
        return activityName;
    }
    public void setActivityName(String activityname) {
        this.activityName = activityname;
    }
    
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }   
    
    public Double getWorkDays() {
        return workDays;
    }
    public void setWorkDays(Double workdays) {
        this.workDays = workdays;
    }
    
	public boolean equals(Object o) {
		boolean isEquals = false;

		if (o instanceof AllocationData) {
			AllocationData allocation = (AllocationData) o;
			isEquals = missionName.equals(allocation.getMissionName())&& 
					   personFullName.equals(allocation.getPersonFullName())&& 
					   activityName.equals(allocation.getActivityName());
		}
		return isEquals;
	}
	
}
