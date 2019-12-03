package com.capsys.parser.model;

public class SntTxInf {
    private String OrgnlMsgId;
    private String OrgnlTxId;
    private String OrgnlIntrBkSttlmAmt;
    private String OrgnlRcvDtTm;
    private String SntTxRsn;
    private String Tp;

    public SntTxInf() {
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

    public String getSntTxRsn() {
        return SntTxRsn;
    }

    public void setSntTxRsn(String sntTxRsn) {
        SntTxRsn = sntTxRsn;
    }

    public String getTp() {
        return Tp;
    }

    public void setTp(String tp) {
        Tp = tp;
    }

    @Override
    public String toString() {
        return "SntTxInf{" +
                "OrgnlMsgId='" + OrgnlMsgId + '\'' +
                ", OrgnlTxId='" + OrgnlTxId + '\'' +
                ", OrgnlIntrBkSttlmAmt='" + OrgnlIntrBkSttlmAmt + '\'' +
                ", OrgnlRcvDtTm='" + OrgnlRcvDtTm + '\'' +
                ", SntTxRsn='" + SntTxRsn + '\'' +
                ", Tp='" + Tp + '\'' +
                '}';
    }
}
