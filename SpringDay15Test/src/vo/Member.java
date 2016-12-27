package vo;

public class Member {
	private int memberNo;
	private String id;
	private String password;
	
	public Member(){}
	
	public Member(int memberNo, String id, String password) {
		super();
		this.memberNo = memberNo;
		this.id = id;
		this.password = password;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", id=" + id + ", password=" + password + "]";
	}
}
