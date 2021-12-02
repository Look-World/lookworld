package com.example.lookworld.Base.Journal.Entry;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("journal")
public class JournalEntry  implements Serializable {

    //主键id
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    //操作
    private String operation;

    //操作结果
    private String operationResult;

    //操作ip地址
    private String ip;

    //操作账户
    private String createUser;

    //操作时间
    private Date createTime;

}
