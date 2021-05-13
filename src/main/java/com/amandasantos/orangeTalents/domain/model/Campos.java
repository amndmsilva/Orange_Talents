package com.amandasantos.orangeTalents.domain.model;

public class Campos {
        private String nome;
        private String mensagem;

        public Campos(String nome, String mensagem) {
            super();
            this.nome = nome;
            this.mensagem = mensagem;
        }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
