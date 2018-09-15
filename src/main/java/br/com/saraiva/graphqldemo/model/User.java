package br.com.saraiva.graphqldemo.model;

import java.util.List;
import java.util.Optional;

/**
 * Created by sara on set, 2018
 */
public class User {

	private String id;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phone;
	private Integer userStatus;
	private List<String> orders;

	public User() {
	}

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getPhone() {
		return phone;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public Optional<List<String>> getOrders() {
		return Optional.ofNullable(orders);
	}

	public static final class Builder {
		private String id;
		private String username;
		private String firstName;
		private String lastName;
		private String email;
		private String password;
		private String phone;
		private Integer userStatus;
		private List<String> orders;

		private Builder() {
		}

		public static Builder anUser() {
			return new Builder();
		}

		public Builder withId(String id) {
			if (id != null && !id.isEmpty())
				this.id = id;
			return this;
		}

		public Builder withUsername(String username) {
			this.username = username;
			return this;
		}

		public Builder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder withEmail(String email) {
			this.email = email;
			return this;
		}

		public Builder withPassword(String password) {
			this.password = password;
			return this;
		}

		public Builder withPhone(String phone) {
			this.phone = phone;
			return this;
		}

		public Builder withUserStatus(Integer userStatus) {
			this.userStatus = userStatus;
			return this;
		}

		public Builder withOrders(List<String> orders) {
			this.orders = orders;
			return this;
		}

		public User build() {
			User user = new User();
			user.id = this.id;
			user.username = this.username;
			user.password = this.password;
			user.phone = this.phone;
			user.lastName = this.lastName;
			user.firstName = this.firstName;
			user.userStatus = this.userStatus;
			user.email = this.email;
			user.orders = this.orders;
			return user;
		}
	}
}
