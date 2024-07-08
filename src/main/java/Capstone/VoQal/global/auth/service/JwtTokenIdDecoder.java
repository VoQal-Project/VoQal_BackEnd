package Capstone.VoQal.global.auth.service;

import Capstone.VoQal.global.auth.dto.SecurityMemberDTO;
import Capstone.VoQal.global.enums.ErrorCode;
import Capstone.VoQal.global.error.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;



@Slf4j
@Service
@RequiredArgsConstructor
public class JwtTokenIdDecoder {

    public Long getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            SecurityMemberDTO userDetails = (SecurityMemberDTO) authentication.getPrincipal();
            return userDetails.getId();
        }
        throw  new BusinessException(ErrorCode.INVALID_INPUT_VALUE);
    }

}
