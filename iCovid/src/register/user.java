package register;


public class user {
	String name;
	String email;
	Float lat;
	Float lng;
	Float res;
	
		
	public user(String name, String email,Float lat, Float lng, Float res) {
		this.name=name;
		this.email=email;
		this.lat=lat;
		this.lng=lng;
		this.res=res;
		
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
		public float getRes() {
			return res;
		}
		
		public void setResult(float res) {
			this.res=res;
		}
}
