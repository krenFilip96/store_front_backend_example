package si.kren.resources;

import org.jboss.logging.Logger;
import si.kren.models.StoreForm;
import si.kren.repository.StoreFormRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


@Path("/api/form")
public class StoreFormResource {
    private static final Logger LOGGER = Logger.getLogger(StoreFormResource.class);

    @Inject
    StoreFormRepository storeFormRepository;


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createEntry(StoreFormPayload payload) {
        LOGGER.info("createEntry - ENTER");
        System.out.println(payload.getTodayDate());
        StoreForm data = new StoreForm(payload.getStoreName(),
                payload.getTodayDate(),
                payload.getServedBy(),
                payload.getEmail(),
                payload.getBand(),
                payload.getTvPackage(),
                payload.calculateTotalFee(),
                payload.getOtherInformation(),
                payload.getSportPackage());

        storeFormRepository.persist(data);
        LOGGER.info("createEntry - Data has been saved successfully.");
        return Response.ok().build();

    }
    private static class StoreFormPayload {
        private String storeName;
        private Date todayDate;
        private String servedBy;
        private String email;
        private Date sportPackage;
        private String band;
        private String tvPackage;
        private int MonthlyCharge;
        private int upfrontFee;
        private int installments;
        private String otherInformation;

        public StoreFormPayload() {
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

        public String getServedBy() {
            return servedBy;
        }

        public void setServedBy(String servedBy) {
            this.servedBy = servedBy;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Date getSportPackage() {
            return sportPackage;
        }

        public void setSportPackage(Date sportPackage) {
            this.sportPackage = sportPackage;
        }

        public String getBand() {
            return band;
        }

        public void setBand(String band) {
            this.band = band;
        }

        public String getTvPackage() {
            return tvPackage;
        }

        public void setTvPackage(String tvPackage) {
            this.tvPackage = tvPackage;
        }

        public int getMonthlyCharge() {
            return MonthlyCharge;
        }

        public void setMonthlyCharge(int monthlyCharge) {
            MonthlyCharge = monthlyCharge;
        }

        public int getUpfrontFee() {
            return upfrontFee;
        }

        public void setUpfrontFee(int upfrontFee) {
            this.upfrontFee = upfrontFee;
        }

        public int getInstallments() {
            return installments;
        }

        public void setInstallments(int installments) {
            this.installments = installments;
        }

        public String getOtherInformation() {
            return otherInformation;
        }

        public void setOtherInformation(String otherInformation) {
            this.otherInformation = otherInformation;
        }

        public int calculateTotalFee() {
            LOGGER.info("calculateTotalFee - ENTER");
            return this.upfrontFee * (this.MonthlyCharge * this.installments);
        }
    }
}

