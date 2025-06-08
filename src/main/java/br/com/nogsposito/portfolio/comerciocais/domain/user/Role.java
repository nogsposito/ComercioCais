package br.com.nogsposito.portfolio.comerciocais.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
    ROLE_CLIENT("Client"),
    ROLE_ADMIN("Admin");

    private String name;
}
