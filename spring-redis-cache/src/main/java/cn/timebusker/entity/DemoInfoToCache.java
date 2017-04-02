package cn.timebusker.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 实现序列化接口，让类可以序列化 Serializable空接口，实现后可让类参与序列化和反序列化
 * 
 * @author Administrator
 *
 */
@Entity
public class DemoInfoToCache implements Serializable {

	public DemoInfoToCache(Long id, String name, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}

	public DemoInfoToCache() {		
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String pwd;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "DemoInfoToCache [id=" + id + ", name=" + name + ", pwd=" + pwd + "]";
	}
}
