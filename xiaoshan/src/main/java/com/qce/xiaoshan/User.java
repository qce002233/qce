package com.qce.xiaoshan;

import lombok.*;

@Data
//实体类层
public class User {
	private Integer id;
	private Integer age;
	private String name;

	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		User other = (User) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
				&& (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());

		return result;
	}

	public static void main(String[] args) {

	}
}
