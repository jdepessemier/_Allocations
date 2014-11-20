package com.jdp.model;

public class SnapshotData {
	
	private int id;
    private String CAProjet;
    private String LibelleProjet;
    private String Director;
    private String ProjectManager;
    private int year;
    private String TypeInput;
    private String DocumentNb;
    private String Comment;
    private String Date;
	private double Montant;
	
	public SnapshotData() {
		CAProjet = "";
		LibelleProjet = "";
		Director = "";
		ProjectManager = "";
		year = 0;
		TypeInput = "";
		DocumentNb = "";
		Comment = "";
		Date = "";
		Montant = 0.00;
	}
	
	public SnapshotData( String caprojet, 
			             String libelleprojet, 
			             String director, 
			             String projectmanager, 
			             int year,
			             String typeinput,
			             String documentnb,
			             String comment,
			             String date,
			             Double montant) {
		this.CAProjet = caprojet;
		this.LibelleProjet = libelleprojet;
		this.Director = director;
		this.ProjectManager = projectmanager;
		this.year = year;
		this.TypeInput = typeinput;
		this.DocumentNb = documentnb;
		this.Comment = comment;
		this.Date = date;
		this.Montant = montant;
	};
	
    public int getSnapshotId() {
        return id;
    }
    public void setSnapshotId(int id) {
        this.id = id;
    }
	
	public String getCAProjet() {
		return CAProjet;
	}
    public void setCAProjet(String caprojet) {
    	this.CAProjet = caprojet;
    }

    public String getLibelleProjet() {
        return LibelleProjet;
    }
    public void setLibelleProjet(String libelleprojet) {
    	this.LibelleProjet = libelleprojet;
    }
    
    public String getDirector() {
        return Director;
    }
    public void setDirector(String director) {
    	this.Director = director;
    }
    
    public String getProjectManager() {
        return ProjectManager;
    }
    public void setProjectManager(String projectmanager) {
        this.ProjectManager = projectmanager;
    }
    
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    
    public String getTypeInput() {
        return TypeInput;
    }
    public void setTypeInput(String typeinput) {
    	this.TypeInput = typeinput;
    }
    
    public String getDocumentNb() {
        return DocumentNb;
    }
    public void setDocumentNb(String documentnb) {
    	this.DocumentNb = documentnb;
    }
    
    public String getComment() {
        return Comment;
    }
    public void setComment(String comment) {
        this.Comment = comment;
    }
    
    public String getDate() {
        return Date;
    }
    public void setDate(String date) {
        this.Date = date;
    }
    
    public Double getMontant() {
        return Montant;
    }
    public void setMontant(Double montant) {
    	this.Montant = montant;
    }
	
}
