package sn.sa.filrouge.backspring.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

public class FormCompte {
        private double codeBank;
        private String nomBeneficiaire;
        private String ninea;

        public String getNinea() {
            return ninea;
        }

        public void setNinea(String ninea) {
            this.ninea = ninea;
        }

        public FormCompte() {
        }

        public FormCompte(double codeBank, String nomBeneficiaire, String ninea ) {

            this.codeBank = codeBank;
            this.nomBeneficiaire = nomBeneficiaire;
            this.ninea = ninea;
        }

        public double getCodeBank() {
            return codeBank;
        }

        public void setCodeBank(double codeBank) {
            this.codeBank = codeBank;
        }

        public String getNomBeneficiaire() {
            return nomBeneficiaire;
        }

        public void setNomBeneficiaire(String nomBeneficiaire) {
            this.nomBeneficiaire = nomBeneficiaire;
        }

    }

