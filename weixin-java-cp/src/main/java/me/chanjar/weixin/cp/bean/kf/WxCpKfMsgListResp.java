package me.chanjar.weixin.cp.bean.kf;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.chanjar.weixin.cp.bean.WxCpBaseResp;
import me.chanjar.weixin.cp.bean.kf.msg.WxCpKfBusinessCardMsg;
import me.chanjar.weixin.cp.bean.kf.msg.WxCpKfEventMsg;
import me.chanjar.weixin.cp.bean.kf.msg.WxCpKfLinkMsg;
import me.chanjar.weixin.cp.bean.kf.msg.WxCpKfLocationMsg;
import me.chanjar.weixin.cp.bean.kf.msg.WxCpKfMenuMsg;
import me.chanjar.weixin.cp.bean.kf.msg.WxCpKfMiniProgramMsg;
import me.chanjar.weixin.cp.bean.kf.msg.WxCpKfResourceMsg;
import me.chanjar.weixin.cp.bean.kf.msg.WxCpKfTextMsg;
import me.chanjar.weixin.cp.util.json.WxCpGsonBuilder;

/**
 * @author leiin
 * created on  2022/1/26 5:24 下午
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class WxCpKfMsgListResp extends WxCpBaseResp {

  private static final long serialVersionUID = -3115552079069452091L;
  @SerializedName("next_cursor")
  private String nextCursor;

  @SerializedName("has_more")
  private Integer hasMore;

  @SerializedName("msg_list")
  private List<WxCpKfMsgItem> msgList;

  @NoArgsConstructor
  @Data
  public static class WxCpKfMsgItem {
    @SerializedName("msgid")
    private String msgId;
    @SerializedName("open_kfid")
    private String openKfid;
    @SerializedName("external_userid")
    private String externalUserId;
    @SerializedName("send_time")
    private Long sendTime;
    private Integer origin;
    @SerializedName("servicer_userid")
    private String servicerUserId;
    @SerializedName("msgtype")
    private String msgType;
    private WxCpKfTextMsg text;
    private WxCpKfResourceMsg image;
    private WxCpKfResourceMsg voice;
    private WxCpKfResourceMsg video;
    private WxCpKfResourceMsg file;
    private WxCpKfLocationMsg location;
    private WxCpKfLinkMsg link;
    @SerializedName("business_card")
    private WxCpKfBusinessCardMsg businessCard;
    @SerializedName("miniprogram")
    private WxCpKfMiniProgramMsg miniProgram;
    @SerializedName("msgmenu")
    private WxCpKfMenuMsg msgMenu;
    private WxCpKfEventMsg event;
  }

  public static WxCpKfMsgListResp fromJson(String json) {
    return WxCpGsonBuilder.create().fromJson(json, WxCpKfMsgListResp.class);
  }
}
