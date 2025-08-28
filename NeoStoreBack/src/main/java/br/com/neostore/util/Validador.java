package br.com.neostore;

// import da biblioteca caelum stella para o cnpj

import br.com.caelum.stella.validation.CNPJValidator;

// import da biblioteca apache commons para o email
import br.com.caelum.stella.validation.InvalidStateException;
import org.apache.commons.validator.routines.EmailValidator;

public class Validador {
    //Valida um endereço de email utilizando a biblioteca Apache Commons

    public static boolean validaEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return EmailValidator.getInstance().isValid(email);
    }

    //Valida o cnpj utilizando o code do site dev media

    public static boolean validaCNPJ(String cnpj) {

        // Remove caracteres de formatação e verifica se é nulo
        if (cnpj == null) return false;
        cnpj = cnpj.replaceAll("[^0-9]", "");

        // Verifica se o CNPJ tem 14 dígitos e não é uma sequência de números iguais
        if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") ||
                cnpj.equals("22222222222222") || cnpj.equals("33333333333333") ||
                cnpj.equals("44444444444444") || cnpj.equals("55555555555555") ||
                cnpj.equals("66666666666666") || cnpj.equals("77777777777777") ||
                cnpj.equals("88888888888888") || cnpj.equals("99999999999999") ||
                (cnpj.length() != 14)) {
            return false;
        }

        // As verificações acima garantem que não teremos erros de conversão de tipo ou de tamanho,
        // tornando o try-catch desnecessário para o erro que ele tentava capturar.
        char dig13, dig14;
        int sm, i, r, num, peso;

        // Cálculo do 1º Dígito Verificador
        sm = 0;
        peso = 2;
        for (i = 11; i >= 0; i--) {
            num = (int) (cnpj.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso + 1;
            if (peso == 10)
                peso = 2;
        }

        r = sm % 11;
        if ((r == 0) || (r == 1))
            dig13 = '0';
        else
            dig13 = (char) ((11 - r) + 48);

        // Cálculo do 2º Dígito Verificador
        sm = 0;
        peso = 2;
        for (i = 12; i >= 0; i--) {
            num = (int) (cnpj.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso + 1;
            if (peso == 10)
                peso = 2;
        }

        r = sm % 11;
        if ((r == 0) || (r == 1))
            dig14 = '0';
        else
            dig14 = (char) ((11 - r) + 48);

        return (dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13));
    }
}
