package me.chanjar.weixin.cp.bean.school.user;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import me.chanjar.weixin.cp.bean.WxCpBaseResp;
import me.chanjar.weixin.cp.util.json.WxCpGsonBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * 读取学生或家长返回结果.
 *
 * @author Wang_Wong
 * created on  2022-07-13
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxCpUserResult extends WxCpBaseResp implements Serializable {
  private static final long serialVersionUID = -4960239393895754138L;

  @SerializedName("student")
  private Student student;

  @SerializedName("parent")
  private Parent parent;

  @SerializedName("user_type")
  private Integer userType;

  @Setter
  @Getter
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Parent implements Serializable {

    @SerializedName("parent_userid")
    private String parentUserId;

    @SerializedName("relation")
    private String relation;

    @SerializedName("mobile")
    private String mobile;

    @SerializedName("external_userid")
    private String externalUserId;

    @SerializedName("is_subscribe")
    private Integer isSubscribe;

    @SerializedName("children")
    private List<Children> children;

    public static Parent fromJson(String json) {
      return WxCpGsonBuilder.create().fromJson(json, Parent.class);
    }

    public String toJson() {
      return WxCpGsonBuilder.create().toJson(this);
    }

  }

  @Setter
  @Getter
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Student implements Serializable {

    @SerializedName("student_userid")
    private String studentUserId;

    @SerializedName("department")
    private List<Integer> department;

    @SerializedName("parents")
    private List<Parent> parents;

    @SerializedName("name")
    private String name;

    public static Student fromJson(String json) {
      return WxCpGsonBuilder.create().fromJson(json, Student.class);
    }

    public String toJson() {
      return WxCpGsonBuilder.create().toJson(this);
    }

  }

  @Setter
  @Getter
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Children implements Serializable {

    @SerializedName("student_userid")
    private String studentUserId;

    @SerializedName("relation")
    private String relation;

    public static Children fromJson(String json) {
      return WxCpGsonBuilder.create().fromJson(json, Children.class);
    }

    public String toJson() {
      return WxCpGsonBuilder.create().toJson(this);
    }

  }

  public static WxCpUserResult fromJson(String json) {
    return WxCpGsonBuilder.create().fromJson(json, WxCpUserResult.class);
  }

  public String toJson() {
    return WxCpGsonBuilder.create().toJson(this);
  }

}
