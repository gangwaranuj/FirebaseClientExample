package com.thinksys.demo.model;


	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	import org.hibernate.annotations.GenericGenerator;

	@Entity
	@Table(name="firebase_detail")
	public class FirebaseDetail {

		
		private int id;
		private String browserName;
		private String token;
		
		@Id
		   @GenericGenerator(name = "sequence", strategy = "sequence", parameters = {
		           @org.hibernate.annotations.Parameter(name = "sequenceName", value = "sequence"),
		           @org.hibernate.annotations.Parameter(name = "allocationSize", value = "1"),
		   })
		@GeneratedValue(generator="sequence",strategy = GenerationType.SEQUENCE)
		   @Column(name="id", unique=true, nullable=false,columnDefinition = "serial")
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		
		
		@Column(name="browser_name")
		public String getBrowserName() {
			return browserName;
		}
		public void setBrowserName(String browserName) {
			this.browserName = browserName;
		}
		
		@Column(name="token_id" ,length=450,unique=true)
		public String getToken() {
			return token;
		}
		public void setToken(String token) {
			this.token = token;
		}
		
		
		
		
		
		
}
