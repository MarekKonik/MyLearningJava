package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DayWorking implements Serializable {


    private String agency;
    private String company;
    private LocalDateTime artWork;
    private LocalDateTime finishWork;
    private LocalTime timeBreak;
    private BigDecimal rate;

    public DayWorking(String agency, String company, LocalDateTime artWork, LocalDateTime finishWork, LocalTime timeBreak, BigDecimal rate) {
        this.agency = agency;
        this.company = company;
        this.artWork = artWork;
        this.finishWork = finishWork;
        this.timeBreak = this.timeBreak;
        this.rate = rate;
    }


    @Override
    public String toString() {
        return "DayWorking{" +
                "agency='" + agency + '\'' +
                ", company='" + company + '\'' +
                ", artWork=" + artWork +
                ", finishWork=" + finishWork +
                ", timeBreak=" + timeBreak +
                ", rate=" + rate +
                '}';
    }
}
