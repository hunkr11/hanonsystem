package com.hanon.system.model;

import java.io.Serializable;

public class FileDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	private long file_id;
	private String name = null;
	private String type = null;
	private String file_path = null;
	private long size;
	private String rec_status = null;
	private String create_user_id = null;
	private String last_modify_dttm = null;
	private String last_modify_user_id = null;
	private String thumbnailFilename;
	private String thumbnailSize;

	private String newFilename;

	private String url = null;
	private String thumbnailUrl = null;
	private String deleteUrl = null;
	private String deleteType = null;
	private String master_name;
	private String file_name;
	private long file_size;
	private String create_dttm;

	private String master_id;
	private String field_name;
	private String readableSize = "";

	public String getMaster_name() {
		return master_name;
	}

	public void setMaster_name(String master_name) {
		this.master_name = master_name;
	}

	public String getMaster_id() {
		return master_id;
	}

	public void setMaster_id(String master_id) {
		this.master_id = master_id;
	}

	public String getField_name() {
		return field_name;
	}

	public void setField_name(String field_name) {
		this.field_name = field_name;
	}

	public long getFile_id() {
		return file_id;
	}

	public void setFile_id(long file_id) {
		this.file_id = file_id;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public String getRec_status() {
		return rec_status;
	}

	public void setRec_status(String rec_status) {
		this.rec_status = rec_status;
	}

	public String getCreate_user_id() {
		return create_user_id;
	}

	public void setCreate_user_id(String create_user_id) {
		this.create_user_id = create_user_id;
	}

	public String getLast_modify_dttm() {
		return last_modify_dttm;
	}

	public void setLast_modify_dttm(String last_modify_dttm) {
		this.last_modify_dttm = last_modify_dttm;
	}

	public String getLast_modify_user_id() {
		return last_modify_user_id;
	}

	public void setLast_modify_user_id(String last_modify_user_id) {
		this.last_modify_user_id = last_modify_user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public String getDeleteUrl() {
		return deleteUrl;
	}

	public void setDeleteUrl(String deleteUrl) {
		this.deleteUrl = deleteUrl;
	}

	public String getDeleteType() {
		return deleteType;
	}

	public void setDeleteType(String deleteType) {
		this.deleteType = deleteType;
	}

	public String getThumbnailFilename() {
		return thumbnailFilename;
	}

	public void setThumbnailFilename(String thumbnailFilename) {
		this.thumbnailFilename = thumbnailFilename;
	}

	public String getNewFilename() {
		return newFilename;
	}

	public void setNewFilename(String newFilename) {
		this.newFilename = newFilename;
	}

	public String getThumbnailSize() {
		return thumbnailSize;
	}

	public void setThumbnailSize(String thumbnailSize) {
		this.thumbnailSize = thumbnailSize;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public long getFile_size() {
		return file_size;
	}

	public void setFile_size(long file_size) {
		this.file_size = file_size;
	}

	public String getCreate_dttm() {
		return create_dttm;
	}

	public void setCreate_dttm(String create_dttm) {
		this.create_dttm = create_dttm;
	}

	/**
	 * @return the readableSize
	 */
	public String getReadableSize() {
		return readableSize;
	}

	/**
	 * @param readableSize the readableSize to set
	 */
	public void setReadableSize(String readableSize) {
		this.readableSize = readableSize;
	}

}

