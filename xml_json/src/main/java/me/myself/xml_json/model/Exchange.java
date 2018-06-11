package me.myself.xml_json.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.google.gson.annotations.SerializedName;

public class Exchange {

    private String r030;
    private String txt;
    private BigDecimal rate;
    private String cc;
    @SerializedName("exchangedate")
    private LocalDate exchangeDate;
    
    public Exchange(String r030, String txt, BigDecimal rate, String cc, LocalDate exchangedate) {
        super();
        this.r030 = r030;
        this.txt = txt;
        this.rate = rate;
        this.cc = cc;
        this.exchangeDate = exchangedate;
    }

    public String getR030() {
        return r030;
    }

    public void setR030(String r030) {
        this.r030 = r030;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public LocalDate getExchangeDate() {
        return exchangeDate;
    }

    public void setExchangeDate(LocalDate exchangedate) {
        this.exchangeDate = exchangedate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cc == null) ? 0 : cc.hashCode());
        result = prime * result + ((exchangeDate == null) ? 0 : exchangeDate.hashCode());
        result = prime * result + ((r030 == null) ? 0 : r030.hashCode());
        result = prime * result + ((rate == null) ? 0 : rate.hashCode());
        result = prime * result + ((txt == null) ? 0 : txt.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Exchange other = (Exchange) obj;
        if (cc == null) {
            if (other.cc != null)
                return false;
        } else if (!cc.equals(other.cc))
            return false;
        if (exchangeDate == null) {
            if (other.exchangeDate != null)
                return false;
        } else if (!exchangeDate.equals(other.exchangeDate))
            return false;
        if (r030 == null) {
            if (other.r030 != null)
                return false;
        } else if (!r030.equals(other.r030))
            return false;
        if (rate == null) {
            if (other.rate != null)
                return false;
        } else if (!rate.equals(other.rate))
            return false;
        if (txt == null) {
            if (other.txt != null)
                return false;
        } else if (!txt.equals(other.txt))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("Exchange [r030=%s, txt=%s, rate=%s, cc=%s, exchangeDate=%s]", r030, txt, rate, cc,
                exchangeDate);
    }
    
}
