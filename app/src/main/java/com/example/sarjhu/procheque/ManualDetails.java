package com.example.sarjhu.procheque;

class ManualDetails {
    Integer cheq;
    String date;
    String pay_name;
    String amount_words;
    Integer amount_num;
    Integer micr;
    Integer accno;
    public ManualDetails(Integer cheq, String date, String pay_name, String amount_words, Integer amount_num, Integer micr, Integer accno)
    {
        this.cheq = cheq;
        this.date = date;
        this.pay_name = pay_name;
        this.amount_words = amount_words;
        this.amount_num = amount_num;
        this.accno = accno;
        this.micr = micr;
    }
    public Integer getCheq() {
        return cheq;
    }

    public String getDate() {
        return date;
    }

    public String getPay_name() {
        return pay_name;
    }

    public String getAmount_words() {
        return amount_words;
    }

    public Integer getAmount_num() {
        return amount_num;
    }

    public Integer getMicr() {
        return micr;
    }

    public Integer getAccno() {
        return accno;
    }



}
