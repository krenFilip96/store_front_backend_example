package si.kren.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class StoreForm {
    @Id @GeneratedValue private int id;
    private String storeName;
    private Date todayDate;
    private String servedBy;
    private String email;
    private String btBroadband;
    private String btTVPackage;
    private int totalPayment;
    private String otherInformation;
    private Date sportPackage;


    public StoreForm(String storeName, Date todayDate, String servedBy, String email, String band, String btTVPackage,
                     int totalPayment, String otherInformation, Date sportPackage) {

        this.storeName = storeName;
        this.todayDate = todayDate;
        this.servedBy = servedBy;
        this.email = email;
        this.btBroadband = band;
        this.btTVPackage = btTVPackage;
        this.totalPayment = totalPayment;
        this.otherInformation = otherInformation;
        this.sportPackage = sportPackage;

    }

    public StoreForm() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Date getTodayDate() {
        return todayDate;
    }

    public void setTodayDate(Date todayDate) {
        this.todayDate = todayDate;
    }

    public String getServedby() {
        return servedBy;
    }

    public void setServed_by(String servedBy) {
        this.servedBy = servedBy;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBtBroadband() {
        return btBroadband;
    }

    public void setBtBroadband(String btBroadband) {
        this.btBroadband = btBroadband;
    }

    public String getBtTVPackage() {
        return btTVPackage;
    }

    public void setBtTVPackage(String btTVPackage) {
        this.btTVPackage = btTVPackage;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }

    public String getOtherInformation() {
        return otherInformation;
    }

    public void setOtherInformation(String otherInformation) {
        this.otherInformation = otherInformation;
    }

    public Date getSportPackage() {
        return sportPackage;
    }

    public void setSportPackage(Date sportPackage) {
        this.sportPackage = sportPackage;
    }
}
