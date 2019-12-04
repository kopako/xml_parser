package com.capsys.parser.model;

import java.sql.*;
import java.util.Calendar;

public abstract class ATxInf {
    private static Connection conn = null;
    private static PreparedStatement preparedStatement;
    private static final String SQL = "insert into giro_raw( batch_id, type_id, orgnlmsgid, orgnltxid, orgnlintrbksttlmamt, orgnlrcvdttm, txrsn, txtp)" +
            " values(?,?,?,?,?,?,?,?)";
    private static int batchId;
    private String OrgnlMsgId;
    private String OrgnlTxId;
    private String OrgnlIntrBkSttlmAmt;
    private String OrgnlRcvDtTm;
    private String Tp;
    private String TxRsn;

    protected txType type;

    protected enum txType {
        RcvTxRsn(1),
        RjctTxRsn(2),
        SntTxRsn(3);
        private int value;

        public int getValue() {
            return value;
        }

        txType(int value) {
            this.value = value;
        }
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

    public String getTp() {
        return Tp;
    }

    public void setTp(String tp) {
        Tp = tp;
    }

    public static void setBatchId(int batchId) {
        ATxInf.batchId = batchId;
    }

    public static void setConn(Connection aConn) throws SQLException {
        conn = aConn;
        preparedStatement = conn.prepareStatement(SQL);
    }

    public void insertTx() throws Exception {
        if (null == conn) {
            throw new Exception("Uninitialized connection");
        }
        if (conn.isClosed()) {
            throw new Exception("Closed connection");
        }
        if (null == preparedStatement) {
            throw new Exception("Uninitialized statement");
        }
        if (preparedStatement.isClosed()) {
            throw new Exception("Closed statement");
        }

        //batch_id, type_id,
        preparedStatement.setInt(1, batchId);
        preparedStatement.setInt(2, type.getValue());
        // orgnlmsgid, orgnltxid, orgnlintrbksttlmamt,
        preparedStatement.setString(3, OrgnlMsgId);
        preparedStatement.setString(4, OrgnlTxId);
        if (OrgnlIntrBkSttlmAmt != null) {
            preparedStatement.setInt(5, Integer.parseInt(OrgnlIntrBkSttlmAmt));
        } else {
            preparedStatement.setNull(5, Types.INTEGER );
        }
        // orgnlrcvdttm,
        Calendar cal = javax.xml.bind.DatatypeConverter.parseDateTime(getOrgnlRcvDtTm());
        Timestamp ts = new Timestamp(cal.getTimeInMillis());

        preparedStatement.setTimestamp(6, ts);
        // txrsn, txtp
        preparedStatement.setString(7, TxRsn);
        preparedStatement.setString(8, Tp);
        int affectedRows = preparedStatement.executeUpdate();
        // check the affected rows
        if (affectedRows != 1) {
            System.out.println("Insert failed for [" + this.toString() + "]");
        }
    }

    @Override
    public String toString() {
        return "ATxInf{" +
                "type=" + type.ordinal() +
                ", OrgnlMsgId='" + OrgnlMsgId + '\'' +
                ", OrgnlTxId='" + OrgnlTxId + '\'' +
                ", OrgnlIntrBkSttlmAmt='" + OrgnlIntrBkSttlmAmt + '\'' +
                ", OrgnlRcvDtTm='" + OrgnlRcvDtTm + '\'' +
                ", Tp='" + Tp + '\'' +
                ", TxRsn='" + TxRsn + '\'' +
                '}';
    }
}
