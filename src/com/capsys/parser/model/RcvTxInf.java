package com.capsys.parser.model;

public class RcvTxInf {

    private String OrgnlMsgId;
    private String OrgnlTxId;
    private String OrgnlIntrBkSttlmAmt;
    private String OrgnlRcvDtTm;
    private String RcvTxRsn;
    private String Tp;

    public RcvTxInf() {
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

    public String getRcvTxRsn() {
        return RcvTxRsn;
    }

    public void setRcvTxRsn(String rcvTxRsn) {
        RcvTxRsn = rcvTxRsn;
    }

    public String getTp() {
        return Tp;
    }

    public void setTp(String tp) {
        Tp = tp;
    }

    @Override
    public String toString() {
        return "RcvTxInf{" +
                "OrgnlMsgId='" + OrgnlMsgId + '\'' +
                ", OrgnlTxId='" + OrgnlTxId + '\'' +
                ", OrgnlIntrBkSttlmAmt='" + OrgnlIntrBkSttlmAmt + '\'' +
                ", OrgnlRcvDtTm='" + OrgnlRcvDtTm + '\'' +
                ", RcvTxRsn='" + RcvTxRsn + '\'' +
                ", Tp='" + Tp + '\'' +
                '}';
    }
}