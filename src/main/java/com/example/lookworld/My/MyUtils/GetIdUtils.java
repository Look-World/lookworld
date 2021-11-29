package com.example.lookworld.My.MyUtils;


import org.springframework.stereotype.Component;

import java.util.UUID;


/**
 *
 *
 * 生成id工具集
 *
 *
 */
@Component
public class GetIdUtils {

    ////////////////////////////////////////////////////生成uuid////////////////////////////////////////////////////////////
    /**
     * 生成uuid
     *
     * @param isReplace 参数为1去除 ”-“ 参数为 “0” 不去除
     * @return uuid
     */
    public static String getUUID(int isReplace){
        try {
        String uuid = " " ;
        switch (isReplace){
            case  1:
                uuid = UUID.randomUUID().toString().replaceAll("-", "");
                return uuid;
            case 0:
                uuid = UUID.randomUUID().toString();
                return uuid;
            default:
                throw new IllegalAccessException("请传入正确的参数");
        }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public GetIdUtils(){
    }


    ////////////////////////////////////////////////////生成uuid结束////////////////////////////////////////////////////////////



    ////////////////////////////////////////////////////雪花算法生成id////////////////////////////////////////////////////////////
    /**
     * 起始的时间戳
     */
    private final static long START_TIMESTAMP = 1480166465631L;

    /**
     * 每一部分占用的位数
     */
    private final static long SEQUENCE_BIT = 12;   //序列号占用的位数
    private final static long MACHINE_BIT = 5;     //机器标识占用的位数
    private final static long DATA_CENTER_BIT = 5; //数据中心占用的位数

    /**
     * 每一部分的最大值
     */
    private final static long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);
    private final static long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT);
    private final static long MAX_DATA_CENTER_NUM = -1L ^ (-1L << DATA_CENTER_BIT);

    /**
     * 每一部分向左的位移
     */
    private final static long MACHINE_LEFT = SEQUENCE_BIT;
    private final static long DATA_CENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
    private final static long TIMESTAMP_LEFT = DATA_CENTER_LEFT + DATA_CENTER_BIT;

    private static long dataCenterId;  //数据中心
    private static long machineId;     //机器标识
    private static long sequence = 0L; //序列号
    private static long lastTimeStamp = -1L;  //上一次时间戳

    private static long getNextMill() {
        long mill = getNewTimeStamp();
        while (mill <= lastTimeStamp) {
            mill = getNewTimeStamp();
        }
        return mill;
    }

    private static long getNewTimeStamp() {
        return System.currentTimeMillis();
    }

//    /**
//     * 根据指定的数据中心ID和机器标志ID生成指定的序列号
//     *
//     * @param dataCenterId 数据中心ID
//     * @param machineId    机器标志ID
//     */
//    public GetIdUtils(long dataCenterId, long machineId) {
//        if (dataCenterId > MAX_DATA_CENTER_NUM || dataCenterId < 0) {
//            throw new IllegalArgumentException("DtaCenterId can't be greater than MAX_DATA_CENTER_NUM or less than 0！");
//        }
//        if (machineId > MAX_MACHINE_NUM || machineId < 0) {
//            throw new IllegalArgumentException("MachineId can't be greater than MAX_MACHINE_NUM or less than 0！");
//        }
//        this.dataCenterId = dataCenterId;
//        this.machineId = machineId;
//    }

    //设置dataCenterId与machineId的值
    public static void setUpDM(){
        dataCenterId = 2;
        machineId = 3;
    }



    /**
     * 雪花算法生成id
     *
     * @return id
     */
    public static synchronized long nextId() {
        setUpDM();
        long currTimeStamp = getNewTimeStamp();
        if (currTimeStamp < lastTimeStamp) {
            throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
        }

        if (currTimeStamp == lastTimeStamp) {
            //相同毫秒内，序列号自增
            sequence = (sequence + 1) & MAX_SEQUENCE;
            //同一毫秒的序列数已经达到最大
            if (sequence == 0L) {
                currTimeStamp = getNextMill();
            }
        } else {
            //不同毫秒内，序列号置为0
            sequence = 0L;
        }

        lastTimeStamp = currTimeStamp;

        return (currTimeStamp - START_TIMESTAMP) << TIMESTAMP_LEFT //时间戳部分
                | dataCenterId << DATA_CENTER_LEFT       //数据中心部分
                | machineId << MACHINE_LEFT             //机器标识部分
                | sequence;                             //序列号部分
    }


    ////////////////////////////////////////////////////雪花算法生成id结束////////////////////////////////////////////////////////////

}
