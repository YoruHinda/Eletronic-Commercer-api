package com.github.yoruhinda.eletronicCommercer.domain.dto.user;

import com.github.yoruhinda.eletronicCommercer.domain.entity.enumerated.UserRoleEnumerated;

public record LoginResponseDTO(String token, String username, UserRoleEnumerated user_role) {
}
