package dto;

public class Member {
	
		private String id;
		private String name;
		private String password;
		private String address;
		private String email;
		
		public Member() {}
		public Member(String id, String name,String password, String address, String email) {
			this.id=id;
			this.name=name;
			this.password=password;
			this.address=address;
			this.email=email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		
	}

}
