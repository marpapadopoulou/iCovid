package register;


public class user {
	String name;
	String email;
	Float lat;
	Float lng;
	
	public user() {
		
	}
		
	public user(String name, String email,Float lat, Float lng) {
		this.name=name;
		this.email=email;
		this.lat=lat;
		this.lng=lng;
		
	}
	
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name=name;
		}
		
		public String getEmail() {
			return email;
		}
		
		public void setEmail(String email) {
			this.email=email;
		}
		
		public Float getLat() {
			return lat;
		}
		
		public void setLat(Float lat) {
			this.lat=lat;
		}
		
		public Float getLng() {
			return lng;
		}
		
		public void setLng(Float lng) {
			this.lng=lng;
		}
}
