package io.swagger.client.model;

import java.util.Date;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class FileReaderBean  {
  
  private Long count = null;
  private Date dateTime = null;
  private String url = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("count")
  public Long getCount() {
    return count;
  }
  public void setCount(Long count) {
    this.count = count;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("dateTime")
  public Date getDateTime() {
    return dateTime;
  }
  public void setDateTime(Date dateTime) {
    this.dateTime = dateTime;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("url")
  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class FileReaderBean {\n");
    
    sb.append("  count: ").append(count).append("\n");
    sb.append("  dateTime: ").append(dateTime).append("\n");
    sb.append("  url: ").append(url).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
