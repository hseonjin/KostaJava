package bean;

import java.time.LocalDateTime;

public class Reply {
	private Integer reply_id;
	private String content;
	private String nickname;
	private Integer board_id;
	private LocalDateTime regdate;

	public Integer getReply_id() {
		return reply_id;
	}

	public void setReply_id(Integer reply_id) {
		this.reply_id = reply_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getBoard_id() {
		return board_id;
	}

	public void setBoard_id(Integer board_id) {
		this.board_id = board_id;
	}

	public LocalDateTime getRegdate() {
		return regdate;
	}

	public void setRegdate(LocalDateTime regdate) {
		this.regdate = regdate;
	}

	public Reply(Integer reply_id, String content, String nickname, Integer board_id, LocalDateTime regdate) {
		super();
		this.reply_id = reply_id;
		this.content = content;
		this.nickname = nickname;
		this.board_id = board_id;
		this.regdate = regdate;
	}

	
}
