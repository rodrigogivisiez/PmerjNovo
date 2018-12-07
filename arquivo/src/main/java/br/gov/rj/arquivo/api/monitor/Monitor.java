package br.gov.rj.arquivo.api.monitor;

import android.util.Base64;

public class Monitor {


//    /getDetalhesVTREmpenhada'
//            /getDetalhesVTRNaoEmpenhada'
//            '/getDetalhesVTRAfastadas'
//            /getDetalhesDespachadores'


    ///{opm}/grafico-de-ocorrencias-acumuladas

///getHoraQntdEmDespacho
    String aguardandoDespacho;
    String despachados;
    String despachadores;
    String vtrEmpenhadas;
    //'/getViaturasDisponiveis
    String vtrNaoEmpenhadas;
    String vtrAfastadas;
    ///getCountLigacaoByData/{data}'
    String ligacoes;
    //ocorrencias/em-andamento
    String ocorrenciasGeradas;
    ///Umnovezero/getOcorrenciasCanceladas
    String ocorrenciasCanceladas;
    String ocorrenciasAtendidas;
    String horaAtualizacao;

    public Monitor() {
    }

    public String getAguardandoDespacho() {
        return aguardandoDespacho;
    }

    public void setAguardandoDespacho(String aguardandoDespacho) {
        this.aguardandoDespacho = aguardandoDespacho;
    }

    public String getDespachados() {
        return despachados;
    }

    public void setDespachados(String despachados) {
        this.despachados = despachados;
    }

    public String getDespachadores() {
        return despachadores;
    }

    public void setDespachadores(String despachadores) {
        this.despachadores = despachadores;
    }

    public String getVtrEmpenhadas() {
        return vtrEmpenhadas;
    }

    public void setVtrEmpenhadas(String vtrEmpenhadas) {
        this.vtrEmpenhadas = vtrEmpenhadas;
    }

    public String getVtrNaoEmpenhadas() {
        return vtrNaoEmpenhadas;
    }

    public void setVtrNaoEmpenhadas(String vtrNaoEmpenhadas) {
        this.vtrNaoEmpenhadas = vtrNaoEmpenhadas;
    }

    public String getVtrAfastadas() {
        return vtrAfastadas;
    }

    public void setVtrAfastadas(String vtrAfastadas) {
        this.vtrAfastadas = vtrAfastadas;
    }

    public String getLigacoes() {
        return ligacoes;
    }

    public void setLigacoes(String ligacoes) {
        this.ligacoes = ligacoes;
    }

    public String getOcorrenciasGeradas() {
        return ocorrenciasGeradas;
    }

    public void setOcorrenciasGeradas(String ocorrenciasGeradas) {
        this.ocorrenciasGeradas = ocorrenciasGeradas;
    }

    public String getOcorrenciasCanceladas() {
        return ocorrenciasCanceladas;
    }

    public void setOcorrenciasCanceladas(String ocorrenciasCanceladas) {
        this.ocorrenciasCanceladas = ocorrenciasCanceladas;
    }

    public String getOcorrenciasAtendidas() {
        return ocorrenciasAtendidas;
    }

    public void setOcorrenciasAtendidas(String ocorrenciasAtendidas) {
        this.ocorrenciasAtendidas = ocorrenciasAtendidas;
    }

    public String getHoraAtualizacao() {
        return horaAtualizacao;
    }

    public void setHoraAtualizacao(String horaAtualizacao) {
        this.horaAtualizacao = horaAtualizacao;
      //  JSON.stringify()
      //  var Base64 = { _keyStr: "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=", encode: function (e) { var t = ""; var n, r, i, s, o, u, a; var f = 0; e = Base64._utf8_encode(e); while (f < e.length) { n = e.charCodeAt(f++); r = e.charCodeAt(f++); i = e.charCodeAt(f++); s = n >> 2; o = (n & 3) << 4 | r >> 4; u = (r & 15) << 2 | i >> 6; a = i & 63; if (isNaN(r)) { u = a = 64 } else if (isNaN(i)) { a = 64 } t = t + this._keyStr.charAt(s) + this._keyStr.charAt(o) + this._keyStr.charAt(u) + this._keyStr.charAt(a) } return t }, decode: function (e) { var t = ""; var n, r, i; var s, o, u, a; var f = 0; e = e.replace(/[^A-Za-z0-9+/=]/g, ""); while (f < e.length) { s = this._keyStr.indexOf(e.charAt(f++)); o = this._keyStr.indexOf(e.charAt(f++)); u = this._keyStr.indexOf(e.charAt(f++)); a = this._keyStr.indexOf(e.charAt(f++)); n = s << 2 | o >> 4; r = (o & 15) << 4 | u >> 2; i = (u & 3) << 6 | a; t = t + String.fromCharCode(n); if (u != 64) { t = t + String.fromCharCode(r) } if (a != 64) { t = t + String.fromCharCode(i) } } t = Base64._utf8_decode(t); return t }, _utf8_encode: function (e) { e = e.replace(/rn/g, "n"); var t = ""; for (var n = 0; n < e.length; n++) { var r = e.charCodeAt(n); if (r < 128) { t += String.fromCharCode(r) } else if (r > 127 && r < 2048) { t += String.fromCharCode(r >> 6 | 192); t += String.fromCharCode(r & 63 | 128) } else { t += String.fromCharCode(r >> 12 | 224); t += String.fromCharCode(r >> 6 & 63 | 128); t += String.fromCharCode(r & 63 | 128) } } return t }, _utf8_decode: function (e) { var t = ""; var n = 0; var r = c1 = c2 = 0; while (n < e.length) { r = e.charCodeAt(n); if (r < 128) { t += String.fromCharCode(r); n++ } else if (r > 191 && r < 224) { c2 = e.charCodeAt(n + 1); t += String.fromCharCode((r & 31) << 6 | c2 & 63); n += 2 } else { c2 = e.charCodeAt(n + 1); c3 = e.charCodeAt(n + 2); t += String.fromCharCode((r & 15) << 12 | (c2 & 63) << 6 | c3 & 63); n += 3 } } return t } }
//        [{"id_pasta":"540","id_arquivo":"9019","ssn":"05299376707","token":"227ece14a5f56ed35664130a49077873"
//        }]
    }
}
