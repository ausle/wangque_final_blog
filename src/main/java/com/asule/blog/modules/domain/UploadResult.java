package com.asule.blog.modules.domain;

//上传图片封装类
public class UploadResult {
//    public static int OK = 200;
//    public static int ERROR = 400;

    /**
     * 上传状态
     */
    private int success;

//    /**
//     * 提示文字
//     */
    private String message;
//
//    /**
//     * 文件名
//     */
//    private String name;
//
//    /**
//     * 文件大小
//     */
//    private long size;

    /**
     * 文件存放路径
     */
    private String url;

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UploadResult ok(String message) {
        this.success = 1;
        this.message = message;
        return this;
    }

    public UploadResult error(String message) {
        this.success = 0;
        this.message = message;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
