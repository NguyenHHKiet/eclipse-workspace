package table.vo;

import java.util.Date;

public class Table {
	protected int 		no; // 프로젝트일련번호
	protected String 	title; // 프로젝트명
	protected String 	content; // 설명
	protected Date 		startDate; // 시작일
	protected Date 		endDate; // 종료일
	protected int 		state; // 상태
	protected Date 		createdDate; // 생성일
	protected String 	tags; // 태그들
	public int getNo() {
		return no;
	}
	public Table setNo(int no) {
		this.no = no;
		 return this;
	}
	public String getTitle() {
		return title;
	}
	public Table setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getContent() {
		return content;
	}
	public Table setContent(String content) {
		this.content = content;
		return this;
	}
	public Date getStartDate() {
		return startDate;
	}
	public Table setStartDate(Date startDate) {
		this.startDate = startDate;
		return this;
	}
	public Date getEndDate() {
		return endDate;
	}
	public Table setEndDate(Date endDate) {
		this.endDate = endDate;
		return this;
	}
	public int getState() {
		return state;
	}
	public Table setState(int state) {
		this.state = state;
		return this;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public Table setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
		return this;
	}
	public String getTags() {
		return tags;
	}
	public Table setTags(String tags) {
		this.tags = tags;
		return this;
	}
	
}
