package com.capsys.parser.model;

public class RjctTxInf {
    private String OrgnlMsgId;
    private String OrgnlTxId;
    private String OrgnlIntrBkSttlmAmt;
    private String OrgnlRcvDtTm;
    private String RjctTxRsn;
    private String Tp;

    public RjctTxInf() {
    }

    public String getOrgnlMsgId() {
        return OrgnlMsgId;
    }

    public void setOrgnlMsgId(String orgnlMsgId) {
        OrgnlMsgId = orgnlMsgId;
    }

    public String getOrgnlTxId() {
        return OrgnlTxId;
    }

    public void setOrgnlTxId(String orgnlTxId) {
        OrgnlTxId = orgnlTxId;
    }

    public String getOrgnlIntrBkSttlmAmt() {
        return OrgnlIntrBkSttlmAmt;
    }

    public void setOrgnlIntrBkSttlmAmt(String orgnlIntrBkSttlmAmt) {
        OrgnlIntrBkSttlmAmt = orgnlIntrBkSttlmAmt;
    }

    public String getOrgnlRcvDtTm() {
        return OrgnlRcvDtTm;
    }

    public void setOrgnlRcvDtTm(String orgnlRcvDtTm) {
        OrgnlRcvDtTm = orgnlRcvDtTm;
    }

    public String getRjctTxRsn() {
        return RjctTxRsn;
    }

    public void setRjctTxRsn(String rjctTxRsn) {
        RjctTxRsn = rjctTxRsn;
    }

    public String getTp() {
        return Tp;
    }

    public void setTp(String tp) {
        Tp = tp;
    }

    @Override
    public String toString() {
        return "RjctTxInf{" +
                "OrgnlMsgId='" + OrgnlMsgId + '\'' +
                ", OrgnlTxId='" + OrgnlTxId + '\'' +
                ", OrgnlIntrBkSttlmAmt='" + OrgnlIntrBkSttlmAmt + '\'' +
                ", OrgnlRcvDtTm='" + OrgnlRcvDtTm + '\'' +
                ", RjctTxRsn='" + RjctTxRsn + '\'' +
                ", Tp='" + Tp + '\'' +
                '}';
    }
}
