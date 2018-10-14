package com.hwq.data.Linear_List;

import lombok.extern.slf4j.Slf4j;

/**
 * Create by wenqing
 * 定义顺序表结构
 *
 * @date 2018-10-13
 */
@Slf4j
public class SLType {

    static final int MAXLEN = 100;

    DATA[] ListDtata = new DATA[MAXLEN + 1]; //保存顺序表的结构数组

    int ListLen; //顺序表已经存结点的数量

    /**
     * 初始化顺序表
     *
     * @param slType
     */
    void SLInt(SLType slType) {
        //初始化为空表
        slType.ListLen = 0;
    }

    /**
     * 返回顺序表的元素数量
     *
     * @param slType
     * @return
     */
    int SLLength(SLType slType) {
        return slType.ListLen;
    }

    /**
     * 插入结点
     *
     * @param slType
     * @param n 插入的元素的位置下标
     * @param data
     * @return <p>
     * 插入结点就是在线性表L的第i个位置插入一个新的结点，使得其后的结点编号依此加1。
     * 这时，插入一个新结点之后，线性表L的长度将变为n+1。插入结点操作的难点在于随后的每个节点数据都要进行移动，
     * 计算量很大。
     * </p>
     */
    int SLInsert(SLType slType, int n, DATA data) {
        //顺序表结点数量已超过最大数量
        if(slType.ListLen > MAXLEN){
            System.out.println("顺序表已经满了，不能插入结点！");
            return 0;
        }
        //插入结点序号不正确（n < 1是因为不能是第一个数的后置结点，slType.ListLen - 1不能是最后一个数的后置结点）
        if(n < 1 || n > slType.ListLen - 1){
            System.out.println("插入元素序号错误，不能插入元素");
        }
        //将顺序表中元素向后移动
        for(int i = slType.ListLen;i>=n;i--){
            slType.ListDtata[n+1] = ListDtata[n];
        }
        slType.ListDtata[n] = data;//插入结点
        slType.ListLen++;          //顺序表结点数量增加1
        return 1;
    }

    /**
     * 追加结点
     * @param slType
     * @param data
     * @return
     */
    int SLAdd(SLType slType,DATA data){
        if(slType.ListLen > MAXLEN){
            System.out.println("顺序表已经满了，不能插入结点！");
            return 0;
        }
        slType.ListDtata[++slType.ListLen] = data;
        return 1;
    }

    /**
     * 查找结点
     * @param slType
     * @param n
     * @return
     */
    DATA SLFindByNum(SLType slType,int n){
        if(slType.ListLen > MAXLEN){
            System.out.println("顺序表已经满了，不能插入结点！");
            return null;
        }
        return slType.ListDtata[n];
    }

    /**
     * 关键字查找
     * @param slType
     * @param key
     * @return
     */
    int SLFindByCont(SLType slType,String key){
        for (int i = 1;i<slType.ListLen;i++){
            if(slType.ListDtata[i].key.contains(key)){
                return i;
            }
        }
        return 0;
    }

    /**
     * 显示所有结点
     * @param slType
     * @return
     */
    int SLAll(SLType slType){
        for(int i=1;i<slType.ListLen;i++){
            System.out.println();
        }
        return 0;
    }
}
