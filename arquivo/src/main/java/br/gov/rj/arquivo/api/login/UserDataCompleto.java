package br.gov.rj.arquivo.api.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Oto on 06/06/2018.
 */

public class UserDataCompleto {

        @SerializedName("nome")
        @Expose
        private String nome;
        @SerializedName("cpf")
        @Expose
        private String cpf;
        @SerializedName("genero")
        @Expose
        private String genero;
        @SerializedName("nome_mae")
        @Expose
        private String nomeMae;
        @SerializedName("nome_pai")
        @Expose
        private String nomePai;
        @SerializedName("data_nasc")
        @Expose
        private String dataNasc;
        @SerializedName("situacao")
        @Expose
        private String situacao;
        @SerializedName("descricaoEscolaridade")
        @Expose
        private String descricaoEscolaridade;

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }

        public String getGenero() {
            return genero;
        }

        public void setGenero(String genero) {
            this.genero = genero;
        }

        public String getNomeMae() {
            return nomeMae;
        }

        public void setNomeMae(String nomeMae) {
            this.nomeMae = nomeMae;
        }

        public String getNomePai() {
            return nomePai;
        }

        public void setNomePai(String nomePai) {
            this.nomePai = nomePai;
        }

        public String getDataNasc() {
            return dataNasc;
        }

        public void setDataNasc(String dataNasc) {
            this.dataNasc = dataNasc;
        }

        public String getSituacao() {
            return situacao;
        }

        public void setSituacao(String situacao) {
            this.situacao = situacao;
        }

        public String getDescricaoEscolaridade() {
            return descricaoEscolaridade;
        }

        public void setDescricaoEscolaridade(String descricaoEscolaridade) {
            this.descricaoEscolaridade = descricaoEscolaridade;
        }
}
