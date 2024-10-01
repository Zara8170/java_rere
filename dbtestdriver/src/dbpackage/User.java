package dbpackage;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class User {

		private String email;
		private String name;
		private String password;
		private String phone;
		private int address_id;
		private Date birthyear;
		
		public User(String pemail,String pname,String ppassword, 
				String pphone, int paddress_id, Date pbirthyear) {
			this.email = pemail;
			this.name = pname;
			this.password = ppassword;
			this.phone = pphone;
			this.address_id = paddress_id;
			this.birthyear = pbirthyear;
		}

		public String getEmail() {
			return email;
		}

		public String getName() {
			return name;
		}

		public String getPassword() {
			return password;
		}

		public String getPhone() {
			return phone;
		}

		public int getAddress_id() {
			return address_id;
		}

		public Date getBirthyear() {
			return birthyear;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public void setAddress_id(int address_id) {
			this.address_id = address_id;
		}

		public void setBirthyear(Date birthyear) {
			this.birthyear = birthyear;
		}
	}
