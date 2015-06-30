package com.domain;

/**
 * Member entity. @author MyEclipse Persistence Tools
 */

public class Member implements java.io.Serializable {

	// Fields

	private Integer memId;
	private String memName;
	private String memPass;
	private String memAdds;
	private String memMail;
	private String memTel;

	// Constructors

	/** default constructor */
	public Member() {
	}

	/** minimal constructor */
	public Member(Integer memId) {
		this.memId = memId;
	}

	/** full constructor */
	public Member(Integer memId, String memName, String memPass,
			String memAdds, String memMail, String memTel) {
		this.memId = memId;
		this.memName = memName;
		this.memPass = memPass;
		this.memAdds = memAdds;
		this.memMail = memMail;
		this.memTel = memTel;
	}

	// Property accessors

	public Integer getMemId() {
		return this.memId;
	}

	public void setMemId(Integer memId) {
		this.memId = memId;
	}

	public String getMemName() {
		return this.memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemPass() {
		return this.memPass;
	}

	public void setMemPass(String memPass) {
		this.memPass = memPass;
	}

	public String getMemAdds() {
		return this.memAdds;
	}

	public void setMemAdds(String memAdds) {
		this.memAdds = memAdds;
	}

	public String getMemMail() {
		return this.memMail;
	}

	public void setMemMail(String memMail) {
		this.memMail = memMail;
	}

	public String getMemTel() {
		return this.memTel;
	}

	public void setMemTel(String memTel) {
		this.memTel = memTel;
	}

}