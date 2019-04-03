package basic05;

public class BbsDTO {
	private int bbsId;
	private int bbsMemberId;
	private String bbsTitle;
	private String bbsDate;
	private String bbsContent;

	public BbsDTO(int bbsId, int bbsMemberId, String bbsTitle, String bbsDate, String bbsContent) {
		super();
		this.bbsId = bbsId;
		this.bbsMemberId = bbsMemberId;
		this.bbsTitle = bbsTitle;
		this.bbsDate = bbsDate;
		this.bbsContent = bbsContent;
	}

	public BbsDTO() {

	}

	public int getBbsId() {
		return bbsId;
	}

	public void setBbsId(int bbsId) {
		this.bbsId = bbsId;
	}

	public int getBbsMemberId() {
		return bbsMemberId;
	}

	public void setBbsMemberId(int bbsMemberId) {
		this.bbsMemberId = bbsMemberId;
	}

	public String getBbsTitle() {
		return bbsTitle;
	}

	public void setBbsTitle(String bbsTitle) {
		this.bbsTitle = bbsTitle;
	}

	public String getBbsDate() {
		return bbsDate;
	}

	public void setBbsDate(String bbsDate) {
		this.bbsDate = bbsDate;
	}

	public String getBbsContent() {
		return bbsContent;
	}

	public void setBbsContent(String bbsContent) {
		this.bbsContent = bbsContent;
	}

	@Override
	public String toString() {
		return "BbsDTO [bbsId=" + bbsId + ", bbsMemberId=" + bbsMemberId + ", bbsTitle=" + bbsTitle + ", bbsDate="
				+ bbsDate + ", bbsContent=" + bbsContent + "]";
	}

}
