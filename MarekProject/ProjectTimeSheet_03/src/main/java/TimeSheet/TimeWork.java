package TimeSheet;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class TimeWork implements Serializable {

    private String agencyShortName;
    private String companyShortName;
    private LocalDateTime startWork;
    private LocalDateTime finishWork;
    private LocalTime timeBreak;
    private BigDecimal rate;
    private boolean addToInovoice = false;

    public TimeWork(String agencyShortName, String companyShortName, LocalDateTime startWork, LocalDateTime finishWork, LocalTime timeBreak, BigDecimal rate) {
        this.agencyShortName = agencyShortName;
        this.companyShortName = companyShortName;
        this.startWork = startWork;
        this.finishWork = finishWork;
        this.timeBreak = timeBreak;
        this.rate = rate;
    }

    public String getAgencyShortName() {
        return agencyShortName;
    }

    public void setAgencyShortName(String agencyShortName) {
        this.agencyShortName = agencyShortName;
    }

    public String getCompanyShortName() {
        return companyShortName;
    }

    public void setCompanyShortName(String companyShortName) {
        this.companyShortName = companyShortName;
    }

    public LocalDateTime getStartWork() {
        return startWork;
    }

    public void setStartWork(LocalDateTime startWork) {
        this.startWork = startWork;
    }

    public LocalDateTime getFinishWork() {
        return finishWork;
    }

    public void setFinishWork(LocalDateTime finishWork) {
        this.finishWork = finishWork;
    }

    public LocalTime getTimeBreak() {
        return timeBreak;
    }

    public void setTimeBreak(LocalTime timeBreak) {
        this.timeBreak = timeBreak;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeWork timeWork = (TimeWork) o;
        return Objects.equals(agencyShortName, timeWork.agencyShortName) && Objects.equals(companyShortName, timeWork.companyShortName) && Objects.equals(startWork, timeWork.startWork) && Objects.equals(finishWork, timeWork.finishWork) && Objects.equals(timeBreak, timeWork.timeBreak) && Objects.equals(rate, timeWork.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(agencyShortName, companyShortName, startWork, finishWork, timeBreak, rate);
    }

    @Override
    public String toString() {
        return "TimeWork{" +
                "agencyShortName='" + agencyShortName + '\'' +
                ", companyShortName='" + companyShortName + '\'' +
                ", startWork=" + startWork +
                ", finishWork=" + finishWork +
                ", timeBreak=" + timeBreak +
                ", rate=" + rate +
                '}';
    }
}
